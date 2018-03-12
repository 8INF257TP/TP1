package info.dicj.distributeur.Distributeur.Distribuable.Saveur;

import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by Michael on 2018-01-17.
 */

public class Gingembre extends Saveur {
    public Gingembre() {
        super(Resources.getSystem().getString(R.string.gin_nom), Resources.getSystem().getString(R.string.gin_desc));
    }

    public String toString() {
        return super.toString();
    }
}
