package string.problems;

import static string.problems.Anagram.areAnagram;

public class UnitTestingStringProblem {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.

        char[] str1 = {'C', 'A', 'T'};
        char[] str2 = {'A', 'C', 'T'};

        if (areAnagram(str1, str2))
            System.out.println(
                    "The two strings are" + " anagram of each other");
        else
            System.out.println(
                    "The two strings are not" + " anagram of each other");
    }

    {

    }
}



