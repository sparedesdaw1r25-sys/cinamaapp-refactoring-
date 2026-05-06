public class Sessio {
private static int comptador = 1;
private int id;
private Sala sala;
private Film film;
private String hora;
private int aforament;
public Sessio(Sala sala, Film film, String hora, int aforament) {
this.id = comptador++;
this.sala = sala;
this.film = film;
this.hora = hora;
this.aforament = aforament;
}
public int getId() { return id; }
public Sala getSala() { return sala; }
public Film getFilm() { return film; }
public String getHora() { return hora; }
public int getAforament(){ return aforament; }
}
