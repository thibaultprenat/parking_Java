package buisness;

import java.util.ArrayList;
import java.util.List;

import exeption.PlaceLibreExeption;
import exeption.PlaceOccupeeExeption;

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

    // Affichage du parking et son état
    public void etatParking() {
        for (int i = 0; i < places.size(); i++) {
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

}
