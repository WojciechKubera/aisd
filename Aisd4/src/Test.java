import java.util.Scanner;


public class Test {
     public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj wyrażenie : ");

        String wyrazenie = sc.nextLine();

        InfixtoPostfix onp = new InfixtoPostfix(wyrazenie);
         System.out.println ("Wyrażenie postfiksowe: " + onp);
         System.out.println("Wynik : " + onp.wylicz());
    }
}
