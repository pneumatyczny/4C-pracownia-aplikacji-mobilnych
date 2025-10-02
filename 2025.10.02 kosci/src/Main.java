import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[] graj(int liczbaRzutow){
        int[] rzucanie = new int[liczbaRzutow];
        for (int i = 1; i <= liczbaRzutow; i++) {
            int random = (int)(Math.random() * 6 + 1);
            System.out.println("Kość "+i+"/"+liczbaRzutow+" - "+random);
            rzucanie[i-1] = random;
        }
        return rzucanie;
    }
    public static int licz(int[] rzuty){
        int[] liczone = new int[6];
        for (int i = 1; i <= liczone.length; i++) {
            liczone[i-1] = 0;
        }
        /*
        System.out.println("Rzuty: "+Arrays.toString(rzuty));
        System.out.println("Zera: "+Arrays.toString(liczone));
        */
        for (int i = 1; i <= rzuty.length; i++) {
            int x = rzuty[i-1];
            liczone[x-1]++;
        }
        //System.out.println("Nowe zera: "+Arrays.toString(liczone));
        int suma=0;
        for (int i = 1; i <= liczone.length; i++) {
            if (liczone[i-1] > 1) {
                suma = suma + liczone[i-1]*i;
            }
        }
        return suma;
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Ile kości chcesz rzucić? (3-10)");

        int liczbaRzutow = myObj.nextInt();
        System.out.println("Rzucanie " + liczbaRzutow+" kości...");

        int[] rzut = graj(liczbaRzutow);

        int suma = licz(rzut);
        System.out.println("Suma " + suma);


    }
}
