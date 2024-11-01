/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dulcehogar;

import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author claud
 */
public class DulceHogar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numSocio;
        String rutSocio;
        int montoCuota;
        
        int menu = 0;
        
        Socio nuevoSocio = null;
        
            do{
            try {
                menu = Integer.parseInt( JOptionPane.showInputDialog("""
                                                                     
                    Bienvenido a DulceHogar! Porfavor selecciona una de las siguentes opciones del menu:
                    1. Registrar Socio
                    2. Ver datos del socio
                    3. Cancelar cuota
                    4. Consultar cuota cancelada
                    5. Consultar Total de cuotas pagadas por el socio
                    6. Salir del programa"""));
        
                switch(menu){
                    case 1:
                        numSocio = DulceHogar.validarNumero();
                        rutSocio = DulceHogar.validarRut();
                        
                        nuevoSocio = new Socio(numSocio, rutSocio);
                        
                        nuevoSocio.setNombre(DulceHogar.validarNombre());
                        nuevoSocio.setApellidoPaterno(DulceHogar.validarApellidoPat());
                        nuevoSocio.setApellidoMaterno(DulceHogar.validarApellidoMat());
                        
                        System.out.println(nuevoSocio.toString());
                        
                        break;
                    case 2:
                    case 3:
                        if (nuevoSocio != null) {
                        
                        montoCuota = DulceHogar.validarMonto();
                        
                        nuevoSocio.cancelarCuota(montoCuota);
                        
                        System.out.println("Monto cancelado por $"+ montoCuota);
                        
                        System.out.println(nuevoSocio.toString());
                        
                        break;
                        
                        } else {
                            System.out.println("No se ha creado un socio "
                                + "todavia!");
                            break;
                        }
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("Gracias");
                        break;
                    default:
                        System.out.println("Porfavor selecciona una opcion del "
                                + "menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Porfavor selecciona una opcion del menu.");
            }                
        } while (menu != 6);                  
    }
    
    private static int validarNumero() {
        while (true) {
            try {
                int numero = Integer.parseInt( JOptionPane.showInputDialog(
                        "Ingrese el numero de socio"));
                
                // Comprobar que el largo del numero de socio es 9.
                if (String.valueOf(numero).length() != 9) {
                    System.out.println("El numero de socio debe ser un numero "
                            + "de nueve caracteres!");
                } else {return numero;}
                
            } catch (NumberFormatException e) {
                System.out.println("El numero de socio debe ser un numero de "
                        + "nueve caracteres!");
            }
        }
    }
    
    private static String validarRut() {
        while (true) {
            String rut = JOptionPane.showInputDialog("Ingrese el RUT del "
                    + "socio (con puntos y con guion)");
            
            // Si rut no es de largo 12, es invalido.
            if (rut.length() != 12) {
                System.out.println("RUT invalido!");
                
            } else {
                if (!validarIndicesRut(rut)) continue;
                
                return rut; 
            }
        }
    }
    
    private static boolean validarIndicesRut(String rut) {
        // Indices donde deberia haber numeros en el RUT.
        Integer[] indicesNumerosRut = {0, 1, 3, 4, 5, 7, 8, 9};
            
        // Lista de caracteres numericos validos.
        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            
        // Revisar cada indice de rut para verificar el tipo de 
        // caracter.
        for (int i = 0; i <= 11; i++) {
            String indice = String.valueOf(rut.charAt(i));
            
            // Revisar si los caracteres numericos de rut son numeros.
            if (Arrays.asList(indicesNumerosRut).contains(i) && 
                    !Arrays.asList(numeros).contains(indice)) {
                System.out.println("RUT Invalido"); 
                
                return false;
                
            // Revisar si los puntos, guion, y dv estan en las posiciones correctas.
            } else if ((i == 2 || i == 6) && !indice.equals(".") &&
                    (i == 10 && !indice.equals("-")) &&
                    i == 11 && !Arrays.asList(numeros).contains(indice) && !indice.equalsIgnoreCase("K")) {
                System.out.println("RUT Invalido!");
                
                return false;
            }
        }
        
        return true;
    }
    
    private static String validarNombre() {
        while (true) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            
            if (!validarIngresoNombre(nombre)) {
                continue;
            }
            
            return nombre;
        }
    }
    
    private static String validarApellidoPat() {
        while (true) {
            String apellidoPat = JOptionPane.showInputDialog("Ingrese el "
                    + "apellido paterno");
            
            if (!validarIngresoNombre(apellidoPat)) {
                continue;
            } 
            
            return apellidoPat;
        }
    }
    
    private static String validarApellidoMat() {
        while (true) {
            String apellidoMat = JOptionPane.showInputDialog("Ingrese el "
                    + "apellido materno");
            
            if (!validarIngresoNombre(apellidoMat)) {
                continue;
            } 
            
            return apellidoMat;
        }
    }
    
    private static boolean validarIngresoNombre(String nombre) {
        if (!nombre.matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+([ '-][A-Za-zÀ-ÖØ-öø-ÿ]+)*$")) {
            System.out.println("Solo se permiten letras alfabeticas!");
            return false;
        }
        
        if (!Character.isUpperCase(nombre.charAt(0))) {
            System.out.println("Los nombres tienen que partir con mayuscula!");
            return false;
        }

        return true;
    }
    
    private static int validarMonto() {
        while (true) {
            try {
                int monto = Integer.parseInt( JOptionPane.showInputDialog(
                        "Ingrese el monto de la cuota a cancelar"));
                
                if (monto <= 0) {
                    System.out.println("El monto debe ser un numero mayor a "
                            + "0!");
                } else {
                    return monto;
                }
                
            } catch (NumberFormatException e) {
                System.out.println("El monto debe ser un numero mayor a 0!");
            }
        }
    }
}
