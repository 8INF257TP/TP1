package info.dicj.distributeur.Distributeur.Distribuable.Boisson;

import android.content.Context;
import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by Michael on 2018-01-17.
 */

public class Racinette extends Boisson {
    public Racinette(Context _context) {
        super(_context.getResources().getString(R.string.racinette_nom), _context.getResources().getString(R.string.racinette_desc), _context);
    }

    public String toString() {
        return super.toString();
    }
}
