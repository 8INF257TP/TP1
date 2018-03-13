package info.dicj.distributeur.Distributeur.Exception;

import android.content.Context;
import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by alex on 2018-01-18.
 */

public class AucunDistribuableException extends Exception {

    Context context;

    public AucunDistribuableException(Context _context){
        super();
        context = _context;
    }

    @Override
    public String getMessage() {
        return context.getResources().getString(R.string.ex_aucun_distribuable);
    }
}
