package exam.repo.impl;

import exam.domain.oeuvre.Oeuvre;
import exam.repo.OeuvreRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Implémentation en mémoire du {@link OeuvreRepository}.
 * <p>
 * Les œuvres sont stockées dans une collection en mémoire.
 * Cette implémentation est destinée aux tests et à la démonstration,
 * sans persistance externe.
 */
public class InMemoryOeuvreRepository implements OeuvreRepository {

    private final List<Oeuvre> oeuvres = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Oeuvre> findById(long id) {
        return oeuvres.stream()
                .filter(oeuvre -> oeuvre.getId() == id)
                .findFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Oeuvre> findAll() {
        return new ArrayList<>(oeuvres); // copie défensive
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException si l'œuvre est null
     */
    @Override
    public void save(Oeuvre oeuvre) {
        if (oeuvre == null) {
            throw new IllegalArgumentException("L'œuvre ne peut pas être null");
        }

        // Remplacement si même id
        Iterator<Oeuvre> iterator = oeuvres.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == oeuvre.getId()) {
                iterator.remove();
                break;
            }
        }

        oeuvres.add(oeuvre);
    }
}
