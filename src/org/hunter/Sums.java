public class Sums {

	public static void main(String [] args) {
		int [] arr = {2, 4};

		System.out.println(rec(arr, 6, arr.length - 1));
//		System.out.println(rec2(arr, 0, 6));
	}

	public static int rec(int [] arr, int total, int i) {
		if (total == 0) {
			return 1;
		}

		if (total < 0) {
			return 0;
		}

		if (i < 0) {
			return 0;
		}


		if (total < arr[i]) {
			return rec(arr, total, i - 1);
		}

		//subsets that include arr[i] + subsets that do not include arr[i]
		return rec(arr, total - arr[i], i - 1) + rec(arr, total, i - 1); 
	}

//	public static int rec2(int [] arr, int i, int total) {
//		int sum = 0;
//		if (arr[i] == total) {
//			sum++;
//			return sum;
//		}
//		if (arr[i] > total) {
//			return sum;
//		}
//		for (int l = 1; l < arr.length; ++l) {
//			for (int )
//
//		}
//
//
//
//	}

}
