package info.dicj.distributeur.Distributeur.Distribuable.Boisson;

import info.dicj.distributeur.Distributeur.Distribuable.Distribuable;

/**
 * Created by Michael on 2018-01-17.
 */

public abstract class Boisson extends Distribuable {
    public Boisson(String _nom, String _description) {
        super(1, _nom, _description);
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
