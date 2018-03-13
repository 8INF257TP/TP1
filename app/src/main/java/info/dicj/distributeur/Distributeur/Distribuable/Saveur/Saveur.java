package info.dicj.distributeur.Distributeur.Distribuable.Saveur;

import android.content.Context;

import info.dicj.distributeur.Distributeur.Distribuable.Distribuable;

/**
 * Created by Michael on 2018-01-17.
 */

public abstract class Saveur extends Distribuable {
    public Saveur(String _nom, String _description, Context _context) {
        super(1, _nom, _description, _context);
    }

    public String toString() {
        return super.toString();
    }

    public void ajouter() {
        super.ajouter();
    }

    public void consommer() {
        super.consommer();
    }
}
