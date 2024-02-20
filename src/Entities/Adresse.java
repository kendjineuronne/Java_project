package Entities;

public class Adresse {
    private Long id;
    private String ville;
    private String quartier;
    private String numVilla;
    private Client client;

    // Constructeur par défaut
    public Adresse() 
    {

    }

    // Constructeur avec paramètres
    public Adresse(String ville, String quartier, String numVilla) {
        this.ville = ville;
        this.quartier = quartier;
        this.numVilla = numVilla;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getNumVilla() {
        return numVilla;
    }

    public void setNumVilla(String numVilla) {
        this.numVilla = numVilla;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
}
