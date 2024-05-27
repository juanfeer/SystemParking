import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n\tParqueadero A.B.C. - Centro de Bucaramanga\n");
            System.out.println("1. Registrar ingreso de vehículo");
            System.out.println("2. Registrar salida de vehículo");
            System.out.println("3. Ver disponibilidad");
            System.out.println("4. Mensualidad");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Digita la placa del vehículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("¿Que tipo de Vehículo es?(Carro/Moto): ");
                    String tipo = scanner.nextLine();
                    System.out.print("¿El vehículo tiene Mensualidad?(TRUE/FALSE): ");
                    boolean conMensualidad = scanner.nextBoolean();
                    if (parqueadero.ingresoVehiculo(placa, tipo, conMensualidad)) {
                        System.out.println("\n\t-----!Vehículo registrado!--------");
                    } else {
                        System.out.println("En este momento no contamos con espacios para "+ tipo);
                    }
                    break;
                case 2:
                    System.out.print("Digita la placa del vehículo: ");
                    placa = scanner.nextLine();
                    if (parqueadero.registrarSalidaVehiculo(placa)) {
                        System.out.println("\n\t------Salida exitosa (Ticket generado)-----");
                    } else {
                        System.out.println("--- No encontramos ningún vehículo con la placa "+ placa);
                    }
                    break;
                case 3:
                    parqueadero.mostrarDisponibilidad();
                    break;
                case 4:
                    System.out.print("Digita la placa del Vehíoculo: ");
                    placa = scanner.nextLine();
                    System.out.print("¿Que tipo de vehiculo es?(carro/moto): ");
                    tipo = scanner.nextLine();
                    if (parqueadero.addPlanMensualidad(placa, tipo)) {
                        System.out.println("\n\t----!Ahora este vehículo tiene un plan de mensualidad vigente.-----");
                    } else {
                        System.out.println("----Este vehículo ya cuenta con plan de mensualidad o algo salio mal.");
                    }
                    break;
                case 5:
                    salir = true;
                    System.out.println("\n\t----- Gracias por venir a Parqueadero A.B.C.\n!Vuelva pronto!.");
                    break;
                default:
                    System.out.println("----- Opción invalida, intentalo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
