package Entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private Long id;
    private String nomComplet;
    private String telephone;
    private String email;
    private List<Adresse> adresses = new ArrayList<>();

    // Constructeur par défaut
    public Client() 
    {

    }

    // Constructeur avec paramètres
    public Client(String nomComplet, String telephone, String email) {
        this.nomComplet = nomComplet;
        this.telephone = telephone;
        this.email = email;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    // Méthode pour ajouter une adresse au client
    public void addAdresse(Adresse adresse) {
        this.adresses.add(adresse);
        adresse.setClient(this);
    }

    
}
