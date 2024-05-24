import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tickets {
    private String placa_Vehiculo;
    private String tipo_Vehiculo;
    private LocalDateTime hora_Entrada;
    private double costo;

    public Tickets(String placa_Vehiculo, String tipo_Vehiculo, LocalDateTime hora_Entrada, double costo) {
        this.placa_Vehiculo = placa_Vehiculo;
        this.tipo_Vehiculo = tipo_Vehiculo;
        this.hora_Entrada = hora_Entrada;
        this.costo = costo;
    }

    public void imprimirTicket() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("\n\tTICKET PARQUEADERO\n");
        System.out.println("---> Placa: " + placa_Vehiculo);
        System.out.println("---> Tipo: " + tipo_Vehiculo);
        System.out.println("---> Hora de Entrada: " + hora_Entrada.format(formatter));
        System.out.println("---> Total a Pagar: $" + costo);
    }
}
