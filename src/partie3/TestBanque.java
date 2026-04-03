package partie3;

import partie1.CompteBancaire;
import partie2.Banque;

public class TestBanque {

    public static void main(String[] args) {

        // 1. Création banque
        Banque banque = new Banque("MarocBank", 1500);

        // 2. Création comptes
        CompteBancaire c1 = new CompteBancaire("Ali", 1000, 500);
        CompteBancaire c2 = new CompteBancaire("Sara", 2000, 300);
        CompteBancaire c3 = new CompteBancaire("Yassine", 1500, 400);

        // 3. Ajout à la banque
        banque.ajouterCompte(c1);
        banque.ajouterCompte(c2);
        banque.ajouterCompte(c3);

        // 4. Opérations
        c1.deposer(500);
        c1.retirer(1200);

        c2.virementVers(c3, 500);

        // 5. Affichage
        banque.afficherTous();

        // 6. Intérêts
        System.out.println("Solde avec intérêts (c2): " + c2.calculerSoldeAvecInterets());
        System.out.println("Solde avec bonus (c2): " + c2.calculerSoldeAvecInterets(0.015));

        // 7. Infos globales
        System.out.println("Nombre total de comptes: " + CompteBancaire.getNbComptes());
        System.out.println("Taux d'intérêt: " + CompteBancaire.getTauxInteretAnnuel());
    }
}