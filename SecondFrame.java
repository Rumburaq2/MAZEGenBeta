import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class SecondFrame extends JFrame{
    private JFrame f = new JFrame("Second");

    static int RADKY = MyLogin.getSizeI();
    static int SLOUPCE = MyLogin.getSizeJ();

    Cell[][] Maze = new Cell[RADKY+1][SLOUPCE+1];

    public SecondFrame() {
        setTitle("Aldous-broderův algoritmus pro generování uniformních stromů v praxi");
        setSize(640, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SecondFrame view = new SecondFrame();
            }
        });
    }


    @Override //awt funkce myslim btw
    public void paint(Graphics g){//vygeneruje bludiste a nakreslí ho na obrazovku
        super.paint(g);
        g.translate(50, 50);//dava vystup trochu od kraje
        Maze = mazeGen();//btw rad bych presunul tohle mimo paint() ale pak bych to musel nechavat jako argument a nevim jak
        Cell current;
        //paint
        for (int z = 0; z <= RADKY; z++) {
            for (int p = 0; p <= SLOUPCE; p++) {
                current = Maze[z][p];
                current.draw(g);
            }
        }
    }


    /**
     * vybere nahodneho souseda dane bunky v poli
     * @param x souradnice x nasi bunky
     * @param y souradnice y nasi bunky
     * @return dvouprvkové pole se souradnicí x a y souseda
     */
    public static int[] vyberRandSouseda(int x, int y) {
        int[] smery = {0, 1, 2, 3}; //nahoru, doprava, doleva, dolu

        Random ran = new Random();
        int smer = ran.nextInt(4);
        int Nx = x;
        int Ny = y;

        if(smer == 0){//nahoru
            Nx = x - 1;
        }
        else if(smer == 1){ //doprava
            Ny = y + 1;
        }
        else if(smer == 2) {//dolu
            Nx = x + 1;
        }
        else if(smer == 3){//doleva
            Ny = y - 1;
        }
        int[]pole = {Nx, Ny};
        return pole;
    }

    public static Cell[][] mazeGen() {

        Cell[][] maze = new Cell[RADKY+1][SLOUPCE+1];

        //vygeneruj maze ig
        //fills grid with Cells - all have all 4 walls
        for (int x = 0; x <= RADKY; x++) {
            for (int y = 0; y <= SLOUPCE; y++) {
                maze[x][y] = new Cell(x, y);
            }
        }

        Cell current;//mozna presunout
        Cell next;

        //generating random coordinates of a cell to choose one
        Random rand = new Random();
        int upperbound = RADKY-1;//btw starting from 0 - upperbound is 1 smaller

        //generates random values
        int random_radek = rand.nextInt(upperbound);
        int random_sloupec = rand.nextInt(upperbound);


        current = maze[random_radek][random_sloupec];//nahodna bunka
        current.setVisited(true);
        next = maze[random_radek][random_sloupec];

        int remaning = (RADKY+1)*(SLOUPCE+1)-1;//RADKY*SLOUPCE-1;//(radky+1)*(sloupce+1)-1
        int[]policko;
        int x = current.getX();
        int y = current.getY();
        int Nx = 0;
        int Ny = 0;
        int u=0;

        while(remaning > 0){//dokud neporjdeme celej maze
            x = current.getX();
            y = current.getY();
            policko = vyberRandSouseda(x, y);//vraci souradnice noveho souseda
            Nx = policko[0];//nove souradnice od bunky na x, y
            Ny = policko[1];
            if( (Nx >= 0) && (Ny >= 0) && (Nx <= RADKY) && (Ny <= SLOUPCE)){//souradnice se fitujou do maze
                next = maze[Nx][Ny];
                if(next.isVisited() == false){
                    current.removeWalls(next);
                    u++;
                    remaning = remaning - 1;
                    next.setVisited(true);
                }
                current = next;
                System.out.println(remaning);
            }
        }
        maze[0][0].walls[0] = false;//start a konec ig
        maze[RADKY][SLOUPCE].walls[3] = false;

        return maze;
    }
}