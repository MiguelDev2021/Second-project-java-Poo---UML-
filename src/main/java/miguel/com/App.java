package miguel.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {

    public static void main(String[] args) throws ParseException {
        var fecha = new SimpleDateFormat("dd/MM/yyyy").parse("17/03/2021");
        var reserva = new Reserva(fecha, "Carlos Perez");
        reserva.adicionarVehiculo(new Automovil("Kia", "Rio Sedan", 60_000_000d, TipoTransmision.MANUAL, false, false));
        reserva.adicionarVehiculo(
                new Automovil("Kia", "Rio Hatchback", 64_000_000d, TipoTransmision.AUTOMATICA, true, true));
        reserva.adicionarVehiculo(new Motocicleta("Suzuki", "VStrong", 30_000_000d, 600d));
        reserva.adicionarVehiculo(new Motocicleta("Auteco", "VICTORY BOLD", 5_999_000d, 125d));
        System.out.printf("Cliente: %s %n", reserva.getCliente());
        System.out.printf("Numero vehiculos: %d %n", reserva.calcularCantidadVehiculos());
        System.out.printf("Subtotal: %,.2f %n", reserva.calcularSubtotal());
        System.out.printf("Descuento: %,.2f %n", reserva.calcularDescuentos());
        System.out.printf("Impuestos: %,.2f %n", reserva.calcularImpuestos());
        System.out.printf("Total: %,.2f %n", reserva.calcularTotal());

    }

}
