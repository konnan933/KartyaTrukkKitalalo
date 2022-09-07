package gondolatolvasokartya;

import java.util.Random;

public class Pakli {

    Random rnd = new Random();
    private final int OSZLOPHOSSZ = 7;
    String[] elsoOszlop = new String[OSZLOPHOSSZ];
    String[] masodikOszlop = new String[OSZLOPHOSSZ];
    String[] harmadikOszlop = new String[OSZLOPHOSSZ];
    String[] segitoOszlopKevereshez = new String[OSZLOPHOSSZ];
    String[][] pakli = {elsoOszlop, masodikOszlop, harmadikOszlop};
    String[][] kevertPakli = new String[3][7];
    String[] felvettKartyak = new String[21];
    String[] valasztottOszlop = new String[7];
    int keveresSzam = 0;
    int i = 0;
    int felvettKartyakIndex = 0;

    public Pakli() {
        pakliLetrehozas();
    }

    public void kiIras(String[][] pakli) {
        for (int j = 0; j < OSZLOPHOSSZ; j++) {
            System.out.printf("|%s| |%s| |%s|", pakli[0][j], pakli[1][j], pakli[2][j]);
            System.out.println("");
        }
    }

    private void pakliLetrehozas() {
        this.felvettKartyak = stringFeltoltes(felvettKartyak);
        while (i != OSZLOPHOSSZ) {
            String[] egySor = new String[3];
            int j = 0;
            while (j != 3) {
                String lap = Kartya.KARTYAK[rnd.nextInt(Kartya.KARTYAK.length)] + Kartya.ERTEKEK[rnd.nextInt(Kartya.ERTEKEK.length)];
                Boolean benne = bennevanE(felvettKartyak, lap);
                if (benne) {
                    oszlopFeltoltes(j, lap);
                    felvettKartyak[felvettKartyakIndex] = lap;
                    egySor[j] = lap;
                    felvettKartyakIndex++;
                    j++;
                }
            }
            i++;
        }
    }

    private void oszlopFeltoltes(int index, String lap) {
        if (index == 0) {
            elsoOszlop[i] = lap;
        } else if (index == 1) {
            masodikOszlop[i] = lap;
        } else {
            harmadikOszlop[i] = lap;
        }
    }

    private static Boolean bennevanE(String[] felvettKartyak, String lap) {
        int i = 0;
        while (i < felvettKartyak.length && !(felvettKartyak[i].equals(lap))) {
            i++;
        }
        return i >= felvettKartyak.length;
    }
    public String melyikKartya(String[] valasztottOszlop) {
        int i = 0;
        while (i < valasztottOszlop.length-1) {
            for (int j = 0; j < this.valasztottOszlop.length-1; j++) {
                if (this.valasztottOszlop[j] == valasztottOszlop[i]) {
                    return this.valasztottOszlop[j];
                }
            }
            i++;
           
        }
         return "Hiba történt";
    }

    private static String[] stringFeltoltes(String[] tomb) {
        for (int i = 0; i < tomb.length; i++) {
            tomb[i] = "";
        }
        return tomb;
    }

    public void elsoValasztott(int valasz) {
        valasztottOszlop = pakli[valasz];
    }

    public String[][] keveres(int oszlopSzam) {
        segitoOszlopKevereshez = pakli[oszlopSzam];
        
        if (keveresSzam == 1 && keveresSzam == 1) {
            pakli = kevertOszlopok(oszlopSzam);
        }else{
            if (oszlopSzam == 0) {
                pakli[0] = pakli[2];
                pakli[2] = pakli[1];
                pakli[1] = segitoOszlopKevereshez;
                
            } else if (oszlopSzam == 2) {
                pakli[0] = pakli[1];
                pakli[2] = pakli[0];
                pakli[1] = segitoOszlopKevereshez;
            } else {
                pakli[2] = pakli[0];
                pakli[0] = pakli[2];
                pakli[1] = segitoOszlopKevereshez;
            }
        }
        keveresSzam++;

        return pakli;

    }
    public String[][] kevertOszlopok(int oszlopSzam){
        String[] masodikUjOszlop = null;
        String[] elsoUjOszlop = null;
        String[] harmadikUjOszlop = null;
        elsoUjOszlop = new String[]{pakli[1][0], pakli[1][3],
                pakli[1][6], pakli[0][2],
                pakli[0][5], pakli[2][1], pakli[2][4]
            };
            masodikUjOszlop = new String[]{pakli[1][1], pakli[1][4],
                pakli[0][0], pakli[0][3],
                pakli[0][6], pakli[2][2], pakli[2][5]
            };
            harmadikUjOszlop = new String[]{pakli[1][2], pakli[1][5],
                pakli[0][1], pakli[0][4],
                pakli[2][0], pakli[2][3], pakli[2][6]
            };
            if (oszlopSzam == 0) {
                pakli[0] = masodikUjOszlop;
                pakli[1] = elsoUjOszlop;
                pakli[2] = harmadikUjOszlop;
            } else if (oszlopSzam == 2) {
                pakli[0] = elsoUjOszlop;
                pakli[1] = harmadikUjOszlop;
                pakli[2] = masodikUjOszlop;
            } else {
                pakli[0] = harmadikUjOszlop;
                pakli[1] = masodikUjOszlop;
                pakli[2] = elsoUjOszlop;
            }
        return pakli;
    }

    public void kevertKiiras(String[][] pakli) {
        int j = 0;
        while (j < 3) {
            for (int k = 0; k < pakli[j].length; k++) {
                System.out.printf("|%s|", pakli[j][k]);
                if (j == 0 && (k == 2 || k == 5)) {
                    System.out.println("");
                } else if ((j == 1 && (k == 1 || k == 4))) {
                    System.out.println("");
                } else if (j == 2 && (k == 0 || k == 3 || k == 6)) {
                    System.out.println("");
                }
            }
            j++;

        }

    }
}
