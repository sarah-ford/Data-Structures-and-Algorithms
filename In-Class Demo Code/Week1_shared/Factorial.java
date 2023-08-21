public class Factorial
{
	public static void main(String[] args)
	{
		int i = Integer.parseInt(args[0]);
		System.out.println( i + "! is " + factorial(i));

	}

	public static int factorial(int n)
	{	int result = 1;
		for(int i = 2; i <= n; i++) {
			result = result * i;

		}
		return result;
	}
}
