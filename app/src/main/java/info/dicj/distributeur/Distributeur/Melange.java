package info.dicj.distributeur.Distributeur;

import java.util.List;

import info.dicj.distributeur.Distributeur.Distribuable.Boisson.Boisson;
import info.dicj.distributeur.Distributeur.Distribuable.Saveur.Saveur;

/**
 * Created by Michael on 2018-01-17.
 */

public class Melange {
    final int MAX_BOISSON = 2;
    int qteBoisson = 0;
    List<Boisson> boissons;
    Saveur saveur;

    public Melange(){};

    public void ajouterBoisson(Boisson boisson) {
        boissons.add(boisson);
        qteBoisson++;

        if(qteBoisson > MAX_BOISSON)
            return; //Throw new DebordementMelangeException("Le melange a deborde!");
    }

    public void ajouterSaveur(Saveur saveur) {
        if(saveur == null)
            this.saveur = saveur;
    }
}
