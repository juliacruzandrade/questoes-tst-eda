import java.util.Scanner;
import java.util.Arrays;

public class InsertionSortRecursivo{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");

	int[] v = new int[entrada.length];

	for(int i = 0; i < v.length; i++){
	    v[i] = Integer.parseInt(entrada[i]);
	}

	insertionSortRecursivo(v, 0, v.length - 1);
    }

    public static void insertionSortRecursivo(int[] v, int ini, int fim){
	if(ini >= fim) return;

	//ordena todos os elementos que não o último
	insertionSortRecursivo(v, ini, fim - 1);
	

	//inserção ordenada do último
	int i = fim;
	while(i > 0 && v[i] < v[i - 1]){
	    int aux = v[i];
	    v[i] = v[i - 1];
	    v[i - 1] = aux;
	    i--;
	}
	
	System.out.println(Arrays.toString(v));

    }


}
