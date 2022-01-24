package Solution;

import java.util.*;


public class Mine {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to minesweeper!");

        System.out.print("\nEnter row size: ");
        int row = input.nextInt();

        System.out.print("Enter column size: ");
        int column = input.nextInt();

        MineSweeper game1 = new MineSweeper(row, column);

        game1.run();



    }
}












