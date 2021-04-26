package buisness;

import exeption.PlaceOccupeeExeption;

public class PlaceTransporteur extends Place {

    @Override
    public boolean isTransporteur() {
        return true;
    }

    @Override
    public void park(Vehicule v) throws PlaceOccupeeExeption {
        if (!isReserved(v.getImmatriculation()) || !isFree())
            throw new PlaceOccupeeExeption();
        vehicule = v;
    }

}
