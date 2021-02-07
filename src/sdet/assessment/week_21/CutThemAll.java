package sdet.assessment.week_21;

import org.junit.Assert;
import org.junit.Test;

public class CutThemAll {

	@Test
	public void example1() {
		int[] lengths = { 4, 3, 2 };
		int minLen = 7;
		Assert.assertEquals(true, cutThemAll(lengths, minLen));
	}

	@Test
	public void example2() {
		int[] lengths = { 3, 5, 4, 3 };
		int minLen = 9;
		Assert.assertEquals(true, cutThemAll(lengths, minLen));
	}

	@Test
	public void example3() {
		int[] lengths = { 5, 6, 2 };
		int minLen = 12;
		Assert.assertEquals(false, cutThemAll(lengths, minLen));
	}
	
	private boolean cutThemAll(int[] lengths, int minLen) {
		long sum = 0;
		int len = lengths.length;
		for (int i = 0; i < len; i++)
			sum += lengths[i];

		int p1 = 0, p2 = len - 1;
		int cut = len;
		while (p1 != p2) {
			if (lengths[p1] <= lengths[p2])
				sum -= lengths[p1++];
			else if (lengths[p1] > lengths[p2])
				sum -= lengths[p2--];
			cut--;

			if (cut < 2)
				return true;
			if (sum < minLen)
				return false;

		}

		return false;
	}
	
	private boolean cutThemAll1(int[] lengths, int minLen) {
		//long count = 0;
		for (int i = 1; i < lengths.length - 1; i++) {
			if (lengths[i] + lengths[i - 1] >= minLen)
				return true;
		}
		return false;

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

    
//      Complete the 'cutThemAll' function below.
//     
//      The function is expected to return a STRING.
//      The function accepts following parameters:
//       1. LONG_INTEGER_ARRAY lengths
//       2. LONG_INTEGER minLength
     

    public static String cutThemAll(List<Long> lengths, long minLength) {
    // Write your code here
        long sum=0;
        int len=lengths.size();
        for(int i=0;i<len;i++) sum+=lengths.get(i);
        
        int p1=0,p2=len-1;
        int cut=len;
        while(p1!=p2){
            if(lengths.get(p1)<=lengths.get(p2)) sum-=lengths.get(p1++);
            else if (lengths.get(p1)>lengths.get(p2)) sum-=lengths.get(p2--);
            cut--;
            
            if(cut<2) return "Possible";
            if(sum<minLength) return "Impossible";
            
        }
        
        return "Impossible";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int lengthsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> lengths = IntStream.range(0, lengthsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Long::parseLong)
            .collect(toList());

        long minLength = Long.parseLong(bufferedReader.readLine().trim());

        String result = Result.cutThemAll(lengths, minLength);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
*/