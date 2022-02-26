package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import static com.company.Main.RADKY;
import static com.company.Main.SLOUPCE;

public class Cell {

    private int x, y, distance, id;

    private Cell parent;

    private boolean visited = false;

    public boolean[] walls = {true, true, true, true};//top, right, left, down

    public boolean[] getWalls() {
        return walls;
    }

    public void setWalls(boolean[] walls) {
        this.walls = walls;
    }

    //constructor of class - mby to move upwards
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = -1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    //metoda vraci pole se souradnicemi sousedu dane bunky
    public ArrayList<Integer> najdiVsechnySousedy(Cell current) {//prejmenovat x a y na radek a soupec !?
        int radekCopy = current.getX();
        int sloupecCopy = current.getY();
        int i=0;
        //int[] sousedi;//az 4 sousedi; kazdy ma souX a souY
        ArrayList<Integer> Sousedi = new ArrayList<Integer>();
        if(jeNaKraji(current.getX(), current.getY()) == 0){ //neni na kraji - je "uprosted" //funguje
            System.out.println("TEST!");
            //sousedi = new int[8];//az 4 sousedi; kazdy ma souX a souY
            //horni soused
            Sousedi.add(radekCopy-1);
            Sousedi.add(sloupecCopy);

            //pravy soused
            Sousedi.add(radekCopy);
            Sousedi.add(sloupecCopy+1);

            //dolni soused
            Sousedi.add(radekCopy+1);
            Sousedi.add(sloupecCopy);

            //levy soused
            Sousedi.add(radekCopy);
            Sousedi.add(sloupecCopy-1);
        }
        else if(je_v_rohu(current.getX(), current.getY()) == 1) { //LH
            //pravy soused
            Sousedi.add(radekCopy);
            Sousedi.add(sloupecCopy+1);
            //dolni soused
            Sousedi.add(radekCopy+1);
            Sousedi.add(sloupecCopy);
        }
        else if(je_v_rohu(current.getX(), current.getY()) == 2) { //PH //funguje
            //levy soused
            Sousedi.add(radekCopy);
            Sousedi.add(sloupecCopy-1);
            //dolni soused
            Sousedi.add(radekCopy+1);
            Sousedi.add(sloupecCopy);
        }
        else if(je_v_rohu(current.getX(), current.getY()) == 3) { //LD
            //horni soused
            Sousedi.add(radekCopy-1);
            Sousedi.add(sloupecCopy);
            //pravy soused
            Sousedi.add(radekCopy);
            Sousedi.add(sloupecCopy+1);
        }
        else if(je_v_rohu(current.getX(), current.getY()) == 4) { //PD
            //horni soused
            Sousedi.add(radekCopy-1);
            Sousedi.add(sloupecCopy);
            //levy soused
            Sousedi.add(radekCopy+1);
            Sousedi.add(sloupecCopy);
        }
        else if(jeNaKraji(current.getX(), current.getY()) == 1){ //je v prvnim radku //funguje
            //horni soused
            //Sousedi.add(radekCopy-1);
            //Sousedi.add(sloupecCopy);
            System.out.println("prvni radek");
            //pravy soused
            Sousedi.add(radekCopy);
            Sousedi.add(sloupecCopy+1);

            //dolni soused
            Sousedi.add(radekCopy+1);
            Sousedi.add(sloupecCopy);

            //levy soused
            Sousedi.add(radekCopy);
            Sousedi.add(sloupecCopy-1);
        }
        else if(jeNaKraji(current.getX(), current.getY()) == 2){//je v poslednim radeku //funguje
            System.out.println("posledni radek");
            //horni soused
            Sousedi.add(radekCopy-1);
            Sousedi.add(sloupecCopy);

            //pravy soused
            Sousedi.add(radekCopy);
            Sousedi.add(sloupecCopy+1);

            //dolni soused
            //Sousedi.add(radekCopy+1);
            //Sousedi.add(sloupecCopy);

            //levy soused
            Sousedi.add(radekCopy);
            Sousedi.add(sloupecCopy-1);
        }
        else if(jeNaKraji(current.getX(), current.getY()) == 3){ //v 1. sloupci //funguje

            //horni soused
            Sousedi.add(radekCopy-1);
            Sousedi.add(sloupecCopy);

            //pravy soused
            Sousedi.add(radekCopy);
            Sousedi.add(sloupecCopy+1);

            //dolni soused
            Sousedi.add(radekCopy+1);
            Sousedi.add(sloupecCopy);

            //levy soused
            //Sousedi.add(radekCopy);
            //Sousedi.add(sloupecCopy-1);
        }
        else if(jeNaKraji(current.getX(), current.getY()) == 4) { //posledni sloupec //fumguje

            //horni soused
            Sousedi.add(radekCopy-1);
            Sousedi.add(sloupecCopy);

            //pravy soused
            //Sousedi.add(radekCopy);
            //Sousedi.add(sloupecCopy+1);

            //dolni soused
            Sousedi.add(radekCopy+1);
            Sousedi.add(sloupecCopy);

            //levy soused
            Sousedi.add(radekCopy);
            Sousedi.add(sloupecCopy-1);
        }
        return Sousedi;
    }

