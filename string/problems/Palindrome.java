package string.problems;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called Palindrome. For example, MOM,DAD,MADAM are
          Palindrome. So write java code to check if a given String is Palindrome or not.
         */
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter a string as an input to check if it is palindrome or not");

        String st= scanner.nextLine();

        if(isPalindrome(st))
        {
            System.out.println(st+" is a palindrome ");
        }
        else
        {
            System.out.println(st+" is not a palindrome ");
        }
    }

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

