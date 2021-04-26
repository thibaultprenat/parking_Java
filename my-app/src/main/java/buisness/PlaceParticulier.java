package buisness;

import exeption.PlaceOccupeeExeption;

public class PlaceParticulier extends Place {

    @Override
    public boolean isTransporteur() {
        return false;
    }

    @Override
    public void park(Vehicule v) throws PlaceOccupeeExeption {
        if (v.isTransporteur() || isReserved(v.getImmatriculation()) || !isFree())
            throw new PlaceOccupeeExeption();
        else
            vehicule = v;
    }

}
