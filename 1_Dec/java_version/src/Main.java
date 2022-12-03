import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            int curr_quantity = 0;
            ArrayList<Integer> l = new ArrayList<>(2248);
            for (int i = 0; i < 2248; i++)  {
                String data = myReader.nextLine();
                if(data.equals("\n")){
                    l.add(curr_quantity);
                    curr_quantity = 0;
                }else{
                    curr_quantity += Integer.parseInt(data);
                }
            }
            Collection.sort(l);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}