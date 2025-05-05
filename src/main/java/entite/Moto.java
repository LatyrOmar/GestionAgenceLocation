package entite;

public class Moto extends Vehicule{
    private int cylindre;

    public Moto(String marque,String modele, String immatriculation, double tarifJournalier, boolean disponible, int cylindre){
        super(marque,modele,immatriculation,tarifJournalier,disponible);
        this.cylindre =cylindre;
    }

    @Override
    public double calculerCout(int nbJours){
        double tarifJournalier =super.getTarifJournalier();
        double cout;
        if(cylindre>500){
            cout = (nbJours*tarifJournalier) - (nbJours*tarifJournalier)*10/100;
        }else{
            cout = nbJours * tarifJournalier;
        }
       // Vehicule.chiffreDaffaire +=cout;
        return cout;
    }
    @Override
    public String toString(){
        return super.toString() +", Cylindre: "+cylindre;
    }
}
