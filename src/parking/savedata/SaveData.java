package parking.savedata;

import parking.Parking;
import parking.model.Car;

import java.io.*;
import java.util.ArrayList;

public final class SaveData {

    public static void init() {
        leerPrice();
        if(Parking.cars.isEmpty()) leer();
        else guardar();
    }

    public static void leer() {
        try {
            //System.out.print("Leyendo ArrayList del fichero.. ");
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream("saves\\cars.parking"));
            Parking.cars = (ArrayList<Car>) leyendoFichero.readObject();
            //Parking.cars.add((Car) leyendoFichero.readObject());
            leyendoFichero.close();
            //System.out.println("...ok");
        } catch (Exception e) {
            System.out.println("Error N°1 en la clase 'SaveData'");
        }
    }

    public static void guardar() {
        try {
            //System.out.println("Guardando ArrayList en el fichero...");
            ObjectOutputStream escribiendaFichero = new ObjectOutputStream(
                    new FileOutputStream("saves\\cars.parking"));
            escribiendaFichero.writeObject(Parking.cars);
            escribiendaFichero.close();
            Parking.cars.clear();
            //System.out.println("Que tenemos:\n" + Parking.cars);
            SaveData.init();
            //System.out.println("Ahora:\n" + Parking.cars);
            //System.out.println("...ok");
        } catch (Exception e) {
            System.out.println("Error N°2 en la clase 'SaveData'");
        }
    }

    public static void guardarPrice() {
        try {
            FileWriter fichero = new FileWriter("saves\\price.parking");
            for (int i = 0; i < Parking.price.length; i++) {
                fichero.write(Parking.price[i] +";");
            }
            fichero.close();
        } catch (Exception e) {
            System.out.println("Error N°3 en la clase 'SaveData'-Price");
        }
    }

    public static void leerPrice() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("saves\\price.parking"));
            String linea = bf.readLine();
            for (int i = 0; i < Parking.price.length; i++) {
                String[] tmp = linea.split(";");
                Parking.price[i] = Double.parseDouble(String.valueOf(tmp[i]));
            }
        } catch (Exception e) {
            System.out.println("Error N°4 en la clase 'SaveData'-Price");
        }
    }

}
