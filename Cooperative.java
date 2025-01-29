import java.util.*;

public class Cooperative {
    public static void main(String[] args) {
        // Initialisation
        Entrepot entrepot = new Entrepot(150);
        List<Agriculteur> agriculteurs = Arrays.asList(
                new Agriculteur(1, 3, 50, 150),
                new Agriculteur(2, 5, 30, 100)
        );
        List<Camion> camions = Arrays.asList(
                new Camion(1, 50, 100),
                new Camion(2, 75, 150)
        );

        List<String> destinations = Arrays.asList("Paris", "Berlin", "Madrid");
        Map<String, Integer> tempsLivraison = Map.of(
                "Paris", 1,
                "Berlin", 2,
                "Madrid", 3
        );

        // Simulation
        for (int jour = 1; jour <= 14; jour++) {
            System.out.println("\n=== Jour " + jour + " ===");

            // 1. Les agriculteurs livrent
            Collections.shuffle(agriculteurs); // pour varier qui arrive en premier
            for (Agriculteur agriculteur : agriculteurs) {
                if (agriculteur.doitLivrerAujourdHui()) {
                    int livraison = agriculteur.livrer();
                    System.out.println("Agriculteur " + agriculteur.getId() + " a voulu livrer " + livraison + " unités.");
                    int qteLivree = entrepot.recevoirLivraison(livraison);
                    if (qteLivree >= 0) {
                        System.out.println("Agriculteur " + agriculteur.getId() + " a livré " + qteLivree + " unités.");
                    }
                }
            }

            // 2. Vérification des camions et affectation de livraisons
            Collections.shuffle(camions); // pour varier un peu
            for (Camion camion : camions) {
                if (camion.estDisponible()) {
                    int chargement = camion.charger(entrepot.getStockActuel());
                    if (entrepot.chargerCamion(camion, chargement)) {
                        // Affecter une destination aléatoire parmi les destinations disponibles
                        String destination = destinations.get(new Random().nextInt(destinations.size()));
                        camion.affecterLivraison(destination, tempsLivraison.get(destination), chargement);
                    }
                } else {
                    camion.decrementerTemps();
                }
            }

            // 3. Afficher le stock actuel
            System.out.println("Stock actuel dans l'entrepôt : " + entrepot.getStockActuel());
        }
    }
}
