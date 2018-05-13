import java.util.Scanner;

/**
 * Created by Wojtek on 2016-04-05.
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
    }

    public class MacierzInteger extends Lista<Integer> {
        MacierzInteger() {
            setTestSubject(0);
        }

        @Override
        Integer sum(Integer a, Integer b) {
            return  a + b;
        }
    }


    Main() {
        MacierzInteger macierzA = new MacierzInteger();
        MacierzInteger macierzB = new MacierzInteger();

        Scanner scanner = new Scanner(System.in);
        int w = 0;
        int k = 0;

        boolean goodInput = false;
        while (!goodInput) {
            System.out.println("Wpisz rozmiary macierzy: w x k");
            if (scanner.hasNextInt()) {
                w = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    k = scanner.nextInt();
                    goodInput = true;
                }
            }
        }

        Integer[][][] macierze = new Integer[2][w][k];

        for (int h = 0; h < 2; h++) {
            System.out.println("Macierz nr: " + h);
            for (int i = 0; i < w; i++) {
                System.out.println("Wiersz nr: " + i);
                for (int j = 0; j < k; j++) {
                    System.out.println(""+i+"-"+j+": ");
                    if (scanner.hasNextInt()) {
                        macierze[h][i][j] = scanner.nextInt();
                    } else {
                        j--;
                    }
                }
            }
        }

        macierzA.Load(macierze[0]);
        macierzB.Load(macierze[1]);

        System.out.println("Macierz A");
        // Wyswietlanie macierzy A
        Object[][] backTab = macierzA.toArray();
        int wiersze = backTab.length;
        int kolumny = (wiersze != 0? backTab[0].length : 0);
        for (int  i = 0; i < wiersze ; i++) {
            for (int j = 0; j < kolumny; j++) {
                System.out.printf("%d ", (Integer)backTab[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Macierz B");
        // Wyswietlanie macierzy B
        backTab = macierzB.toArray();
        for (int  i = 0; i < wiersze ; i++) {
            for (int j = 0; j < kolumny; j++) {
                System.out.printf("%d ", (Integer)backTab[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        macierzA.dodawanie(macierzB);

        System.out.println("Macierz A+B");
        // Wyswietlanie macierzy A+B
        backTab = macierzA.toArray();
        for (int  i = 0; i < wiersze ; i++) {
            for (int j = 0; j < kolumny; j++) {
                System.out.printf("%d ", (Integer)backTab[i][j]);
            }
            System.out.println();
        }




    }
}
