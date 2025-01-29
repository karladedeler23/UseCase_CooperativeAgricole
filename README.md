# Simulation du Système d'une Coopérative Agricole

## Cas d'utilisation

L'objectif est de modéliser le système d'une coopérative agricole et d'en simuler le fonctionnement avec les fonctionnalités suivantes :

- Plusieurs producteurs livrent leurs marchandises dans un entrepôt commun.
- L'entrepôt a une capacité limitée.
- Les agriculteurs livrent à des fréquences différentes, de 1 à 5 fois par semaine.
- Les livraisons peuvent avoir des tailles variables.
- La coopérative dispose de plusieurs camions fonctionnant 24h/24 et 7j/7 pour transporter les marchandises de l'entrepôt vers diverses destinations en Europe (par exemple, des hypermarchés).
- Le temps de livraison des camions dépend de leur destination.

## Objectifs

Le système doit être modélisé et simulé sur une période déterminée (plusieurs mois) avec des paramètres ajustables :

- Nombre d'agriculteurs
- Taille de l'entrepôt
- Capacité minimale et maximale des camions
- Nombre de camions

La simulation doit enregistrer un log pour chaque livraison dans l'entrepôt ou chaque expédition vers un hypermarché.

## Contraintes Techniques

- La solution doit être développée en **Java**.
- Une classe de test ou un `main` doit être prévu pour exécuter la simulation.
- Le code doit être publié sur **GitHub**.
- Le délai d'implémentation est de **une semaine maximum** (idéalement).

---

### Comment exécuter la simulation

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/votre-repertoire.git
   cd votre-repertoire
2. Compilez et exécutez le projet en utilisant votre IDE Java préféré ou en ligne de commande :
   ```bash
    javac Simulation.java
    java Simulation
3. Consultez les logs de la simulation pour analyser les livraisons et les expéditions.
