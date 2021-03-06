package uacm.edu.mx.partipromo.domain;

public class Promocion {


    private String tituloPromoción;
    private String descripcionPromo;

    public Promocion(String tituloPromoción, String descripcionPromo) {
        this.tituloPromoción = tituloPromoción;
        this.descripcionPromo = descripcionPromo;
    }

    public String getTituloPromoción() {
        return tituloPromoción;
    }

    public void setTituloPromoción(String tituloPromoción) {
        this.tituloPromoción = tituloPromoción;
    }

    public String getDescripcionPromo() {
        return descripcionPromo;
    }

    public void setDescripcionPromo(String descripcionPromo) {
        this.descripcionPromo = descripcionPromo;
    }
}
