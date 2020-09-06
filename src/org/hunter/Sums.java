public class Sums {

	public static void main(String [] args) {
		int [] arr = {2, 4};

		System.out.println(rec(arr, 6, arr.length - 1));
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

}
