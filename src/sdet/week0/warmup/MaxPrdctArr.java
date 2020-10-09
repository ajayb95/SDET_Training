package sdet.week0.warmup;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class MaxPrdctArr {

	public static void main(String[] args) {
		
		int[] arr= {-10,-3,5,-6,-2};
		Map<String, Integer> map=new LinkedHashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int prdct=arr[i]*arr[j];
				String val1 = String.valueOf(arr[i]);
				String val2=String.valueOf(arr[j]);
				map.put(val1+","+val2, prdct);
			}
		}
		
		Entry<String, Integer> entry = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("The maximum product formed by ("+entry.getKey()+")");
		
	}

}
