package Views;
import java.util.List;
import java.util.Scanner;

import Entities.Adresse;
import Entities.Client;
import Repositories.AdresseRepository;
import Repositories.ClientRepository;
import Services.AdresseService;
import Services.ClientService;

public class App {

    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepository();
        AdresseRepository adresseRepository = new AdresseRepository();

        ClientService clientService = new ClientService(clientRepository);
        AdresseService adresseService = new AdresseService(adresseRepository, clientService);

        Scanner scanner = new Scanner(System.in);

        int choix;
        do {
            System.out.println("1. Créer un client");
            System.out.println("2. Lister les clients");
            System.out.println("3. Ajouter une adresse et lui associer un client");
            System.out.println("4. Lister les adresses en affichant le nom du client");
            System.out.println("5. Quitter l'application");
            System.out.print("Choix : ");
            
            choix = scanner.nextInt();
            scanner.nextLine(); // pour consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    System.out.print("Nom complet du client : ");
                    String nomComplet = scanner.nextLine();
                    System.out.print("Téléphone du client : ");
                    String telephone = scanner.nextLine();
                    System.out.print("Email du client : ");
                    String email = scanner.nextLine();

                    Client newClient = clientService.createClient(nomComplet, telephone, email);
                    System.out.println("Client créé avec l'ID : " + newClient.getId());
                    break;

                case 2:
                    List<Client> clients = clientService.getAllClients();
                    System.out.println("Liste des clients :");
                    for (Client client : clients) {
                        System.out.println(client.getId() + ". " + client.getNomComplet());
                    }
                    break;

                case 3:
                    System.out.print("Ville de l'adresse : ");
                    String ville = scanner.nextLine();
                    System.out.print("Quartier de l'adresse : ");
                    String quartier = scanner.nextLine();
                    System.out.print("Numéro de villa : ");
                    String numVilla = scanner.nextLine();

                    System.out.print("ID du client à associer : ");
                    Long clientId = scanner.nextLong();

                    Adresse newAdresse = adresseService.createAdresse(ville, quartier, numVilla, clientId);
                    if (newAdresse != null) {
                        System.out.println("Adresse créée avec l'ID : " + newAdresse.getId());
                    } else {
                        System.out.println("Le client avec l'ID " + clientId + " n'existe pas.");
                    }
                    break;

                case 4:
                    List<Adresse> adresses = adresseService.getAllAdresses();
                    System.out.println("Liste des adresses avec le nom du client :");
                    for (Adresse adresse : adresses) {
                        System.out.println(adresse.getId() + ". " + adresse.getVille() +
                                " - Client: " + adresse.getClient().getNomComplet());
                    }
                    break;

                case 5:
                    System.out.println("Quitter l'application.");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }

        } while (choix != 5);

        scanner.close();
    }
}
