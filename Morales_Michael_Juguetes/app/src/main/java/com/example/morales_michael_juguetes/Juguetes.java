package com.example.morales_michael_juguetes;

public class Juguetes {
    private String strMarca;
    private String strTipo;
    private String strCantidad;

    public Juguetes(String strMarca, String strTipo, String strCantidad) {
        this.strMarca = strMarca;
        this.strTipo = strTipo;
        this.strCantidad = strCantidad;
    }

    public String getStrMarca() {
        return strMarca;
    }

    public void setStrMarca(String strMarca) {
        this.strMarca = strMarca;
    }

    public String getStrTipo() {
        return strTipo;
    }

    public void setStrTipo(String strTipo) {
        this.strTipo = strTipo;
    }

    public String getStrCantidad() {
        return strCantidad;
    }

    public void setStrCantidad(String strCantidad) {
        this.strCantidad = strCantidad;
    }
}
