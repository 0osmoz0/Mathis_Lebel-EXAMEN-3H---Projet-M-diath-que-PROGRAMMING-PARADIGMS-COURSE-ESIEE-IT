package exam.domain.oeuvre;

import java.util.Objects;

public abstract class Oeuvre {
    private final long id;      
    private final String titre;  
    private boolean disponible;  


    protected Oeuvre(long id, String titre) {
        if (id <= 0)
            throw new IllegalArgumentException("L'id doit être strictement positif");
        this.id = id;

        if (titre == null || titre.isBlank())
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        this.titre = titre;

        this.disponible = true; 
    }

   
    public long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    protected void marquerDisponible() {
        if (disponible)
            throw new IllegalStateException("L'œuvre est déjà disponible");
        disponible = true;
    }

    protected void marquerIndisponible() {
        if (!disponible)
            throw new IllegalStateException("L'œuvre est déjà indisponible");
        disponible = false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Oeuvre)) return false;
        Oeuvre oeuvre = (Oeuvre) o;
        return id == oeuvre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{id=" + id + ", titre='" + titre + "'}";
    }
}
