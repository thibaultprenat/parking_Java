package buisness;

public abstract class Vehicule {

    // Variables de classe

    private String immatriculation;
    private String modele;
    private String marque;
    private String proprietaire;

    // Constructeur par défaut
    public Vehicule() {
        System.out.println("Création de l'objet Véhicule (vide)");
    }

    // Constructeur surchargé
    public Vehicule(String imm, String mod, String mar, String prop) {
        this.immatriculation = imm;
        this.modele = mod;
        this.marque = mar;
        this.proprietaire = prop;
        System.out.println(toString());
    }

    // Vérifier si le véhicue est un transporteur
    public abstract boolean isTransporteur();

    // Génération des Get Set

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    @Override // Annotation permettant de spécifier la surcharge de notre méthode
    public String toString() {

        return getClass().getSimpleName() + " Immatriculé " + immatriculation + " Appartenant à " + proprietaire
                + " De la marque " + marque + " Ayant pour model " + modele;

    }

}
