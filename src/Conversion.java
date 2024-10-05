import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Conversion {
    Scanner scanner = new Scanner(System.in);
    public String Conversion_d_moneda() {
        try {
            ConsultaApi solicitud = new ConsultaApi();
                double monto = 0;
                double resultado = 0;
                double tasa = 0;
                String moneda = "";
                String moneda_d_cambio = "";
                
                System.out.println("Ingresa la moneda de origen: ");
                moneda = scanner.nextLine().toUpperCase();
                Moneda respuesta  =  solicitud.getMoneda(moneda);

                // if (respuesta == null) {
                //     throw new NoSuchElementException("La moneda de origen no existe.");
                // }
                try{
                    System.out.println("Ingresa el monto de la moneda principal: ");
                    monto = scanner.nextDouble();
                    scanner.nextLine();

                }catch (InputMismatchException e) {
                    if(respuesta.base_code() == null){
                        System.out.println("La moneda de origen no existe.");
                        return null;
                    }else{
                        System.out.println("Error: El monto ingresado no es un número válido.");
                        scanner.nextLine();
                        return null;
                    }
                } 
                System.out.println("Ingresa la moneda de destino: ");
                moneda_d_cambio = scanner.nextLine().toUpperCase(); 
                
                try {
                    tasa = respuesta.conversion_rates().get(moneda_d_cambio);
                } catch (NullPointerException e) {
                    System.out.println("Error: La moneda de destino no existe.");
                    return null;
                }
                resultado = monto * tasa;  
                DecimalFormat formato = new DecimalFormat("#,##0.00");
                String res = formato.format(resultado);
                System.out.println("La convercion es de : "+res+"\n");

                File file = new File("Historial-de-conversiones.txt");
                Date fecha = new Date(System.currentTimeMillis());
                SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
                String fechaFormateada = formateador.format(fecha);
                FileWriter escritor = new FileWriter(file, true);
                escritor.write("""
                        Fecha de la conversión:\s""" + fechaFormateada + """
                        \nDivisa de origen:\s""" + moneda + """
                        \nDivisa de destino:\s""" + moneda_d_cambio + """
                        \nMonto:\s""" + monto + """
                        \nTasa:\s""" + tasa + """
                        \nTotal:\s""" + resultado + """
                        \n
                        """);
                escritor.close();
                return res;
        }catch(RuntimeException e) {
            System.out.println("No es posible comunicarse con la API(intentelo mas tarde)");
            return null;
        }
        catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            return null;
        }
    }
    public String Conversion_predeterminada_moneda(String moneda,String moneda_d_cambio) {
        try {
            double monto = 0;
            double resultado = 0;
            double tasa = 0;
            ConsultaApi consulta = new ConsultaApi();
            Moneda respuesta = consulta.getMoneda(moneda);



            try{
                System.out.println("Ingresa el monto de la moneda principal: ");
                monto = scanner.nextDouble();
                scanner.nextLine();
            }catch (InputMismatchException e) {
                System.out.println("Error: El monto ingresado no es un número válido.");
                scanner.nextLine();
                return null;
            }
            
            
            try {
                tasa = respuesta.conversion_rates().get(moneda_d_cambio);
            } catch (NullPointerException e) {
                System.out.println("Error: La moneda de destino o origen no existe.");
                return null;
            }


            resultado = monto * tasa;  
            DecimalFormat formateo = new DecimalFormat("#,##0.00");
            String res = formateo.format(resultado);
            System.out.println("La convercion es de : "+res+"\n");


            File file = new File("Historial-de-conversiones.txt");
            Date fecha = new Date(System.currentTimeMillis());
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = formateador.format(fecha);
            FileWriter escritor = new FileWriter(file, true);
            escritor.write("""
                    Fecha de la conversión:\s""" + fechaFormateada + """
                    \nDivisa de origen:\s""" + moneda + """
                    \nDivisa de destino:\s""" + moneda_d_cambio + """
                    \nMonto:\s""" + monto + """
                    \nTasa:\s""" + tasa + """
                    \nTotal:\s""" + resultado + """
                    \n
                    """);
            escritor.close();
            return res;

        }catch(RuntimeException e) {
            System.out.println("No es posible comunicarse con la API(intentelo mas tarde)");
            return null;
        }catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            return null;
        }
    }
}