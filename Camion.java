import java.util.Random;

public class Camion {
    private final int id;
    private final int capaciteMin;
    private final int capaciteMax;
    private int tempsRestant;   // Temps restant avant disponibilité
    private boolean disponible;

    public Camion(int id, int capaciteMin, int capaciteMax) {
        this.id = id;
        this.capaciteMin = capaciteMin;
        this.capaciteMax = capaciteMax;
        this.disponible = true;
        this.tempsRestant = 0;
    }

    public int getId() {
        return id;
    }

    public int getCapaciteMin() {
        return capaciteMin;
    }

    public boolean estDisponible() {
        return disponible;
    }

    public void affecterLivraison(String destination, int tempsLivraison, int chargement) {
        this.tempsRestant = tempsLivraison;
        this.disponible = false;
        System.out.println("Camion " + id + " affecté à " + destination + " pour une livraison de " + chargement + " unités, " + tempsLivraison + " jours.");
    }

    public void decrementerTemps() {
        if (!disponible) {
            tempsRestant--;
            if (tempsRestant <= 0) {
                disponible = true;
                //System.out.println("Camion " + id + " est de nouveau disponible.");
            }
        }
    }

    public int charger(int maxDisponible) {
        int difference = Math.min(capaciteMax, maxDisponible) - capaciteMin + 1;
        int random = 0;
        if (difference > 0) {
            random += new Random().nextInt(difference);
        }
        return random + capaciteMin;
    }
}
