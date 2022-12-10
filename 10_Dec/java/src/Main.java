import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File myObj = new File("src/input_radu.txt");
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            Scanner myReader = new Scanner(myObj);
            int cycleCount = 0;
            int sum = 0;
            int x = 1;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arrData = data.split(" ");
                //noop takes one cycle to complete
                if(arrData[0].equals("noop")){
                    cycleCount ++;
                    if (cycleCount % 40 == 20){
                        sum += x * cycleCount;
                    }
                }else{
                //addx V takes two cycles to complete, only adds after 2 cycles
                    System.out.println(arrData);
                    int value = Integer.parseInt(arrData[1]);
                    int cyclesLeft = 2;
                    while(cyclesLeft > 0 ){
                        cycleCount ++;
                        if (cycleCount % 40 == 20){
                            sum += x * cycleCount;
                        }
                        cyclesLeft--;
                    }
                    x += value;
                }
            }
            System.out.println(sum);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
