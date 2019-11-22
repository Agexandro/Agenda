package com.alex.agenda.ui.database;

public class Notes {
    private String _titulo;
    private String _descripcion;
    private String _fecha;
    private String _multimedia;

    public Notes(String _titulo, String _descripcion, String _fecha, String _multimedia) {
        this._titulo = _titulo;
        this._descripcion = _descripcion;
        this._fecha = _fecha;
        this._multimedia = _multimedia;
    }

    public String get_titulo() {
        return _titulo;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public String get_fecha() {
        return _fecha;
    }

    public String get_multimedia() {
        return _multimedia;
    }
}
