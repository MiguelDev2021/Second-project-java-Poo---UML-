package miguel.com;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {

    

    public static void main(String[] args) throws ParseException {
        var fecha = new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2021");
        var reserva = new Reserva(fecha, "Cesar Díaz");
        reserva.adicionarVehiculo(new Automovil("Mazda", "R8", 150_000_000d,
        TipoTransmision.MANUAL, true, true));
        reserva.adicionarVehiculo(new Motocicleta("BMW", "S 1000 RR", 60_000_000d, 1000d));
        System.out.printf("Cliente: %s %n", reserva.getCliente());
        System.out.printf("Numero vehiculos: %d %n", reserva.calcularCantidadVehiculos());
        System.out.printf("fecha de reserva: %s", reserva.getFecha().toString());
        System.out.printf("Subtotal: %,.2f %n", reserva.calcularSubtotal());
        System.out.printf("Descuento: %,.2f %n", reserva.calcularDescuentos());
        System.out.printf("Impuestos: %,.2f %n", reserva.calcularImpuestos());
        System.out.printf("Total: %,.2f %n", reserva.calcularTotal());


    
    
    }

   

}
