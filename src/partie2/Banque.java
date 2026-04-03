package partie2;

import partie1.CompteBancaire;
public class Banque {

    private String nom;
    private CompteBancaire[] comptes;
    private int nbActuels;

    public Banque(String nom, int capacite) {
        this.nom = nom;
        this.comptes = new CompteBancaire[capacite];
        this.nbActuels = 0;
    }

    // Ajouter un compte
    public void ajouterCompte(CompteBancaire c) {
        if (nbActuels < comptes.length) {
            comptes[nbActuels++] = c;
        } else {
            System.out.println("Capacité maximale atteinte.");
        }
    }
    
    // Afficher tous les comptes
    public void afficherTous() {
        System.out.println("Nom de la banque: " + nom);
        System.out.println("Liste des comptes:");
        System.out.println("====================");

        for (int i = 0; i < nbActuels; i++) {
            comptes[i].afficher();
        }
    }

}