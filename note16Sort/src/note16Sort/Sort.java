package note16Sort;
import java.util.Random;

public class Sort {

	public static void main(String[] args) {
		int[] unsorted = new int[10];
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			unsorted[i] = random.nextInt(10);
		}
		
		
		for (int i = 0; i < unsorted.length; i++) {
			for (int j = i + 1; j < unsorted.length; j++) {
				for (int integer : unsorted) {
					System.out.print(integer + " ");
				}
				if (unsorted[i] > unsorted[j]) {
					int temp = unsorted[j];
					unsorted[j] = unsorted[i];
					unsorted[i] = temp;
				}
				System.out.println();
			}
		}
		for(int integer : unsorted) {
			System.out.print(integer + " ");
		}
	}
	
	public Sort() {
		System.out.println("bleh");
	}

}
