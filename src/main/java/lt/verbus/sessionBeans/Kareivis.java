package lt.verbus.sessionBeans;

import lt.verbus.annotations.ValstybesTarnautojas;
import lt.verbus.interfaces.Sveikinamas;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.text.MessageFormat;

@Stateful
@ValstybesTarnautojas(reiksme = ValstybesTarnautojas.TarnybosTipas.KAREIVIS)
@lt.verbus.annotations.Kareivis
public class Kareivis implements Sveikinamas, Serializable {

    @Override
    public String sveikinti(String vardas) {
        return MessageFormat.format("Taip, tamsta vade! {0}", vardas);
    }
}