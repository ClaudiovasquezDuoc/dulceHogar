
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dulcehogar;

/**
 *
 * @author jaket
 */
public class Socio {

    private final int numeroSocio;
    private final String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String domicilio;
    private String region;
    private String ciudad;
    private String comuna;
    private String telefono;
    private int valorCuota;
    private int cantidadAportada;

    public Socio(int numeroSocio, String rut) {
        this.numeroSocio = numeroSocio;
        this.rut = rut;
        this.nombre = "";
        this.apellidoPaterno = "";
        this.apellidoMaterno = "";
        this.correo = "";
        this.domicilio = "";
        this.region = "";
        this.ciudad = "";
        this.comuna = "";
        this.telefono = "";
        this.valorCuota = 0;
        this.cantidadAportada = 0;
    }

    public void cancelarCuota(int monto) {
        this.setValorCuota(monto);
        this.cantidadAportada += this.valorCuota;
    }
    
    public int getNumeroSocio() {
        return numeroSocio;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(int valorCuota) {
        this.valorCuota = valorCuota;
    }

    public int getCantidadAportada() {
        return cantidadAportada;
    }
    public  String showSocio() {
        return "Número de Socio: " + numeroSocio + "\n" +
               "RUT: " + rut + "\n" +
               "Nombre: " + nombre + "\n" +
               "Apellido Paterno: " + apellidoPaterno + "\n" +
               "Apellido Materno: " + apellidoMaterno + "\n" +
               "Correo: " + correo + "\n" +
               "Domicilio: " + domicilio + "\n" +
               "Región: " + region + "\n" +
               "Ciudad: " + ciudad + "\n" +
               "Comuna: " + comuna + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Valor Cuota: " + valorCuota + "\n" +
               "Cantidad Aportada: " + cantidadAportada;
    }


    @Override
    public String toString() {
        return "Socio{" + "numeroSocio=" + numeroSocio + ", rut=" + rut + 
                ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + 
                ", apellidoMaterno=" + apellidoMaterno + ", correo=" + correo + 
                ", domicilio=" + domicilio + ", region=" + region + ", ciudad=" 
                + ciudad + ", comuna=" + comuna + ", telefono=" + telefono + 
                ", valorCuota=" + valorCuota + ", cantidadAportada=" + 
                cantidadAportada + '}';
    }

    
    
}
