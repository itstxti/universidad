package JavaEatF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author busto
 */
public class MetodosRestaurantes {
    
    private static Restaurante restaurante;
    private static ArrayList<Restaurante> restaurantes;
    
    
    public static byte[] leerFoto(File ruta){
        try{
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            return icono;
        }catch(Exception ex){
            return null;
        }
    }
    
    public static ArrayList<Restaurante> setRestaurantes() {
    
        File carbonara = new File("imagenes/espaguetisCarbonara.jpg");
        File lasaña = new File("imagenes/lasaña.jpg");
        File polloParmesana = new File("imagenes/polloParmesana.jpg");
        
        
        File tacos = new File("imagenes/tacos.jpg");
        File enchiladas = new File("imagenes/enchiladas.jpg");
        File nachos = new File("imagenes/nachos.jpg");
        
        File rollitos = new File("imagenes/rollitos.jpg");
        File tallarines = new File("imagenes/tallarines.jpg");
        File sopa = new File("imagenes/sopa.jpg");
        
        File katsudon = new File("imagenes/katsudon.jpg");
        File ramen = new File("imagenes/ramen.jpg");
        File okonomiyaki = new File("imagenes/okonomiyaki.jpg");
               
        ArrayList<Comida> comidas1 = new ArrayList<>();
        Comida comida11 = new Comida("Espaguetis carbonara", "Pasta, queso, bacon, huevo.", 
                11.05, leerFoto(carbonara)); 
        
        Comida comida12 = new Comida("Lasaña de carne picada", "Cebolla, ajo, carne picada, salsa de tomate, queso, masa de lasaña.", 
                12.00, leerFoto(lasaña));
        
        Comida comida13 =new Comida("Pollo a la parmesana", "Filetes de pollo, pan rallado, queso parmesano y mozzarella, salsa de tomate, ajo, cebolla, huevo.", 
        12.55, leerFoto(polloParmesana));
        
        comidas1.add(comida11);
        comidas1.add(comida12);
        comidas1.add(comida13);
        
        ArrayList<Comida> comidas2 = new ArrayList<>();
        Comida comida21 = new Comida("Tacos mexicanos de ternera", "Ternera, ajo, cebolla, zanahoria, chile chipotle, tomate, tortilla de maiz.", 
                9.95, leerFoto(tacos));
        
        Comida comida22 = new Comida("Enchiladas mexicanas de pollo", "Pollo, cebolla, chiles serranos, nata, tomate, tortilla de maiz, queso.", 
                10.95, leerFoto(enchiladas));
        
        Comida comida23 = new Comida("Nachos a la mexicana con queso poblano", "Cebolla, chiles poblanos, ajo, queso crema, queso manchego, leche, nachos.", 
                7.05, leerFoto(nachos));
        
        comidas2.add(comida22);
        comidas2.add(comida21);
        comidas2.add(comida23);
        
        ArrayList<Comida> comidas3 = new ArrayList<>();
        
        Comida comida31 = new Comida("Rollitos de primavera", "Obleas de arroz, zanahorias, cebolletas, gambas, cilantro, salsa de soja.",
        7.63, leerFoto(rollitos));
        
        Comida comida32 = new Comida("Tallarines chinos con verduras", 
                "Tallarines chinos, calabacin, cebolla, pimienta verde, ternera, salsa de soja.",
                8.50, leerFoto(tallarines));
        Comida comida33 = new Comida("Sopa Wan Tan", "Pasta wantan, carne molida, huevo, cebolla china, jengibre.", 
                8.05, leerFoto(sopa));
        
        
        comidas3.add(comida31);
        comidas3.add(comida32);
        comidas3.add(comida33);
        
        ArrayList<Comida> comidas4 = new ArrayList<>();
        
        Comida comida41 = new Comida("Katsudon", "Chuleta de cerdo, harina, huevo, pan rallado japones, arroz, cebolla, huevo.", 
                9.80, leerFoto(katsudon));
        Comida comida42 = new Comida("Ramen", "Fideos, panceta, cebolleta, setas shitake, brotes de soja, huevo, jengibre.", 
                10.95, leerFoto(ramen));
        
        Comida comida43 = new Comida("Okonomiyaki", "Calamar, harina, caldo de pescado, mayonesa japonesa, col, bacon, huevo, katsuobushi.", 
                9.25, leerFoto(okonomiyaki));
        
        comidas4.add(comida41);
        comidas4.add(comida42);
        comidas4.add(comida43);
        
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        
        Restaurante restaurante1 = new Restaurante( "N864513",  "Pastamore Alcala",  "Alcala",  "235",  
                28008,"Madrid",  "Italiano",  2.55,  20,  true,
                comidas1, 0.0,
                ("""
                 Rueda de ibericos acompañados con picos de Jerez,
                 Fuente de quesos variados,
                 Tortilla española en daditos,
                 Pancito de jamón serrano con tomate"""), 120); 
        
        Restaurante restaurante2 = new Restaurante( "C3946510",  "Mayser",  "Santa Clara",  "95",  28017,
             "Madrid",  "Mexicano",  1.33,  15,  true,
                comidas2, 0.0,
                ("Brochetas de cerezas con perlas de mozzarella, pan de salmón con salsa de mostaza y alcaparras, flautita tex-mex con guacamole, brochetas de langostinos con huevos de codorniz"), 150);
        
        Restaurante restaurante3 = new Restaurante("F865324", "Casa del oro", "Pastor", "4",
                28001, "Madrid", "Chino", 1.05, 10, false,
                comidas3, 0.0,
                (""), 0);
        
        Restaurante restaurante4 = new Restaurante("G25986", "Kagura", "Alfonso X", "10",
                28012, "Madrid", "Japones", 1.05, 10, false,
                comidas4, 0.0,
                (""), 0);
        
        restaurantes.add(restaurante1);
        restaurantes.add(restaurante2);
        restaurantes.add(restaurante3);
        restaurantes.add(restaurante4);

        
        return restaurantes;
    
    }
    
