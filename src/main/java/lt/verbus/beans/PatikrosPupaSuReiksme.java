package lt.verbus.beans;

import lt.verbus.annotations.Tinklui;
import lt.verbus.annotations.ValstybesTarnautojas;
import lt.verbus.interfaces.Sveikinamas;

import javax.inject.Inject;
import java.io.Serializable;

@Tinklui
public class PatikrosPupaSuReiksme implements Serializable {

    @Inject
    @ValstybesTarnautojas(reiksme = ValstybesTarnautojas.TarnybosTipas.POLICININKAS)
    private Sveikinamas sveikinamasPolicininkas;

    @Inject
    @ValstybesTarnautojas(reiksme = ValstybesTarnautojas.TarnybosTipas.KAREIVIS)
    private Sveikinamas sveikinamasKareivis;

    private String policininkoPasveikinimas;
    private String kareivioPasveikinimas;
    private String vardas;

    public void sveikintiKaipPolicininka() {
        policininkoPasveikinimas = sveikinamasPolicininkas.sveikinti(vardas);
    }

    public void sveikintiKaipKareivi() {
        kareivioPasveikinimas = sveikinamasKareivis.sveikinti(vardas);
    }

    public String getPolicininkoPasveikinimas() {
        return policininkoPasveikinimas;
    }

    public void setPolicininkoPasveikinimas(String policininkoPasveikinimas) {
        this.policininkoPasveikinimas = policininkoPasveikinimas;
    }

    public String getKareivioPasveikinimas() {
        return kareivioPasveikinimas;
    }

    public void setKareivioPasveikinimas(String kareivioPasveikinimas) {
        this.kareivioPasveikinimas = kareivioPasveikinimas;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }
}
