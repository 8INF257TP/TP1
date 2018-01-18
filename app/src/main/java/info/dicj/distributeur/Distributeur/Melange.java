package info.dicj.distributeur.Distributeur;

import java.util.List;

import info.dicj.distributeur.Distributeur.Distribuable.Boisson.Boisson;
import info.dicj.distributeur.Distributeur.Distribuable.Saveur.Saveur;
import info.dicj.distributeur.Distributeur.Exception.DebordementMelangeException;

/**
 * Created by Michael on 2018-01-17.
 */

public class Melange {
    private static final int MAX_BOISSON = 2;
    private int qteBoisson = 0;
    private List<Boisson> boissons;
    private Saveur saveur;

    public Melange(){}

    public Melange (Melange _melange) {
        for(Boisson boisson : _melange.boissons)
            ajouterBoisson(boisson);
        saveur = _melange.saveur;
    }

    public void ajouterBoisson(Boisson boisson) {
        try {
            boissons.add(boisson);
            qteBoisson++;

            if (qteBoisson > MAX_BOISSON) {
                throw new DebordementMelangeException();
            }
        }
        catch (DebordementMelangeException DME)
        {
            DME.getMessage();
        }
    }

    public void ajouterSaveur(Saveur saveur) {
        if(saveur == null)
            this.saveur = saveur;
    }
}
