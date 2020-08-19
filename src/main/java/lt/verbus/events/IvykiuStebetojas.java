package lt.verbus.events;

import lt.verbus.annotations.Administravimas;
import lt.verbus.annotations.PopuliarusStendas;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
public class IvykiuStebetojas implements Serializable {

    @Inject
    private Logger protokoluotojas;

    void paprastasIvykis(@Observes IvykioDuomenys ivykioDuomenys) {
        //Persist in databse, send to another application outside your app
        //Essentially you can do whatever you want with the event data here.
        //We will just log it
        protokoluotojas.log(Level.INFO, "Vartotojas {0} prisijungė {1}. Protokoluota iš paprastojo įvykio stebėtojo.",
                new Object[]{ivykioDuomenys.getElpastas(), ivykioDuomenys.getPrisijungimoLaikas()});
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            protokoluotojas.log(Level.SEVERE, null, e);
        }
    }

    void vartotojasPrisijunge(@Observes @PopuliarusStendas IvykioDuomenys ivykioDuomenys) {
        //Persist in databse, send to another application outside your app
        //Essentially you can do whatever you want with the event data here.
        //We will just log it
        protokoluotojas.log(Level.INFO, "Vartotojas {0} prisijunge {1}. Protokoluota iš patikros stebėtojo.",
                new Object[]{ivykioDuomenys.getElpastas(), ivykioDuomenys.getPrisijungimoLaikas()});
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            protokoluotojas.log(Level.SEVERE, null, e);
//        }
    }

    void asyncStebetojas(@ObservesAsync @PopuliarusStendas IvykioDuomenys ivykioDuomenys) {
        //Persist in databse, send to another application outside your app
        //Essentially you can do whatever you want with the event data here.
        //We will just log it
        protokoluotojas.log(Level.INFO, "Vartotojas {0} prisijunge {1}. Protokoluota iš aSync stebėtojo.",
                new Object[]{ivykioDuomenys.getElpastas(), ivykioDuomenys.getPrisijungimoLaikas()});
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            protokoluotojas.log(Level.SEVERE, null, e);
        }
    }

    void salyginisStebetojas(@Observes(notifyObserver = Reception.IF_EXISTS,
            during = TransactionPhase.IN_PROGRESS) @Administravimas IvykioDuomenys ivykioDuomenys) {
        protokoluotojas.log(Level.INFO, "VADOVAS {0} prisijungė {1}. Protokoluota ir salyginio stebėtojo",
                new Object[]{ivykioDuomenys.getElpastas(), ivykioDuomenys.getPrisijungimoLaikas()});
    }


}
