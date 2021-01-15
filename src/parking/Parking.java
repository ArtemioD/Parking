package parking;

import parking.gui.MainFrame;
import parking.model.Car;
import parking.savedata.SaveData;
import parking.settings.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class Parking implements Serializable {

    public static double[] price = new double[4];
    public static ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args)  {
        //testModel();
        init();
        new MainFrame().setVisible(true);
        //System.out.println(cars);
    }

    private static void init() {
        SaveData.init();
        Text.init();
    }

    private static void testModel() {

        cars.add(new Car("kim-555"));
        cars.add(new Car("lok-563"));
        cars.add(new Car("poJ-651"));
    }
}
