package info.dicj.distributeur.Distributeur;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;

import info.dicj.distributeur.Distributeur.Distribuable.Boisson.Boisson;
import info.dicj.distributeur.Distributeur.Distribuable.Saveur.Saveur;
import info.dicj.distributeur.Distributeur.Exception.DebordementMelangeException;
import info.dicj.distributeur.R;

/**
 * Created by Michael on 2018-01-17.
 */

public class Melange implements Recette {
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

    public String getInformation() {
        ArrayList<String> nomBoissons = new ArrayList<>();

        for(Boisson boisson: boissons){
            nomBoissons.add(boisson.getNom());
        }

        if(saveur == null)
            return Resources.getSystem().getString(R.string.info_boisson_1) + nomBoissons.toString() +
                    Resources.getSystem().getString(R.string.info_boisson_2) +
                    Resources.getSystem().getString(R.string.info_boisson_2_aucune);
        else
            return Resources.getSystem().getString(R.string.info_boisson_1) + nomBoissons.toString() +
                    Resources.getSystem().getString(R.string.info_boisson_2) + saveur.getNom();
    }

    public int getNbBoissons(){
        return boissons.size();
    }

    public ArrayList<Boisson> getBoissons (){
        return boissons;
    }
}
