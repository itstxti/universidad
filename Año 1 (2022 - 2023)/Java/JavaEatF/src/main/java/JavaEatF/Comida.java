package JavaEatF;

import java.io.Serializable;
/**
 *
 * @author tgarc
 */
public class Comida implements Serializable {
    
    private String tituloComida;
    private String ingredientesComida;
    private double precioComida;
    private byte[] imagenComida;
    
    public Comida(){
    
    }
    
    public Comida(String tituloComida, String ingredientesComida,
            double precioComida, byte[] imagenComida){
        this.tituloComida = tituloComida;
        this.ingredientesComida = ingredientesComida;
        this.precioComida = precioComida;
        this.imagenComida = imagenComida;
    }
        
    public String getTituloComida() {
        return this.tituloComida;
    }
    public void setTituloComida(String tituloComida) {
        this.tituloComida = tituloComida;
    }
    public String getIngredientesComida() {
        return this.ingredientesComida;
    }
    public void setIngredientesComida(String ingredientesComida) {
        this.ingredientesComida = ingredientesComida;
    }
    public double getPrecioComida() {
        return this.precioComida;
    }
    public void setPrecioComida(double precioComida) {
        this.precioComida = precioComida;
    }
    public byte[] getImagenComida() {
        return this.imagenComida;
    }
    public void setImagenComida(byte[] imagenComida) {
        this.imagenComida = imagenComida;
    }

    @Override
    public String toString() {
        return tituloComida + "$" + ingredientesComida + "$" + precioComida + "$" + imagenComida;
    }
}

