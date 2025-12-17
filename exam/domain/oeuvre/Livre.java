
package exam.domain.oeuvre;

public final class Livre extends Oeuvre {
    private final String auteur;
    private final int isbn;


    public Livre(long id, String titre, String auteur, int isbn) {
        super(id, titre);

        if (auteur == null || auteur.isBlank())
            throw new IllegalArgumentException("L'auteur ne peut pas être vide");
        this.auteur = auteur;

        if (isbn <= 0)
            throw new IllegalArgumentException("L'ISBN doit être strictement positif");
        this.isbn = isbn;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getIsbn() {
        return isbn;
    }
}