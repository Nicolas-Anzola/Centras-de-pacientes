package com.mycompany.centralpacientes;

public class ListaPacientes {
    private Nodo cabeza;
    private int tamaño;

    public ListaPacientes() {
        cabeza = null;
        tamaño = 0;
    }

    // Agregar al final
    public boolean agregar(Paciente p) {
        if (buscarPorId(p.getId()) != null) {
            return false; // ID ya existe
        }
        Nodo nuevo = new Nodo(p);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        tamaño++;
        return true;
    }

    // Buscar por ID
    public Paciente buscarPorId(String id) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getData().getId().equals(id)) {
                return actual.getData();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // Eliminar por ID
    public boolean eliminarPorId(String id) {
        if (cabeza == null) return false;

        // si cabeza es el nodo a eliminar
        if (cabeza.getData().getId().equals(id)) {
            cabeza = cabeza.getSiguiente();
            tamaño--;
            return true;
        }

        Nodo previo = cabeza;
        Nodo actual = cabeza.getSiguiente();

        while (actual != null) {
            if (actual.getData().getId().equals(id)) {
                previo.setSiguiente(actual.getSiguiente());
                tamaño--;
                return true;
            }
            previo = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Mostrar todos
    public String listarTodos() {
        if (cabeza == null) return "No hay pacientes registrados.";
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        while (actual != null) {
            sb.append(actual.getData().toString()).append(System.lineSeparator());
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    public int getTamaño() { return tamaño; }
}
