package lt.verbus.scopes;

import java.io.Serializable;

public class SesijosApimty implements Serializable {
    private static final long serialVersionUID = 440804699990999L;

    public String gautiHashKoda(){return this.hashCode() + " ";}
}
