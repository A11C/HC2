package com.fiuady.db;

public class Area_patio {
    private int id;
    private int perfil_id;
    private String luzext;
    private String sensorext;
    private String intenext;
    private String luzpisci;
    private String sensorpisci;
    private String intenpisci;
    private String ventana;

    public Area_patio(int id, int perfil_id, String luzext, String sensorext,
                      String intenext, String luzpisci, String sensorpisci,
                      String intenpisci, String ventana) {
        this.id = id;
        this.perfil_id = perfil_id;
        this.luzext = luzext;
        this.sensorext = sensorext;
        this.intenext = intenext;
        this.luzpisci = luzpisci;
        this.sensorpisci = sensorpisci;
        this.intenpisci = intenpisci;
        this.ventana = ventana;
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

    public String getLuzext() {
        return luzext;
    }

    public void setLuzext(String luzext) {
        this.luzext = luzext;
    }

    public String getSensorext() {
        return sensorext;
    }

    public void setSensorext(String sensorext) {
        this.sensorext = sensorext;
    }

    public String getIntenext() {
        return intenext;
    }

    public void setIntenext(String intenext) {
        this.intenext = intenext;
    }

    public String getLuzpisci() {
        return luzpisci;
    }

    public void setLuzpisci(String luzpisci) {
        this.luzpisci = luzpisci;
    }

    public String getSensorpisci() {
        return sensorpisci;
    }

    public void setSensorpisci(String sensorpisci) {
        this.sensorpisci = sensorpisci;
    }

    public String getIntenpisci() {
        return intenpisci;
    }

    public void setIntenpisci(String intenpisci) {
        this.intenpisci = intenpisci;
    }

    public String getVentana() {
        return ventana;
    }

    public void setVentana(String ventana) {
        this.ventana = ventana;
    }
}
