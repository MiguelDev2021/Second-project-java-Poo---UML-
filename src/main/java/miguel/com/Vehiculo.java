package miguel.com;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Vehiculo {

    private String marca;
    private String modelo;
    private Double precioBase;
   
    

    public Vehiculo(String marca, String modelo, Double precioBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
    }

    public abstract Double calcularPrecio();

    public abstract Double calcularPorcentajeImpuesto();

    public Double calcularDescuento(Date fecha, Boolean tipovehiculo) {
        // Extrae el mes de la fecha actual.
        // Para comparar use las constantes Calendar.JULY o Calendar.JUNE
        var cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        var mes = cal.get(Calendar.MONTH);
        String marca = getMarca();
        Double descuento = 0.0;
        var precioRealvehiculo =  getPrecioBase();

        if (mes == Calendar.MAY && marca == "Mazda") {
            descuento = (10 * precioRealvehiculo) / 100;

        } else if (mes == Calendar.JUNE && marca == "BMW") { 
            if (tipovehiculo) {
               
                descuento =  (5 * precioRealvehiculo) / 100; 
            } else {
                
                descuento = (10 * precioRealvehiculo) / 100;

            }
           
        
        }
        setPrecioBase(precioRealvehiculo - descuento);
        return descuento;

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }


    


    

}