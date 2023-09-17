package JavaEatF;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Tatiana Garcia
 */
public class Metodos {
    
    private static Particular particular;
    
    public static ArrayList<Cliente> setClientes() {
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        Particular particular1 = new Particular("8613565M", "Juan Pérez", "juan@gmail.com", "1111",
        "Calle Mayor", 12, "28001", "Madrid", "912345678", "Juan Pérez", "4829367910325407",
        LocalDate.of(2023, 11, 30));

        Particular particular2 = new Particular("31648234G", "María López", "maria@gmail.com", "2222",
        "Calle Gran Vía", 34, "28013", "Madrid", "678901234", "María López", "7594132068759215",
        LocalDate.of(2025, 7, 30));

        Particular particular3 = new Particular("30518636C", "Pedro Rodríguez", "pedro@gmail.com", "3333",
        "Calle Alcalá", 45, "28009", "Madrid", "789012345", "Pedro Rodríguez", "6105827398419267",
        LocalDate.of(2023, 8, 15));

        Particular particular4 = new Particular("65381354F", "Laura García", "laura@gmail.com", "4444",
        "Calle Serrano", 56, "28006", "Madrid", "567890123", "Laura García", "9243067518293054",
        LocalDate.of(2024, 10, 30));

        Particular particular5 = new Particular("31568683L", "Carlos Martínez", "carlos@gmail.com", "5555",
        "Calle Atocha", 78, "28012", "Madrid", "890123456", "Carlos Martínez", "1376958402539176",
        LocalDate.of(2026, 7, 20));
        
        Empresa empresa1 = new Empresa("A6284635X", "Telefónica", "info@telefonica.com", "1111", "Gran Vía", 28, "28013", "Madrid", "912345678", "www.telefonica.com", "Titular 1", "1111222233334444", LocalDate.of(2023, 12, 31));
        Empresa empresa2 = new Empresa("B8431952Y", "BBVA", "info@bbva.com", "2222", "Paseo de Recoletos", 10, "28021", "Madrid", "911234567", "www.bbva.com", "Titular 2", "4444333322221111", LocalDate.of(2024, 6, 30));
        Empresa empresa3 = new Empresa("C6418524Z", "Iberdrola", "info@iberdrola.com", "3333", "Paseo de la Castellana", 259, "28026", "Madrid", "910987654", "www.iberdrola.com", "Titular 3", "6666777788889999", LocalDate.of(2025, 9, 30));
        Empresa empresa4 = new Empresa("D2605687W", "Repsol", "info@repsol.com", "4444", "Méndez Álvaro", 44, "28025", "Madrid", "913456789", "www.repsol.com", "Titular 4", "5555444433332222", LocalDate.of(2026, 2, 28));
        Empresa empresa5 = new Empresa("E6438491V", "Inditex", "info@inditex.com", "5555", "Calle de Serrano", 36, "28011", "Madrid", "914567890", "www.inditex.com", "Titular 5", "9999888877776666", LocalDate.of(2027, 8, 31));

        clientes.add(empresa1);
        clientes.add(empresa2);
        clientes.add(empresa3);
        clientes.add(empresa4);
        clientes.add(empresa5);  
                
        clientes.add(particular1);
        clientes.add(particular2);       
        clientes.add(particular3);       
        clientes.add(particular4);       
        clientes.add(particular5);       
        
        return clientes;
    }
    
    
    public static void RegistrarClientes(ArrayList<Cliente> clientes) {
                
            try {
                File ruta = new File("clientes.dat");
                FileOutputStream fileOut = new FileOutputStream(ruta);
                try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                    objectOut.writeObject(clientes);
                }
                System.out.println(clientes);
        } catch (IOException ex) {
      } 
    }
    
    
    public static void GuardarVenta(ArrayList<Venta> ventas) throws IOException{
        try{
            File ruta = new File("ventas.dat");
            FileOutputStream fileOut = new FileOutputStream(ruta); 
            try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)){
                objectOut.writeObject(ventas);
                
            }
            System.out.println(ventas);
            
        } catch (IOException ex){
            ex.printStackTrace();
        }  
    }
    
    public static ArrayList<Venta> LeerVenta() throws FileNotFoundException, IOException, ClassNotFoundException{
        File ruta = new File("ventas.dat");
        FileInputStream fileIn = new FileInputStream(ruta);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        ArrayList<Venta> ventas = (ArrayList<Venta>) objectIn.readObject();
        objectIn.close();
        
        return ventas;
    }
    
    
    
    
    public static ArrayList<Cliente> LeerClientes() throws FileNotFoundException, IOException, ClassNotFoundException {
        File ruta = new File("clientes.dat");
        FileInputStream fileIn = new FileInputStream(ruta);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) objectIn.readObject();
        objectIn.close();

        return clientes;
    }
    
    
    public static Cliente consultaClientePorClave(String clave, ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getClave().equals(clave)) {
                return cliente; 
            }
        }
        return null; 
    }
    
    public static Cliente consultaClientePorCorreo(String correo, ArrayList<Cliente> clientes) {
        //Comparador para ordenar los Productos por su código
        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equals(correo)) {
                return cliente; 
            }
        }
        return null;
    }
    
    
    public static boolean esBisiesto(int y) {
        return (y % 4 == 0) && ((y % 100 != 0) || (y % 400 == 0));
    }

    
    public static boolean buenaFecha(int d, int m, int a) {
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (esBisiesto(a)) {
            diasMes[1] = 29; //Febrero es el segundo mes (índice 1)
        }
        return (a > 0 && a < 3000 && m >= 1 && m <= 12 && d >= 1 && d <= diasMes[m - 1]);
    }
    
    public static void generarFactura(ArrayList<Comida> comidas, ArrayList<Integer> cantidades, Restaurante restaurante, Cliente cliente) throws IOException {

    LocalDate hoy = LocalDate.now();
    DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String fn = hoy.format(formatoCorto);
    String timestamp = String.valueOf(System.currentTimeMillis());
    String rutaFicheroFactura = "./Facturas/Factura(" + fn.replace('/', '_') + "_" + timestamp + ").txt";
    double total = restaurante.getGastosEnvio();

    try {
        // Si no existe el directorio Facturas, lo creamos
        File dirFacturas = new File("./Facturas");
        if (!dirFacturas.exists()) {
            dirFacturas.mkdir();
        }

        FileWriter fw = new FileWriter(rutaFicheroFactura);
        try (PrintWriter salida = new PrintWriter(new BufferedWriter(fw))) {
            // Datos del Restaurante
            salida.println("Restaurante: " + restaurante.getNombre());
            salida.println("CIF: " + restaurante.getCif());
            salida.println("Dirección: " + restaurante.getCalle() + ", " + restaurante.getNumeroCalle() + ", " + restaurante.getCodigoPostal() + ", " + restaurante.getCiudad());
            salida.println("Especialidad: " + restaurante.getEspecialidad());
            salida.println("Catering: " + restaurante.getCatering());
            salida.println("Tiempo medio de envio: " + restaurante.getTiempoEnvio());
            salida.println("Gastos de envio: " + restaurante.getGastosEnvio());
            salida.println("Calificación sobre 5: " + restaurante.getValoracion());
            salida.println("\n");

            salida.println("-------------------------------- Factura Restaurante --------------------------------");
            salida.println("-------------------------------- Fecha: " + fn + " -------------------------------");
            salida.println("\n");

            // Datos del Cliente
            salida.println("Cliente: " + cliente.getNombre());
            salida.println("Correo: " + cliente.getCorreo());
            salida.println("Clave: " + cliente.getClave());
            salida.println("Teléfono: " + cliente.getTelefono());
            salida.println("Dirección: " + cliente.getCalle() + ", " + cliente.getNumeroCalle() + ", " + cliente.getCodigoPostal() + ", " + cliente.getCiudad());

            if (cliente instanceof Particular) {
                Particular particular = (Particular) cliente;
                salida.println("DNI: " + particular.getDni());
                
                salida.println("\n");

                
                salida.println("Tarjeta de crédito.");
                salida.println("Titular: " + particular.getTitularTarjeta());
                salida.println("Número: " + particular.getNumeroTarjeta());
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                salida.println("Fecha de caducidad: " + particular.getFechaCaducidad().format(formatoFecha));
            } else if (cliente instanceof Empresa) {
                Empresa empresa = (Empresa) cliente;
                
                salida.println("CIF: " + empresa.getCif());
                salida.println("Web: " + empresa.getWeb());
                
                salida.println("\n");

                salida.println("Tarjeta de crédito.");
                salida.println("Titular: " + empresa.getTitularTarjeta());
                salida.println("Número: " + empresa.getNumeroTarjeta());
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                salida.println("Fecha de caducidad: " + empresa.getFechaCaducidad().format(formatoFecha));
            }

            salida.println("\n");
            DecimalFormat df = new DecimalFormat("#.##");
            for (int i = 0; i < comidas.size(); i++) {
                Comida comida = comidas.get(i);
                int cantidad = cantidades.get(i);

                salida.println("Nombre: " + comida.getTituloComida());
                salida.println("Ingredientes: " + comida.getIngredientesComida());
                salida.println("Precio: " + comida.getPrecioComida());
                salida.println("Cantidad: " + cantidad);
                salida.println("Total: " + df.format(comida.getPrecioComida() * cantidad));
                salida.println("\n");

                total += comida.getPrecioComida() * cantidad;
            }
            
            

            salida.println("---------------------------------------------------------------------------------");
            salida.println("TOTAL: " + df.format(total));            
            salida.println("\n");
            salida.println("-------------------------------------------------------------------------------");
            
            if (cliente instanceof Empresa) {
                double totalDescuento = total - total*0.1;
                salida.println("DESCUENTO: " + df.format(total*0.1));
                salida.println("---------------------------------------------------------------------------------");
                salida.println("TOTAL TRAS DESCUENTO: " + df.format(totalDescuento));            
                salida.println("\n");
                salida.println("-------------------------------------------------------------------------------");
            }      
        }
    } catch (IOException ioe) {
        System.out.println("Error de IO: " + ioe.getMessage());
    }
}
    
    public static ArrayList<Venta> filtrarVentaFecha(ArrayList<Venta> ventas, LocalDate fecha) {
        ArrayList<Venta> ventasFiltradas = new ArrayList<>();
        for (Venta venta: ventas) {
            if (venta.getFechaCompra().isEqual(fecha) || venta.getFechaCompra().isAfter(fecha)){
                ventasFiltradas.add(venta);
            }
            
        }
        return ventasFiltradas;
    }
    
    public static double generarFacturaCatering(boolean camareros, boolean cocineros, boolean decoracion, boolean espacio, boolean comida, Restaurante restaurante, Cliente cliente) throws IOException {

    LocalDate hoy = LocalDate.now();
    DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String fn = hoy.format(formatoCorto);
    String timestamp = String.valueOf(System.currentTimeMillis());
    String rutaFicheroFactura = "./Facturas/Factura(" + fn.replace('/', '_') + "_" + timestamp + ").txt";
    double total = 0.0;

    try {
        File dirFacturas = new File("./Facturas");
        if (!dirFacturas.exists()) {
            dirFacturas.mkdir();
        }

        FileWriter fw = new FileWriter(rutaFicheroFactura);
        try (PrintWriter salida = new PrintWriter(new BufferedWriter(fw))) {
            // Datos del Restaurante
            salida.println("Restaurante: " + restaurante.getNombre());
            salida.println("CIF: " + restaurante.getCif());
            salida.println("Dirección: " + restaurante.getCalle() + ", " + restaurante.getNumeroCalle() + ", " + restaurante.getCodigoPostal() + ", " + restaurante.getCiudad());
            salida.println("Especialidad: " + restaurante.getEspecialidad());
            salida.println("Catering: " + restaurante.getCatering());
            salida.println("Calificación sobre 5: " + restaurante.getValoracion());
            salida.println("\n");

            salida.println("-------------------------------- Factura Restaurante: Catering --------------------------------");
            salida.println("-------------------------------- Fecha: " + fn + " -------------------------------");
            salida.println("\n");

            // Datos del Cliente
            salida.println("Cliente: " + cliente.getNombre());
            salida.println("Correo: " + cliente.getCorreo());
            salida.println("Clave: " + cliente.getClave());
            salida.println("Teléfono: " + cliente.getTelefono());
            salida.println("Dirección: " + cliente.getCalle() + ", " + cliente.getNumeroCalle() + ", " + cliente.getCodigoPostal() + ", " + cliente.getCiudad());
            Empresa empresa = (Empresa) cliente;
            salida.println("CIF: " + empresa.getCif());
            salida.println("Web: " + empresa.getWeb());
                
            salida.println("\n");

            salida.println("Tarjeta de crédito.");
            salida.println("Titular: " + empresa.getTitularTarjeta());
            salida.println("Número: " + empresa.getNumeroTarjeta());
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            salida.println("Fecha de caducidad: " + empresa.getFechaCaducidad().format(formatoFecha));
            

            salida.println("\n");
            salida.println("Servicios prestados.");

            if (camareros) {
                total += 800;
                salida.println("Camareros: " + 800);
            }
            
            if (cocineros) {
                total += 1000;
                salida.println("Cocineros: " + 1000);
            }
            
            if (decoracion) {
                total += 500;
                salida.println("Decoración: " + 500);
            }
            
            if (espacio) {
                total += 1000;
                salida.println("Alquiler de espacio privado: " + 1000);
            }
            
            if (comida) {
                total += restaurante.getPrecioCatering();
                salida.println("Comida: " + restaurante.getPrecioCatering());
            }
            
             DecimalFormat df = new DecimalFormat("#.##");

            salida.println("---------------------------------------------------------------------------------");
            salida.println("TOTAL: " + df.format(total));
            salida.println("\n");
            salida.println("-------------------------------------------------------------------------------");
        }
    } catch (IOException ioe) {
        System.out.println("Error de IO: " + ioe.getMessage());
    }
    return total;
}
    
    public static String StringToHtml(String txt) {
        return "<html><p>" + txt + "</p></html>";
    }


}
    