    public static void Registrar(ArrayList<Restaurante> restaurantes) {
                
            try {
                File ruta = new File("restauranteF.dat");
                FileOutputStream fileOut = new FileOutputStream(ruta);
                try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                    objectOut.writeObject(restaurantes);
                }
                System.out.println(restaurantes);
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }
    
    public static ArrayList<Restaurante> Leer() throws FileNotFoundException, IOException, ClassNotFoundException {
        File ruta = new File("restauranteF.dat");
        FileInputStream fileIn = new FileInputStream(ruta);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        ArrayList<Restaurante> restaurantes = (ArrayList<Restaurante>) objectIn.readObject();
        objectIn.close();

    return restaurantes;
    }

    public static ArrayList<Restaurante> OrdenarTiempoEnvio(ArrayList<Restaurante> restaurantes) {
        Comparator<Restaurante> comparador = new Comparator<Restaurante>() {
            
            @Override
            public int compare(Restaurante r1, Restaurante r2) {
                return Double.compare(r1.getTiempoEnvio(), r2.getTiempoEnvio());
            }
        };

        Collections.sort(restaurantes, comparador);

        return restaurantes;
    }
    
    public static ArrayList<Restaurante> OrdenarCalificacion(ArrayList<Restaurante> restaurantes) {
        Comparator<Restaurante> comparador = new Comparator<Restaurante>() {
            
            @Override
            public int compare(Restaurante r1, Restaurante r2) {
                return Double.compare(r2.getValoracion(), r1.getValoracion());
            }
        };

        restaurantes.sort(comparador);

        return restaurantes;
    }
    
    public static ArrayList<Restaurante> obtenerRestaurantesConCatering(ArrayList<Restaurante> restaurantes) {
        ArrayList<Restaurante> restaurantesConCatering = new ArrayList<>();

        for (Restaurante restaurante : restaurantes) {
            if (restaurante.getCatering() == true) {
                restaurantesConCatering.add(restaurante);
            }
        }

        return restaurantesConCatering;
    }
    
    public static ArrayList<Restaurante> obtenerRestaurantesSinCatering(ArrayList<Restaurante> restaurantes) {
        ArrayList<Restaurante> restaurantesConCatering = new ArrayList<>();

        for (Restaurante restaurante : restaurantes) {
            if (restaurante.getCatering() == false) {
                restaurantesConCatering.add(restaurante);
            }
        }

        return restaurantesConCatering;
    }
    
    public static ArrayList<Restaurante> obtenerRestaurantesCP(ArrayList<Restaurante> restaurantes, String CP) {
        ArrayList<Restaurante> restaurantesCP = new ArrayList<>();

        String CPSubstring = CP.substring(0, 4); // Obtener los cuatro primeros dígitos

        for (Restaurante restaurante : restaurantes) {
            String restauranteCPString = String.valueOf(restaurante.getCodigoPostal()); // Convertir el código postal del restaurante a String
            String restauranteCPSubstring = restauranteCPString.substring(0, 4); // Obtener los cuatro primeros dígitos

        if (restauranteCPSubstring.equals(CPSubstring)) {
            restaurantesCP.add(restaurante);
        }
    }
     return restaurantesCP;
        
    }
    
    public static Restaurante consultaRestaurantePorCif(String cif, ArrayList<Restaurante> restaurantes) {
        //Comparador para ordenar los Productos por su código
        for (Restaurante restaurante : restaurantes) {
            if (restaurante.getCif().equals(cif)) {
                return restaurante; 
            }
        }
        return null;
    }
    
    
}

