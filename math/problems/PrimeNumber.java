package math.problems;

public class PrimeNumber {

	public static void main(String[] args) {
		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */
		{
			int i = 0;
			int N = 0;

			String primeNumbers = "";

			for (i = 1; i <= 100; i++) {
				int counter = 0;
				for (N = i; N >= 1; N--) {
					if (i % N == 0) {
						counter = counter + 1;
					}
				}
				if (counter == 2) {

					primeNumbers = primeNumbers + i + " ";
				}
			}
			System.out.println("Prime numbers from 1 to 100 are :");
			System.out.println(primeNumbers);

		}
	}
}
	
