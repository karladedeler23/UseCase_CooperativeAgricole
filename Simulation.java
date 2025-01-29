import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Simulation {

    public static void main(String[] args) {
        Entrepot entrepot = new Entrepot(150);
        List<Agriculteur> agriculteurs = Arrays.asList(
                new Agriculteur(1, 3, 70, 150),
                new Agriculteur(2, 5, 50, 100)
        );
        List<Camion> camions = Arrays.asList(
                new Camion(1, 20, 70),
                new Camion(2, 75, 100)
        );

        List<String> destinations = Arrays.asList("Paris", "Berlin", "Madrid");
        Map<String, Integer> tempsLivraison = Map.of(
                "Paris", 1,
                "Berlin", 2,
                "Madrid", 3
        );

        Cooperative cooperative = new Cooperative(agriculteurs, entrepot, camions, destinations, tempsLivraison);
        cooperative.simuler(14); // Simulation sur 14 jours
    }
}
