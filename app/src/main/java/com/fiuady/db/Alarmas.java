package com.fiuady.db;

public class Alarmas {
    private int id;
    private int perfil_id;
    private String puerta;
    private String cochera;
    private String sala;
    private String habitacion1;
    private String habitacion2;
    private String sensor;

    public Alarmas(int id, int perfil_id, String puerta, String cochera, String sala,
                   String habitacion1, String habitacion2, String sensor) {
        this.id = id;
        this.perfil_id = perfil_id;
        this.puerta = puerta;
        this.cochera = cochera;
        this.sala = sala;
        this.habitacion1 = habitacion1;
        this.habitacion2 = habitacion2;
        this.sensor = sensor;
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

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getCochera() {
        return cochera;
    }

    public void setCochera(String cochera) {
        this.cochera = cochera;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getHabitacion1() {
        return habitacion1;
    }

    public void setHabitacion1(String habitacion1) {
        this.habitacion1 = habitacion1;
    }

    public String getHabitacion2() {
        return habitacion2;
    }

    public void setHabitacion2(String habitacion2) {
        this.habitacion2 = habitacion2;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }
}
