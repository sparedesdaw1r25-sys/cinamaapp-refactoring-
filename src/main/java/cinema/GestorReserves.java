import java.util.ArrayList;
public enum TipusReserva { ESTANDARD, PREESTRENA, VIP }

public class GestorReserves {
private static final double DESCOMPTE_PREESTRENA = 0.10;
private static final double BONUS_GRUP_GRAN = 0.05;
private static final double DESCOMPTE_VIP = 0.15;
private static final int MIDA_GRUP_GRAN = 6;

private ArrayList<int[]> reservesRegistrades = new ArrayList<>();
public boolean reservar(TipusReserva tipus, int[] seients, double preuPerSeient) {

   if (seients == null || seients.length == 0) {
        return false;
    }
if (preuPerSeient <= 0) {
    return false;
}

double total = calcularTotal(tipus, seients.length, preuPerSeient);

 registrarReserva(seients);

    mostrarResum(tipus, seients.length, total);

    return true;
}
private double calcularTotal(TipusReserva tipus, int numSeients, double preuBase) {

    double total = preuBase * numSeients;

    if (tipus == TipusReserva.PREESTRENA) {
        total *= (1 - DESCOMPTE_PREESTRENA);
    }

    if (tipus == TipusReserva.VIP) {
        total *= (1 - DESCOMPTE_VIP);
    }

    if (numSeients >= MIDA_GRUP_GRAN) {
        total *= (1 - BONUS_GRUP_GRAN);
    }

    return total;
}
private void registrarReserva(int[] seients) {
    reservesRegistrades.add(seients);
}
private void mostrarResum(TipusReserva tipus, int numSeients, double total) {
    System.out.println("Tipus: " + tipus);
    System.out.println("Seients: " + numSeients);
    System.out.println("Total: " + total);
}
}


