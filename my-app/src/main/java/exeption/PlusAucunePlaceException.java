package exeption;

public class PlusAucunePlaceException extends Exception {
    public PlusAucunePlaceException() {
        super("Pas de place disponible ... ");
    }
}
