package files;

public class Test {

	public static void main(String[] args) {
		File file1 = new File("Parks.txt", 20);
		File file2 = new File("Gardents.txt", 30);
		File file3 = new File("Reservations.txt", 60);
		FileSystemObject[] files = {file1, file2, file3};
		Folder folder = new Folder("Green files", files);
		
		int folderSize = folder.getSize();
		System.out.println(folderSize);
		
		File file4 = new File("Forests.txt", 40);
		folder.add(file4);
	}

}
