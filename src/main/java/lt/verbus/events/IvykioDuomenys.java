package lt.verbus.events;

import java.time.LocalDateTime;

public class IvykioDuomenys {
    private String elpastas;
    private LocalDateTime prisijungimoLaikas;

    public IvykioDuomenys(){
    }

    public IvykioDuomenys(String elpastas, LocalDateTime prisijungimoLaikas) {
        this.elpastas = elpastas;
        this.prisijungimoLaikas = prisijungimoLaikas;
    }

    public String getElpastas() {
        return elpastas;
    }

    public void setElpastas(String elpastas) {
        this.elpastas = elpastas;
    }

    public LocalDateTime getPrisijungimoLaikas() {
        return prisijungimoLaikas;
    }

    public void setPrisijungimoLaikas(LocalDateTime prisijungimoLaikas) {
        this.prisijungimoLaikas = prisijungimoLaikas;
    }
}
