import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OddOrEvenRunner {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader readingFile = new FileReader();
		readingFile.readerFunction();

	}

	
}

class FileReader {
	public FileReader() {
	}
	
	public void readerFunction() throws FileNotFoundException {
		Scanner file = new Scanner(new File("/home/student/git/centennialCompSci20172018/OddorEven/src/lab01data.dat"));
		
		int size = file.nextInt();
		file.nextLine();
		
		for (int i=0; i < size; i++) {
			int num = file.nextInt();
			
			if (num % 2 == 0) {
				System.out.println(num + " is even.");
			}
			else if (num % 2 == 1){
				System.out.println(num + " is odd.");
			}
			
		}
		file.close();
		return;
	}
	
}
