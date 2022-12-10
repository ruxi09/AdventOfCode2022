import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Position{
    private int  x;
    private int  y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Main {
    public static int getDist(Position t, Position h){
        if (Math.abs(t.getX()-h.getX()) == Math.abs(t.getY() - h.getY())){
            return 1;
        }
        if(Math.abs(t.getX()-h.getX()) == 1 || Math.abs(t.getY()-h.getY()) == 1)
            return 1;
        if(t.getY() == h.getY())
            return 2;
        if(t.getX() == h.getX())
            return 3;
        return -1;

    }

    public static void main(String[] args) {
        try {
            File myObj = new File("src/easy.txt");
            Scanner myReader = new Scanner(myObj);
            Set<Position> tailPositions = new HashSet<>();
            Map<Character, Position> directions =  new HashMap<>();
            directions.put('U', new Position(-1, 0));
            directions.put('D', new Position(1, 0));
            directions.put('L', new Position(0, -1));
            directions.put('R', new Position(0, 1));

            Position t = new Position(0,0);
            Position h = new Position(0,0);
            tailPositions.add(h);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                String[] arrData = data.split(" ");
                char d = arrData[0].charAt(0);
                int p = Integer.parseInt(arrData[1]);
                while(p > 0){
                    Position dp = directions.get(d);
                    h.setX(h.getX() + dp.getX());
                    h.setY(h.getY() + dp.getY());
                    int dist = getDist(t,h);
                    switch (dist){
                        case 2:
                            if(t.getY() < h.getY()){
                                t.setY(t.getY() - 1);
                            } else{
                                t.setY(t.getY() + 1);
                            }
                        case 3:
                            if(t.getX() < h.getX()){
                                t.setX(t.getX() - 1);
                            } else{
                                t.setY(t.getX() + 1);
                            }
                    }
                    System.out.println(h.getX());
                    System.out.println(h.getY());
                    System.out.println(t.getX());
                    System.out.println(t.getY());
                    System.out.println("---------------------");
                    tailPositions.add(t);
                    p--;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}