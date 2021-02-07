package sdet.assessment.week_21;

import org.junit.Assert;
import org.junit.Test;

public class BalancedArray {

	@Test
	public void example1() {
		int[] arr = { 1, 2, 3, 4, 6 };
		Assert.assertEquals(3, findPivot(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 1, 2, 3, 3 };
		Assert.assertEquals(2, findPivot(arr));
	}

	@Test
	public void example3() {
		int[] arr = { 1, 2, 1 };
		Assert.assertEquals(1, findPivot(arr));
	}

	private int findPivot(int[] arr) {
		int p1 = 0, p2 = arr.length - 1;
		int p1sum = arr[p1++], p2sum = arr[p2--];

		while (p1 != p2) {
			if (p1sum < p2sum)
				p1sum += arr[p1++];
			else if (p1sum > p2sum)
				p2sum += arr[p2--];
			else {
				p1sum += arr[p1++];
				p2sum += arr[p2--];
			}
		}
		return p1;
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

    
//      Complete the 'balancedSum' function below.
//     
//      The function is expected to return an INTEGER.
//      The function accepts INTEGER_ARRAY arr as parameter.
     

    public static int balancedSum(List<Integer> arr) {
    // Write your code here
        int p1=0,p2=arr.size()-1;
        int p1sum=arr.get(p1++),p2sum=arr.get(p2--);
        
        while(p1!=p2){
            if(p1sum<p2sum) p1sum+=arr.get(p1++);
            else if(p1sum>p2sum) p2sum+=arr.get(p2--);
            else{
                p1sum+=arr.get(p1++);
                p2sum+=arr.get(p2--);
            }
        }
        
        return p1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.balancedSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
*/