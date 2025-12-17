package exam.repo;

import exam.domain.emprunt.Emprunt;
import java.util.List;
import java.util.Optional;

/**
 * Repository des emprunts de la médiathèque.
 * <p>
 * Cette interface définit les opérations de persistance pour les emprunts.
 * Elle est utilisée par les services métier afin de gérer les emprunts
 * sans dépendre d'une implémentation concrète (principe DIP).
 */
public interface EmpruntRepository {

    /**
     * Recherche un emprunt par son identifiant.
     *
     * @param id identifiant de l'emprunt (strictement positif)
     * @return un {@link Optional} contenant l'emprunt s'il existe,
     *         ou {@link Optional#empty()} sinon
     */
    Optional<Emprunt> findById(long id);

    /**
     * Retourne la liste de tous les emprunts enregistrés.
     *
     * @return liste de tous les emprunts (jamais null)
     */
    List<Emprunt> findAll();

    /**
     * Sauvegarde un emprunt dans le repository.
     * <p>
     * Si un emprunt avec le même identifiant existe déjà,
     * il est remplacé.
     *
     * @param emprunt emprunt à sauvegarder (non null)
     * @throws IllegalArgumentException si l'emprunt est null
     */
    void save(Emprunt emprunt);
}