    //dostane souradnice bunky
    //kdyz je v 1. radku vrati 1
    //kdyz je v v poslednim radku vrati 2
    //kdyz je v 1. sloupci vrati 3
    //kdyz je v poslednim sloupci vrati 4
    //kdyz neni na kraji vraci 0
    public static int jeNaKraji(int radek, int sloupec){
        if(radek == 0){// 1. radek
            return 1;
        }
        else if(radek == RADKY-1){// poseldni radek
            return 2;
        }
        else if(sloupec == 0){// 1. sloupec
            return 3;
        }
        else if(sloupec == SLOUPCE-1){// posledni sloupec
            return 4;
        }
        else {
            return  0;
        }
    }

    //dostane souradnice cell jako argument
    //kdyz je v LH rohu vraci 1
    //kdyz je v PH rohu vraci 2
    //kdyz je v LD rohu vraci 3
    //kdyz je v PD rohu vraci 4
    //kdyz neni v zadny rohu vraci 0
    //TODO otestovat ze to spravne vraci ze vsech rohu
    public static int je_v_rohu(int x, int y){
        if((x == 0) && (y == 0)){// LH roh
            return 1;
        }
        else if((x == 0) && (y == SLOUPCE-1)){// PH roh
            return 2;
        }
        else if((x == RADKY-1) && (y == 0)){// LD roh
            return 3;
        }
        else if((x == RADKY-1) && (y == SLOUPCE-1)){// PD roh
            return 4;
        }
        else {
            return 0;
        }
    }

    public static int[] vyberRandomSouseda(List<Integer> sousedi){
        //vyber random sude cislo
        int[] soused = new int[2];//souradnice 1 nahodneho souseda
        Random rand = new Random();
        int hranice = sousedi.size()-1;
        System.out.println("hranice= "+hranice);
        int ran_cislo = rand.nextInt(hranice);
        if( (ran_cislo % 2) != 0) { //neni sude cislo
            ran_cislo++;//ted je sude
        }
        System.out.print("sude cislo= ");
        System.out.println(ran_cislo);
        //if(ran_cislo != 666) {
        soused[0] = sousedi.get(ran_cislo);
        soused[1] = sousedi.get(ran_cislo+1);
        //}

        return soused;

    }

    public void removeWalls(Cell next) {
        int i = this.x - next.x;
        if(i == 1){//jdu nahoru
            walls[0] = false; //horni stena pryc
            next.walls[3] = false; //dolni strana pryc
        }
        else if(i == -1){//jdu dolu
            walls[3] = false; //spodni strana pryc
            next.walls[0] = false; //horni strana pryc
        }

        int j = this.y - next.y;
        if(j == -1){// jdu doprava
            walls[1] = false; //prava stena pryc
            next.walls[2] = false; //leva stena pryc
        }
        else if(j == 1){//jdu doleva
            walls[2] = false; //leva strana pryc
            next.walls[1] = false; //prava strana pryc
        }
    }
}