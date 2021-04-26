package project;

import buisness.*;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        Voiture voit = new Voiture("AB-123-CD", "M3", "BMW", "Prenat");
        Moto mot = new Moto("TR-265-FG", "ZX-658", "suzuki", "Fabrice");
        Camion cam = new Camion("DS-651-SD", "M3", "RENAULT", "Laurent");

    }
}
