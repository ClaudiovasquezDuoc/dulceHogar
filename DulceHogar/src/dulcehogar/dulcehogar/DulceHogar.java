/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dulcehogar.dulcehogar;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

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
                        nuevoSocio.setCorreo(DulceHogar.validarCorreo());
                        nuevoSocio.setDomicilio(DulceHogar.validarDomicilio());
                        nuevoSocio.setRegion(DulceHogar.validarRegion());
                        nuevoSocio.setCiudad(DulceHogar.validarCiudad());
                        nuevoSocio.setComuna(DulceHogar.validarComuna());   
                        nuevoSocio.setTelefono(DulceHogar.solicitarTelefono());
                        
                        socios.add(nuevoSocio);
                        
                        JOptionPane.showMessageDialog(null,
                                    "Socio creado con exito!"
                                    , "Exito", JOptionPane.INFORMATION_MESSAGE);
                        
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
                                    
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                    socio.showSocio()
                                    , "Datos del Socio", JOptionPane.INFORMATION_MESSAGE);
                                    break;  
                                }
                    
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                                
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
                            
                        } else {
                        
                        montoCuota = DulceHogar.validarMonto();
                        
                        socio.cancelarCuota(montoCuota);
                        JOptionPane.showMessageDialog(null, "Su pago total de cuotas es de: $"+ montoCuota +" de pesos");
                        
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
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Su pago de cuota mas reciente es de : $"+ socio.getValorCuota()+" de pesos!");
                            
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
                        } else {
                            JOptionPane.showMessageDialog(null, "Su pago total de cuotas son: $"+ socio.getCantidadAportada()+" de pesos");
                            //JOptionPane.showMessageDialog(parentComponent:null, message:"Su pago total de cuotas es: "+ socio.getCantidadAportada()+ " de pesos!", messageType);

                            break;
                        }
                    }
                    case 6:
                        JOptionPane.showMessageDialog(null, "Gracias por usar DulceHogar!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Por favor selecciona una opcion del menu");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor selecciona una opcion del menu");
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
                    JOptionPane.showMessageDialog(null, "El numero de socio debe ser un numero "
                            + "de nueve digitos!");
                    System.out.println("El numero de socio debe ser un numero "
                            + "de nueve digitos!");
                } else {return numero;}

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El numero de socio debe ser un numero "
                            + "de nueve digitos!");
                System.out.println("El numero de socio debe ser un numero de "
                        + "nueve digitos!");
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
                System.out.println("Operacion cancelada por el usuario.");
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
            System.out.println("Ingrese el nombre");
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
            System.out.println("Ingrese el apellido paterno");
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
            System.out.println("Ingrese el apellido materno");
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
            JOptionPane.showMessageDialog(null, "Solo se aceptan letras alfabeticas!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Revisar si el nombre ingresado parte con mayuscula.
        if (!Character.isUpperCase(nombre.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Los nombres deben partir con mayuscula!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    
    private static int validarMonto() {
        while (true) {
            try {
                System.out.println("Ingrese el monto de la cuota a cancelar");
                int monto = Integer.parseInt( JOptionPane.showInputDialog(
                        "Ingrese el monto de la cuota a cancelar"));

                // Revisar si el monto ingresado es mayor a 0.
                if (monto <= 0) {
                    JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    return monto;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private static String validarCorreo() {
        while (true) {
            System.out.println("Ingrese el correo");
            String correo = JOptionPane.showInputDialog("Ingrese el correo");

            // Validar formato correcto de nombre.
            if (!validarIngresoCorreo(correo)) {
                continue;
            }

            return correo;
        }
    } 
    
    public static String validarDomicilio() {
            String domicilio;
            do {
                System.out.println("Ingrese su direccion (ej. 123 Calle Principal):");
                domicilio = JOptionPane.showInputDialog("Ingrese su direccion (ej. 123 Calle Principal):");
                if (domicilio == null) {
                    // Si el usuario cancela, se sale del ciclo
                    return null;
                }
                if (!validarDomicilioValida(domicilio)) {
                    JOptionPane.showMessageDialog(null, "La direccion ingresada no es valida. Intente de nuevo.");
                }
            } while (!validarDomicilioValida(domicilio));
            return domicilio; // Retorna la dirección válida
    }
    
    private static String validarRegion() {
        while (true) {
            System.out.println("Ingrese el nombre de la region");
            String region = JOptionPane.showInputDialog("Ingrese el nombre de la region");

            // Validar formato correcto de nombre.
            if (!validarIngresoRegion(region)) {
                continue;
            }

            return region;
        }
    }
    
    private static String validarCiudad() {
        while (true) {
            System.out.println("Ingrese el nombre de la ciudad:");
            String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad"); 
            // Validar formato correcto de nombre de ciudad.
            
            if (!validarIngresoCiudad(ciudad)) {
                continue;
            }

            return ciudad;
        }
    }
    
    private static String validarComuna() {
        while (true) {
            System.out.println("Ingrese el nombre de la comuna:");
            String comuna = JOptionPane.showInputDialog("Ingrese el nombre de la comuna");
            // Validar formato correcto de nombre comuna.
            
            if (!validarIngresoComuna(comuna)) {
                continue;
            }

            return comuna;
        }
    }
    
    public static String solicitarTelefono() {
        String telefono;
        do {
            System.out.println("Ingrese su numero telefonico chileno (ej. +56912345678)");
            telefono = JOptionPane.showInputDialog("Ingrese su número telefónico chileno (ej. +56912345678):"); 
            if (telefono == null) {
                // Si el usuario cancela, se sale del ciclo
                return null;
            }
            if (!telefonoValido(telefono)) {
                JOptionPane.showMessageDialog(null, "El número telefónico ingresado no es válido. Intente de nuevo.");                    
            }
        } while (!telefonoValido(telefono));

        return telefono; // Retorna el número válido
    }
    
    private static boolean validarIngresoCorreo(String correo) {

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(correo).matches();
    }
    
    private static boolean validarDomicilioValida(String domicilio) {
        String regex = "^[0-9]+\\s+[a-zA-Z0-9\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(domicilio).matches();
    }
    
    private static boolean validarIngresoRegion(String region) {
        // Verificar que el ingreso es solo de valores alfabeticos.
        if (!region.matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+([ '-][A-Za-zÀ-ÖØ-öø-ÿ]+)*$")) {
            JOptionPane.showMessageDialog(null, "Solo se permiten letras alfabeticas!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Revisar si el nombre ingresado parte con mayuscula.
        if (!Character.isUpperCase(region.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Los nombres de las regiones deben partir con mayuscula!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    
    private static boolean validarIngresoCiudad(String ciudad) {
        // Verificar que el ingreso es solo de valores alfabeticos.
        if (!ciudad.matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+([ '-][A-Za-zÀ-ÖØ-öø-ÿ]+)*$")) {
            JOptionPane.showMessageDialog(null, "Solo se permiten letras alfabeticas!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Revisar si el nombre ingresado parte con mayuscula.
        if (!Character.isUpperCase(ciudad.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Los nombres de las ciudades deben partir con mayuscula!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    
    private static boolean validarIngresoComuna(String comuna) {
        // Verificar que el ingreso es solo de valores alfabeticos.
        if (!comuna.matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+([ '-][A-Za-zÀ-ÖØ-öø-ÿ]+)*$")) {
            JOptionPane.showMessageDialog(null, "Solo se permiten letras alfabeticas!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Revisar si el nombre ingresado parte con mayuscula.
        if (!Character.isUpperCase(comuna.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Los nombres de las comunas deben partir con mayuscula!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    
    public static boolean telefonoValido(String telefono) {
        // Expresión regular para números telefónicos chilenos
        String regex = "^(?:\\+?56)?(?:0?9\\d{8}|(?:0?[2-9])\\s?\\d{4}\\s?\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(telefono).matches();
    }
}
