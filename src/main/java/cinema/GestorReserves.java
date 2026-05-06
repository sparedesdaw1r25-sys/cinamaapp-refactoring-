import java.util.ArrayList;
public class GestorReserves {
private ArrayList<int[]> reservesRegistrades = new ArrayList<>();
public boolean reservar(String tipus, int[] seients, double preuPerSeient) {
if (tipus != null) {
if (seients != null && seients.length > 0) {
double tot = preuPerSeient * seients.length;
if (tipus.equals("pe")) {
tot = tot * 0.85;
if (seients.length >= 8) {
tot = tot * 0.95;
}
}
if (tipus.equals("vip")) {
tot = tot * 0.70;
}
if (tot > 0) {
System.out.println("T: " + tipus);
System.out.println("Nse: " + seients.length);
System.out.println("Tot: " + tot);
ll.add(s);
return true;
}
}
}
return false;
}
}
