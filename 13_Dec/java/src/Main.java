import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        try {
            File myObj = new File("src/easy.txt");
            Scanner myReader = new Scanner(myObj);
            char[] right = new char[80];
            char[] left = new char[80];
            int pairCt = 0;
            int sum = 0;
            boolean first  = true;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(!data.equals("")){
                    if (first){
                        left = data.toCharArray();
                        first = false;
                    }else {
                        right = data.toCharArray();
                        first = true;
                    }
                }
                else{
                    pairCt++;
                    int iter_r = 0;
                    int[] r_arr = new int[30];
                    int len_r =0;
                    int iter_l = 0;
                    int[] l_arr = new int[30];
                    int len_l =0;

                    while(iter_l < left.length){
                        while(iter_l < left.length && !Character.isDigit(left[iter_l])){
                            iter_l++;
                        }
                        if(iter_l < left.length){
                            int l = 0;
                            while (iter_l < left.length && Character.isDigit(left[iter_l])){
                                l += Character.getNumericValue(left[iter_l]);
                                iter_l++;
                            }
                            l_arr[len_l] = l;
                            len_l++;
                        }
                    }
//                    for (int k = 0; k < len_l; k++) {
//                        System.out.print(l_arr[k]);
//                    }
//                    System.out.println();

                    while(iter_r < right.length){
                        while(iter_r < right.length && !Character.isDigit(right[iter_r])){
                            iter_r++;
                        }
                        if(iter_r < right.length){
                            int l = 0;
                            while (iter_r < right.length && Character.isDigit(right[iter_r])){
                                l += Character.getNumericValue(right[iter_r]);
                                iter_r++;
                            }
                            r_arr[len_r] = l;
                            len_r++;
                        }
                    }
//                    for (int k = 0; k < len_r; k++) {
//                        System.out.print(r_arr[k]);
//                    }
//                    System.out.println();

                    boolean ok = true;
                    int i = 0, j = 0;
                    boolean eq = false;
                    if(len_r == 0 && len_l == 0 && left.length < right.length){
                        System.out.println("YES");
                        System.out.println(pairCt);
                        sum += pairCt;
                        System.out.println(pairCt);
                        System.out.println(sum);
                    }else if(len_r != 0 && len_l != 0){
                        while (i < len_l && j < len_r && ok) {
                            if (l_arr[i] > r_arr[j]) {
                                ok = false;
                            } else {
                                i++;
                                j++;
                            }
                            eq = l_arr[i] == r_arr[j];
                        }
                        if (ok) {
                            if(i== len_l && j == len_r){
                                System.out.println("YESs");
                                System.out.println(pairCt);
                                sum += pairCt;
                                System.out.println(pairCt);
                                System.out.println(sum);
                            }
                            if (j < len_r) {
                                System.out.println("YESss");
                                System.out.println(pairCt);
                                sum += pairCt;
                                System.out.println(pairCt);
                                System.out.println(sum);
                            }
                            if(!eq && i<len_l ){
                                System.out.println(eq);
                                System.out.println("YESsss");
                                System.out.println(pairCt);
                                sum += pairCt;
                                System.out.println(pairCt);
                                System.out.println(sum);
                            }
                        }
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