/**
   Represents a sequence of values.
 */
public class Sequence
{
	private int[] values;

	/**
      Construct a sequence of a given size.
      @param size the size to use.
	 */
	public Sequence(int size)
	{
		values = new int[size];
	}

	/**
      Sets a value in the sequence to a new value.
      @param i the position to modify
      @param n the number to use for the new value.
	 */
	public void set(int i, int n)
	{
		values[i] = n;
	}

	/**
      Gets a value from the sequence.
      @param i the position of the value to retrieve
      @return the number at position i.
	 */
	public int get(int i)
	{
		return values[i];
	}

	/**
      Returns the number of elements in the sequence.
      @return the number at position i.
	 */
	public int size()
	{
		return values.length;
	}

	/**
      True if two sequences have the same values in the same order.
      @param other the sequence to compare to this one.
      @return whether the two sequences have the same values
         in the same order.
	 */
	public boolean equals(Sequence other)
	{
		if(values.length != other.values.length) {
			return false;
		}
		for(int i = 0; i < values.length; i++) {
			if(values[i] != other.values[i]) {
				return false;
			}
		}

		return true;
	}


	public static void main(String[] args)
	{
		Sequence first = new Sequence(5);
		Sequence second = new Sequence(5);
		Sequence third = new Sequence(5);

		first.set(0, 1);
		first.set(1, 3);
		first.set(2, 5);
		first.set(3, 7);
		first.set(4, 9);

		second.set(0, 1);
		second.set(1, 4);
		second.set(2, 5);
		second.set(3, 8);
		second.set(4, 9);

		third.set(0, 1);
		third.set(1, 3);
		third.set(2, 5);
		third.set(3, 7);
		third.set(4, 9);

		System.out.println(first.equals(second));
		System.out.println("Expected: false");

		System.out.println(first.equals(third));
		System.out.println("Expected: true");

		{
			int[] a1 = {1, 4, 9};
			int[] a2 = {9, 4, 1};
			int[] a3 = {9, 4, 1};
			int[] a4 = {1, 4, 9, 11};

			Sequence firstx = new Sequence(a1.length);
			Sequence secondx = new Sequence(a2.length);
			Sequence thirdx = new Sequence(a3.length);
			Sequence fourthx = new Sequence(a4.length);

			for (int i = 0; i < 3; i++)
			{
				firstx.set(i, a1[i]);
				secondx.set(i, a2[i]);
				thirdx.set(i, a3[i]);
				fourthx.set(i, a4[i]);
			}
			fourthx.set(3, a4[3]);

			System.out.println(firstx.equals(secondx));
			System.out.println("Expected: false");

			System.out.println(secondx.equals(thirdx));
			System.out.println("Expected: true");

			System.out.println(thirdx.equals(secondx));
			System.out.println("Expected: true");

			System.out.println(firstx.equals(fourthx));
			System.out.println("Expected: false");
		}}

}