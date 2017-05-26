package com.fiuady.db;

public class Area_hab1 {
    private int id;
    private int perfil_id;
    private String luz;
    private String rgb;
    private String ventana;
    private String ventilador;
    private String autoventi;
    private String tempmin;
    private String tempmax;

    public Area_hab1(int id, int perfil_id, String luz, String rgb, String ventana, String ventilador, String autoventi,
                     String tempmin, String tempmax) {
        this.id = id;
        this.perfil_id = perfil_id;
        this.luz = luz;
        this.rgb = rgb;
        this.ventana = ventana;
        this.ventilador = ventilador;
        this.autoventi = autoventi;
        this.tempmin = tempmin;
        this.tempmax = tempmax;
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

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String luzr) {
        this.rgb = rgb;
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
}
