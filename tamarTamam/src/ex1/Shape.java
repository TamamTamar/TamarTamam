package ex1;


public abstract class Shape {

	protected int height;
	protected int width;
	
	
	public Shape(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(int height) {	
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}
	
	public abstract void calArea();
	
	


}
