package ex1;

import java.util.Scanner;

public class Triangular extends Shape{
	Scanner s = new Scanner(System.in);

	public Triangular(int height, int width) {
		super(height, width);
		// TODO Auto-generated constructor stub

	}

	public void calTriangular(int height, int width) {
		getSize();
		calArea();	
	}	


	public void TryprintTriangular(int width, int height) {
		getSize();
		if ((getWidth() % 2) == 0|| (getHeight()*2)<getWidth()) {
			System.out.println("you can't print the triangular");
		}
		else {
			printTriangular();
		}

	}	

	public void printTriangular() {
		int numberOfGrope = width/2-1;
		int LineInGroupe = numberOfGrope == 0 ? height - 2 : (height - 2)/numberOfGrope;
		int lineToAdd = (height - 2)% numberOfGrope;

		printLine(width, 1);

		for (int groupeNumber = 0; groupeNumber < numberOfGrope; ++groupeNumber) {
			for (int groupeIndex = 0; groupeIndex < LineInGroupe +(groupeNumber == 0 ? lineToAdd:0) ; ++groupeIndex) {
				printLine(width, 3 + groupeNumber*2);
			}
		}
		printLine(width, width);
	}

	public static void printChar(char c, int times) {
		for (int i = 0; i < times; i++) {
			System.out.print(c);
		}
	}

	public static void printLine(int width, int length) {
		int space = (width-length)/2;
		printChar(' ', space);
		printChar('*', length);
		System.out.println();
	}


	//get the height and the width of the triangle - it's must be bigger of 2
	public void getSize() {
		do {
			System.out.print("Enter the height of the triangle: ");
			height = s.nextInt();
			setHeight(height);
		} while (height<2);
		while (height>=2) {
			System.out.print("Enter the width of the triangle: ");
			width = s.nextInt();
			setWidth(width);
			break;
		}

	}

	@Override
	//cal the Scope of the triangle
	public void calArea() {
		double rib= Math.sqrt(Math.pow(height, 2)+Math.pow(width/2, 2));
		double area = rib*2+width;
		System.out.println(area);
	}

}
