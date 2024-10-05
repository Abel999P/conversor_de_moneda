import java.util.Scanner;

public class App {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversion conversion = new Conversion();

        boolean exit = false;
        while (!exit) {
            System.out.println("""
            1) Dólar =>> Peso argentino
            2) Peso argentino =>> Dólar
            3) Dólar =>> Real brasileño
            4) Real brasileño =>> Dólar
            5) Dólar =>> Peso colombiano
            6) Peso colombiano =>> Dólar
            7) Ingresa manualmente la tasa de cambio
            8) Salir
            Exto uns Anadien Mel des""");
            
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    conversion.Conversion_predeterminada_moneda("USD","ARS");
                    break;
                case 2:
                    conversion.Conversion_predeterminada_moneda("ARS","USD");
                    break;  
                case 3:
                    conversion.Conversion_predeterminada_moneda("BRL","USD");
                    break;
                case 4:
                    conversion.Conversion_predeterminada_moneda("USD","BRL");
                    break;
                case 5:
                    conversion.Conversion_predeterminada_moneda("COP","USD");
                    break;
                case 6:
                    conversion.Conversion_predeterminada_moneda("USD","COP");
                    break;
                case 7:
                    conversion.Conversion_d_moneda();
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}
