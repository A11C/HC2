package com.fiuady.db;

public class Area_sala {
    private int id;
    private String perfil_id;
    private String puerta;
    private String ventana;
    private String sensormov;

    public Area_sala(int id, String perfil_id, String puerta, String ventana, String sensormov) {
        this.id = id;
        this.perfil_id = perfil_id;
        this.puerta = puerta;
        this.ventana = ventana;
        this.sensormov = sensormov;
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

    public String getVentana() {
        return ventana;
    }

    public void setVentana(String ventana) {
        this.ventana = ventana;
    }

    public String getSensormov() {
        return sensormov;
    }

    public void setSensormov(String sensormov) {
        this.sensormov = sensormov;
    }
}
