import java.util.Optional;

/*
 * Reponses etape 3 :
 * 1. Un bibliothecaire n'est PAS un catalogue : c'est une personne qui UTILISE un catalogue.
 *    Si Catalogue change, BibliothecaireAbusif change avec lui (classe de base fragile).
 *    bibliothecaire.ajouter(livre) n'a aucun sens : il "s'ajouterait" un livre a lui-meme.
 * 2. Problemes : relation "est un" fausse ; API polluee ; couplage maximal ;
 *    substituabilite absurde ; heritage unique consomme ; relation figee a la compilation.
 * 3. Refactoring : composition + delegation (ci-dessous).
 */
public class Bibliothecaire {
    private final String nom;
    private final Catalogue<Document> catalogue; // COMPOSITION

    public Bibliothecaire(String nom, Catalogue<Document> catalogue) {
        this.nom = nom;
        this.catalogue = catalogue;
    }

    public void accueillir() { System.out.println("Bonjour, " + nom); }

    // DELEGATION : on n'expose que ce qui a un sens pour un bibliothecaire
    public Optional<Document> chercher(String titre) {
        return catalogue.rechercherParTitre(titre);
    }
}
