package pentalog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Problema {

	public static int k;
	public static double n[] = {0,2,4.3,12,14,34,78,12,13,12.3,19,87,76,100,200,15,300,34,13,99.9,22.1};

	public static void main(String[] args) {
		input();
		sum();
	}

	public static void input(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Valoarea lui k: ");
		try{
			k = scanner.nextInt();
		}catch(InputMismatchException exception){
			System.out.println("Doar numere int");
		}
		scanner.close(); 

	}

	public static void sum(){
		double sum = 0;
		int start = 0;
		int end = 0;
		double current = 0;
		
		for(int i=0;i<n.length-k;i++){
				current = 0;
			for(int j=0;j<k;j++){
				
				current += n[i+j];
				
				if(current > sum && j == k-1){
					sum = current;
					start = i;
					end = i+j;
				}
			}

		}
		
		double small = 0;
		double big = 0;
		
		if(n[start] > n[end]){
			big = n[start];
			small = n[end];
		}else{
			big = n[end];
			small = n[start];
		}
		
		for(int i=start;i<=end;i++){
			if(n[i] > big){
				big = n[i];
			}
			if(n[i] < small){
				small = n[i];
			}
			
		}
		System.out.println("Intre " + n[start] + " si " + n[end]);
		System.out.println("Intarval " + small + " - " + big);
		System.out.println("Suma " + sum);

	}

}
