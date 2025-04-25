import java.util.ArrayList;

class Playlista {
    private String nazwa;
    private ArrayList<String> utwory = new ArrayList<>();

    public Playlista(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void dodajUtwor(String utwor) {
        if (utwor != null && !utwor.isBlank() && !utwory.contains(utwor)) {
            utwory.add(utwor);
        }
    }

    public void usunUtwor(String utwor) {
        utwory.remove(utwor);
    }

    public void wyswietlUtwory() {
        System.out.println("Playlista: " + nazwa);
        for (String utwor : utwory) {
            System.out.println("- " + utwor);
        }
    }
}

class BibliotekaMuzyczna {
    private String nazwa;
    private String wlasciciel;
    private ArrayList<String> utwory = new ArrayList<>();
    private ArrayList<Playlista> playlisty = new ArrayList<>();

    public BibliotekaMuzyczna(String nazwa, String wlasciciel) {
        this.nazwa = nazwa;
        this.wlasciciel = wlasciciel;
    }

    public void dodajUtwor(String utwor) {
        if (utwor != null && !utwor.isBlank() && !utwory.contains(utwor)) {
            utwory.add(utwor);
        }
    }

    public void usunUtwor(String utwor) {
        utwory.remove(utwor);
        for (Playlista p : playlisty) {
            p.usunUtwor(utwor);
        }
    }

    public void wyswietlUtwory() {
        System.out.println("Utwory w bibliotece:");
        for (String utwor : utwory) {
            System.out.println("- " + utwor);
        }
    }

    public void wyszukajUtwory(String fraza) {
        if (fraza == null || fraza.isBlank()) return;

        System.out.println("Wyniki wyszukiwania dla: " + fraza);
        for (String utwor : utwory) {
            if (utwor.contains(fraza)) {
                System.out.println("- " + utwor);
            }
        }
    }

    public void utworzPlayliste(String nazwaPlaylisty) {
        for (Playlista p : playlisty) {
            if (p.getNazwa().equalsIgnoreCase(nazwaPlaylisty)) {
                return;
            }
        }
        playlisty.add(new Playlista(nazwaPlaylisty));
    }

    public Playlista znajdzPlayliste(String nazwaPlaylisty) {
        for (Playlista p : playlisty) {
            if (p.getNazwa().equalsIgnoreCase(nazwaPlaylisty)) {
                return p;
            }
        }
        return null;
    }

    public void dodajUtworDoPlaylisty(String utwor, String nazwaPlaylisty) {
        Playlista p = znajdzPlayliste(nazwaPlaylisty);
        if (p != null) {
            p.dodajUtwor(utwor);
        }
    }

    public void wyswietlPlayliste(String nazwaPlaylisty) {
        Playlista p = znajdzPlayliste(nazwaPlaylisty);
        if (p != null) {
            p.wyswietlUtwory();
        }
    }

    public void wyswietlWszystkiePlaylisty() {
        System.out.println("Wszystkie playlisty:");
        for (Playlista p : playlisty) {
            System.out.println("- " + p.getNazwa());
        }
    }

    public int getLiczbaUtworow() {
        return utwory.size();
    }

    public int getLiczbaPlaylist() {
        return playlisty.size();
    }
}

public class Program {
    public static void main(String[] args) {
        BibliotekaMuzyczna mojaBiblioteka = new BibliotekaMuzyczna("Kolekcja Rockowa", "Jan Kowalski");

        mojaBiblioteka.dodajUtwor("Led Zeppelin - Stairway to Heaven");
        mojaBiblioteka.dodajUtwor("Queen - Bohemian Rhapsody");
        mojaBiblioteka.dodajUtwor("Pink Floyd - Comfortably Numb");
        mojaBiblioteka.dodajUtwor("AC/DC - Back in Black");
        mojaBiblioteka.dodajUtwor("Metallica - Nothing Else Matters");

        mojaBiblioteka.wyswietlUtwory();

        mojaBiblioteka.utworzPlayliste("Ulubione");
        mojaBiblioteka.utworzPlayliste("Na imprezę");

        mojaBiblioteka.dodajUtworDoPlaylisty("Queen - Bohemian Rhapsody", "Ulubione");
        mojaBiblioteka.dodajUtworDoPlaylisty("Pink Floyd - Comfortably Numb", "Ulubione");
        mojaBiblioteka.dodajUtworDoPlaylisty("AC/DC - Back in Black", "Na imprezę");
        mojaBiblioteka.dodajUtworDoPlaylisty("Metallica - Nothing Else Matters", "Na imprezę");

        mojaBiblioteka.wyswietlWszystkiePlaylisty();
        mojaBiblioteka.wyswietlPlayliste("Ulubione");

        mojaBiblioteka.wyszukajUtwory("Queen");

        mojaBiblioteka.usunUtwor("AC/DC - Back in Black");
        mojaBiblioteka.wyswietlPlayliste("Na imprezę");

        System.out.println("Liczba utworów w bibliotece: " + mojaBiblioteka.getLiczbaUtworow());
        System.out.println("Liczba playlist: " + mojaBiblioteka.getLiczbaPlaylist());
    }
}
