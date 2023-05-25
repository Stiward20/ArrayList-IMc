package ArrayListIMC;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class procesosIMC {
    String cadena="", nombre="";
    double imc, talla, peso;
    int telefono;
    ArrayList<String> listaNombres = new ArrayList<String>();
    ArrayList<String> listaResultado = new ArrayList<String>();

    public void procesos() {
        System.out.println("<<<<<Inicio del proceso>>>>>\n");

        int cantidad=0;
        do {
            cantidad = Integer.parseInt(JOptionPane.showInputDialog("cuantas veces lo quiere repetir"));
            if (cantidad < 1) {
                JOptionPane.showMessageDialog(null, "numero fuera de rango" + cantidad, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (cantidad < 1);
        
        for (int i = 0; i < cantidad; i++) {

        pedirDatos();
        imprimir();
        }
        buscarEstudiante();
    }

    public void pedirDatos() {
        System.out.println("<<<<<Ingresa los datos>>>>>\n");

        String continuar="";

        nombre = JOptionPane.showInputDialog("ingrese el nombre de la persona");
        listaNombres.add(nombre);
        do {
            telefono = Integer.parseInt(JOptionPane.showInputDialog("ingrese su numero telefonico"));
            if (telefono < 1) {
                JOptionPane.showMessageDialog(null, "numero fuera de rango" + telefono, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (telefono < 1);
        do {
            peso = Double.parseDouble(JOptionPane.showInputDialog("ingrese el peso"));
            if (peso < 1) {
                JOptionPane.showMessageDialog(null, "numero fuera de rango" + peso, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (peso < 0);
        do {
            talla = Double.parseDouble(JOptionPane.showInputDialog("ingrese el talla")); 
            if (talla < 1) {
                JOptionPane.showMessageDialog(null, "numero fuera de rango" + talla, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (talla < 1);
        
        do {
            continuar = JOptionPane.showInputDialog("Si desea continuar ingrese 'S' o 'N' para terminar");
            calcular();
            if (continuar.equalsIgnoreCase("N")) {
                JOptionPane.showMessageDialog(null, "has ingresado " + continuar + "para terminar", "ERROR", JOptionPane.CLOSED_OPTION);
            }
        } while (continuar.equalsIgnoreCase("S"));
    } 

    public void calcular() {
            imc = peso / (talla * talla);
            System.out.println("El resultado del imc es: "+imc);

            if (imc < 18) {
                cadena += ("anorexia");
            } else if (imc >= 18 && imc < 20) {
                cadena += ("delgadez");
            }else if (imc >= 20 && imc < 27) {
                cadena += ("normalidad");
            }else if (imc >= 27 && imc < 30) {
                cadena += "obesidad(grado 1";
            }else if (imc >= 30 && imc < 20) {
                cadena += "obesidad(grado 2";
            }else if (imc >= 30 && imc < 20) {
                cadena += "obesidad(grado 3";
            }else if (imc >= 30 && imc < 20) {
                cadena += "obesidad morbida";
            }
            listaResultado.add(cadena);
                 
    }

    public void imprimir() {
        for (int i = 0; i < listaNombres.size(); i++) {
            
            System.out.println(listaNombres.get(i) + " \nresultado " + listaResultado.get(i) + "\n");
       }
       System.out.println("Lista de estudiantes" + listaNombres);
       System.out.println("Lista de resultadoa" + listaResultado);
    }

    public void buscarEstudiante() {
        
        String buscaNom = JOptionPane.showInputDialog("ingrese el nombre a buscar");
        for (int i = 0; i < listaNombres.size(); i++) {
            if (buscaNom.equalsIgnoreCase(listaNombres.get(i))) {
                System.out.println("Datos del estudiante:\n" );
                System.out.println(buscaNom + "con una talla de " + talla + " un peso de " + peso + " el total del imc es: " + imc + "\nEl numero de telefono es:" + telefono);
                break;
            }else {
                System.out.print("No se encontró a la persona con nombre " + buscaNom);
                
            }
        }
    }
}
