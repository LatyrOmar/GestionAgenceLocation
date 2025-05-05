package entite;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private List<Vehicule> vehiculesLoues;

    public Client(int id, String nom, String prenom, String email){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.vehiculesLoues = new ArrayList<>();
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getPrenom() {
//        return prenom;
//    }
//
//    public void setPrenom(String prenom) {
//        this.prenom = prenom;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    @Override
    public String toString(){
        return "Client: "+prenom+", nom: "+nom+", email: "+email+", véhicule loués: "+getVehiculesLoues();
    }
}
