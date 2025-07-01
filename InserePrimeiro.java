import java.util.Scanner;
import java.util.Arrays;

public class InserePrimeiro{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");

	int[] v = new int[entrada.length];

	for(int i = 0; i < v.length; i++){
	    v[i] = Integer.parseInt(entrada[i]);
	}

	inserePrimeiro(v);
	System.out.println(Arrays.toString(v));
    }

    
    //recebe array ordenado de forma crescente exceto pelo primeiro elemento
    public static void inserePrimeiro(int[] v){
	int i = 0;
	while(i < v.length - 1 && v[i] > v[i + 1]){
	    int aux = v[i];
	    v[i] = v[i + 1];
	    v[i + 1] = aux;
	    i++;
	}

    }




}
