package info.dicj.distributeur.Distributeur.Distribuable.Boisson;

import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by Michael on 2018-01-17.
 */

public class Orangeade extends Boisson {
    public Orangeade() {
        super(Resources.getSystem().getString(R.string.orangeade_nom), Resources.getSystem().getString(R.string.orangeade_desc));
    }

    public String toString() {
        return super.toString();
    }
}
