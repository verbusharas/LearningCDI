package lt.verbus.scopes;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UzklausosApimty {

    public String gautiHashKoda(){
        return this.hashCode() + " ";
    }

}
