package com.fiuady.db;

public class Area_frente {
    private int id;
    private String perfil_id;
    private String puerta;
    private String luz;
    private String sensor;
    private String intensidad;

    public Area_frente(int id, String perfil_id, String puerta, String luz, String sensor, String intensidad) {
        this.id = id;
        this.perfil_id = perfil_id;
        this.puerta = puerta;
        this.luz = luz;
        this.sensor = sensor;
        this.intensidad = intensidad;
    }

    public int getId() {
        return id;
    }

    public String getPerfil_id() {
        return perfil_id;
    }

    public void setPerfil_id(String perfil_id) {
        this.perfil_id = perfil_id;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getLuz() {
        return luz;
    }

    public void setLuz(String luz) {
        this.luz = luz;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }
}
