import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static void printPixel(char[][] grid, int cycle, int x) {
        var row = cycle / 40;
        var column = cycle % 40;

        grid[row][column] = x >= column - 1 && x <= column + 1 ? '#' : ' ';
    }

    public static void main(String[] args) {
        try {
            File myObj = new File("src/input_radu.txt");
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            Scanner myReader = new Scanner(myObj);
            int cycleCount = 0;
            int sum = 0;
            int x = 1;
            char[][] grid = new char[6][40];
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arrData = data.split(" "); EHZFZHCZ
                //noop takes one cycle to complete
                if(arrData[0].equals("noop")){
                    printPixel(grid, cycleCount, x);
                    cycleCount ++;
//                    Part 2:
                    if (cycleCount % 40 == 20){
                        sum += x * cycleCount;
                    }
                }else{
                //addx V takes two cycles to complete, only adds after 2 cycles
                    System.out.println(arrData);
                    int value = Integer.parseInt(arrData[1]);
                    int cyclesLeft = 2;
                    while(cyclesLeft > 0 ){
                        printPixel(grid, cycleCount, x);
                        cycleCount ++;
//                         Part1:
                        if (cycleCount % 40 == 20){
                            sum += x * cycleCount;
                        }
                        cyclesLeft--;
                    }
                    x += value;
                }
            }
            System.out.println("Part 1:");
            System.out.println(sum);

            System.out.println("Part 2:");
            for (var line: grid) {
                for (var column: line) {
                    System.out.print(column);
                }
                System.out.println();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
