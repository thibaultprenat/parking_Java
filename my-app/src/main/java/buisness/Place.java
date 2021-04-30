package buisness;

import java.util.Observable;

import exeption.PlaceLibreExeption;
import exeption.PlaceOccupeeExeption;
import exeption.PlusAucunePlaceException;

public abstract class Place extends Observable {
    static int nbInstance = 0;
    private int numero;
    private String reservationImmat;
    private boolean reserve = false;

    protected Vehicule vehicule = null; // Futur véhicule stationné

    public Place() {
        numero = nbInstance++;
    }

    // True si place disponible
    public boolean isFree() {
        return vehicule == null;
    }

    // True si il y a une reservation sur la place
    public boolean isReserved() {
        return reserve;
    }

    // True si la réservation a été faite pour ce vehicule
    public boolean isReserved(String immat) {
        return !immat.equals(reservationImmat) && reserve;
    }

    // Renvoyer le vehicule stationné
    public Vehicule getParkedVehicule() {
        return vehicule;
    }

    // Retirer la réservation faite sur cette place
    public void liberer() {
        reserve = false;
        reservationImmat = null;
    }

    // Reserver la place au véhicule
    public void reserver(String immat) throws PlusAucunePlaceException {
        if (reserve)
            throw (new PlusAucunePlaceException());
        else

        {
            reservationImmat = immat;
            reserve = true;
        }

    }

    // Numéro de la place
    public int getNumero() {
        return numero;
    }

    // Si la place est faite pour les transporteurs
    public abstract boolean isTransporteur();

    // Essayer de placer un véhicule dans cette place
    public abstract void park(Vehicule v) throws PlaceOccupeeExeption;

    // Retirer le véhicule de la place
    public void retirer() throws PlaceLibreExeption {
        if (vehicule == null)
            ;
        Vehicule tmp = vehicule;
        vehicule = null;
        System.out.println("Notification de véhicule retiré");
    }
}
