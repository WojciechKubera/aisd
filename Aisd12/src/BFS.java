import javafx.util.Pair;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by Wojtek on 2016-05-24.
 */
public class BFS {
    Color[][] image;
    Color nowy;
    Color stary;
    ArrayList<Pair<Integer,Integer>> kolejka = new ArrayList<>();

    public BFS(Color[][] image, int x, int y, Color nowy) {
        this.image = image;
        this.nowy = nowy;
        stary = image[x][y];
        kolejka.add(new Pair<>(x,y));
        while (!kolejka.isEmpty()) {
            Pair<Integer, Integer> u = kolejka.remove(0);
            if (u.getKey() >= 0 && u.getValue() >= 0
                    && u.getKey() < image.length && u.getValue() < image[x].length
                    &&image[u.getKey()][u.getValue()].equals(stary) ) {
                image[u.getKey()][u.getValue()] = nowy;
                kolejka.add(new Pair<>(u.getKey() + 1, u.getValue()));
                kolejka.add(new Pair<>(u.getKey() - 1, u.getValue()));
                kolejka.add(new Pair<>(u.getKey(), u.getValue() + 1));
                kolejka.add(new Pair<>(u.getKey(), u.getValue() - 1));
            }
        }
    }

}