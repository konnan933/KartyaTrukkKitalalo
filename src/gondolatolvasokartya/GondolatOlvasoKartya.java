package gondolatolvasokartya;

import java.util.Scanner;

public class GondolatOlvasoKartya {

    public static void main(String[] args) {
        foProgram();
    }

    private static void foProgram() {
        Pakli pakli = new Pakli();
        pakli.eredetiKiiras();
        int valasz = valaszBekeres();
        pakli.keveres(valasz);
    }

    private static int valaszBekeres() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Melyik oszlopban lévő kártyára gondolt?( 1 | 2 | 3 )");
        int valasz = scr.nextInt()-1;
        while(valasz != 0 && valasz != 1 && valasz != 2 ){
            System.out.println("Csak 1, 2, és 3 közül válaszhat!");
            valasz = scr.nextInt()-1;
        }
        return valasz;
    }
    
}


