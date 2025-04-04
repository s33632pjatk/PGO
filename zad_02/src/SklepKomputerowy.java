public class SklepKomputerowy {
    public class SklepKomputerowy {
        private Produkt[] produkty = new Produkt[10];
        private Klient[] klienci = new Klient[10];
        private Zamowienie[] zamowienia = new Zamowienie[10];
        private int liczbaProduktow;
        private int liczbaKlientow;
        private int liczbaZamowien;


        public void dodajKlienta(Klient klient1) {
            if (liczbaKlientow < klienci.length) {
                klienci[liczbaKlientow++] = klient;
                System.out.println("Dodano klienta: " + klient.getImie() + " " + klient.getNazwisko());
            } else {
                System.out.println("Brak miejsca na nowego klienta.");
            }
        }

        public Zamowienie utworzZamowienie(
                Klient klient1,
                Produkt[] produktyZamowienia1,
                int[] ilosciZamowienia1) {

            Zamowienie zamowienie = new Zamowienie();
            zamowienie.setKlient(klient1);
            zamowienie.setProdukty(produktyZamowienia1);
            zamowienie.setIlosci(ilosciZamowienia1);
            zamowienie.setId(0);
            zamowienie.setStatus("Nowe");

            return zamowienie;
        }

        public void dodajProdukt(Produkt produkt1) {
            if (liczbaProduktow < produkty.length) {
                produkty[liczbaProduktow++] = produkt;
                System.out.println("Dodano produkt: " + produkt.getNazwa());
            } else {
                System.out.println("Brak miejsca na nowy produkt.");
            }

        }
        public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
            Produkt[] zamProdukty = zamowienie.getProdukty();
            int[] zamIlosci = zamowienie.getIlosci();

            for (int i = 0; i < zamProdukty.length; i++) {
                Produkt produktZam = zamProdukty[i];
                int iloscZam = zamIlosci[i];

                for (int j = 0; j < liczbaProduktow; j++) {
                    if (produkty[j] == produktZam) {
                        int stan = produkty[j].getIloscWSklepie();
                        produkty[j].setIloscWSklepie(stan - iloscZam);
                    }
                }
            }

            System.out.println("Zaktualizowano stan magazynowy.");
        }
        public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
            for (int i = 0; i < liczbaZamowien; i++) {
                if (zamowienia[i].getId() == idZamowienia) {
                    zamowienia[i].setStatus(nowyStatus);
                    System.out.println("Zmieniono status zamówienia ID: " + idZamowienia + " na " + nowyStatus);
                    return;
                }
            }
            System.out.println("Nie znaleziono zamówienia o ID: " + idZamowienia);
        }
        public void wyswietlProduktyWKategorii(String kategoria) {
            System.out.println("Produkty w kategorii: " + kategoria);
            for (int i = 0; i < liczbaProduktow; i++) {
                if (produkty[i].getKategoria().equalsIgnoreCase(kategoria)) {
                    System.out.println("- " + produkty[i].getNazwa() + " (" + produkty[i].getCena() + " zł)");
                }
            }
        }
        public void wyswietlZamowieniaKlienta(int idKlienta) {
            System.out.println("Zamówienia klienta o ID: " + idKlienta);
            for (int i = 0; i < liczbaZamowien; i++) {
                if (zamowienia[i].getKlient().getId() == idKlienta) {
                    zamowienia[i].wyswietlSzczegoly();
                    System.out.println("-----");
                }
            }
        }
    }
}
