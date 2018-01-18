package info.dicj.distributeur.Distributeur;

import java.util.List;

import info.dicj.distributeur.Distributeur.Distribuable.Boisson.*;
import info.dicj.distributeur.Distributeur.Distribuable.Saveur.*;
import info.dicj.distributeur.Distributeur.Distribuable.Distribuable;

/**
 * Created by Michael on 2018-01-17.
 */

public class Distributeur {
    List<Boisson> boissons;
    List<Saveur> saveurs;
    Melange melangePrecedent;
    Melange melangeCourant;

    public Distributeur() {
        remplirDistributeur();
    }
    private void remplirDistributeur() {
        boissons.add(new Fraise());
        boissons.add(new Orangeade());
        boissons.add(new Pepsi());
        boissons.add(new Racinette());

        for (Boisson boisson : boissons)
            remplirProduit(boisson);

        saveurs.add(new Bacon());
        saveurs.add(new Epice());
        saveurs.add(new Gingembre());

        for(Saveur saveur : saveurs)
            remplirProduit(saveur);
    }
    private void remplirProduit(Distribuable dist) {
        while(dist.getQuantite()<dist.MAX_PRODUIT)
            dist.ajouter();
    }
}
