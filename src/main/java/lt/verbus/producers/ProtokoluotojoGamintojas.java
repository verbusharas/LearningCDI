package lt.verbus.producers;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

public class ProtokoluotojoGamintojas {
    @Produces
    public Logger gamintiProtokoluotoja(InjectionPoint injekcijosVieta) {
        return Logger.getLogger(injekcijosVieta.getMember().getDeclaringClass().getName());
    }


}
