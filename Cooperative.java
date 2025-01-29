import java.util.*;

class Cooperative {
    private final List<Agriculteur> agriculteurs;
    private final Entrepot entrepot;
    private final List<Camion> camions;
    private final List<String> destinations;
    private final Map<String, Integer> tempsLivraison;
    private int jourActuel;

    public Cooperative(List<Agriculteur> agriculteurs, Entrepot entrepot, List<Camion> camions,
                       List<String> destinations, Map<String, Integer> tempsLivraison) {
        this.agriculteurs = agriculteurs;
        this.entrepot = entrepot;
        this.camions = camions;
        this.destinations = destinations;
        this.tempsLivraison = tempsLivraison;
        this.jourActuel = 1;
    }

    public void simuler(int jours) {
        for (int i = 0; i < jours; i++) {
            System.out.println("\n=== Jour " + jourActuel + " ===");
            gererLivraisons();
            gererExpeditions();
            afficherStock();
            jourActuel++;
        }
    }

    private void gererLivraisons() {
        Collections.shuffle(agriculteurs); // Variation des ordres de livraison
        for (Agriculteur agriculteur : agriculteurs) {
            if (agriculteur.doitLivrerAujourdHui()) {
                int livraison = agriculteur.livrer();
                System.out.println("Agriculteur " + agriculteur.getId() + " veut livrer " + livraison + " unités.");
                int qteLivree = entrepot.recevoirLivraison(livraison);
                if (qteLivree >= 0) {
                    System.out.println("Agriculteur " + agriculteur.getId() + " a livré " + qteLivree + " unités.");
                } else {
                    System.out.println("Entrepôt plein ! Livraison refusée.");
                }
            }
        }
    }

    private void gererExpeditions() {
        Collections.shuffle(camions); // Variation de l'affectation
        for (Camion camion : camions) {
            if (camion.estDisponible()) {
                int chargement = camion.charger(entrepot.getStockActuel());
                if (entrepot.chargerCamion(camion, chargement)) {
                    String destination = destinations.get(new Random().nextInt(destinations.size()));
                    camion.affecterLivraison(destination, tempsLivraison.get(destination), chargement);
                }
            } else {
                camion.decrementerTemps();
            }
        }
    }

    private void afficherStock() {
        System.out.println("Stock actuel dans l'entrepôt : " + entrepot.getStockActuel());
    }
}
