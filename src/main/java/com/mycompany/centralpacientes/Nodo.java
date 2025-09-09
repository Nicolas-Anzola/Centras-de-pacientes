package com.mycompany.centralpacientes;

public class Nodo {
    private Paciente data;
    private Nodo siguiente;

    public Nodo(Paciente data) {
        this.data = data;
        this.siguiente = null;
    }

    public Paciente getData() { return data; }
    public Nodo getSiguiente() { return siguiente; }
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
}

