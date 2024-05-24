import java.time.Duration;
import java.time.LocalDateTime;
        
public class Vehiculo {
    private String placa;
    private String tipo;
    private LocalDateTime hora_Entrada;
    private LocalDateTime hora_Salida;
    private double costo;
    private boolean conMensualidad;
    
    public Vehiculo(String placa, String tipo, LocalDateTime hora_Entrada, boolean conMensualidad) {
           
        this.placa = placa;
        this.tipo = tipo;
        this.hora_Entrada = hora_Entrada;
        this.conMensualidad = conMensualidad;
    }
    
    public void Salida (LocalDateTime hora_Salida) {
        
        this.hora_Salida = hora_Salida;

        // Comprueba si el Vehículo tiene una mensualidad activa
        if(!conMensualidad) {
            this.costo = calcularCosto();
        }
        else {
            this.costo = 0;
        }
    }
    
    public double calcularCosto() {
        
        Duration tiempo = Duration.between(hora_Entrada, hora_Salida);
        long minutos = tiempo.toMinutes();
        double costo = 0;
        
        if ("carro".equalsIgnoreCase(tipo)) {
            if (minutos <= 60) {
                costo = 2000;
            } else {
                costo = 2000 + ((minutos - 60) / 30) * 1000;
            }
        } else if ("moto".equalsIgnoreCase(tipo)) {
            if (minutos <= 60) {
                costo = 3000;
            } else {
                costo = 3000 + ((minutos - 60) / 30) * 1500;
            }
        }
        return costo;       
    }
    
    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getHora_Entrada() {
        return hora_Entrada;
    }

    public LocalDateTime getHora_Salida() {
        return hora_Salida;
    }

    public double getCosto() {
        return costo;
    }
    public boolean conMensualidad() {

        return conMensualidad;
    }
    public void setconMensualidad(boolean conMensualidad) {

        this.conMensualidad = conMensualidad;
    }
    
}
