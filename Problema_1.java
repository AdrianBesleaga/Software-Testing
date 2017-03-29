package pentalog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Problema {

	public static void main(String[] args) {
		int input[] = input();
		int n = input[0];
		int k = input[1];
		if(n<37){
			matrice(n,k);
		}else{
			System.out.println("n trebuie sa fie mai mic decat 37");
		}
		

	}

	public static int[] input(){
		int n=0; 
		int k=0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Valoarea lui n: ");
		try{
			n = scanner.nextInt();
			System.out.print("Valoarea lui k: ");
			k = scanner.nextInt();
		}catch(InputMismatchException exception){ // validare int
			System.out.println("Doar numere int");
		}
		scanner.close(); 
		return new int[] {n,k};

	}

	public static void matrice(int n,int k){
		String data[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
		for(int z=0;z<k;z++){
			int x = z * n ; 
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(i+j+x < data.length){
					System.out.print(data[i+j+x] + " ");
					}else{
						if(j==0 && i+j+x-data.length == 0){
							//verificare ultima linie posibila fara repetare
							z=k;
							i=n;
							j=n;
							System.out.println("............");
						}else{
							System.out.print(data[i+j+x-data.length] + " ");
						}
					}
				}
				System.out.println();								
			}
			System.out.println();
		}
	}

}
