import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;






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

public abstract class  Vehiculo  {

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

public class Automovil extends Vehiculo {

    private TipoTransmision transmision;
    private Boolean vidriosElectricos;
    private Boolean aireAcondicionado;

    public Automovil(String marca, String modelo, Double precioBase, TipoTransmision transmision,
            Boolean vidriosElectricos, Boolean aireAcondicionado) {
        super(marca, modelo, precioBase);
        this.transmision = transmision;
        this.vidriosElectricos = vidriosElectricos;
        this.aireAcondicionado = aireAcondicionado;
    }

    public Double calcularPrecio() {

        Double precioBase = getPrecioBase();
       // var transmision_vehiculo = TipoTransmision.AUTOMATICA;

        if (getTransmision() == TipoTransmision.AUTOMATICA) {
            precioBase = precioBase + ((7 * precioBase) / 100);
        }

        if (getVidriosElectricos()) {
            precioBase = precioBase + 300000;
        }

        if (getAireAcondicionado()) {
            precioBase = precioBase + 2500000;

        }
        setPrecioBase(precioBase);
        return precioBase;
    }

    public Double calcularPorcentajeImpuesto() {
        Double precioBase = getPrecioBase();
        Double impuesto = 0.0;
        if ( precioBase > 80000000){
           impuesto =  precioBase * 19 / 100;
            

        }


        return impuesto;
    }

    // metodo creado para poder verificar el tipo de la transmision
    public TipoTransmision getTransmision() {
        return transmision;
    }

    public Boolean getVidriosElectricos() {
        return vidriosElectricos;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

  

}

public class Motocicleta extends Vehiculo {

    private Integer cilindraje;

    public Motocicleta(String marca, String modelo, Double precioBase, Integer cilindraje) {
        super(marca, modelo, precioBase);
        this.cilindraje = cilindraje;
    }

    

    public Double calcularPrecio() {
        Double precioBase = getPrecioBase();
        Integer cilindraje = getCilindraje();

        if (cilindraje >= 150 && cilindraje <= 300) {

            precioBase += 400000;

        } else if (cilindraje > 300 && cilindraje <= 600) {
            precioBase += 800000;

        } else if (cilindraje > 600) {
            precioBase += 1200000;

        }
        setPrecioBase(precioBase);
        return precioBase;
    }

    public Double calcularPorcentajeImpuesto() {
        Double precioBase = getPrecioBase();
        Double impuesto = 0.0;
        if (precioBase > 6100000) {
            impuesto = (precioBase * 19) / 100;

        }

        return impuesto;

    }

    public Integer getCilindraje() {
        return cilindraje;
    }

}

public enum TipoTransmision {
    MANUAL,AUTOMATICA
}