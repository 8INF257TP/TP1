package info.dicj.distributeur.Distributeur.Exception;

import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by alex on 2018-01-18.
 */

public class AucunMelangeException extends NullPointerException {
    public AucunMelangeException () {
        super();
    }

    @Override
    public String getMessage() {
        return super.getMessage() + Resources.getSystem().getString(R.string.ex_aucun_melange);
    }
}
