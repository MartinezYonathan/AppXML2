package uacm.edu.mx.partipromo.domain;

public class Plaza {

    private String calle;
    private String numeroInt;
    private String numExt;
    private  String nomPlaza;
    private String CP;
    private String municipio;


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroInt() {
        return numeroInt;
    }

    public void setNumeroInt(String numeroInt) {
        this.numeroInt = numeroInt;
    }

    public String getNumExt() {
        return numExt;
    }

    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    public String getNomPlaza() {
        return nomPlaza;
    }

    public void setNomPlaza(String nomPlaza) {
        this.nomPlaza = nomPlaza;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Plaza{" +
                "calle='" + calle + '\'' +
                ", numeroInt='" + numeroInt + '\'' +
                ", numExt='" + numExt + '\'' +
                ", nomPlaza='" + nomPlaza + '\'' +
                ", CP='" + CP + '\'' +
                ", municipio='" + municipio + '\'' +
                '}';
    }
}
