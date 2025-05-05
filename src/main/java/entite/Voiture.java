package entite;

public class Voiture extends Vehicule{
//    private double tarifJournalier;

    public Voiture(String marque,String modele, String immatriculation, double tarifJournalier, boolean disponible){

        super(marque,modele,immatriculation,tarifJournalier,disponible);

    }

    @Override
    public double calculerCout(int nbJours){
        return super.getTarifJournalier() * nbJours;
    }
}
