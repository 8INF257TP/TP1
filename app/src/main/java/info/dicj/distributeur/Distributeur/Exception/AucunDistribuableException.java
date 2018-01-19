package info.dicj.distributeur.Distributeur.Exception;

/**
 * Created by alex on 2018-01-18.
 */

public class AucunDistribuableException extends Exception {
    public AucunDistribuableException(){
        super();
    }

    @Override
    public String getMessage() {
        return "Le distributeur est vide !";
    }
}
