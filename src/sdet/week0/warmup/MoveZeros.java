package sdet.week0.warmup;

public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr={1, 2, 0, 4, 3, 0, 5, 0};
		
		int cnt=0;
		
		for(int i=0;i<arr.length;i++)
			if(arr[i]!=0)
				arr[cnt++]=arr[i];
		
		while(cnt<arr.length)
			arr[cnt++]=0;
		
		for(int a:arr)
			System.out.print(a+" ");
	}

}
