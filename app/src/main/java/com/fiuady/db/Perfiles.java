package com.fiuady.db;

public class Perfiles {

    private int id;
    private String usuario_id;
    private String descripcion;

    public Perfiles(int id, String usuario_id, String descripcion) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
