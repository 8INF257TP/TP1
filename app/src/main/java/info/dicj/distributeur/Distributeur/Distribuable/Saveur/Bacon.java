package info.dicj.distributeur.Distributeur.Distribuable.Saveur;

import android.content.Context;
import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by Michael on 2018-01-17.
 */

public class Bacon extends Saveur {
    public Bacon(Context _context) {
        super(_context.getResources().getString(R.string.bacon_nom), _context.getResources().getString(R.string.bacon_desc), _context);
    }

    public String toString() {
        return super.toString();
    }
}
