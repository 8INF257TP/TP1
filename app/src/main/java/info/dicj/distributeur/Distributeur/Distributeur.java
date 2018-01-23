package info.dicj.distributeur.Distributeur;

import java.util.ArrayList;

import info.dicj.distributeur.Distributeur.Distribuable.Boisson.*;
import info.dicj.distributeur.Distributeur.Distribuable.Saveur.*;
import info.dicj.distributeur.Distributeur.Distribuable.Distribuable;
import info.dicj.distributeur.Distributeur.Exception.AucunDistribuableException;
import info.dicj.distributeur.Distributeur.Exception.DebordementMelangeException;

/**
 * Created by : Michael Lizotte, Alexandre Girard-Gagnon
 * Date: 2018-01-17.
 */

public class Distributeur {
    private ArrayList<Boisson> boissons;
    private ArrayList<Saveur> saveurs;
    private Melange melangePrecedent;
    private Melange melangeCourant;

    public Distributeur() {
        boissons = new ArrayList<>();
        saveurs = new ArrayList<>();
        melangeCourant = new Melange();
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
        while(dist.getQuantite() < Distribuable.MAX_PRODUIT)
            dist.ajouter();
    }

    public void ajouterBoisson(String _nomBoisson) throws DebordementMelangeException {
        for(Boisson _boisson: boissons) {
            if(_boisson.getNom() == _nomBoisson)
            {
                if(!_boisson.estVide()) {
                    melangeCourant.ajouterBoisson(_boisson);
                    _boisson.consommer();
                }
            }
        }
    }

    public void ajouterSaveur(String _nomSaveur) throws DebordementMelangeException, AucunDistribuableException {

        for(Saveur _saveur: saveurs) {
            if(_saveur.getNom() == _nomSaveur)
            {
                if(!_saveur.estVide()) {
                    melangeCourant.ajouterSaveur(_saveur);
                    _saveur.consommer();
                }
                else
                    throw new AucunDistribuableException();
            }
        }
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
