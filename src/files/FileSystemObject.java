package files;

public abstract class FileSystemObject {
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String nameValue) {
		if(nameValue != null && !nameValue.isEmpty()) {
			this.name = nameValue;
		}
	}
	
	public abstract int getSize();
	
	public FileSystemObject() {
		this.name = "File";
	}
	
	public FileSystemObject(String nameValue) {
		this.setName(nameValue);
	}
}
