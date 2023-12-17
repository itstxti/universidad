package JavaEatF;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Tatiana Garcia
 */
public class Empresa extends Cliente implements Serializable{
    //Atributos
    
    private String cif;
  
    private String web;
    
    
    
    
    //Constructor
    
    
    
    public Empresa(String cif, String nombre, String correo,
            String clave, String calle, int numeroCalle, String codigoPostal, String ciudad, String telefono, String web, 
            String titularTarjeta, String numeroTarjeta, LocalDate fechaCaducidad) {
        super(nombre, correo, clave, calle, numeroCalle, codigoPostal, ciudad, telefono,  titularTarjeta,  numeroTarjeta, fechaCaducidad);
        this.cif = cif;
        
        this.web = web;
        
    }
    
    //Metodos
    
    public String getCif() {
        return this.cif;
    }
    
    public void setCif(String cif){
        this.cif = cif;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
    
    



    @Override
    public String toString() {
        return cif + "|" + nombre + "|" + correo + "|" + clave + "|" + calle + "|" + numeroCalle + "|" + codigoPostal + "|" + ciudad + "|" + telefono + "|" + web;
    }
}

//String cif, String nombre, String correo, String clave, String calle, String numeroCalle, String codigoPostal, String ciudad, String telefono, String web