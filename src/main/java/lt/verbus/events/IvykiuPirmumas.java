package lt.verbus.events;

import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
public class IvykiuPirmumas {

    @Inject
    Logger protokoluotojas;

    void sveikinimoGavejas(@Observes @Priority(Interceptor.Priority.APPLICATION + 200) String pasveikinimas) {
        protokoluotojas.log(Level.INFO, "Pasveikinimas Nr. 1 su mažesniu pirmumu iškviestas su šia žinute: " + pasveikinimas + "1");
    }

    void sveikinimoGavejas2(@Observes @Priority(Interceptor.Priority.APPLICATION) String pasveikinimas) {
        protokoluotojas.log(Level.INFO, "Pasveikinimas Nr. 2 su didesniu pirmumu iškviestas su šia žinute: " + pasveikinimas + "2");
    }

}
