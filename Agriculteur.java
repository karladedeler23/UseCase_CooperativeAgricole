import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Agriculteur {
    private final int id;
    private final int frequenceLivraison; // Nombre de livraisons par semaine
    private final int tailleLivraisonMin;
    private final int tailleLivraisonMax;
    private final Set<Integer> joursLivraison; // Jours de livraison dans la semaine (1 = lundi, 7 = dimanche)
    private int jourActuel; // Compteur pour suivre les jours de la semaine

    public Agriculteur(int id, int frequenceLivraison, int tailleLivraisonMin, int tailleLivraisonMax) {
        this.id = id;

        // Vérification de la fréquence (doit être entre 1 et 5)
        if (frequenceLivraison < 1 || frequenceLivraison > 5) {
            throw new IllegalArgumentException("La fréquence de livraison doit être comprise entre 1 et 5.");
        }
        this.frequenceLivraison = frequenceLivraison;

        this.tailleLivraisonMin = tailleLivraisonMin;
        this.tailleLivraisonMax = tailleLivraisonMax;
        this.joursLivraison = calculerJoursLivraison();
        this.jourActuel = 1; // Commence à lundi
    }

    private Set<Integer> calculerJoursLivraison() {
        Set<Integer> jours = new HashSet<>();
        int intervalle = 7 / frequenceLivraison; // Espacement idéal entre livraisons
        int jour = 1; // Commence à lundi
        for (int i = 0; i < frequenceLivraison; i++) {
            jours.add(jour);
            jour += intervalle;
            if (jour > 7) {
                jour -= 7; // Revenir au début de la semaine
            }
        }
        return jours;
    }

    public boolean doitLivrerAujourdHui() {
        boolean doitLivrer = joursLivraison.contains(jourActuel);
        jourActuel = (jourActuel % 7) + 1; // Passer au jour suivant
        return doitLivrer;
    }

    public int getId() {
        return id;
    }

    public int livrer() {
        return new Random().nextInt(tailleLivraisonMax - tailleLivraisonMin + 1) + tailleLivraisonMin;
    }
}
