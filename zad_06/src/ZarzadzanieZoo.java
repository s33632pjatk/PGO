abstract class Zwierze {
    protected String nazwa;
    protected int wiek;

    public Zwierze(String nazwa, int wiek) {
        this.nazwa = nazwa;
        this.wiek = wiek;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getWiek() {
        return wiek;
    }

    public void wyswietlInformacje() {
        System.out.println("Zwierze: " + nazwa + ", Wiek: " + wiek);
    }

    public abstract String wydajDzwiek();
    public abstract String poruszajSie();
    public abstract String srodowiskoNaturalne();
}

class Lew extends Ssak {
    private String typGrzywy;

    public Lew(String nazwa, int wiek, String typGrzywy) {
        super(nazwa, wiek);
        this.typGrzywy = typGrzywy;
    }

    public String getTypGrzywy() {
        return typGrzywy;
    }

    public String wydajDzwiek() {
        return "Roooar";
    }

    public String poruszajSie() {
        return "Lew biegnie";
    }

    public String srodowiskoNaturalne() {
        return "Sawanna";
    }
}

class Orzel extends Ptak {
    private double rozpietoscSkrzydel;

    public Orzel(String nazwa, int wiek, double rozpietoscSkrzydel) {
        super(nazwa, wiek);
        this.rozpietoscSkrzydel = rozpietoscSkrzydel;
    }

    public double getRozpietoscSkrzydel() {
        return rozpietoscSkrzydel;
    }

    public String wydajDzwiek() {
        return "Kraa";
    }

    public String poruszajSie() {
        return "Orzel leci";
    }

    public String srodowiskoNaturalne() {
        return "Góry i lasy";
    }
}

class Waz extends Gad {
    private boolean jadowity;

    public Waz(String nazwa, int wiek, boolean jadowity) {
        super(nazwa, wiek);
        this.jadowity = jadowity;
    }

    public boolean isJadowity() {
        return jadowity;
    }

    public String wydajDzwiek() {
        return "Ssssss";
    }

    public String poruszajSie() {
        return "Waz pelznie";
    }

    public String srodowiskoNaturalne() {
        return "Dzungla";
    }
}

abstract class Ssak extends Zwierze {
    public Ssak(String nazwa, int wiek) {
        super(nazwa, wiek);
    }
}

abstract class Ptak extends Zwierze {
    public Ptak(String nazwa, int wiek) {
        super(nazwa, wiek);
    }
}

abstract class Gad extends Zwierze {
    public Gad(String nazwa, int wiek) {
        super(nazwa, wiek);
    }
}

public class ZarzadzanieZoo {
    public static void main(String[] args) {
        Zwierze lew = new Lew("Lew", 5, "Gesta");
        Zwierze orzel = new Orzel("Orzel", 3, 2.0);
        Zwierze waz = new Waz("Waz", 2, true);

        Zwierze[] zwierzeta = {lew, orzel, waz};

        for (Zwierze z : zwierzeta) {
            z.wyswietlInformacje();
            System.out.println("Dzwiek: " + z.wydajDzwiek());
            System.out.println("Ruch: " + z.poruszajSie());
            System.out.println("Srodowisko: " + z.srodowiskoNaturalne());
            System.out.println();
        }
    }
}
