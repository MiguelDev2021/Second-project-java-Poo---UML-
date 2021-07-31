package miguel.com;

import java.util.Date;

public class Reserva {

    private Date fecha;
    private String cliente;

    private Vehiculo vehiculo;
    
    Integer cantidadVehiculos = 0;


    


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
        calcularCantidadVehiculos();
    }

    public Integer calcularCantidadVehiculos() {
        
        cantidadVehiculos= cantidadVehiculos + 1 ;
        return cantidadVehiculos;
    }

    public Double calcularSubtotal() {
        Double subtotal  = 0.0;
        subtotal += vehiculo.calcularPrecio();
        return subtotal;
    }

    public Double calcularDescuentos() {
        Double descuentos = 0.0;
        descuentos += vehiculo.calcularPorcentajeImpuesto();
        return descuentos;
    }

    public Double calcularImpuestos() {
        Double impuestos = 0.0;
        impuestos += calcularImpuestos();
        return impuestos;
    }

    public Double calcularTotal() {
        return calcularSubtotal() - calcularDescuentos() + calcularImpuestos();
    }

    public String getCliente() {
        return cliente;
    }



   

}