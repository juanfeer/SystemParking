import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private int capacidadAutos = 15;
    private int capacidadMotos = 30;
    private List<Vehiculo> vehiculosEstacionados = new ArrayList<>();
    private List<Vehiculo> vehiculosTieneMensualidad = new ArrayList<>();

    public boolean registrarIngresoVehiculo(String placa, String tipo, boolean conMensualidad) {
        if (conMensualidad) {
            return registrarVehiculoTieneMensualidad(placa, tipo);
        } else {
            return registrarVehiculoNormal(placa, tipo);
        }
    }

    private boolean registrarVehiculoNormal(String placa, String tipo) {
        if (tipo.equalsIgnoreCase("carro") && espaciosDisponiblesAutos() > 0) {
            vehiculosEstacionados.add(new Vehiculo(placa, tipo, LocalDateTime.now(), false));
            return true;
        } else if (tipo.equalsIgnoreCase("moto") && espaciosDisponiblesMotos() > 0) {
            vehiculosEstacionados.add(new Vehiculo(placa, tipo, LocalDateTime.now(), false));
            return true;
        }
        return false;
    }

    private boolean registrarVehiculoTieneMensualidad(String placa, String tipo) {
        if (vehiculoTieneMensualidad(placa)) {
            vehiculosTieneMensualidad.add(new Vehiculo(placa, tipo, LocalDateTime.now(), true));
            return true;
        }
        return false;
    }

    public boolean registrarSalidaVehiculo(String placa) {
        for (Vehiculo vehiculo : vehiculosEstacionados) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculo.Salida(LocalDateTime.now());
                vehiculosEstacionados.remove(vehiculo);
                generarTicket(vehiculo);
                return true;
            }
        }
        for (Vehiculo vehiculo : vehiculosTieneMensualidad) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculo.Salida(LocalDateTime.now());
                vehiculosTieneMensualidad.remove(vehiculo);
                generarTicket(vehiculo);
                return true;
            }
        }
        return false;
    }

    private void generarTicket(Vehiculo vehiculo) {
        Tickets ticket = new Tickets(vehiculo.getPlaca(), vehiculo.getTipo(), vehiculo.getHora_Entrada(), vehiculo.getCosto());
        ticket.imprimirTicket();
    }

    public boolean addPlanMensualidad(String placa, String tipo) {
        if (!vehiculoTieneMensualidad(placa)) {
            vehiculosTieneMensualidad.add(new Vehiculo(placa, tipo, null, true));
            return true;
        }
        return false;
    }

    private boolean vehiculoTieneMensualidad(String placa) {
        for (Vehiculo vehiculo : vehiculosTieneMensualidad) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }

    public int espaciosDisponiblesAutos() {
        long autosEstacionados = vehiculosEstacionados.stream().filter(v -> "carro".equalsIgnoreCase(v.getTipo())).count();
        return capacidadAutos - (int) autosEstacionados;
    }

    public int espaciosDisponiblesMotos() {
        long motosEstacionados = vehiculosEstacionados.stream().filter(v -> "moto".equalsIgnoreCase(v.getTipo())).count();
        return capacidadMotos - (int) motosEstacionados;
    }

    public double calcularTotalIngreso() {
        return vehiculosEstacionados.stream().mapToDouble(Vehiculo::getCosto).sum();
    }

    public void mostrarDisponibilidad() {
        System.out.println("Espacios disponibles para autos: " + espaciosDisponiblesAutos());
        System.out.println("Espacios disponibles para motos: " + espaciosDisponiblesMotos());
    }
}
