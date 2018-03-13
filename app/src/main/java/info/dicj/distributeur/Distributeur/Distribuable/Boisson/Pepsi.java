package info.dicj.distributeur.Distributeur.Distribuable.Boisson;

import android.content.Context;
import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by Michael on 2018-01-17.
 */

public class Pepsi extends Boisson {

    public Pepsi(Context _context) {
        super(_context.getResources().getString(R.string.pepsi_nom), _context.getResources().getString(R.string.pepsi_desc), _context);
    }

    public String toString() {
        return super.toString();
    }
}
