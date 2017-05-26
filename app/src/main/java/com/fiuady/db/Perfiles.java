package com.fiuady.db;

public class Perfiles {

    private int id;
    private int usuario_id;
    private String descripcion;

    public Perfiles(int id, int usuario_id, String descripcion) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
