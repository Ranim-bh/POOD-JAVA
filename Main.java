public class Main {
    public static void main(String[] args) {
        Catalogue<Document> catalogue = new Catalogue<>();
        catalogue.ajouter(new Livre("Clean Code", 2008, "R. Martin", 464));
        catalogue.ajouter(new Dvd("Inception", 2010, 148));
        catalogue.ajouter(new Revue("Science", 2026, 412));
        catalogue.afficherTout();

        EmpruntManager manager = new EmpruntManager(catalogue);
        essayer(manager, "Clean Code");
        essayer(manager, "Clean Code");
        essayer(manager, "Science");
        essayer(manager, "Fantome");
    }

    private static void essayer(EmpruntManager m, String titre) {
        try {
            m.emprunter(titre);
            System.out.println("OK : " + titre);
        } catch (DocumentIntrouvableException e) {
            System.out.println("Introuvable : " + e.getMessage());
        } catch (DocumentIndisponibleException e) {
            System.out.println("Indisponible : " + e.getMessage());
        } catch (MediathequeException e) {
            System.out.println("Autre : " + e.getMessage());
        }
    }
}