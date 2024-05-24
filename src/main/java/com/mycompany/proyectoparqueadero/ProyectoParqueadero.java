import java.util.Scanner;

public class ProyectoParqueadero {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nParqueadero A.B.C. - Centro de Bucaramanga");
            System.out.println("1. Registrar ingreso de vehículo");
            System.out.println("2. Registrar salida de vehículo");
            System.out.println("3. Mostrar disponibilidad");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Digita la placa del vehículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("¿Que tipo de Vehículo es?(Carro/Moto): ");
                    String tipo = scanner.nextLine();
                    if (parqueadero.registrarIngresoVehiculo(placa, tipo)) {
                        System.out.println("Vehículo registrado!");
                    } else {
                        System.out.println("En este momento no contamos con espacios para ");
                        System.out.println(tipo);
                    }
                    break;
                case 2:
                    System.out.print("Digita la placa del vehículo: ");
                    placa = scanner.nextLine();
                    if (parqueadero.registrarSalidaVehiculo(placa)) {
                        System.out.println("Salida exitosa (Ticket generado)");
                    } else {
                        System.out.println("No encontramos ningún vehículo con la placa ");
                        System.out.println(placa);
                    }
                    break;
                case 3:
                    parqueadero.mostrarDisponibilidad();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Gracias por venir a Parqueadero A.B.C.\n!Vuelva pronto!.");
                    break;
                default:
                    System.out.println("Opción invalida, intentalo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
