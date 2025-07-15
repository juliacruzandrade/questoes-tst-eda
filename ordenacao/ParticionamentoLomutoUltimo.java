import java.util.*;

public class ParticionamentoLomutoUltimo{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);

	String[] entrada = sc.nextLine().split(" ");

	int[] v = new int[entrada.length];

	for(int i = 0; i < v.length; i++){
	    v[i] = Integer.parseInt(entrada[i]);
	}

	particionamentoLomutoUltimo(v, 0, v.length - 1);
	    
    }


    public static int particionamentoLomutoUltimo(int[]v, int ini, int fim){
	int pivot = v[fim];
	int i = fim;
	for(int j = i - 1; j >= ini; j--){
	    if(v[j] > pivot){
	        i--;
		swap(v, i, j);	
		System.out.println(Arrays.toString(v));

	    }	

	}

	swap(v, fim, i);
	System.out.println(Arrays.toString(v));
	System.out.println(Arrays.toString(v));

	return i;	
    }

    public static void swap(int[] v, int a, int b){
	int aux = v[a];
	v[a] = v[b];
	v[b] = aux;
    }



}

