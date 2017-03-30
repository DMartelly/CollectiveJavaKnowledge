package Fibonacci;

/**
 * @author Dominick Martelly
 */
class Fibonacci {

	/**
	 * Returns the fib number using dynamic programming
	 *
	 * @param x the fib number
	 * @return the fib number at location x
	 */
	static long fib1(int x) {
		if (x < 0)
			throw new IndexOutOfBoundsException("Number must be natural");
		if (x <= 2)
			return 1;

		long[] f = new long[3];
		f[0] = 1;
		f[1] = 1;

		for (int i = 2; i < x; i++) {
			f[2] = f[1] + f[0];
			f[0] = f[1];
			f[1] = f[2];
		}
		return f[2];
	}

	/**
	 * Returns the fib number in O(n^2)
	 *
	 * @param x the fib number
	 * @return the fib number at position x
	 */
	static long fib2(int x) {
		if (x < 0)
			throw new IndexOutOfBoundsException("Number must be natural");
		if (x <= 2)
			return 1;
		return fib2(x - 1) + fib2(x - 2);
	}

	/**
	 * Calculates the nth Fibonacci number in O(log n) time
	 *
	 * @param x which Fibonacci number
	 * @return the nth Fibonacci number
	 */
	static long fib3(int x) {
		if (x < 0)
			throw new IndexOutOfBoundsException("Number must be natural");
		if (x <= 2)
			return 1;

		// Must use 2D array (Pascal's Triangle)
		// **Please note: I did use some help from the Internet to explain how
		// to solve the fib sequence with a O(log(n)) approach**
		long[][] r =
			{
				{
					1, 0
				},
				{
					0, 1
				}
			};
		long[][] save =
			{
				{
					1, 1
				},
				{
					1, 0
				}
			};

		while (x > 0) {
			if (x % 2 == 1) { //If odd
				long a = r[0][0] * save[0][0] + r[0][1] * save[1][0];
			long b = r[0][0] * save[0][1] + r[0][1] * save[1][1];
			long c = r[1][0] * save[0][0] + r[1][1] * save[0][1];
			long d = r[1][0] * save[0][1] + r[1][1] * save[1][1];

			r[0][0] = a;
			r[0][1] = b;
			r[1][0] = c;
			r[1][1] = d;
			}

			x = x / 2;

			long a = save[0][0] * save[0][0] + save[0][1] * save[1][0];
			long b = save[0][0] * save[0][1] + save[0][1] * save[1][1];
			long c = save[1][0] * save[0][0] + save[1][1] * save[0][1];
			long d = save[1][0] * save[0][1] + save[1][1] * save[1][1];

			save[0][0] = a;
			save[0][1] = b;
			save[1][0] = c;
			save[1][1] = d;

		}
		return r[1][0];
	}

}
