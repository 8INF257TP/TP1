package info.dicj.distributeur.Distributeur.Distribuable.Saveur;

import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by Michael on 2018-01-17.
 */

public class Bacon extends Saveur {
    public Bacon() {
        super(Resources.getSystem().getString(R.string.bacon_nom),Resources.getSystem().getString(R.string.bacon_desc));
    }

    public String toString() {
        return super.toString();
    }
}
