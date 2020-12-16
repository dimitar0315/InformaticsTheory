package files;

public class File extends FileSystemObject {
	private int size;

	public File() {
		super();
		this.size = 0;
	}

	public File(String nameValue, int sizeValue) {
		super(nameValue);
		if (sizeValue >= 0) {
			this.size = sizeValue;
		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

}
