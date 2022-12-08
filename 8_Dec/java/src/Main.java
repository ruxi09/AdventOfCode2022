import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static boolean check(int i, int j, int dim){
        return i > 0 && j > 0 && i < dim && j < dim;
    }
    public static boolean visit(boolean[][] is_visible, int[][] map,int i, int j, int dim){
        if(is_visible[i][j]){
            return true;
        }

        if (check(i-1,j, dim)) {
            is_visible[i - 1][j] = visit(is_visible, map, i - 1, j, dim);
            boolean up = is_visible[i - 1][j] && (map[i][j] > map[i - 1][j]);
            if (up) {
                return true;
            }
        }

        if (check(i+1,j, dim)) {
            is_visible[i + 1][j] = visit(is_visible, map, i + 1, j, dim);
            boolean down = is_visible[i + 1][j] && (map[i][j] > map[i + 1][j]);
            if (down) {
                return true;
            }
        }

        if (check(i,j-1, dim)) {
            is_visible[i][j - 1] = visit(is_visible, map, i, j - 1, dim);
            boolean left = is_visible[i][j - 1] && (map[i][j] > map[i][j - 1]);
            if (left) {
                return true;
            }
        }

        if (check(i,j+1, dim)) {
            is_visible[i][j + 1] = visit(is_visible, map, i, j + 1, dim);
            boolean right = is_visible[i][j + 1] && (map[i][j] > map[i][j + 1]);
            if (right) {
                return true;
            }
        }

        return false;
    }

    public static boolean[][] v(boolean[][] is_visible, int[][] map, int dim){
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                is_visible[i][j] = visit(is_visible,map,i,j, dim);
            }
        }
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(is_visible[i][j]);
            }
            System.out.println(" ");
        }
        return is_visible;
    }

    public static int visit(int dim,int[][] map){
        int[] dx = { 0,0,-1,1};
        int[] dy = { 1,-1,0,0};
        int visible_counter = 0;

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                int x = i;
                int y = j;
                for (int k = 0; k < dx.length; k++) {
                    while (check(x,y,dim)){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(check(nx,ny,dim) == false){
                            visible_counter += 1;
                            break;
                        }
//                        else if(map[nx][ny] > map[x,y]){
//
//                        }
                        x = nx;
                        y = ny;
                    }
                }
            }
        }
        return visible_counter;
    }

    public static void main(String[] args) {
        try {
            File myObj = new File("src/easy.txt");
//            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            Scanner myReader = new Scanner(myObj);
            int dim = 5;
            int [][] map = new int[dim][dim];
            int line = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (int j = 0; j < dim; j++) {
                    map[line][j] = Integer.parseInt(String.valueOf(data.charAt(j)));
                }
                line += 1;
            }
//            boolean [][] isVisible = new boolean[dim][dim];
//            for (int f = 0; f < dim; f++) {
//                isVisible[f][0] = true;
//                isVisible[0][f] = true;
//                isVisible[f][dim - 1] = true;
//                isVisible[dim - 1][f] = true;
//            }
//            isVisible = v(isVisible,map, dim);
            System.out.println(visit(dim,map));
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}