package Repositories;

import java.util.ArrayList;
import java.util.List;
import Entities.Client;

public class ClientRepository {
    private List<Client> clients = new ArrayList<>();
    private static long clientIdCounter = 1;

    // Enregistre un client dans la liste et lui attribue un id
    public Client save(Client client) {
        if (client.getId() == null) {
            client.setId(clientIdCounter++);
        }
        clients.add(client);
        return client;
    }

    // Récupère tous les clients
    public List<Client> findAll() {
        return new ArrayList<>(clients);
    }

    // Récupère un client par son id
    public Client findById(Long id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        return null;
    }

    
}
