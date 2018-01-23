package info.dicj.distributeur.Distributeur.Exception;

/**
 * Created by alex on 2018-01-18.
 */

public class AucunMelangeException extends NullPointerException {
    public AucunMelangeException () {
        super();
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Pas de melange !";
    }
}
