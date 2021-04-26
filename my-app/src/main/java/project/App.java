package project;

import buisness.*;
import exeption.PlaceOccupeeExeption;

public class App {
    public static void main(String[] args) throws PlaceOccupeeExeption {

        System.out.println("Hello World!");

        Voiture voit = new Voiture("AB-123-CD", "M3", "BMW", "Prenat");
        Moto mot = new Moto("TR-265-FG", "ZX-658", "suzuki", "Fabrice");
        Camion cam = new Camion("DS-651-SD", "M3", "RENAULT", "Laurent");

        Parking parking = Parking.getInstance();
        parking.park(voit);
        parking.park(mot);
        // parking.park(cam);
        parking.etatParking();

    }
}
