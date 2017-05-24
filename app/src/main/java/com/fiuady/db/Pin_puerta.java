package com.fiuady.db;

public class Pin_puerta {

    private int id;
    private String usuario_id;
    private String pin;

    public Pin_puerta(int id, String usuario_id, String pin) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.pin = pin;
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}