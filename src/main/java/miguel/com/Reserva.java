package miguel.com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {

    private Date fecha;
    private String cliente;

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    
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
            vehiculos = (ArrayList<Vehiculo>) getVehiculos();
            var añadir = vehiculos.add(vehiculo);
    }

    public Integer calcularCantidadVehiculos() {
       return vehiculos.size();
    }

    public Double calcularSubtotal() {
        Double subtotal  = 0.0;

        for (var vehiculo : vehiculos) {
            subtotal += vehiculo.calcularPrecio(); 
        }
        
        return subtotal;
    }

    public Double calcularDescuentos() {
        Double descuentos = 0.0;
        for (var vehiculo : vehiculos) {
            descuentos += vehiculo.calcularDescuento(getFecha());  
            
        }
        
        
        return descuentos;
    }

    public Double calcularImpuestos() {
        Double impuestos = 0.0;
        for (Vehiculo vehiculo : vehiculos) {
            impuestos += vehiculo.calcularPorcentajeImpuesto();  
        }
        
        return impuestos;
    }

    public Double calcularTotal() {
        return calcularSubtotal() - calcularDescuentos() + calcularImpuestos();
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