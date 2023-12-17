package JavaEatF;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Tatiana Garcia
 */
public class Restaurante implements Serializable {

    // atributos
    private String Cif;
    private String nombre;
    private String calle;
    private String numeroCalle;
    private int codigoPostal;
    private String ciudad;
    private String especialidad;
    private double gastosEnvio;
    private double tiempoEnvio;
    private boolean catering; 
    private ArrayList<Comida> comidas;
    private double valoracion;
    private ArrayList<Integer> valoraciones;
    private String comidaCatering;
    private double precioCatering;
    private static final long serialVersionUID = 2070816552105129401L;

    // constructor

    public Restaurante(String Cif, String nombre, String calle, String numeroCalle, int codigoPostal,
            String ciudad, String especialidad, double gastosEnvio, double tiempoEnvio, boolean catering,
            ArrayList<Comida> comidas, double valoracion, String comidaCatering, double precioCatering) {

        this.Cif = Cif;
        this.nombre = nombre;
        this.calle = calle;
        this.numeroCalle = numeroCalle;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.especialidad = especialidad;
        this.gastosEnvio = gastosEnvio;
        this.tiempoEnvio = tiempoEnvio;
        this.catering = catering;
        this.comidas = comidas;
        this.valoracion = 0.0;
        this.valoraciones = new ArrayList<>();
        this.comidaCatering = comidaCatering;
        this.precioCatering = precioCatering;
        
    }

    public String getCif() {
        return this.Cif;
    }

    public void setCif(String Cif) {
        this.Cif = Cif;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroCalle() {
        return this.numeroCalle;
    }

    public void setNumeroCalle(String numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public int getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getGastosEnvio() {
        return this.gastosEnvio;
    }

    public void setGastosEnvio(double gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public double getTiempoEnvio() {
        return this.tiempoEnvio;
    }

    public void setTiempoEnvio(double tiempoEnvio) {
        this.tiempoEnvio = tiempoEnvio;
    }

    public boolean getCatering() {
        return this.catering;
    }

    public void setCatering(boolean catering) {
        this.catering = catering;
    }

    public ArrayList<Comida> getComidas() {
        return this.comidas;
    }

    public void setComidas(ArrayList<Comida> comidas) {
        this.comidas = comidas;
    }

    public double getValoracion() {
        return this.valoracion;
    }

    public void agregarValoracion(int nuevaValoracion) {
        valoraciones.add(nuevaValoracion);
        int cantidadValoraciones = valoraciones.size();
        double sumaValoraciones = 0;
        for (int valoracion : valoraciones) {
            sumaValoraciones += valoracion;
        }
        valoracion = sumaValoraciones / cantidadValoraciones;
    }

    public ArrayList<Integer> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(ArrayList<Integer> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public String getComidaCatering() {
        return comidaCatering;
    }

    public void setComidaCatering(String comidaCatering) {
        this.comidaCatering = comidaCatering;
    }

    public double getPrecioCatering() {
        return precioCatering;
    }

    public void setPrecioCatering(double precioCatering) {
        this.precioCatering = precioCatering;
    }
    
    @Override
    public String toString() {
        return Cif + "|" + nombre + "|" + calle + "|" + numeroCalle + "|" + codigoPostal + "|" + ciudad + "|" 
                + especialidad + "|" + gastosEnvio + "|" + tiempoEnvio + "|" + catering + "|" + comidas + "|" + valoraciones; 
    }
}

