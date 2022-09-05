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
        for (int j = 0; j < pakli.pakli.length; j++) {
            for (int k = 0; k < pakli.pakli[j].length; k++) {
                System.out.print("|"+pakli.pakli[j][k]+"|");
            }
            System.out.println("");
            
        }
    }

    
    
    
    
}
