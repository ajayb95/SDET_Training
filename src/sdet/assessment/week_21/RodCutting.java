package sdet.assessment.week_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class RodCutting {

	@Test
	public void example1() {
		int[] lengths = { 1, 1, 3, 4 };
		System.out.println(rodCutting(lengths));
	}

	@Test
	public void example2() {
		int[] lengths = { 5, 4, 4, 2, 2, 8 };
		System.out.println(rodCutting(lengths));
	}

	@Test
	public void example3() {
		int[] lengths = { 1, 2, 3, 4, 3, 3, 2, 1 };
		System.out.println(rodCutting(lengths));
	}

	private List<Integer> rodCutting(int[] lengths) {
		List<Integer> input = Arrays.stream(lengths).boxed().collect(Collectors.toList());
		List<Integer> output = new ArrayList<>();
		while (!input.isEmpty()) {
			output.add(input.size());
			int min = Collections.min(input);
			while (input.remove((Integer) min))
				;
		}

		return output;
	}
}


/*
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    
//      Complete the 'rodOffcut' function below.
//     
//      The function is expected to return an INTEGER_ARRAY.
//      The function accepts INTEGER_ARRAY lengths as parameter.
     

    public static List<Integer> rodOffcut(List<Integer> lengths) {
    // Write your code here
        List<Integer> output=new ArrayList<>();
        while(!lengths.isEmpty()){
            output.add(lengths.size());
            int min=Collections.min(lengths);
            while(lengths.remove((Integer)min));
        }
        
        return output;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int lengthsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> lengths = IntStream.range(0, lengthsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.rodOffcut(lengths);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
*/
