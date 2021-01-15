package parking.gui;

import parking.Parking;
import parking.gui.dialog.ConfirmDialog;
import parking.model.Car;
import parking.savedata.SaveData;
import parking.settings.Style;
import parking.settings.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class MainFrame extends JFrame implements ActionListener, Refresh {
    private MainPanel mainPanel;
    private FirstPanel firstPanel;
    private AddPanel addPanel;
    private DeletePanel deletePanel;
    private CarListPanel carListPanel;
    private PricePanel pricePanel;
    private MrButton buttonSave, buttonSearch, buttonRemove, buttonPriceSave;

    public MainFrame() {
        super(Text.get("PROGRAM_NAME"));
        setIconImage(Style.ICON_PARKING.getImage());
        setLayout(null);
        setSize(700, 491);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(Color.darkGray);

        init();
        addWindowListener(new Listener());
    }

    private void init() {
        MainMenu menu = new MainMenu(this);
        setJMenuBar(menu);

        mainPanel = new MainPanel();
        mainPanel.getButton1().addActionListener(this);
        mainPanel.getButton2().addActionListener(this);
        mainPanel.getButton3().addActionListener(this);
        mainPanel.getButton4().addActionListener(this);
        mainPanel.getButton5().addActionListener(this);

        buttonSave = new MrButton(Text.get("BUTTON_SAVE"), Style.SAVE_ICON, 58, 355, 270, 70);
        buttonSave.addActionListener(this);

        buttonSearch = new MrButton(null, Style.SEARCH_ICON, 310, 60, 50, 50);
        buttonSearch.addActionListener(this);

        buttonRemove = new MrButton(Text.get("BUTTON_OK"), Style.BORRAR_ICON, 58, 364, 260, 60);
        buttonRemove.addActionListener(this);

        buttonPriceSave = new MrButton(Text.get("BUTTON_SAVE"), Style.SAVE_ICON, 58, 355, 270, 70);
        buttonPriceSave.addActionListener(this);

        firstPanel = new FirstPanel();
        addPanel = new AddPanel();
        deletePanel = new DeletePanel();
        carListPanel = new CarListPanel();
        pricePanel = new PricePanel();

        add(mainPanel);
        add(firstPanel);
        add(addPanel);
        add(deletePanel);
        add(carListPanel);
        add(pricePanel);

        mostrar(true, false, false, false, false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object botonPulsado = e.getSource();
        if (botonPulsado == mainPanel.getButton1()) {
            addPanel.refresh(1);
            addPanel.add(buttonSave);
            mostrar(false, true, false, false, false);
        }
        if (botonPulsado == mainPanel.getButton2()) {
            deletePanel.refresh(1);
            deletePanel.add(buttonSearch);
            deletePanel.add(buttonRemove);
            mostrar(false, false, true, false, false);
        }
        if (botonPulsado == mainPanel.getButton3()) {
            mostrar(false, false, false, true, false);
        }
        if (botonPulsado == mainPanel.getButton4()) {
            pricePanel.refresh(1);
            pricePanel.add(buttonPriceSave);
            mostrar(false, false, false, false, true);
            addButton();
        }
        if (botonPulsado == mainPanel.getButton5()) {
            int result = ConfirmDialog.show(null, Text.get("CONFIRM_EXIT_TEXT"), Text.get("CONFIRM_EXIT_TITLE"));
            if (result == JOptionPane.YES_OPTION) System.exit(0);
        }
        if (botonPulsado == buttonSave) {
            if (addPanel.getTextField().getText().length() < 1)
                JOptionPane.showMessageDialog(null, message(1));
            else {
                int x = 1;
                for (int i = 0; i < Parking.cars.size(); i++) {
                    if (Parking.cars.get(i).getPatente().equals(addPanel.getTextField().getText().toUpperCase())) {
                        x = 2;
                        JOptionPane.showMessageDialog(null, message(5)); break;
                    }
                }
                if (x == 1) {
                    Parking.cars.add(new Car(addPanel.getTextField().getText()));
                    SaveData.guardar();
                    JOptionPane.showMessageDialog(null, message(2));
                    carListPanel.refresh(1);
                    mostrar(false, false, false, true, false);
                }
            }
        }
        if (botonPulsado == buttonSearch) buscar();
        if (botonPulsado == buttonRemove) {
            buscar();
            for (int i = 0; i < Parking.cars.size(); i++) {
                if ((Parking.cars.get(i)).getPatente().equalsIgnoreCase(deletePanel.getTextField().getText())) {
                    Parking.cars.remove(Parking.cars.get(i));
                    SaveData.guardar();
                    JOptionPane.showMessageDialog(null, message(3));
                    carListPanel.refresh(1);
                    mostrar(false, false, false, true, false); break;
                }
            }
        }
        if (botonPulsado == buttonPriceSave) addPrice();
    }

    private void addPrice() {
        try{
            if (pricePanel.getTextField_1() < 0 || pricePanel.getTextField_2() < 0
                    || pricePanel.getTextField_3() < 0 || pricePanel.getTextField_4() < 0) {
                System.out.println(pricePanel.getTextField_1());
                JOptionPane.showMessageDialog(null, message(7));
            }else {
                Parking.price[0] = pricePanel.getTextField_1();
                Parking.price[1] = pricePanel.getTextField_2();
                Parking.price[2] = pricePanel.getTextField_3();
                Parking.price[3] = pricePanel.getTextField_4();
                SaveData.guardarPrice();
                JOptionPane.showMessageDialog(null, message(2));
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, message(6));
        }
    }

    private void addButton() {
        pricePanel.add(buttonPriceSave);
    }

    private void buscar() {
        if (deletePanel.getTextField().getText().length() > 0 && Parking.cars.isEmpty()) {
            JOptionPane.showMessageDialog(null, message(4));
        }else if (deletePanel.getTextField().getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, message(1));
        }else {
            for (int i = 0; i < Parking.cars.size(); i++) {
                DateFormat date = new SimpleDateFormat("HH:mm    dd/MM/yyyy");
                if ((Parking.cars.get(i)).getPatente().equalsIgnoreCase(deletePanel.getTextField().getText())) {
                    deletePanel.getDisplayDate().setText(date.format(Parking.cars.get(i).getDate()));
                    deletePanel.getDisplayPay().setText(calculatePrice(new Date(), Parking.cars.get(i).getDate())); // a pagar
                    break;
                }else deletePanel.getDisplayDate().setText(" ");
            }
            if (deletePanel.getDisplayDate().getText().equals(" "))
                JOptionPane.showMessageDialog(null, message(4));
        }
    }

    private String calculatePrice(Date fechaMayor, Date fechaMenor)  {
        DecimalFormat df = new DecimalFormat("0.00");

        double totalPagar = 0;
        long diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
        long minutos = diferenciaEn_ms / (1000 * 60); // minutos
        long horas = diferenciaEn_ms / (1000 * 60 * 60); // horas
        //long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24); //dias
        //System.out.println("min: " + minutos);
        //System.out.println("hs: " + horas);
        //System.out.println("dias: " + dias);

        if (minutos < 30) totalPagar = Parking.price[1]; //------------------------------------------- menos de 1/2 hora
        else if (minutos >= 30 && minutos < 60) totalPagar = Parking.price[0]; //--------------------- entre 1/2 y 1 hora
        else if (minutos > 60 && minutos < 720) {
            int x = (int) (minutos % 60);
            if (x < 30) totalPagar = horas * Parking.price[0] + Parking.price[1]; //--------------------- 1 mas 1/2 hora
            else if (x >= 30 && x < 60) totalPagar = horas * Parking.price[0] + Parking.price[0]; //-------- casi 2 horas
        }else if (minutos >= 720 && minutos < 1440) {
            int hor = (int) (horas - 12);
            int x = (int) ((minutos -(hor * 60)) % 60);
            if (x < 30) totalPagar = Parking.price[2] + hor * Parking.price[0] + Parking.price[1]; // ok
            else if (x >= 30 && x < 60) totalPagar = Parking.price[2] + hor * Parking.price[0] + Parking.price[0]; // ok
        }else if (horas >= 24) {
            int a = (int) (horas / 24); // a * Parking.price[3]
            int b = (int) (horas % 24);
            int c = b / 12; // c * Parking.price[2]
            int d = b % 12;
            int ostatok = (int) (minutos - (((a * 24) + (c * 12) + d) * 60));
            if (ostatok < 30) totalPagar = a * Parking.price[3] + c * Parking.price[2] + d * Parking.price[0] + Parking.price[1];
            else if (ostatok >= 30 && ostatok < 60) totalPagar = a * Parking.price[3] + c * Parking.price[2] + d * Parking.price[0] + Parking.price[0];
        }
        return "$ " + df.format(totalPagar);
    }

    private String message(int menssage) {
        String a = "";
        switch (menssage) {
            case 1:
                a = Text.get("ERROR_TITLE_EMPTY"); break; // "Не указан номер автомобиля !"
            case 2:
                a = Text.get("DIALOG_SAVE"); break;
            case 3:
                a = Text.get("BUTTON_REMOVE"); break;
            case 4:
                a = Text.get("ERROR_CAR_PATENT"); break; // "Такого номера не существует !"
            case 5:
                a = Text.get("ERROR_IS_EXISTS"); break;
            case 6:
                a = Text.get("ERROR_PRICE"); break;
            case 7:
                a = Text.get("ERROR_PRICE_+"); break;
        }
        return a;
    }

    private void mostrar(boolean fP, boolean aP, boolean dP, boolean cLP, boolean pP) {
        firstPanel.setVisible(fP);
        addPanel.setVisible(aP);
        deletePanel.setVisible(dP);
        carListPanel.setVisible(cLP);
        pricePanel.setVisible(pP);
    }

    @Override
    public void refresh(int code) {
        firstPanel.refresh(2);
        mainPanel.refresh(2);
        addPanel.refresh(2);
        deletePanel.refresh(2);
        carListPanel.refresh(2);
        pricePanel.refresh(2);
        init();
    }

}
