import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Wczytaj {

    public static void main(String[] args) {
      Wczytaj wczytaj = new Wczytaj();

    }
    Color[][] image;

    public Wczytaj() {
        File input = new File("G:\\aa.ppm");
        File output = new File("G:\\output.ppm");

        try{Scanner in = new Scanner((input));
            DataOutputStream out = new DataOutputStream(new FileOutputStream(output));
            OutputStreamWriter writer = new OutputStreamWriter(out);
             in.nextLine();

            int w=in.nextInt(); //System.out.println("width="+w);
            int h=in.nextInt(); //System.out.println("height="+h);
            in.nextLine();
            in.nextLine();
            image = new Color [w][h];
            for(int i=0; i<w*h; i++){
                int r=in.nextInt(); //System.out.println("red="r);
                int g=in.nextInt(); //System.out.println("green="g);
                int b=in.nextInt(); //System.out.println("blue="b);

            image [i%w][i/w] = new Color( r,  g, b);

            }
            in.close();
            //DFS dfs = new DFS(image,0,0,new Color(255,0,0));
            BFS bfs = new BFS(image,2,2,new Color(38, 183, 255));
            writer.write("P3\n");
            writer.write(String.format("%d %d\n255\n",w,h ));
            for(int i=0; i<w*h; i++) {
                Color tmp  = image[i%w][i/w];
                writer.write(String.format("%d %d %d ",tmp.getRed(),tmp.getGreen(),tmp.getBlue()));
            }
            writer.close();
        } catch (IOException ex) { System.err.println(ex); }

    }

}
