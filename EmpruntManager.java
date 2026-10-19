public class EmpruntManager {
    private final Catalogue<Document> catalogue; // COMPOSITION

    public EmpruntManager(Catalogue<Document> catalogue) {
        this.catalogue = catalogue;
    }

    public void emprunter(String titre) throws MediathequeException {
        Document d = catalogue.rechercherParTitre(titre)
                .orElseThrow(() -> new DocumentIntrouvableException(titre));
        if (!(d instanceof Empruntable e)) {
            throw new DocumentIndisponibleException(titre, "consultation sur place uniquement");
        }
        e.emprunter();
    }
}
