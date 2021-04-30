package buisness;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.Stack;

import exeption.PasAssezDobservateurException;
import exeption.PlaceDisponibleException;
import exeption.PlaceLibreExeption;
import exeption.PlaceOccupeeExeption;
import exeption.PlusAucunePlaceException;

public class Parking {
    private static Parking instance;
    private List<Place> places;

    public static Parking getInstance() {
        if (instance == null)
            instance = new Parking();
        return instance;
    }

    protected Parking() {
        places = new ArrayList<Place>();
        for (int i = 0; i <= Constante.nbPlaceParticulier; i++) {
            places.add(new PlaceParticulier());
        }
        for (int i = 0; i <= Constante.nbPlaceTransporteur; i++) {
            places.add(new PlaceTransporteur());
        }

    }

    public boolean vehiculeExiste(Vehicule v) {
        return places.contains(v);
    }

    // Placer un véhicule dans le parking à la première place trouvée
    public void park(Vehicule v) throws PlaceOccupeeExeption {
        for (Place place : places) {
            try {

                place.park(v);
                return;
            } catch (PlaceOccupeeExeption e) {
                // System.out.println(e.getMessage());
            }

        }
        throw new PlaceOccupeeExeption();
    }

    // Essayer de placer un véhicule dans une place donnée
    public void park(Vehicule v, Place place) throws PlaceOccupeeExeption {
        if (!place.isReserved(v.getImmatriculation()) && place.isFree())
            place.park(v);
        else
            throw new PlaceOccupeeExeption();
    }

    // Essayer de placer un véhicule dans une place numéroté
    public void park(Vehicule v, int place) throws PlaceOccupeeExeption {
        park(v, places.get(place));
    }

    // Retirer un vehicule de la place
    public Vehicule unpark(Place place) throws PlaceLibreExeption, PlaceOccupeeExeption {
        Vehicule v = place.getParkedVehicule();
        if (v == null) {
            throw new PlaceLibreExeption();
        }
        place.retirer();
        reorganiserPlace();
        return v;
    }

    public Vehicule unpark(int place) throws PlaceLibreExeption, PlaceOccupeeExeption {
        return unpark(places.get(place));
    }

    // Affichage du parking et son état
    public void etatParking() {
        for (int i = 0; i < places.size() - 1; i++) {
            System.out.println("Place : " + i + " : ");
            if (places.get(i).isFree()) {
                if (places.get(i).isReserved()) {
                    System.out.println("Place réservée");
                } else {
                    System.out.println("Place libre");
                }
            } else {
                System.out.println("Place occupée");

            }
        }

    }

    // Essayer de réserver la place pour un véhicule donné à un numéro de place
    // donné
    public Place bookPlace(Vehicule v, Place p) throws PlusAucunePlaceException {
        if (!p.isReserved() && p.isFree()) {
            p.reserver(v.getImmatriculation());
            return p;
        }
        throw new PlusAucunePlaceException();
    }

    public Place bookPlace(Vehicule v, int emplacement) throws PlusAucunePlaceException {
        return bookPlace(v, places.get(emplacement));
    }

    // annule la réservationde la place donnée
    public void freePlace(Place p) throws PlaceDisponibleException {
        if (!p.isReserved()) {
            throw new PlaceDisponibleException();
        } else {
            p.liberer();
        }

    }

    public void freePlace(int i) throws PlaceDisponibleException {
        freePlace(places.get(i));
    }

    // position de la voiture avec un paramètre son immatriculation
    public int getLocalisation(String immat) throws PlaceLibreExeption {
        for (int i = 0; i < places.size() - 1; i++) {
            if (!(places.get(i).isFree()) && places.get(i).getParkedVehicule().getImmatriculation().equals(immat)) {
                return i;
            }

        }
        return -1;
    }

    // retirer le véhicule du parking selon son immatriculation
    public Vehicule retirerVehicule(String immat) throws PlaceLibreExeption, PlaceOccupeeExeption {
        return unpark(getLocalisation(immat));
    }

    // Réorganisation des places suite aux changements et à la libération
    public void reorganiserPlace() throws PlaceLibreExeption, PlaceOccupeeExeption {
        Stack<Place> placesLibres = new Stack<Place>();
        for (Place p : places.subList(0, Constante.nbPlaceParticulier)) {
            if (!p.isTransporteur() && p.isFree() && !p.isReserved()) {
                placesLibres.push(p);
            }
        }
        for (Place p : places.subList(Constante.nbPlaceParticulier,
                Constante.nbPlaceParticulier + Constante.nbPlaceTransporteur)) {
            if (!p.isFree() && !p.getParkedVehicule().isTransporteur()) {
                park(unpark(places.get(p.getNumero())), placesLibres.pop());
            }
        }
    }

    // Ajouter des observateurs sur toutes les places,
    // la liste doit contenir autant d'observateur que de place à observer
    public void obserPlaces(List<? extends Observer> observer) throws PasAssezDobservateurException {
        // todo ajouter les observateurs
        if(observer.size() !=places.size()) throw new PasAssezDobservateurException();
        Iterator<Place> placeIt = places.iterator();
        Iterator<?extends Observer> obsIt = observer.iterator();
        while(placeIt.hasNext() && obsIt.hasNext()){
            Place p = placeIt.next();
        }
    }

}
