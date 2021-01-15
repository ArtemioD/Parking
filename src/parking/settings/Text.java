package parking.settings;

import java.util.Calendar;
import java.util.HashMap;

final public class Text {

    private final static HashMap<String, String> data = new HashMap<>();

    public static String get(String key) {
        if (data.containsKey(key)) return data.get(key);
        else System.out.println("Такого ключа не существует в классе 'Text'!!"); // <---------------- for check
        return "";
    }

    public static void init() {
        data.put("PROGRAM_NAME", "Parking");
        data.put("DIALOG_LANGUAGE", "Language");

        data.put("MENU_LANGUAGE_RUSSIAN", "Русский");
        data.put("MENU_LANGUAGE_SPANISH", "Español");
        data.put("MENU_LANGUAGE_ENGLISH", "English");

        if (Settings.getLANGUAGE().equals("ru")) {

            data.put("FIRST_HI_1","Добро пожаловать");
            data.put("FIRST_HI_2","на");
            data.put("FIRST_HI_3","Парковку");

            data.put("MENU_HELP","Помощь");
            data.put("DIALOG_ABOUT_TITLE", "О программе");
            data.put("ABOUT", "<body style='font-size: 120%; text-align: center; width: 300px; height: 260px;'>" +
                    "<h1>Parking</h1><p><img src='file:img/parking.png' /></p> " +
                    "<p>Разработчик программы: Артём Деркачёв" +
                    "<br />Май 2020</p> " +
                    "<br /><p>Copyright " + Calendar.getInstance().get(Calendar.YEAR) + " </p></body>");

            data.put("VEHICLE_ENTRY", "Регистрация");
            data.put("VEHICLE_DEPARTURE", "Выезд");
            data.put("CAR_LIST", "Список");
            data.put("PRICE_PARKING", "Тариф");
            data.put("EXIT", "Выход");

            data.put("ERROR_CAR_PATENT", "Такой номер не зарегистрирован!");
            data.put("ERROR_TITLE_EMPTY", "Не указан номер автомобиля!");
            data.put("ERROR_IS_EXISTS", "Такой номер уже зарегестрирован!");
            data.put("ERROR_PRICE", "Ошибка, только цифры!");
            data.put("ERROR_PRICE_+", "Цена может быть только положительной!");

            data.put("YES", "Да");
            data.put("NO", "Нет");

            data.put("BUTTON_SAVE", "Сохранить");
            data.put("DIALOG_SAVE", "Сохранено!");
            data.put("BUTTON_OK", "Удалить");
            data.put("BUTTON_REMOVE", "Удалено!");
            data.put("BUTTON_PRICE_NEW", "Removed!");

            data.put("CAR_PATENT", "Номер автомобиля");
            data.put("CAR_TIME_ACTUAL", "Время прибытия");

            data.put("TABLE_CAR_PATENT", "Номер автомобиля:  ");
            data.put("TABLE_CAR_TIME", "Время прибытия:  ");

            data.put("TO_PAY", "Оплатить");
            data.put("TO_PAY_$", "$");

            data.put("CONFIRM_EXIT_TEXT", "Вы уверены, что хотите выйти из Parking?");
            data.put("CONFIRM_EXIT_TITLE", "Подтверждение выхода");

            data.put("PRICE_1", "Час  $");
            data.put("PRICE_2", "1/2 часа  $");
            data.put("PRICE_3", "12 часов  $");
            data.put("PRICE_4", "24 часа  $");

        }else if (Settings.getLANGUAGE().equals("es")) {

            data.put("FIRST_HI_1","Bienvenido");
            data.put("FIRST_HI_2","en");
            data.put("FIRST_HI_3","Estacionamiento");

            data.put("MENU_HELP","Ayuda");
            data.put("DIALOG_ABOUT_TITLE", "Sobre el programa");
            data.put("ABOUT", "<body style='font-size: 120%; text-align: center; width: 300px; height: 260px;'>" +
                    "<h1>Parking</h1><p><img src='file:img/parking.png' /></p> " +
                    "<p> Desarrollador del programa: Artemio Derkachev" +
                    "<br />Mayo 2020</p> " +
                    "<br /><p>Copyright " + Calendar.getInstance().get(Calendar.YEAR) + " </p></body>");

            data.put("VEHICLE_ENTRY", "Ingreso");
            data.put("VEHICLE_DEPARTURE", "Partida");
            data.put("CAR_LIST", "Listado");
            data.put("PRICE_PARKING", "Tarifa");
            data.put("EXIT", "Salir");

            data.put("ERROR_CAR_PATENT", "¡Este número no está registrado!");
            data.put("ERROR_TITLE_EMPTY", "¡Número de coche no especificado!");
            data.put("ERROR_IS_EXISTS", "¡Este número ya ha sido registrado!");
            data.put("ERROR_PRICE", "Error, solo números!");
            data.put("ERROR_PRICE_+", "¡El precio solo puede ser positivo!");

            data.put("YES", "Si");
            data.put("NO", "No");

            data.put("BUTTON_SAVE", "Guardar");
            data.put("DIALOG_SAVE", "Guardado!");
            data.put("BUTTON_OK", "Eliminar");
            data.put("BUTTON_REMOVE", "Eliminado!");

            data.put("CAR_PATENT", "Patente de auto");
            data.put("CAR_TIME_ACTUAL", "Hora de ingreso");

            data.put("TABLE_CAR_PATENT", "Patente de vehículo:  ");
            data.put("TABLE_CAR_TIME", "Hora de ingreso:  ");

            data.put("TO_PAY", "Abonar");
            data.put("TO_PAY_$", "$");

            data.put("CONFIRM_EXIT_TEXT", "¿Estás seguro de que quieres salir de Parking?");
            data.put("CONFIRM_EXIT_TITLE", "Confirmación de salida");

            data.put("PRICE_1", "Hora  $");
            data.put("PRICE_2", "1/2 hora  $");
            data.put("PRICE_3", "12 horas  $");
            data.put("PRICE_4", "24 horas  $");

        }else {

            data.put("FIRST_HI_1","Welcome");
            data.put("FIRST_HI_2","in");
            data.put("FIRST_HI_3","Parking");

            data.put("MENU_HELP","Help");
            data.put("DIALOG_ABOUT_TITLE", "About");
            data.put("ABOUT", "<body style='font-size: 120%; text-align: center; width: 300px; height: 260px;'>" +
                    "<h1>Parking</h1><p><img src='file:img/parking.png' /></p> " +
                    "<p>Developer of the program: Artyom Derkachev" +
                    "<br />May 2020</p> " +
                    "<br /><p>Copyright " + Calendar.getInstance().get(Calendar.YEAR) + " </p></body>");

            data.put("VEHICLE_ENTRY", "Entry");
            data.put("VEHICLE_DEPARTURE", "Departure");
            data.put("CAR_LIST", "List");
            data.put("PRICE_PARKING", "Tariff");
            data.put("EXIT", "Exit");

            data.put("ERROR_CAR_PATENT", "This number is not registered!");
            data.put("ERROR_TITLE_EMPTY", "Car number not specified!");
            data.put("ERROR_IS_EXISTS", "This number has already been registered!");
            data.put("ERROR_PRICE", "Error, only numbers!");
            data.put("ERROR_PRICE_+", "The price can only be positive!");

            data.put("YES", "Yes");
            data.put("NO", "No");

            data.put("BUTTON_SAVE", "Save");
            data.put("DIALOG_SAVE", "Saved!");
            data.put("BUTTON_OK", "Remove");
            data.put("BUTTON_REMOVE", "Removed!");
            data.put("BUTTON_PRICE_NEW", "Removed!");//-----------------------------------------------------

            data.put("CAR_PATENT", "Car patent");
            data.put("CAR_TIME_ACTUAL", "Check in time");

            data.put("TABLE_CAR_PATENT", "Car patent:  ");
            data.put("TABLE_CAR_TIME", "Check in time:  ");

            data.put("TO_PAY", "Pay");
            data.put("TO_PAY_$", "$");

            data.put("CONFIRM_EXIT_TEXT", "Are you sure you want to exit Parking?");
            data.put("CONFIRM_EXIT_TITLE", "Exit confirmation");

            data.put("PRICE_1", "Hour  $");
            data.put("PRICE_2", "1/2 hour  $");
            data.put("PRICE_3", "12 hours  $");
            data.put("PRICE_4", "24 hours  $");
        }
    }

}
