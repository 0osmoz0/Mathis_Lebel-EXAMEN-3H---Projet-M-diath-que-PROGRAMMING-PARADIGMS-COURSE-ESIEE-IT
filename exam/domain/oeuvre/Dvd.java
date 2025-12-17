package exam.domain.oeuvre;


public final class Dvd extends Oeuvre {
    private final String realisateur;
    private final int duree;

    public Dvd(long id, String titre, String realisateur, int duree) {
        super(id, titre);

        if (realisateur == null || realisateur.isBlank())
            throw new IllegalArgumentException("Le réalisateur ne peut pas être vide");
        this.realisateur = realisateur;

        if (duree <= 0)
            throw new IllegalArgumentException("La durée doit être strictement positive");
        this.duree = duree;
    }


    public String getRealisateur() {
        return realisateur;
    }

    public int getDuree() {
        return duree;
    }
}