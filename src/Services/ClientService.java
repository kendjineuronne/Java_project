
package Services;

import java.util.List;

import Entities.Client;
import Repositories.ClientRepository;

public class ClientService {
    private ClientRepository clientRepository;

    // Constructeur prenant un ClientRepository en paramètre
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Crée un nouveau client
    public Client createClient(String nomComplet, String telephone, String email) {
        Client newClient = new Client(nomComplet, telephone, email);
        return clientRepository.save(newClient);
    }

    // Récupère tous les clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Récupère un client par son id
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }

    
}

