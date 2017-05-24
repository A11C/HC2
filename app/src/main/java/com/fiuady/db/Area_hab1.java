package com.fiuady.db;

public class Area_hab1 {
    private int id;
    private int perfil_id;
    private String luz;
    private String luzr;
    private String luzg;
    private String luzb;
    private String ventana;
    private String ventilador;
    private String autoventi;
    private String tempmin;
    private String tempmax;
    private String tempact;

    public Area_hab1(int id, int perfil_id, String luz, String luzr, String luzg,
                     String luzb, String ventana, String ventilador, String autoventi,
                     String tempmin, String tempmax, String tempact) {
        this.id = id;
        this.perfil_id = perfil_id;
        this.luz = luz;
        this.luzr = luzr;
        this.luzg = luzg;
        this.luzb = luzb;
        this.ventana = ventana;
        this.ventilador = ventilador;
        this.autoventi = autoventi;
        this.tempmin = tempmin;
        this.tempmax = tempmax;
        this.tempact = tempact;
    }

    public int getId() {
        return id;
    }

    public int getPerfil_id() {
        return perfil_id;
    }

    public void setPerfil_id(int perfil_id) {
        this.perfil_id = perfil_id;
    }

    public String getLuz() {
        return luz;
    }

    public void setLuz(String luz) {
        this.luz = luz;
    }

    public String getLuzr() {
        return luzr;
    }

    public void setLuzr(String luzr) {
        this.luzr = luzr;
    }

    public String getLuzg() {
        return luzg;
    }

    public void setLuzg(String luzg) {
        this.luzg = luzg;
    }

    public String getLuzb() {
        return luzb;
    }

    public void setLuzb(String luzb) {
        this.luzb = luzb;
    }

    public String getVentana() {
        return ventana;
    }

    public void setVentana(String ventana) {
        this.ventana = ventana;
    }

    public String getVentilador() {
        return ventilador;
    }

    public void setVentilador(String ventilador) {
        this.ventilador = ventilador;
    }

    public String getAutoventi() {
        return autoventi;
    }

    public void setAutoventi(String autoventi) {
        this.autoventi = autoventi;
    }

    public String getTempmin() {
        return tempmin;
    }

    public void setTempmin(String tempmin) {
        this.tempmin = tempmin;
    }

    public String getTempmax() {
        return tempmax;
    }

    public void setTempmax(String tempmax) {
        this.tempmax = tempmax;
    }

    public String getTempact() {
        return tempact;
    }

    public void setTempact(String tempact) {
        this.tempact = tempact;
    }
}
