package gondolatolvasokartya;

import java.util.Random;

public class Pakli {

    Random rnd = new Random();

    String[][] pakli = new String[7][3];

    String[] felvettKartyak = new String[21];

    int i = 0;
    int felvettKartyakIndex = 0;

    public Pakli() {
        pakliLetrehozas();
    }

    
    
    
    
    private void pakliLetrehozas(){
        this.felvettKartyak  = feltoltes(felvettKartyak);

    while(i != this.pakli.length){
            String[] egySor = new String[3];
        int j = 0;
        while (j != 3) {
            String lap = Kartya.KARTYAK[rnd.nextInt(Kartya.KARTYAK.length)] + Kartya.ERTEKEK[rnd.nextInt(Kartya.ERTEKEK.length)];
            Boolean benne = bennevanE(felvettKartyak, lap);
            if (benne) {
                felvettKartyak[felvettKartyakIndex] = lap;
                egySor[j] = lap;
                felvettKartyakIndex++;
                j++;
            }

        }
        pakli[i] = egySor;
        i++;
    }
    }
    

    private static Boolean bennevanE(String[] felvettKartyak, String lap) {
        int i = 0;
        while (i < felvettKartyak.length && !(felvettKartyak[i].equals(lap))) {
            i++;
        }
        return i >= felvettKartyak.length;
    }

    private static String[] feltoltes(String[] tomb) {
        for (int i = 0; i < tomb.length; i++) {
            tomb[i] = "";
        }
        return tomb;
    }
}
