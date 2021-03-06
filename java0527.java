import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

class Calculator {
    public Calculator() {
    }

    // Sum of A n B
    public ArrayList<Integer> intersection(int[] A, int[] B) {


        ArrayList<Integer> integerA = new ArrayList<>(A.length);
        ArrayList<Integer> integerB = new ArrayList<>(B.length);
        int i;


        for (i = 0; i < A.length; i++)
            integerA.add(A[i]);

        for (i = 0; i < B.length; i++)
            integerB.add(B[i]);
        integerA.retainAll(integerB);

        return integerA;


    }

    // Sum of A - B
    public ArrayList<Integer> differenceOfSet(int[] A, int[] B) {

        ArrayList<Integer> integerA = new ArrayList<>(A.length);
        ArrayList<Integer> integerB = new ArrayList<>(B.length);
        int i;


        for (i = 0; i < A.length; i++)
            integerA.add(A[i]);

        for (i = 0; i < B.length; i++)
            integerB.add(B[i]);
        integerA.removeAll(integerB);

        return integerA;
    }
}

class Minesweeper {
    public static int MAP_X = 10;
    public static int MAP_Y = 10;
    private int[][] map;
    private int numOfpick;

    public Minesweeper(int[][] map) {
        this.map = map;
        this.numOfpick = 0;
    }

    public int pick(int x, int y) {
        int numOfMine = 0;
        // todo
        return numOfMine;
    }

    public int getNumOfpick() {
        return numOfpick;
    }

    public boolean checkMap() {
        // todo
        return false;
    }

    public void printMap() {
        for (int i = 0; i < MAP_X; i++) {
            for (int j = 0; j < MAP_Y; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("intersection = " + calculator.intersection(new int[]{1, 2, 4, 11, 6, 7, 5, 14, 19, 16}, new int[]{2, 9, 8, 4, 11, 19, 15, 12}));
        System.out.println("differenceOfSet = " + calculator.differenceOfSet(new int[]{1, 2, 4, 11, 6, 7, 5, 14, 19, 16}, new int[]{2, 9, 8, 4, 11, 19, 15, 12}));

        int[][] map = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}
        };

        Minesweeper minesweeper = new Minesweeper(map);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Minesweeper start!!!");
        System.out.println("----------------------------------------------------");
        minesweeper.printMap();
        while (minesweeper.checkMap()) {
            System.out.print("x(0~9) : ");
            int x = scanner.nextInt();
            System.out.print("y(0~9) : ");
            int y = scanner.nextInt();

            if (x >= minesweeper.MAP_X || y >= minesweeper.MAP_Y || x < 0 || y < 0) break;

            int numOfMine = minesweeper.pick(Minesweeper.MAP_Y - y - 1, x);
            if (numOfMine == -1) {
                System.out.println("Mine has exploded!!!");
                break;
            } else {
                System.out.println("There's a mine around : " + numOfMine);
                minesweeper.printMap();
            }
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Number of Attempts : " + minesweeper.getNumOfpick());
        System.out.println("Minesweeper end!!!");
    }
}
