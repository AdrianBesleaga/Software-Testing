package pentalog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Problema {

	public static void main(String[] args) {
		int x = input();
		matrice(x,x);
	}

	public static int input(){
		int x=0; //initializare variabile
		Scanner scanner = new Scanner(System.in);
		System.out.print("Valoarea lui x: ");
		try{
			x = scanner.nextInt();

		}catch(InputMismatchException exception){ // validare int
			System.out.println("Doar numere int");
		}
		scanner.close(); // Aici am rezolvat "Resource leak: 'scanner' is never closed" 
		return x;

	}

	public static void matrice(int x,int y){
		int[][] matrice = new int[x][y];

		for(int i=0;i<x;i++){
			for(int j=0;j<i;j++){
				//Spatiu la stanga pentru un triunghi /\ frumos :)
				String space = "  ";
				StringBuilder s = new StringBuilder();
				for(int count = 0; count < x-i; count++) {
					s.append(space);
				}
				String output = s.toString();
				//End triunghi frumos 
				if(j==0){
					matrice[i][j]= 1;
					System.out.print(output + matrice[i][j] + "  ");	
				}else{
					matrice[i][j]=matrice[i-1][j]+matrice[i-1][j-1];
					if(matrice[i][j] < 10){
						System.out.print(" " + matrice[i][j] + "  ");
					}else{
						System.out.print(matrice[i][j] + "  ");
					}
				}
			}
			System.out.println();					

		}


	}

}
