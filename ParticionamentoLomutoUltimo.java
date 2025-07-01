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
	System.out.println(Arrays.toString(v));
	    
    }


    public static int particionamentoLomutoUltimo(int[]v, int ini, int fim){
	
	

    }



}

