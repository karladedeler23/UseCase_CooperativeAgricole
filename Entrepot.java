public class Entrepot {
    private final int tailleMax;
    private int stockActuel;

    public Entrepot(int tailleMax) {
        this.tailleMax = tailleMax;
        this.stockActuel = 0;
    }

    public int getStockActuel() {
        return stockActuel;
    }

    public int recevoirLivraison(int taille) {
        if (stockActuel >= tailleMax) {
            //System.out.println("Livraison rejetée : pas de place dans l'entrepôt.");
            return -1;
        } else if (stockActuel + taille > tailleMax) {
            int qteAcceptee = tailleMax - stockActuel;
            int qteRefusee = taille - qteAcceptee;
            stockActuel = tailleMax;
            //System.out.println("Livraison partiellement rejetée : accepte " + qteAcceptee + " mais rejette " + qteRefusee + ".");
            return qteAcceptee;
        }
        stockActuel += taille;
        return taille;
    }

    public boolean chargerCamion(Camion camion, int taille) {
        if (stockActuel < camion.getCapaciteMin()) {
            System.out.println("Pas assez de stock pour charger le camion " + camion.getId() +".");
            return false;
        }
        stockActuel -= taille;
        return true;
    }
}
