package com.mycompany.centralpacientes;

import java.util.Scanner;

public class Main {
    private static ListaPacientes lista = new ListaPacientes();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String opcion = sc.nextLine().trim();
            switch (opcion) {
                case "1": registrarPaciente(); break;
                case "2": buscarPaciente(); break;
                case "3": eliminarPaciente(); break;
                case "4": mostrarLista(); break;
                case "5": modificarPaciente(); break;
                case "0": salir = true; System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida. Intente de nuevo.");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("=== CENTRAL DE PACIENTES ===");
        System.out.println("1. Registrar paciente");
        System.out.println("2. Buscar paciente por ID");
        System.out.println("3. Eliminar paciente por ID");
        System.out.println("4. Mostrar todos los pacientes");
        System.out.println("5. Modificar paciente (nombre/edad/clínica)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarPaciente() {
        System.out.print("ID: ");
        String id = sc.nextLine().trim();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Edad: ");
        int edad = leerEntero();
        System.out.print("Clínica: ");
        String clinica = sc.nextLine().trim();

        Paciente p = new Paciente(id, nombre, edad, clinica);
        boolean ok = lista.agregar(p);
        if (ok) System.out.println("Paciente registrado correctamente.");
        else System.out.println("Error: ya existe un paciente con ese ID.");
    }

    private static void buscarPaciente() {
        System.out.print("Ingrese ID a buscar: ");
        String id = sc.nextLine().trim();
        Paciente p = lista.buscarPorId(id);
        if (p != null) System.out.println("Encontrado: " + p);
        else System.out.println("Paciente no encontrado.");
    }

    private static void eliminarPaciente() {
        System.out.print("Ingrese ID a eliminar: ");
        String id = sc.nextLine().trim();
        boolean ok = lista.eliminarPorId(id);
        if (ok) System.out.println("Paciente eliminado correctamente.");
        else System.out.println("No se encontró paciente con ese ID.");
    }

    private static void mostrarLista() {
        System.out.println("=== Lista de pacientes (" + lista.getTamaño() + ") ===");
        System.out.print(lista.listarTodos());
    }

    private static void modificarPaciente() {
        System.out.print("Ingrese ID del paciente a modificar: ");
        String id = sc.nextLine().trim();
        Paciente p = lista.buscarPorId(id);
        if (p == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }
        System.out.println("Paciente actual: " + p);
        System.out.print("Nuevo nombre (enter = mantener): ");
        String nombre = sc.nextLine();
        if (!nombre.trim().isEmpty()) p.setNombre(nombre.trim());
        System.out.print("Nueva edad (enter = mantener): ");
        String edadStr = sc.nextLine().trim();
        if (!edadStr.isEmpty()) {
            try {
                int edad = Integer.parseInt(edadStr);
                p.setEdad(edad);
            } catch (NumberFormatException ex) {
                System.out.println("Edad inválida. Se mantiene la anterior.");
            }
        }
        System.out.print("Nueva clínica (enter = mantener): ");
        String clinica = sc.nextLine();
        if (!clinica.trim().isEmpty()) p.setClinica(clinica.trim());
        System.out.println("Paciente actualizado: " + p);
    }

    private static int leerEntero() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                System.out.print("Valor inválido. Ingrese un número: ");
            }
        }
    }
}

