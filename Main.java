package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.company.Cell;
import static com.company.Cell.vyberRandomSouseda;

public class Main {

    static final int RADKY = 5;
    static final int SLOUPCE = 5;

    public static void main(String[] args) {

       final List<Cell> grid = new ArrayList<Cell>();//grid aka maze
       List<Cell> currentCells = new ArrayList<Cell>();//doesnt do shit rn

       //fills grid with Cells - all have all 4 walls
       for (int x = 0; x < RADKY; x++) {
           for (int y = 0; y < SLOUPCE; y++) {
               grid.add(new Cell(x, y));
           }
       }

        //generating random coordinates of a cell to choose one
        Random rand = new Random();
        int upperbound = RADKY;//btw starting from 0 - upperbound is 1 smaller

        //generates random values
        int random_radek = rand.nextInt(upperbound);
        int random_sloupec = rand.nextInt(upperbound);

        System.out.println(random_radek);
        System.out.println(random_sloupec);
        System.out.println("souradnice nahodne bunky");

        int remaning = RADKY * SLOUPCE-1;
        List<Integer> neigs = new ArrayList<Integer>();
        Cell current = new Cell(random_radek, random_sloupec);//starting from a random cell
        Cell next; //next cell we're moving to
        int soused[];
        boolean steny[];

        //while (remaning > 0){ //until we're finished
            neigs = current.najdiVsechnySousedy(current); //find all neighs to current cell
            System.out.println(neigs);
            soused = vyberRandomSouseda(neigs);//choose one random available neigh
            next = new Cell(soused[0], soused[1]); //crate next cell with coordinates of random neigh
            System.out.println("nahodna bunka");
            System.out.println("X: "+soused[0]+" Y: "+soused[1]);
            if(!next.isVisited()){
                current.removeWalls(next);//funguje
                remaning = remaning - 1;
                for(int i=0; i < 4; i++){
                    System.out.println(current.walls[i]);
                }
                System.out.println("-----");
                for(int i=0; i < 4; i++){
                    System.out.println(next.walls[i]);
                }
            }
            current = next;
       // }

    }
}
