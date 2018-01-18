package info.dicj.distributeur.Distributeur.Exception;

/**
 * Created by alex on 2018-01-18.
 */

public class DebordementMelangeException extends Exception{
    public DebordementMelangeException(){
        super();
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Le melange a deborde";
    }
}
