package JavaEatF;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Tatiana Garcia
 */
public class Particular extends Cliente implements Serializable {
    
    //Atributos
    
    private String dni;
       
    //Constructor
    

    public Particular(String dni, String nombre, String correo, String clave,  String calle, int numeroCalle, String codigoPostal, String ciudad, String telefono, String titularTarjeta, String numeroTarjeta, LocalDate fechaCaducidad) {
        super(nombre, correo, clave, calle, numeroCalle, codigoPostal, ciudad, telefono,  titularTarjeta,  numeroTarjeta, fechaCaducidad);
        this.dni = dni;
        
    }
        
    //Metodos
    
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni){
        this.dni = dni;
    }
       
    @Override
    public String toString() {
        return "Particular{" + "dni=" + dni + ", nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + ", telefono=" + telefono + ", calle=" + calle + ", numeroCalle=" + numeroCalle + ", codigoPostal=" + codigoPostal + ", ciudad=" + ciudad + ", titularTarjeta=" + titularTarjeta + ", numeroTarjeta=" + numeroTarjeta + ", fechaCaducidad=" + fechaCaducidad + '}';
    }  

}

