package info.dicj.distributeur.Distributeur.Distribuable.Boisson;

import android.content.Context;
import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by Michael on 2018-01-17.
 */

public class Orangeade extends Boisson {
    public Orangeade(Context _context) {
        super(_context.getResources().getString(R.string.orangeade_nom), _context.getResources().getString(R.string.orangeade_desc), _context);
    }

    public String toString() {
        return super.toString();
    }
}
