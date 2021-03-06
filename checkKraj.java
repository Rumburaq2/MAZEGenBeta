package com.company;
import java.util.Random;

public class Main {
    static final int SIRKA = 5;
    static final int VYSKA = 5;

    public static void main(String[] args) {
	// write your code here
        //final int SIRKA = 5;
        //final int VYSKA = 5;
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

        System.out.println();
        System.out.println();
        System.out.println(random_x);
        System.out.println(random_y);
        System.out.println("hodnota na bunce x y = "+arr[random_x][random_y]);
        //System.out.println(arr[random_x][random_y]);
        System.out.println(je_na_kraji(random_x, random_y));
    }

    //dostane souradnice bunky
    //kdyz je v 1. radku vrati 1
    //kdyz je v v poslednim radku vrati 2
    //kdyz je v 1. sloupci vrati 3
    //kdyz je v poslednim sloupci vrati 4
    //kdyz neni na kraji vraci 0
    public static int je_na_kraji(int x, int y){
        if(x == 0){// 1. radek
            return 1;
        }
        else if(x == VYSKA-1){// poseldni radek
            return 2;
        }
        else if(y == SIRKA-1){// posledni sloupec
            return 4;
        }
        else if(y == 0){// 1. sloupec
            return 3;
        }
        else {
            return  0;
        }

    }
}
