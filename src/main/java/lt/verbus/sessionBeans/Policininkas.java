package lt.verbus.sessionBeans;

import lt.verbus.annotations.ValstybesTarnautojas;
import lt.verbus.interfaces.Sveikinamas;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.text.MessageFormat;

@Stateful
@ValstybesTarnautojas(reiksme = ValstybesTarnautojas.TarnybosTipas.POLICININKAS)
@lt.verbus.annotations.Policininkas
public class Policininkas implements Sveikinamas, Serializable {

    @Override
    public String sveikinti(String vardas) {
        return MessageFormat.format("Taip pareigūne! {0}", vardas);
    }
}
