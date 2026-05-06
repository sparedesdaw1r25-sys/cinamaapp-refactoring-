import java.util.ArrayList;
import java.util.List;

public class GestorSessions {

    private static final int MIN_AFORAMENT = 10;

    private List<Sala> sales = new ArrayList<>();
    private List<Film> films = new ArrayList<>();
    private List<Sessio> sessions = new ArrayList<>();

    // Responsabilitats de programarSessio:
    // 1. Cercar la sala
    // 2. Validar si la sala existeix i és operativa
    // 3. Cercar la pel·lícula
    // 4. Comprovar conflictes d’horari
    // 5. Validar l’aforament
    // 6. Crear i guardar la sessió
    // 7. Notificar al personal

    public String programarSessio(int idSala, String titolFilm, String hora, int aforament) {

        Sala sala = cercarSala(idSala);
        if (sala == null) return "Error: sala no trobada";
        if (!sala.isOperativa()) return "Error: sala no operativa";

        Film film = cercarFilm(titolFilm);
        if (film == null) return "Error: film no trobat al catàleg";

        if (hiHaConflicteHorari(idSala, hora)) return "Error: la sala ja té una sessió a aquesta hora";
        if (!validarAforament(aforament, sala)) return "Error: aforament no vàlid";

        Sessio s = new Sessio(sala, film, hora, aforament);
        sessions.add(s);

        notificarPersonal(sala, film, hora, s);

        return "OK: sessió " + s.getId();
    }

    private Sala cercarSala(int idSala) {
        for (Sala s : sales) {
            if (s.getId() == idSala) return s;
        }
        return null;
    }

    private Film cercarFilm(String titol) {
        for (Film f : films) {
            if (f.getTitol().equals(titol)) return f;
        }
        return null;
    }

    private boolean hiHaConflicteHorari(int idSala, String hora) {
        for (Sessio s : sessions) {
            if (s.getSala().getId() == idSala && s.getHora().equals(hora)) {
                return true;
            }
        }
        return false;
    }

    private boolean validarAforament(int aforament, Sala sala) {
        if (aforament < MIN_AFORAMENT) return false;
        if (aforament > sala.getCapacitat()) return false;
        return true;
    }

    private void notificarPersonal(Sala sala, Film film, String hora, Sessio s) {
        System.out.println("Sala " + sala.getNom() + " — " + film.getTitol() + " a les " + hora);
        System.out.println("Aforament: " + s.getAforament() + " espectadors");
        System.out.println("Sessió #" + s.getId() + " creada.");
    }
    //fi
}
