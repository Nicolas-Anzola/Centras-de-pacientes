package com.mycompany.centralpacientes;

public class Paciente {
    private String id;
    private String nombre;
    private int edad;
    private String clinica;

    public Paciente(String id, String nombre, int edad, String clinica) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.clinica = clinica;
    }

    // Getters y setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getClinica() { return clinica; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setClinica(String clinica) { this.clinica = clinica; }

    @Override
    public String toString() {
        return "Paciente{ID='" + id + '\'' +
               ", Nombre='" + nombre + '\'' +
               ", Edad=" + edad +
               ", Clínica='" + clinica + '\'' +
               '}';
    }
}
