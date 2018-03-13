package info.dicj.distributeur.Distributeur.Distribuable.Boisson;

import android.content.Context;
import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by Michael on 2018-01-17.
 */

public class Fraise extends Boisson {
    public Fraise(Context _context) {
        super(_context.getResources().getString(R.string.fraise_nom), _context.getResources().getString(R.string.fraise_desc), _context);
    }

    public String toString() {
        return super.toString();
    }
}
