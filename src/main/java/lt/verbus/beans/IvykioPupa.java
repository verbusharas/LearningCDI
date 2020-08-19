package lt.verbus.beans;

import lt.verbus.annotations.Administravimas;
import lt.verbus.annotations.PopuliarusStendas;
import lt.verbus.annotations.Tinklui;
import lt.verbus.events.IvykioDuomenys;
import lt.verbus.events.Vartotojas;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletionStage;

@Tinklui
public class IvykioPupa {

    @Inject
    private Vartotojas vartotojas;

    @Inject
    Event<String> pasisveikinimoIvykis;

    @Inject
    Event<IvykioDuomenys> paprastasIvykis;

    @Inject
    @PopuliarusStendas
    private Event<IvykioDuomenys> ivykioDuomenuIvykis;

    @Inject
    @Administravimas
    private Event<IvykioDuomenys> salyginisIvykis;

    public void login() {
        //Do credentials checking to login in user then fire login event
        //someSecurityManager.loginUser(user.getEmail, user.getPassword)

        pasisveikinimoIvykis.fire("Labas iš pirmumo");

        paprastasIvykis.fire(new IvykioDuomenys(vartotojas.getElpastas(), LocalDateTime.now()));

        LocalDateTime dabar = LocalDateTime.now();

        System.out.println("Kažkodėl spausdinamas dabarties laikas: " + dabar);

        CompletionStage<IvykioDuomenys> fireAsync = ivykioDuomenuIvykis.fireAsync(new IvykioDuomenys(vartotojas.getElpastas(), LocalDateTime.now()));

        long sekundes = ChronoUnit.SECONDS.between(dabar, LocalDateTime.now());
        System.out.println("Prisijungta per: " + sekundes + " sek.");

        // Qualified Observer
        salyginisIvykis.fire(new IvykioDuomenys(vartotojas.getElpastas(), LocalDateTime.now()));
    }

    public Vartotojas getVartotojas() {
        return vartotojas;
    }

    public void setVartotojas(Vartotojas vartotojas) {
        this.vartotojas = vartotojas;
    }

}
