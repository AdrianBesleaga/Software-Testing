package pentalog;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Problema {

	public static int x = 10;
	public static int y = 10;
	public static int pas = 0;
	public static boolean stop = false;
	public static int[][] after = null;
	public static int[][] matrice = null;

	public static void main(String[] args) {
		input();			//citire input
		make();				//random labirint
		next();				//procesare
		matrice(after);		//final
	}

	private static void input(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Valoarea lui x: ");
		try{
			x = scanner.nextInt();
			System.out.print("Valoarea lui y: ");
			y = scanner.nextInt();

		}catch(InputMismatchException exception){ // validare int
			System.out.println("Doar numere int");
		}
		scanner.close(); 

	}

	//afisare matrice
	private static void matrice(int[][] matrice){
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(matrice[i][j] < 10){
					System.out.print(matrice[i][j] + "  ");
				}else{
					System.out.print(matrice[i][j] + " ");	
				}		
			}
			System.out.println();
		}											
		System.out.println("----------");
	}

	//Generator labirint folosind random numbers
	private static void make(){
		Random rand = new Random();
		matrice = new int[x][y];
		after = new int [x][y];


		int max = x*y;
		int one = 0;
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				int  n = rand.nextInt(10) + 1;
				if(n > 3 && i%2==1 && one++ < max/2){
					matrice[i][j]=1;
					after[i][j]=1;
				}else{
					matrice[i][j]=0;
					after[i][j]=0;
				};

				System.out.print(matrice[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("----------");
	}

	private static void next(){
		int k =2;
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){			
				check(i,j,k);
			}
		}
	}


	private static boolean check(int i,int j,int k){
		boolean info = false;		

		if(stop == false){
			for(int z=0;z<y;z++){
				if(matrice[x-1][z] > 2){
					stop = true;

					last(x-1,z,matrice[x-1][z]);

					break;
				}
			}
		}				

		if(stop == false){

			try{
				//first
				if(pas == 0 && matrice[i][j]== 0){				
					matrice[i][j]=k;
					k++;
					pas++;
				}

			}catch(Exception e){}

			try{
				//jos
				if(matrice[i+1][j]==0){
					if(matrice[i][j] == k-1 ){
						matrice[i+1][j]=k;						
						pas++;
						info = true;
						check(i+1,j,k+1);
						check(i,j+1,k+1);						
						check(i,j-1,k+1);
						check(i-1,j,k+1);
					}
				}
			}catch(Exception e){}

			try{
				//dreapta
				if(matrice[i][j+1]==0){
					if(matrice[i][j] == k-1 ){
						matrice[i][j+1]=k;						
						pas++;
						info = true;
						check(i+1,j,k+1);
						check(i,j+1,k+1);						
						check(i,j-1,k+1);
						check(i-1,j,k+1);
					}
				}
			}catch(Exception e){}


			try{
				//stanga
				if(matrice[i][j-1]==0){
					if(matrice[i][j] == k-1 ){
						matrice[i][j-1]=k;					
						pas++;
						info = true;
						check(i+1,j,k+1);
						check(i,j+1,k+1);						
						check(i,j-1,k+1);
						check(i-1,j,k+1);
					}
				}
			}catch(Exception e){}	

			try{
				//sus
				if(matrice[i-1][j]==0){
					if(matrice[i][j] == k-1 ){
						matrice[i-1][j]=k;					
						pas++;
						info = true;
						check(i+1,j,k+1);
						check(i,j+1,k+1);						
						check(i,j-1,k+1);
						check(i-1,j,k+1);
					}
				}
			}catch(Exception e){}

		}

		return info;	

	}

	private static void last(int i,int j,int k){



		try{
			//current
			if(matrice[i][j]==k && k>1 && after[i][j]==0){

				after[i][j]=k;
				last(i-1,j,k-1);
				last(i,j-1,k-1);						
				last(i,j+1,k-1);
				last(i+1,j,k-1);

			}
		}catch(Exception e){}

		try{
			//sus
			if(matrice[i-1][j]==k && k>1 && after[i][j]==0){

				after[i-1][j]=k;
				last(i-1,j,k-1);
				last(i,j-1,k-1);						
				last(i,j+1,k-1);
				last(i+1,j,k-1);

			}
		}catch(Exception e){}

		try{
			//stanga
			if(matrice[i][j-1]==k && k>1 && after[i][j]==0){

				after[i][j-1]=k;
				last(i-1,j,k-1);
				last(i,j-1,k-1);						
				last(i,j+1,k-1);
				last(i+1,j,k-1);

			}
		}catch(Exception e){}

		try{
			//dreapta
			if(matrice[i][j+1]==k && k>1 && after[i][j]==0){

				after[i][j+1]=k;
				last(i-1,j,k-1);
				last(i,j-1,k-1);						
				last(i,j+1,k-1);
				last(i+1,j,k-1);

			}
		}catch(Exception e){}


		try{
			//jos
			if(matrice[i+1][j]==k && k>1 && after[i][j]==0 ){

				after[i+1][j]=k;
				last(i-1,j,k-1);
				last(i,j-1,k-1);						
				last(i,j+1,k-1);
				last(i+1,j,k-1);

			}
		}catch(Exception e){}


	}

}





