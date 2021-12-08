// VYBERE NAHODOU CELL Z 2D POLE
//
package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final int SIRKA = 5;
        final int VYSKA = 5;
        System.out.println("ahoj svete!");

        int[][] arr = { { 1, 2, 3, 4, 5 },
                        { 6, 7, 8, 9, 10 },
                        { 11, 12, 13, 14, 15 },
                        { 16, 17, 18, 19, 20 },
                        { 21, 22, 23, 24, 25 } };

        for (int i = 0; i < SIRKA; i++)
            for (int j = 0; j < VYSKA; j++)
                System.out.println("arr[" + i + "][" + j + "] = "
                        + arr[i][j]);

        //generuje random num pro vyber cell
        Random rand = new Random();
        int upperbound = 0;
        if(SIRKA > VYSKA){
            upperbound = SIRKA;
        }
        else if(SIRKA < VYSKA){
            upperbound = VYSKA;
        }
        else {
            upperbound = SIRKA;
        }

        //generate random values
        int random_x = rand.nextInt(upperbound);//+1 protoze generuje upper-1
        int random_y = rand.nextInt(upperbound);

        System.out.println(random_x);
        System.out.println(random_y);
        System.out.println(arr[random_x][random_y]);
    }
}
