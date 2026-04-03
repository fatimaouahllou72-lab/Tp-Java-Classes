package partie1;
public class CompteBancaire {

    private int numero;
    private String titulaire;
    private double solde;
    private double decouvertAutorise;

    private static int nbComptes = 0;
    private static double tauxInteretAnnuel = 0.03;

    // Constructeur par défaut
    public CompteBancaire() {
        this.numero = ++nbComptes;
        this.titulaire = "Inconnu";
        this.solde = 0;
        this.decouvertAutorise = 0;
    }

    // Constructeur paramétré
    public CompteBancaire(String titulaire, double solde, double decouvertAutorise) {
        this.numero = ++nbComptes;
        setTitulaire(titulaire);
        this.solde = solde;
        setDecouvertAutorise(decouvertAutorise);
    }

    // Getters & Setters
    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        if (titulaire != null && !titulaire.isEmpty()) {
            this.titulaire = titulaire;
        }
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(double decouvertAutorise) {
        if (decouvertAutorise >= 0) {
            this.decouvertAutorise = decouvertAutorise;
        }
    }

    public static int getNbComptes() {
        return nbComptes;
    }

    public static double getTauxInteretAnnuel() {
        return tauxInteretAnnuel;
    }

    public static void setTauxInteretAnnuel(double taux) {
        if (taux >= 0) {
            tauxInteretAnnuel = taux;
        }
    }

    // Méthode afficher
    public void afficher() {
        System.out.println("Compte N°: " + numero);
        System.out.println("Titulaire: " + titulaire);
        System.out.println("Solde: " + solde);
        System.out.println("Découvert autorisé: " + decouvertAutorise);
        System.out.println("----------------------------");
    }

    // Dépôt
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }

    // Retrait
    public void retirer(double montant) {
        if (montant > 0 && solde - montant >= -decouvertAutorise) {
            solde -= montant;
        } else {
            System.out.println("Retrait refusé.");
        }
    }

    // Virement
    public void virementVers(CompteBancaire autre, double montant) {
        if (montant > 0 && solde - montant >= -decouvertAutorise) {
            this.retirer(montant);
            autre.deposer(montant);
        } else {
            System.out.println("Virement impossible : montant ou solde insuffisant.");
        }
    }

    // Intérêts
    public double calculerSoldeAvecInterets() {
        return solde + (solde * tauxInteretAnnuel);
    }

    public double calculerSoldeAvecInterets(double bonus) {
        return solde + (solde * (tauxInteretAnnuel + bonus));
    }
}