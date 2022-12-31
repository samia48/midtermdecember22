package string.problems;

import java.util.Arrays;

public class Anagram {

    //public static boolean main(String[] args) {
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".

        static boolean areAnagram(char[] str1,char[] str2){

            int n1 = str1.length;
            int n2 = str2.length;

                if (n1 != n2)
                return false;

            Arrays.sort(str1);
            Arrays.sort(str2);

            for (int i = 0; i < n1; i++)
                if (str1[i] != str2[i])
                    return false;

            return true;
        }

    }

