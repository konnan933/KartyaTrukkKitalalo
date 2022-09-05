package gondolatolvasokartya;

import java.util.Random;

public class Pakli {

    Random rnd = new Random();
    private final int OSZLOPHOSSZ = 7;
    String[] elsoOszlop = new String[OSZLOPHOSSZ];
    String[] masodikOszlop = new String[OSZLOPHOSSZ];
    String[] harmadikOszlop = new String[OSZLOPHOSSZ];
    String[][] pakli = {elsoOszlop,masodikOszlop,harmadikOszlop};
    String[][] kevertPakli = new String[3][7];
    String[] felvettKartyak = new String[21];

    int i = 0;
    int felvettKartyakIndex = 0;

    public Pakli() {
        pakliLetrehozas();
    }

    public void eredetiKiiras() {    
        for (int j = 0; j < OSZLOPHOSSZ; j++) {
            System.out.printf("|%s| |%s| |%s|" ,elsoOszlop[j], masodikOszlop[j], harmadikOszlop[j]);
            System.out.println("");
        }
    }

    private void pakliLetrehozas() {
        this.felvettKartyak = feltoltes(felvettKartyak);
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

    private static String[] feltoltes(String[] tomb) {
        for (int i = 0; i < tomb.length; i++) {
            tomb[i] = "";
        }
        return tomb;
    }
    public void keveres(int oszlopSzam){
//        String[] valasztottOszlop = pakli[oszlopSzam];
//        String[] elsoUjOszlop = pakli[pakli.length-oszlopSzam];
//        String[] utolsoUjOszlop = pakli[pakli.length-1-(pakli.length-oszlopSzam)];
            //Ki akartam matekozni de nem sikerült :(

        String[] elsoUjOszlop = null;
        String[] valasztottOszlop = null;
        String[] utolsoUjOszlop = null;
        
        if (oszlopSzam == 0) {
            elsoUjOszlop = pakli[1];
            valasztottOszlop = pakli[0];
            utolsoUjOszlop = pakli[2];
        } else if(oszlopSzam == 2) {
            elsoUjOszlop = pakli[1];
            valasztottOszlop = pakli[2];
            utolsoUjOszlop = pakli[0];
            
        }else{
            elsoUjOszlop = pakli[0];
            valasztottOszlop = pakli[1];
            utolsoUjOszlop = pakli[2];
        }
        for (int j = 0; j < OSZLOPHOSSZ; j++) {
            System.out.printf("|%s| |%s| |%s|" ,elsoUjOszlop[j], valasztottOszlop[j], utolsoUjOszlop[j]);
            System.out.println("");
        }
    }
}
