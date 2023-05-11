package ex1;

import java.util.Scanner;

public class Menu {
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int height = 0; 
		int width = 0;

		OptionMenu();
		int option= s.nextInt();

		while (option >= 1 && option<3) {
			switch (option) {
			case 1:
				System.out.println("You have selected Square building");

				Rectangle Rectangle = new Rectangle(height, width);
				Rectangle.calRectangle(height, width);
				break;
			case 2:
				System.out.println("You have selected triangular building");
				System.out.println("Please select an option:");
				System.out.println("1.Calculate the perimeter of the triangle");
				System.out.println("2. print the triangle");
				int subOption = s.nextInt();

				//Triangular menu
				switch (subOption) {
				case 1:
					Triangular triangular = new Triangular(height, width);
					triangular.calTriangular(height, width);
					break;
				case 2:
					Triangular tri = new Triangular(height, width);
					tri.TryprintTriangular(width, height);
					break;
				}	
			}
			OptionMenu();
			option = s.nextInt();
		}
			
		s.close();
		System.out.println("Exiting program...");
	}
	//main menu
	public static void OptionMenu() {
		System.out.println("Please select an option:");
		System.out.println("1. Square building");
		System.out.println("2. triangular building");
		System.out.println("3. Exit");
	}
}