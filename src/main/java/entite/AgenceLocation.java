package entite;

import java.util.ArrayList;
import java.util.List;

public class AgenceLocation {

    private List<Client> clients;
    private List<Vehicule> vehicules;
    private final List<Double> chiffreDaffaire;

    public AgenceLocation(){
        this.clients = new ArrayList<>();
        this.vehicules = new ArrayList<>();
        this.chiffreDaffaire = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public void ajouterVehicule(Vehicule vehicule){
        vehicules.add(vehicule);
    }

    public void ajouterClient( Client client){
        clients.add(client);
    }

    public void louerVehicule(Client client, Vehicule vehicule, int nbJours) {
        if (vehicule == null) {
            throw new IllegalArgumentException("Le véhicule ne peut pas être null.");
        }
        if (client == null) {
            throw new IllegalArgumentException("Le client ne peut pas être null.");
        }

        if (!vehicule.isDisponible()) {
            throw new IllegalStateException("Véhicule déjà loué");
        }

        client.getVehiculesLoues().add(vehicule);
        vehicule.setDisponible(false);
       // System.out.println("Véhicule loué : " + vehicule);

        chiffreDaffaire.add(vehicule.calculerCout(nbJours));
    }

    public void retournerVehicule(Client client, Vehicule vehicule){
        if(client.getVehiculesLoues().contains(vehicule)){
            client.getVehiculesLoues().remove(vehicule);
            vehicule.setDisponible(true);
            //System.out.println("Le véhicule " + vehicule + " a été rendue par le client " + client);
       }
        //else {
//            System.out.println("Ce véhicule n'a pas été loué par ce client.");
//        }

    }

    public double chiffreDaffaire(){
        double somme = 0;
       for(double valeur : chiffreDaffaire){
           somme+= valeur;
       }

       return somme;

    }


}
