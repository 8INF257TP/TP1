package info.dicj.distributeur.Distributeur;

import java.util.List;

import info.dicj.distributeur.Distributeur.Distribuable.Boisson.Boisson;
import info.dicj.distributeur.Distributeur.Distribuable.Saveur.Saveur;

/**
 * Created by Michael on 2018-01-17.
 */

public class Melange {
    final int MAX_BOISSON = 2;
    List<Boisson> boissons;
    Saveur saveur;

    public Melange(){};

    public boolean ajouterBoisson(Boisson boisson) {

        if(boissons.contains(boisson))
            boissons.get(boissons.indexOf(boissons)).ajouter();
        else if(boissons.size() >= 2)
            return false;
        else
            boissons.add(boisson);

        return true;
    }

    public boolean ajouterSaveur(Saveur saveur) {
        if(saveur == null)
            this.saveur = saveur;
        else
            return false;

        return true;
    }
}
