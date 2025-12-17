package exam.domain.membre;

public final class Membre {
    private final long id;
    private final String nom;
    private StatutMembre statut;

    public Membre(long id, String nom) {
        if (id <= 0) throw new IllegalArgumentException("id invalide");
        if (nom == null || nom.isBlank()) throw new IllegalArgumentException("nom vide");

        this.id = id;
        this.nom = nom;
        this.statut = StatutMembre.ACTIF;
    }

    public boolean estActif() {
        return statut == StatutMembre.ACTIF;
    }

    public void activer() {
        statut = StatutMembre.ACTIF; 
    }

    public void desactiver() {
        statut = StatutMembre.INACTIF;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Membre{id=" + id + ", nom='" + nom + "', statut=" + statut + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membre)) return false;
        Membre membre = (Membre) o;
        return id == membre.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
