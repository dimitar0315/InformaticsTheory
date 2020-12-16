package files;

import javax.swing.JOptionPane;

public class Folder extends FileSystemObject{
	private FileSystemObject[] files;
	private int size;
	private int index;
	
	public Folder(String nameValue, FileSystemObject[] filesValue) {
		super(nameValue);
		this.files = filesValue;
		this.size = this.files.length;
		for(int i = 0; i < this.files.length; i++) {
			if(this.files[i] != null)
				this.index++;
		}
	}
	
	public Folder() {
		super();
		this.files = new FileSystemObject[50];
		this.index = 0;
		this.size = 50;
	}
	
	
	public int getIndex()
	{
		return index;
	}
	
	public FileSystemObject[] getFiles()
	{
		return this.files;
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 0; i < files.length; i++) {
			sum += files[i].getSize();
		}
		
		return sum;
	}
	
	public void add(FileSystemObject o) {
		for(FileSystemObject a: files) {
			if(a.getName().equals(o.getName())) {
				JOptionPane.showMessageDialog(null, "A File With This Name Already Esists", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
		if(this.index == this.size - 1) 
		{
			FileSystemObject[] filesCopy = new FileSystemObject[this.size + 1];
			for(int i = 0; i < this.size; i++) {
				filesCopy[i] = this.files[i];
			}
			this.files = filesCopy;
		}
		this.files[index - 1] = o;
		this.index++;
	}

}
