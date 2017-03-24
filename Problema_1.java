package pentalog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Problema {

	public static void main(String[] args) {
		int input[] = input();
		int x = input[0];
		int y = input[1];
		if(x+y < 38){
			matrice(x,y);
		}else{
			System.out.println("Valorile sunt prea mari");
		}

	}

	public static int[] input(){
		int x=0; //initializare variabile
		int y=0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Valoarea lui x: ");
		try{
			x = scanner.nextInt();
			System.out.print("Valoarea lui y: ");
			y = scanner.nextInt();
		}catch(InputMismatchException exception){ // validare int
			System.out.println("Doar numere int");
		}
		scanner.close(); // Aici am rezolvat "Resource leak: 'scanner' is never closed" 
		return new int[] {x, y};

	}

	public static void matrice(int x,int y){
		String[][] matrice = new String[x][y];
		String data[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
		
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				matrice[i][j]=data[i+j];
				System.out.print(matrice[i][j] + " ");				
			}
			System.out.println();					
			
		}
		

	}

}
