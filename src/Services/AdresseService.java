package Services;
import java.util.List;

import Entities.Adresse;
import Entities.Client;
import Repositories.AdresseRepository;

public class AdresseService {
    private AdresseRepository adresseRepository;
    private ClientService clientService;

    // Constructeur prenant un AdresseRepository et un ClientService en paramètres
    public AdresseService(AdresseRepository adresseRepository, ClientService clientService) {
        this.adresseRepository = adresseRepository;
        this.clientService = clientService;
    }

    // Crée une nouvelle adresse et l'associe à un client
    public Adresse createAdresse(String ville, String quartier, String numVilla, Long clientId) {
        Client client = clientService.getClientById(clientId);
        if (client == null) {
            
            return null;
        }

        Adresse newAdresse = new Adresse(ville, quartier, numVilla);
        client.addAdresse(newAdresse);

        return adresseRepository.save(newAdresse);
    }

    // Récupère toutes les adresses
    public List<Adresse> getAllAdresses() {
        return adresseRepository.findAll();
    }

    // Récupère une adresse par son id
    public Adresse getAdresseById(Long adresseId) {
        return adresseRepository.findById(adresseId);
    }

    
}
