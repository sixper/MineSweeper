package Solution;

import java.util.*;


public class PalindromeChecker {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to palindrome checker!");
        System.out.print("\nPlease enter a string: ");
        String pattern = input.nextLine();


        int i = 0;
        int j = pattern.length() - 1;

        while(i < j){

            if(pattern.charAt(i) != pattern.charAt(j)){

                System.out.println("\"" + pattern + "\"" + " is not a palindrome");
                System.exit(0);
            }

            i++;
            j--;

        }


        System.out.println("\"" + pattern + "\"" + " is a palindrome");

    }
}












