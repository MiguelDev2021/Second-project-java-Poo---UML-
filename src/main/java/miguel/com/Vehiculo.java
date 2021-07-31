package miguel.com;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Vehiculo {

    private String marca;
    private String modelo;
    private Double precioBase;

    private Motocicleta motocicleta;
    private Automovil automovil;

    public Vehiculo(String marca, String modelo, Double precioBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
    }

    public abstract Double calcularPrecio();

    public abstract Double calcularPorcentajeImpuesto();

    public Double calcularDescuento(Date fecha) {
        // Extrae el mes de la fecha actual.
        // Para comparar use las constantes Calendar.JULY o Calendar.JUNE
        var cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        var mes = cal.get(Calendar.MONTH);
        String marca = getMarca();
        Double descuento = 0.0;

        if (mes == Calendar.MAY && marca.equals(getMarca())) {
            Double precioBase = getPrecioBase();
            descuento = precioBase - ((10 * precioBase) / 100);

        } else if (mes == Calendar.JUNE && marca.equals(getMarca())) {

            if (marca.equals(automovil.getMarca())) {
                Double precioBase = automovil.getPrecioBase();
                descuento = precioBase - ((5 * precioBase) / 100);
            } else if (marca.equals(motocicleta.getMarca())) {
                Double precioBase = automovil.getPrecioBase();
                descuento = precioBase - ((10 * precioBase) / 100);

            }

        }

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