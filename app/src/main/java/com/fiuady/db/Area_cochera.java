package com.fiuady.db;

public class Area_cochera {
    private int id;
    private int perfil_id;
    private String puerta;

    public Area_cochera(int id, int perfil_id, String puerta) {
        this.id = id;
        this.perfil_id = perfil_id;
        this.puerta = puerta;
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
}
