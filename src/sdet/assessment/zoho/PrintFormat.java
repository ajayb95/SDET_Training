package sdet.assessment.zoho;

import org.junit.Test;

/*
Assume that the input will be a word with odd letter count. Print the output as given below.
    
Input : W E L C O M E
Explanation : start with middle letter from first line. Next line two letter from middle . Continue still you print all letters in last line. Then start with the first letter and continue for the remaining letters. 
  
output :  


                     C
                 C O
              C O M
           C O M E
       C O M E W
   C O M E W E
C O M E W E L

Input : W A T E R
Output :

            T
         T E
      T E R
   T E R W
T E R W A
*/

public class PrintFormat {

	@Test
	public void example1() {
		String input = "WELCOME";
		printFormat(input);
	}

	@Test
	public void example2() {
		String input = "WATER";
		printFormat(input);
	}

	@Test
	public void example3() {
		String input = "BALL"; // Assuming to throw an error as problem says input to be in odd length
		printFormat(input);
	}

	@Test
	public void example4() {
		String input = "";
		printFormat(input);
	}

	@Test
	public void example5() {
		String input = "AAAAA";
		printFormat(input);
	}

	private void printFormat(String input) {
		int len = input.length();

		if (len == 0 || len % 2 == 0)
			throw new RuntimeException("Invalid input");

		int mid = len / 2, left = mid - 1, right = mid + 1;

		StringBuilder output = new StringBuilder("  ");

		for (int i = 0; i < len - 1; i++)
			output.append("  ");

		for (int i = 0; i < len; i++) {
			if (i == 0) {
				output.append(input.charAt(mid)).append(" ");
				output.delete(0, 2);
			} else if (right < len) {
				output.append(input.charAt(right++)).append(" ");
				output.delete(0, 2);
			} else {
				output.append(input.charAt(left--)).append(" ");
				output.delete(0, 2);
			}
			System.out.println(output);
		}

	}
}
