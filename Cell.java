package com.example.rocnikovakafx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Cell {

    public static final int W = 20;//sirka bunky pro kresleni

    private int x, y;//souradnice bunky

    private boolean visited = false;

    public boolean[] walls = {true, true, true, true};//top, right, left, down

    public boolean[] getWalls() {
        return walls;
    }

    //constructor of class
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * odstrani stenu mezi dvema bunkami - podle pozice nasi a sousedni bunky zjistí, kterým jdeme směrem,
     * potom odstraní příslušné "dotýkající" se stěny.
     * @param next Cell next
     */
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


    public void draw(GraphicsContext gc){
        int x2 = this.y * W;//W = sirka bunky v px
        int y2 = this.x * W;

        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
        //gc.strokeLine();

       // Line line = new Line();

        //g.setColor(Color.BLACK);
        if (walls[0]) {//horní
           // g.drawLine(x2, y2, x2+W, y2);
            /*
            line.setStartX(x2);
            line.setEndX(y2);
            line.setStartY(x2+W);
            line.setEndY(y2);

             */

            gc.strokeLine(x2, y2, x2+W, y2);
        }
        if (walls[1]) {//pravá
            //g.drawLine(x2+W, y2, x2+W, y2+W);
            /*
            line.setStartX(x2+W);
            line.setEndX(y2);
            line.setStartY(x2+W);
            line.setEndY(y2+W);

             */
            gc.strokeLine(x2+W, y2, x2+W, y2+W);
        }
        if (walls[2]) { //Levá
            //g.drawLine(x2, y2+W, x2, y2);
            /*
            line.setStartX(x2);
            line.setEndX(y2+W);
            line.setStartY(x2);
            line.setEndY(y2);

             */
            gc.strokeLine(x2, y2+W, x2, y2);
        }
        if (walls[3]) { //dolní
            //g.drawLine(x2+W, y2+W, x2, y2+W);
            /*
            line.setStartX(x2+W);
            line.setEndX(y2+W);
            line.setStartY(x2);
            line.setEndY(y2+W);

             */
            gc.strokeLine(x2+W, y2+W, x2, y2+W);
        }
    }
}