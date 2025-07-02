import java.util.*;

public class EstatisticaDeOrdem{

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");

	int[] v = new int[entrada.length];

	for(int i = 0; i < v.length; i++) v[i] = Integer.parseInt(entrada[i]);

	System.out.println(particionaHoare(v) + 1);
    }
	
	
    public static int particionaHoare(int[] v){
	int pivot = v[0];
	int i = 1;
	int j = v.length - 1;

	while(i <= j){
	    while(i <= j && v[i] <= pivot){i++;}
	    while(i <= j && v[j] >= pivot){j--;}

	    if(i < j){
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	    }
	}

	int aux = v[j];
	v[j] = pivot;
	v[0] = aux;

	return j;
    }

}
