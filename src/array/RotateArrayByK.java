package array;
public class RotateArrayByK {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		rotateArrByNIndex(arr, 17);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+" ");
			
		}
	}

	// rotate an array by one time
	private static void rotateArrByOne(int[] arr) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i-1]=arr[i];
			
		}
		arr[arr.length-1]=temp;
	}
	// rotate an array by nth times
	private static void rotateArrByNIndex(int[] arr, int n) {
		if(arr.length<=1) {
			return;
		}
        n=n%arr.length;

		int [] temp = new int[n];
		for(int i =0;i<temp.length;i++) {
			temp[i]=arr[i];
		}
		
		int len = arr.length;
		for(int i =n;i<len;i++) {
			arr[i-n]=arr[i];
		}
		
		for(int i=len-n;i<len;i++) {
			arr[i]=temp[i-(len-n)];
		}
		
		
	}

}
