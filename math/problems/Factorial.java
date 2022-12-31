package math.problems;

public class Factorial {

    //public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */
        static int Factorial(int n){
            if (n == 0)
                return 1;
            else
                return(n * Factorial(n-1));
        }
        public static void main(String[] args){

                int fact=1;
                int number=5;
                fact = Factorial(number);
                System.out.println("Factorial of "+number+" is: "+fact);
            }
        }




