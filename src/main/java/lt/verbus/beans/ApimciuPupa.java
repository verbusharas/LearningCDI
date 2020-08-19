package lt.verbus.beans;

import lt.verbus.annotations.Tinklui;
import lt.verbus.scopes.PrisitaikanciojeApimty;
import lt.verbus.scopes.ProgramosApimty;
import lt.verbus.scopes.SesijosApimty;
import lt.verbus.scopes.UzklausosApimty;
import lt.verbus.sessionBeans.AuditoServisas;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Tinklui
public class ApimciuPupa implements Serializable {

    //Field injection point
    @Inject
    private UzklausosApimty uzklausosApimty;

    @Inject
    private ProgramosApimty programosApimty;

    @Inject
    private AuditoServisas auditoServisas;

    //Producer object
    @Inject
    private Logger protokoluotojas;

    private SesijosApimty sesijosApimty;

    private PrisitaikanciojeApimty prisitaikanciojeApimty;

    //Lifecycle callback
    @PostConstruct
    private void init() {
        auditoServisas.audituojamasMetodas();
        protokoluotojas.log(Level.INFO, "************************************");
        protokoluotojas.log(Level.INFO, "Apimtys iškviestos");
        protokoluotojas.log(Level.INFO, "************************************");
    }

    @PreDestroy
    private void kill() {
        protokoluotojas.log(Level.INFO, "************************************");
        protokoluotojas.log(Level.INFO, "Apimtys bus sunaikintos :(");
        protokoluotojas.log(Level.INFO, "************************************");
    }

    //Constructor injection point
    @Inject
    private ApimciuPupa(PrisitaikanciojeApimty prisitaikanciojeApimty) {
        this.prisitaikanciojeApimty = prisitaikanciojeApimty;
    }

    //Method injection point
    @Inject
    private void setSesijosApimty(SesijosApimty sesijosApimty) { this.sesijosApimty = sesijosApimty;}

    public String uzklausosApimtiesHashKodas() { return uzklausosApimty.gautiHashKoda();}
    public String programosApimtiesHashKodas() { return programosApimty.gautiHashKoda();}
    public String sesijosApimtiesHashKodas() { return sesijosApimty.gautiHashKoda();}
    public String prisitaikanciosApimtiesHashKodas() { return prisitaikanciojeApimty.gautiHashKoda();}

}
