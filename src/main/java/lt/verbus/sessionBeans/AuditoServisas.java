package lt.verbus.sessionBeans;

import lt.verbus.annotations.Protokoluojamas;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class AuditoServisas {

    @Inject
    private Logger protokoluotojas;

    @PostConstruct
    private void init() {

    }

    //This method will only be called after the Logged Interceptor has returned ie InvocationContext#proceed
    //This annotation could also be put on the class, making every method of the class intercepted

    @Protokoluojamas
    public void audituojamasMetodas() {
        protokoluotojas.log(Level.INFO, "OK -> Pavyko iškviesti šitą metodą po audito.");
    }


}
