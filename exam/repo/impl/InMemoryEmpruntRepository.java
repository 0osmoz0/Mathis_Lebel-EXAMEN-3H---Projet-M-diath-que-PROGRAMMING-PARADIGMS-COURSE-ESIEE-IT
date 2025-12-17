package exam.repo.impl;

import exam.domain.emprunt.Emprunt;
import exam.repo.EmpruntRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Implémentation en mémoire du {@link EmpruntRepository}.
 * <p>
 * Les emprunts sont stockés dans une collection en mémoire.
 * Cette implémentation est utilisée à des fins pédagogiques
 * et ne repose sur aucune persistance externe.
 */
public class InMemoryEmpruntRepository implements EmpruntRepository {

    private final List<Emprunt> emprunts = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Emprunt> findById(long id) {
        return emprunts.stream()
                .filter(emprunt -> emprunt.getId() == id)
                .findFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Emprunt> findAll() {
        return new ArrayList<>(emprunts); // copie défensive
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException si l'emprunt est null
     */
    @Override
    public void save(Emprunt emprunt) {
        if (emprunt == null) {
            throw new IllegalArgumentException("L'emprunt ne peut pas être null");
        }

        // Remplacer l'emprunt s'il existe déjà (même id)
        Iterator<Emprunt> iterator = emprunts.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == emprunt.getId()) {
                iterator.remove();
                break;
            }
        }

        emprunts.add(emprunt);
    }
}
