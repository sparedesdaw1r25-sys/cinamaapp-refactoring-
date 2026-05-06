package cinema;

public class PromoEstudiant implements EstrategiaPromocio {

    private ValidadorEstudiant validador;

    public PromoEstudiant(ValidadorEstudiant validador) {
        this.validador = validador;
    }

    @Override
    public double aplicar(Entrada entrada, double preuBase) {
        if (validador.verificar(entrada.getClientId())) {
            return preuBase * 0.75;
        }
        return preuBase;
    }
}
