package info.dicj.distributeur.Distributeur.Distribuable.Saveur;

import android.content.Context;
import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by Michael on 2018-01-17.
 */

public class Gingembre extends Saveur {
    public Gingembre(Context _context) {
        super(_context.getResources().getString(R.string.gin_nom), _context.getResources().getString(R.string.gin_desc), _context);
    }

    public String toString() {
        return super.toString();
    }
}
