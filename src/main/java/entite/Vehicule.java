package entite;

import lombok.Data;

@Data
public abstract class Vehicule {
    private String marque;
    private String modele;
    private String immatriculation;
    private double tarifJournalier;
    private boolean disponible;
    //public static double chiffreDaffaire = 0;

    public Vehicule(String marque, String modele, String immatriculation, double tarifJournalier, boolean disponible){
        this.marque=marque;
        this.modele=modele;
        this.immatriculation=immatriculation;
        this.tarifJournalier=tarifJournalier;
        this.disponible=disponible;
    }

//    public String getMarque(){
//        return marque;
//    }
//
//    public void setMarque(String marque){
//        this.marque = marque;
//    }
//
//    public String getImmatriculation(){
//        return immatriculation;
//    }
//
//    public void setImmatriculation(String immatriculation) {
//        this.immatriculation = immatriculation;
//    }
//
//    public String getModele(){
//        return modele;
//    }
//
//    public void setModele(String modele){
//        this.modele = modele;
//    }
//
//    public double getTarifJournalier() {
//        return tarifJournalier;
//    }
//
//    public void setTarifJournalier(double tarifJournalier) {
//        this.tarifJournalier = tarifJournalier;
//    }
//
//    public boolean isDisponible() {
//        return disponible;
//    }
//
//    public void setDisponible(boolean disponible) {
//        this.disponible = disponible;
//    }


     public abstract double calculerCout(int nbJours) ;

    @Override
    public String toString(){
        return "Marque: "+marque+", Modele :"+modele+", immatriculation: "+immatriculation+", tarifJournalier: "+tarifJournalier+", disponibilite: "+disponible;
    }
}
