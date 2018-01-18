package info.dicj.distributeur.Distributeur.Distribuable;

/**
 * Created by Michael on 2018-01-17.
 */

public class Distribuable implements IProduit{
    int quantite;
    String nom;
    String description;
    public static final int MAX_PRODUIT = 10;

    public Distribuable(int _quantite, String _nom, String _description) {
        quantite = _quantite;
        nom = _nom;
        description = _description;
    }

    public void ajouter() {
        if(quantite < MAX_PRODUIT)
            quantite += 1;
    }
    public void consommer() {
        if(quantite > 0)
            quantite -= 1;
    }

    public boolean estVide() {
        return quantite == 0;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantite() {
        return quantite;
    }

    public String toString() {
        return nom+":"+description+" qte: "+quantite;
    }
}
