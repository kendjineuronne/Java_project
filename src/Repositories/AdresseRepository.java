package Repositories;

import java.util.ArrayList;
import java.util.List;
import Entities.Adresse;

public class AdresseRepository {
    private List<Adresse> adresses = new ArrayList<>();
    private static long adresseIdCounter = 1;

    // Enregistre une adresse dans la liste et lui attribue un id
    public Adresse save(Adresse adresse) {
        if (adresse.getId() == null) {
            adresse.setId(adresseIdCounter++);
        }
        adresses.add(adresse);
        return adresse;
    }

    // Récupère toutes les adresses
    public List<Adresse> findAll() {
        return new ArrayList<>(adresses);
    }

    // Récupère une adresse par son id
    public Adresse findById(Long id) {
        for (Adresse adresse : adresses) {
            if (adresse.getId().equals(id)) {
                return adresse;
            }
        }
        return null;
    }

   
}

