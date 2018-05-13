import java.util.Scanner;

/**
 * Created by Wojtek on 2016-04-26.
 */
public class Test {

    public static void main(String[] args) {

        // Find the node with key 75

      //  System.out.println("\nNode with the key 75");

      //  System.out.println(theTree.findNode(75));

        Scanner sc = new Scanner(System.in);
        System.out.print ("Podaj wyrażenie infiksowe: " );

        // pobieramy od użytkownika wyrażenie
        String wyrazenie = sc.nextLine();

        // tworzymy nowy obiekt klasy OdwrotnaNotacjaPolska
        // i przekazujemy do konstruktora pobrane od użytkownika wyrażenie
        InfixtoPostfix onp = new InfixtoPostfix(wyrazenie);


        // wyświetlamy wyrażenie w postaci postfiksowej
        String wyrazeniePostfiksowe = onp.toString();
        System.out.println ("Wyrażenie postfiksowe: " + wyrazeniePostfiksowe);
       // theTree.addNode(wyrazenie);

      Tree tree = new Tree();
        tree.createTree(wyrazeniePostfiksowe);
        System.out.println("Wezły: " + tree.size(tree.root));
        System.out.println("Liscie: "+tree.leaf(tree.root));
        System.out.println("Wysokosc: "+tree.height(tree.root));
        System.out.println("Wynik: "+tree.oblicz(tree.root));
        tree.inOrderTraverseTree(tree.root);
    }
}
