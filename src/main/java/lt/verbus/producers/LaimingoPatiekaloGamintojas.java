package lt.verbus.producers;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import java.util.ArrayList;
import java.util.List;

public class LaimingoPatiekaloGamintojas {

    /**
     * Producer methods are very useful for when the concrete type to to be
     * injected varies at runtime. This provides polymorphic injection at
     * runtime. Think of CDI producers as the Factory Pattern.
     * <p>
     * Producers are also a way to transform beans we don't own into contextual
     * instances
     * <p>
     * Default scope of produced object is Dependent Scope. Could be altered by
     * annotating the method accordingly.
     */

    @Produces
    public List<String> getLaimingiPatiekalai(){
        List<String> patiekalai = new ArrayList<>();

        patiekalai.add("Šaltibarščiai");
        patiekalai.add("Tacos");
        patiekalai.add("Pasta pecorino");
        patiekalai.add("Shakshuka");
        patiekalai.add("Charčio");
        patiekalai.add("Plovas");
        patiekalai.add("Žemaitiška + jelapenos");
        patiekalai.add("Apvalios bulvės");
        patiekalai.add("Šonkauliai");
        return patiekalai;
    }

    public void dispose(@Disposes List<String> patiekalai) { patiekalai = null; }


}
