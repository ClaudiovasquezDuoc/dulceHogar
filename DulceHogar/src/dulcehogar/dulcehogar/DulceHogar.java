/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dulcehogar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author claud
 */
public class DulceHogar {
    private static ArrayList<Socio> socios = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       

        
        int numSocio;
        String rutSocio;
        int montoCuota;
        
        int menu = 0;
        
       
        
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
                        Socio nuevoSocio = null;

                        numSocio = DulceHogar.validarNumero();
                        rutSocio = DulceHogar.validarRut();
                        
                        nuevoSocio = new Socio(numSocio, rutSocio);
                        
                        nuevoSocio.setNombre(DulceHogar.validarNombre());
                        nuevoSocio.setApellidoPaterno(DulceHogar.validarApellidoPat());
                        nuevoSocio.setApellidoMaterno(DulceHogar.validarApellidoMat());
                        
                        socios.add(nuevoSocio);
                        
                        System.out.println("Socio registrado con exito!");
                        System.out.println(nuevoSocio.toString());
                        
                        break;
                    case 2:
                        while (true) {
                            
                        
                            try {
                                String RUT = validarRut();
                                
                                if(RUT.equals("")){
                                    break;
                                }

                                Socio socio = getSocio(RUT); 
                    
                                if (socio == null) {
                                    JOptionPane.showMessageDialog(null, "¡Socio no encontrado! Por favor, intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                                    System.out.println("¡Socio no encontrado!");
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                    socio.showSocio()
                                    , "Datos del Socio", JOptionPane.INFORMATION_MESSAGE);
                                    break;  
                                }
                    
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                                System.out.println("Entrada no válida, debe ser un número.");
                            }
                        }

                        break;

                    case 3:{
                        String RUT = validarRut();
                                
                        if(RUT.equals("")){
                            break;
                        } 
                        Socio socio = getSocio(RUT);
                        if (socio == null) {
                            JOptionPane.showMessageDialog(null, "¡Socio no encontrado! Por favor, intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                            System.out.println("¡Socio no encontrado!");
                        } else {
                        
                        montoCuota = DulceHogar.validarMonto();
                        
                        socio.cancelarCuota(montoCuota);
                        
                        System.out.println("Monto cancelado por $"+ montoCuota);
                        
                        System.out.println(socio.toString());
                        
                        break;
                        
                        }
                        break;
                    }
                    case 4:{
                        String RUT = validarRut();
                                    
                        if(RUT.equals("")){
                            break;
                        } 
                        Socio socio = getSocio(RUT);
                        if (socio == null) {
                            JOptionPane.showMessageDialog(null, "¡Socio no encontrado! Por favor, intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                            System.out.println("¡Socio no encontrado!");
                        } else {
                            System.out.println("Su pago de cuota fue: $"+ 
                                    socio.getValorCuota() + " de pesos!");
                            break;
                            }
                        }
                    case 5:{
                        String RUT = validarRut();
                                        
                        if(RUT.equals("")){
                            break;
                        } 
                        Socio socio = getSocio(RUT);
                        if (socio == null) {
                            JOptionPane.showMessageDialog(null, "¡Socio no encontrado! Por favor, intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                            System.out.println("¡Socio no encontrado!");
                        } else {
                            System.out.println("Su pago total de cuotas es: $"+ 
                                    socio.getCantidadAportada() + 
                                    " de pesos!");
                            break;
                        } 
                    }
                    case 6:
                        System.out.println( "Gracias por usar DulceHogar!");
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
    private static Socio getSocio(String rut) {

        for (Socio socio : socios) {
            if (socio.getRut().equals(rut)) {
                return socio;
            }
        }
        
        return null;
    }

   
    private static String validarRut() {
        while (true) {
            String rut = JOptionPane.showInputDialog("Ingrese el RUT del "
                    + "socio (con puntos y con guion)");
            
            if (rut == null){
                System.out.println("Operación cancelada por el usuario.");
                return "";
            
            }
        
            // Si rut no es de largo 12, es invalido.
            if (rut.length() != 12) {
                JOptionPane.showMessageDialog(null, "RUT invalido! Por favor, intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                
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
                    i == 11 && !Arrays.asList(numeros).contains(indice) && 
                    !indice.equalsIgnoreCase("K")) {
                System.out.println("RUT Invalido!");
                
                return false;
            }
        }
        
        return true;
    }
    
    private static String validarNombre() {
        while (true) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            
            // Validar formato correcto de nombre.
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
            
            // Validar el formato correcto de nombre.
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
            
            // Validar el formato correcto de nombre.
            if (!validarIngresoNombre(apellidoMat)) {
                continue;
            } 
            
            return apellidoMat;
        }
    }
    
    private static boolean validarIngresoNombre(String nombre) {
        // Verificar que el ingreso es solo de valores alfabeticos.
        if (!nombre.matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+([ '-][A-Za-zÀ-ÖØ-öø-ÿ]+)*$")) {
            System.out.println("Solo se permiten letras alfabeticas!");
            return false;
        }
        
        // Revisar si el nombre ingresado parte con mayuscula.
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

                System.out.println("monto");
                System.out.println(monto);
                
                // Revisar si el monto ingresado es mayor a 0.
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
