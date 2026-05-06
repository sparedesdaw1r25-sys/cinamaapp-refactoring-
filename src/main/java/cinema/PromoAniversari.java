package cinema;

public class PromoAniversari implements EstrategiaPromocio {

    @Override
    public double aplicar(Entrada entrada, double preuBase) {
        return preuBase * 0.50;
    }
}
