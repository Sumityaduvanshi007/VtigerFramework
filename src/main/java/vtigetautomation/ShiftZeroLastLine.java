package vtigetautomation;

public class ShiftZeroLastLine {

	public static void main(String[] args) {
		int[] ar = { 2, 0, 4, 0, 6, 4};

		int temp = 0;
		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length ; j++) {
				if (ar[i] == 0) {
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]);
		}
	} 

}
