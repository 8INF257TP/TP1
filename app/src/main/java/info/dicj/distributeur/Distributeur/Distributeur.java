package info.dicj.distributeur.Distributeur;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

import info.dicj.distributeur.Distributeur.Distribuable.Boisson.*;
import info.dicj.distributeur.Distributeur.Distribuable.Saveur.*;
import info.dicj.distributeur.Distributeur.Distribuable.Distribuable;
import info.dicj.distributeur.Distributeur.Exception.AucunDistribuableException;
import info.dicj.distributeur.Distributeur.Exception.AucunMelangeException;
import info.dicj.distributeur.Distributeur.Exception.DebordementMelangeException;

/**
 * Created by : Michael Lizotte, Alexandre Girard-Gagnon
 * Date: 2018-01-17.
 */

public class Distributeur{
    private ArrayList<Boisson> boissons;
    private ArrayList<Saveur> saveurs;
    private Melange melangePrecedent;
    private Melange melangeCourant;
    private Context context;

    public Distributeur(Context _context)
    {
        boissons = new ArrayList<>();
        saveurs = new ArrayList<>();
        melangeCourant = new Melange();
        context = _context;
        remplirDistributeur();
    }
    private void remplirDistributeur() {
        boissons.add(new Fraise(context));
        boissons.add(new Orangeade(context));
        boissons.add(new Pepsi(context));
        boissons.add(new Racinette(context));

        for (Boisson boisson : boissons)
            remplirProduit(boisson);

        saveurs.add(new Bacon(context));
        saveurs.add(new Epice(context));
        saveurs.add(new Gingembre(context));

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
                    throw new AucunDistribuableException(context);
            }
        }
    }

    public void nouveauMelange(){
        melangePrecedent = melangeCourant;
        melangeCourant = new Melange();
    }

    public void dupliquerMelange() throws AucunMelangeException, AucunDistribuableException, DebordementMelangeException {
        if (melangePrecedent == null)
            throw new AucunMelangeException(context);
        if (melangePrecedent.getNbBoissons() > 2)
            throw new DebordementMelangeException(context);
        for (Boisson boisson : melangePrecedent.getBoissons())
            if (boisson.estVide())
                throw new AucunDistribuableException(context);
        melangeCourant = melangePrecedent;
    }

    public Melange melangerRecette() throws AucunMelangeException {
        if (melangeCourant.getBoissons().isEmpty())
                throw new AucunMelangeException(context);
        melangePrecedent = melangeCourant;
        return melangeCourant;
    }
}
