package sdet.assessment.week_21;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PickingTickets {

	@Test
	public void example1() {
		int[] arr = { 8, 5, 4, 8, 4 };
		Assert.assertEquals(3, findMaxTickets(arr));
	}
	
	@Test
	public void example2() {
		int[] arr = { 4, 13, 2, 3 };
		Assert.assertEquals(3, findMaxTickets(arr));
	}

	private int findMaxTickets(int[] arr) {
		Arrays.sort(arr);

		int maxSize = Integer.MIN_VALUE;
		int size = 1;

		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i + 1] - arr[i] < 2)
				size++;
			else
				size = 1;
			maxSize = Math.max(maxSize, size);
		}

		return maxSize;
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

public class Solution {



    // Complete the maxTickets function below.
    static int maxTickets(List<Integer> tickets) {
        Collections.sort(tickets);
        
        int maxSize=Integer.MIN_VALUE;
        int size=1;
        
        for(int i=0;i<tickets.size()-1;i++){
            if(tickets.get(i+1)-tickets.get(i)<2) size++;
            else size=1;
            maxSize=Math.max(maxSize, size);
        }
        
        return maxSize;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int ticketsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ticketsTemp = new ArrayList<>();

        IntStream.range(0, ticketsCount).forEach(i -> {
            try {
                ticketsTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> tickets = ticketsTemp.stream()
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int res = maxTickets(tickets);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
*/