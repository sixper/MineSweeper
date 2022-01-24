package Solution;

import java.util.Scanner;

public class MineSweeper {

    int row;
    int column;
    int mineCount;
    int left;

    char[][] game;
    int[][] mines;

    MineSweeper(int row, int column){

        this.row = row;
        this.column = column;
        this.mineCount = (this.row * this.column) / 4;
        this.left = (this.row * this.column) - mineCount;

        this.mines = new int[row][column];
        this.game = new char[row][column];

    }

    public void run(){

        Scanner input = new Scanner(System.in);

        setMines();
        init();

        do{

            print();

            System.out.print("Select the row: ");
            int rowSelect = input.nextInt();

            System.out.print("Select the column: ");
            int columnSelect = input.nextInt();

            if(rowSelect < 0 || rowSelect >= this.row || columnSelect < 0 || columnSelect >= this.column){

                System.out.println("Wrong row or select. Please enter valid values");
                continue;
            }

            if(mines[rowSelect][columnSelect] == 0){

                int count = 0;

                for(int i = 0; i < this.row; i++){

                    for(int j = 0; j < this.column; j++){

                        if(mines[i][j] == 1){

                            if(rowSelect >= i - 1 && rowSelect <= i + 1 &&
                               columnSelect >= j - 1 && columnSelect <= j + 1){

                                count++;

                            }

                        }

                    }
                }

                if(count > 0){

                    game[rowSelect][columnSelect] = (char)(count + '0');

                }else
                    game[rowSelect][columnSelect] = '0';

                this.left--;


            }else{

                System.out.println("Game over!!");
                break;

            }

            if(this.left == 0){

                print();
                System.out.println("You win the game !");

            }


        }while (this.left > 0);


    }

    private void init() {

        for(int i = 0; i < this.row; i++){

            for(int j = 0; j < this.column; j++){

                if(mines[i][j] == 0)
                    game[i][j] = '-';
                else
                    game[i][j] = '*';

            }
        }

    }

    public void print(){

        System.out.println("\n===========================");

        for(char[] row : game){

            for(char element : row){

                if(element == '-' || element == '*')
                    System.out.print("- ");
                else
                    System.out.print(element + " ");

            }

            System.out.println();
        }


    }

    public void setMines(){


        while(mineCount > 0){

            int rowMines = (int)(Math.random() * 10) % row;
            int columnMines = (int)(Math.random() * 10) % column;

            if(mines[rowMines][columnMines] == 0){

                mines[rowMines][columnMines] = 1;
                this.mineCount--;

            }

        }


    }
}
