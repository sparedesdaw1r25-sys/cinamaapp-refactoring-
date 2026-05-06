public class GestorPromocions {

    private EstrategiaPromocio estrategia;

    public GestorPromocions(EstrategiaPromocio estrategia) {
        this.estrategia = estrategia;
    }

    public double aplicarPromocio(Entrada entrada) {
        return estrategia.aplicar(entrada, entrada.getPreuBase());
    }
}
