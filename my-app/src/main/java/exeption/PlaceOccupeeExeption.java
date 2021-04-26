package exeption;

public class PlaceOccupeeExeption extends Exception {
    public PlaceOccupeeExeption() {
        super("La place est déjà occupée...");
    }
}
