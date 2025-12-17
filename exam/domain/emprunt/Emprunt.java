package exam.domain.emprunt;

import java.time.LocalDate;
import java.util.Objects;


public final class Emprunt {
    private final long id;
    private final long membreId;
    private final long oeuvreId;
    private final LocalDate dateEmprunt;
    private LocalDate dateRetour;

    public Emprunt(long id, long membreId, long oeuvreId, LocalDate dateEmprunt) {
        if (id <= 0)
            throw new IllegalArgumentException("L'id doit être strictement positif");
        this.id = id;

        if (membreId <= 0)
            throw new IllegalArgumentException("L'id du membre doit être strictement positif");
        this.membreId = membreId;

        if (oeuvreId <= 0)
            throw new IllegalArgumentException("L'id de l'oeuvre doit être strictement positif");
        this.oeuvreId = oeuvreId;

        if (dateEmprunt == null)
            throw new IllegalArgumentException("La date d'emprunt ne peut pas être null");
        this.dateEmprunt = dateEmprunt;

        this.dateRetour = null;
    }

    public long getId() {
        return id;
    }

    public long getMembreId() {
        return membreId;
    }

    public long getOeuvreId() {
        return oeuvreId;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }
    
    public boolean isActif(){
        return dateRetour == null;
    }

    public void marquerRetour(LocalDate dateRetour) {
        if (dateRetour == null)
            throw new IllegalArgumentException("La date de retour ne peut pas être null");
        if (this.dateRetour != null)
            throw new IllegalStateException("L'emprunt est déjà retourné");
        this.dateRetour = dateRetour;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", membreId=" + membreId +
                ", oeuvreId=" + oeuvreId +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRetour=" + dateRetour +
                '}';    
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emprunt)) return false;
        Emprunt emprunt = (Emprunt) o;
        return id == emprunt.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);    
    }
}