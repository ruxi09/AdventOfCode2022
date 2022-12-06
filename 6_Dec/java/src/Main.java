import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            File myObj = new File("src/input_radu.txt");
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                Queue<Character> group = new LinkedList<>();
                for (int i = 0; i < data.length(); i++) {
                    if (group.size() == 14){
//                        System.out.println(group);
//                        System.out.println(group.stream().distinct().count() );
                        if (group.stream().distinct().count() == 14){
                            System.out.println(i);
                            break;
                        }
                        group.poll();
                        group.add(data.charAt(i));
                    }
                    else{
                        group.add(data.charAt(i));
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}