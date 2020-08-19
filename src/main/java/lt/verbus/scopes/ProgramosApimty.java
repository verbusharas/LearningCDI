package lt.verbus.scopes;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class ProgramosApimty implements Serializable {

    //??????????
    private static final long serialVersionUID = 27080464521478L;

    public String gautiHashKoda(){return this.hashCode() + " "; }

}
