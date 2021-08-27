package miguel.com;

public class Motocicleta extends Vehiculo {

    private Double cilindraje;

    public Motocicleta(String marca, String modelo, Double precioBase, Double cilindraje) {
        super(marca, modelo, precioBase);
        this.cilindraje = cilindraje;
    }

    

    public Double calcularPrecio() {
        Double precioBase = getPrecioBase();
        Double cilindraje = getCilindraje();

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

    public Double getCilindraje() {
        return cilindraje;
    }

}
