package cinema;

public class PromoSoci implements EstrategiaPromocio {

    private ClubSocisServei socis;

    public PromoSoci(ClubSocisServei socis) {
        this.socis = socis;
    }

    @Override
    public double aplicar(Entrada entrada, double preuBase) {
        if (socis.esSoci(entrada.getClientId())) {
            return preuBase * 0.80;
        }
        return preuBase;
    }
}
