
public class Quiz {

	public static void main(String[] args) {
		int x = -2;
		while(x<9) {
			x++;
			System.out.print(x + " ");
		}
		System.out.println("\n");
		int m = 1, total = 0;
		while(m<9) {
			total = total + m;
			m++;
		}
		System.out.print(total);
		System.out.println("\n");
		
		int b = 3;
		String list = " ";
		while(b<10) {
			b = b+2;
			if (b%2 == 1) {
				list = b+" "+list;
			}
		System.out.print(list);
		}

	}

}
