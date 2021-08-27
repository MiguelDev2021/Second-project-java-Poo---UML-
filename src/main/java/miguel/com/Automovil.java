package miguel.com;

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