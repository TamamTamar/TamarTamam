package ex1;

import java.util.Scanner;

public class Rectangle extends Shape{
	Scanner s = new Scanner(System.in);

	public Rectangle(int height, int width) {
		super(height, width);
		// TODO Auto-generated constructor stub
	}
	public void calRectangle(int height,int width) {
		do {
			//get the height and the width of the square - it's must be bigger of 2
			System.out.print("Enter the height of the square: ");
			height = s.nextInt();
			setHeight(height);
		} while (height<2);

		while (height>=2) {
			System.out.print("Enter the width of the square: ");
			width = s.nextInt();
			setWidth(width);
			
			//cal the arae of the square
			if (height == width) {
				calArea();
			}
			//cal the arae of the Rectangle
			else if ((width-height)>5) {
				calArea();
			}
			//cal the scope of the Rectangle
			else if ((width-height)<5) {

				System.out.println(calRectangleScope(height, width));
			}

			break;
		}
	}
	public static int calRectangleScope(int height, int width) {
		int area = (height + width)*2;
		return area;
	}


	@Override
	public void calArea() {
		int arae = this.height * this.width;
		System.out.println(arae);

	}
}
