import java.awt.*;

/**
 * Created by Wojtek on 2016-05-24.
 */
public class DFS {
    Color [][] image;
    Color nowy;
    Color stary;

    public DFS(Color [][] image, int x,int y ,Color nowy ){
        this.image = image;
        this.nowy = nowy;
        stary = image [x][y];
        DFS_V(x, y);


    }

    private void DFS_V(int x, int y){
        if(x>=0 && y>=0 && x<image.length && y<image[x].length){
            if(image[x][y].equals(stary)){
                image[x][y]= nowy;
                DFS_V( x+1, y);
                DFS_V( x-1, y);
                DFS_V( x, y+1);
                DFS_V( x, y-1);
            }
        }

    }

}
