package info.dicj.distributeur.Distributeur.Exception;

import android.content.res.Resources;

import info.dicj.distributeur.R;

/**
 * Created by alex on 2018-01-18.
 */

public class DebordementMelangeException extends Exception{
    public DebordementMelangeException(){
        super();
    }

    @Override
    public String getMessage() {
        return Resources.getSystem().getString(R.string.ex_debordement);
    }
}
