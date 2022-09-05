package gondolatolvasokartya;

public class GondolatOlvasoKartya {

    public static void main(String[] args) {

        foProgram();

    }

    private static void foProgram() {
        kiiras();
    }

    private static void kiiras() {
        Pakli pakli = new Pakli();
        for (int j = 0; j < pakli.elsoOszlop.length; j++) {
            System.out.printf("|%s| |%s| |%s|", pakli.elsoOszlop[j], pakli.masodikOszlop[j], pakli.harmadikOszlop[j]);
            System.out.println("");
        }
    }
}


