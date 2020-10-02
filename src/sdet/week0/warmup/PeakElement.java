package sdet.week0.warmup;

public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 20, 15, 2, 23, 90, 67 };

		if (arr[0] > arr[1])
			System.out.println(arr[0]);
		else if (arr[arr.length - 1] > arr[arr.length - 2])
			System.out.println(arr[arr.length - 1]);

		for (int i = 1; i < arr.length - 1; i++)
			if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
				System.out.println(arr[i]);

	}
}
