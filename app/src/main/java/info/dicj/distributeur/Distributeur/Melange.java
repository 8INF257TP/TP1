package info.dicj.distributeur.Distributeur;

import java.util.ArrayList;

import info.dicj.distributeur.Distributeur.Distribuable.Boisson.Boisson;
import info.dicj.distributeur.Distributeur.Distribuable.Saveur.Saveur;
import info.dicj.distributeur.Distributeur.Exception.DebordementMelangeException;

/**
 * Created by Michael on 2018-01-17.
 */

public class Melange {
    private static final int MAX_BOISSON = 2;
    private int qteBoisson = 0;
    private ArrayList<Boisson> boissons;
    private Saveur saveur;

    public Melange(){
        boissons = new ArrayList<>();
    }

    public Melange (Melange _melange) {
        for(Boisson boisson : _melange.boissons)
            try{
            ajouterBoisson(boisson);
            }
            catch (DebordementMelangeException DME){
                DME.printStackTrace();
            }
        saveur = _melange.saveur;
    }

    public void ajouterBoisson(Boisson boisson) throws DebordementMelangeException {
            boissons.add(boisson);
            qteBoisson++;

            if (qteBoisson > MAX_BOISSON) {
                throw new DebordementMelangeException();
            }
    }

    public void ajouterSaveur(Saveur _saveur) throws DebordementMelangeException {
        if(saveur == null)
            saveur = _saveur;
        else
            throw new DebordementMelangeException();
    }

}
