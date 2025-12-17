package exam.repo.impl;

import exam.domain.membre.Membre;
import exam.repo.MembreRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Implémentation en mémoire du {@link MembreRepository}.
 * <p>
 * Les membres sont stockés dans une collection en mémoire.
 * Cette implémentation est destinée aux tests et à l'usage pédagogique,
 * sans persistance externe.
 */
public class InMemoryMembreRepository implements MembreRepository {

    private final List<Membre> membres = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Membre> findById(long id) {
        return membres.stream()
                .filter(membre -> membre.getId() == id)
                .findFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Membre> findAll() {
        return new ArrayList<>(membres); // copie défensive
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException si le membre est null
     */
    @Override
    public void save(Membre membre) {
        if (membre == null) {
            throw new IllegalArgumentException("Le membre ne peut pas être null");
        }

        // Remplacer le membre si même identifiant
        Iterator<Membre> iterator = membres.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == membre.getId()) {
                iterator.remove();
                break;
            }
        }

        membres.add(membre);
    }
}
