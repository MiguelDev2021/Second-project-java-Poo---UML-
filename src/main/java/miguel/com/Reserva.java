package miguel.com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {

    private Date fecha;
    private String cliente;

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    Double total = 0.0;

    public Reserva(Date fecha, String cliente) {
        this.setFecha(fecha);
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void adicionarVehiculo(Vehiculo vehiculo) {
        vehiculos = (ArrayList<Vehiculo>) getVehiculos();
        var añadir = vehiculos.add(vehiculo);
    }

    public Integer calcularCantidadVehiculos() {
        return vehiculos.size();
    }

    public Double calcularSubtotal() {
        Double subtotal = 0.0;

        for (var vehiculo : vehiculos) {
            Double precio_vehiculo = vehiculo.calcularPrecio();
            subtotal += precio_vehiculo;
        }
        total += subtotal;
        return subtotal;
    }

    public Double calcularDescuentos() {
        Double descuentos = 0.0;
        for (var vehiculo : vehiculos) {
            Boolean tipovehiculo = vehiculo instanceof Automovil;
            descuentos += vehiculo.calcularDescuento(getFecha(), tipovehiculo);

        }

        total -= descuentos;
        return descuentos;
    }

    public Double calcularImpuestos() {
        Double impuestos = 0.0;
        for (Vehiculo vehiculo : vehiculos) {
            impuestos += vehiculo.calcularPorcentajeImpuesto();
        }
        total += impuestos;
        return impuestos;
    }

    public Double calcularTotal() {

        return total;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

}