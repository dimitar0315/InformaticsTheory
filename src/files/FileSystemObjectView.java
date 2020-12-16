package files;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

import files.File;
import files.FileSystemObject;
import files.Folder;

public class FileSystemObjectView  extends JComponent{
	
	private FileSystemObject object;
	private int StringParametersX;
	private int StringParametersY;
	private Rectangle borderLine;
	private int fileSquare;
	
	
	
	public FileSystemObjectView(FileSystemObject object, int stringParameterX, int stringParameterY, Rectangle borderLine, int fileSquare)
	{
		if(object != null)
		{
			this.object = object;
		}
		
		this.StringParametersX = stringParameterX;
		this.StringParametersY = stringParameterY;
		this.fileSquare = fileSquare;
		
		
		if(borderLine !=null)
		{
			this.setBounds(borderLine);
			this.borderLine = borderLine;
		}
	}
	
	
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D)graphics;
		g.setColor(Color.black);
		g.draw(this.borderLine);
		if(this.object.getClass().equals(Folder.class))
		{
			this.drawFolder(graphics, (Folder)this.object);
		}
		else
		{
			this.drawFile(graphics, (File)this.object);
		}
		
	}


	public void drawFile(Graphics graphics, File object) {
		// TODO Auto-generated method stub
		
		super.paintComponent(graphics);
		Graphics2D fileFigure = (Graphics2D)graphics;
		fileFigure.setColor(Color.BLACK);
		fileFigure.fill(borderLine);
		fileFigure.setColor(Color.YELLOW);
		String objectInformation = String.format("%s %d", this.object.getName(), object.getSize()); 
		fileFigure.drawString(objectInformation, (int)StringParametersX, (int)StringParametersY);
	}


	public void drawFolder(Graphics graphics, Folder object) {
		// TODO Auto-generated method stub
		
		super.paintComponent(graphics);
		Graphics2D folderFigure = (Graphics2D)graphics;
		folderFigure.setColor(Color.orange);
		folderFigure.fill(borderLine);
		folderFigure.setColor(Color.yellow);
		String objectInformation = String.format("%s %d", this.object.getName(), this.object.getSize());
		folderFigure.drawString(objectInformation,StringParametersX , StringParametersY);
		
		for(int i = 0; i < object.getIndex(); i++)
		{
			this.borderLine.setBounds(0,(int)this.borderLine.getBounds().getY() + 150,150,150);
			if(object.getFiles()[i].getClass().equals(Folder.class))
			{
				this.drawFolder(graphics, (Folder)object.getFiles()[i]);
				StringParametersX = StringParametersX + fileSquare;
			}
			else if(object.getFiles()[i].getClass().equals(File.class))
			{
				this.drawFile(graphics, (File)object.getFiles()[i]);
				StringParametersY = StringParametersY + fileSquare;
			}
		}
		
	}
	
	
}
