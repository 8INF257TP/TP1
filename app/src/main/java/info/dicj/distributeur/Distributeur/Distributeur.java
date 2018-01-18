package info.dicj.distributeur.Distributeur;

import java.util.List;

import info.dicj.distributeur.Distributeur.Distribuable.Boisson.*;
import info.dicj.distributeur.Distributeur.Distribuable.Saveur.*;
import info.dicj.distributeur.Distributeur.Distribuable.Distribuable;

/**
 * Created by : Michael Lizotte, Alexandre Girard-Gagnon
 * Date: 2018-01-17.
 */

public class Distributeur {
    private List<Boisson> boissons;
    private List<Saveur> saveurs;
    private Melange melangePrecedent;
    private Melange melangeCourant;

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
        while(dist.getQuantite()<Distribuable.MAX_PRODUIT)
            dist.ajouter();
    }
    public void nouveauMelange(){
        melangePrecedent = melangeCourant;
        melangeCourant = new Melange();
    }

    public void dupliquerMelange(){
        melangePrecedent = melangeCourant;
        melangeCourant = new Melange(melangePrecedent);
    }

   // public Melange getMelangeCourant() {}

   // public Melange getMelangePrecedent() {}
}
