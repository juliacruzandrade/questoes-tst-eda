import java.util.*;

public class RadixSortTresDigitos{	
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");
	int tamNums = sc.nextInt();

	int[] v = new int[entrada.length];
	
	for(int i = 0; i < v.length; i++){
	    v[i] = Integer.parseInt(entrada[i]);
	}

	radixSort(v, tamNums);

    }

    public static void radixSort(int[] v, int q){
        int[] ordenado = new int[v.length];	
	//para cada dois dígito (dezena, milhar, etc)
	for(int base = 1; v[0] / base > 0; base *= 100){
	    int[] aux = new int[100];
    
	    //pegar dígitos da vez de cada número, fazer contagem
	    for(int i = 0; i < v.length; i++){
		int d = (v[i] / base) % 100;
		aux[d] += 1;
	    } 


	    //fazer o array cumulativo
	    for(int i = 1; i < aux.length; i++){
		aux[i] += aux[i - 1];
	    }

	    //ordenando pelo dígito
	    for(int i = v.length - 1; i >= 0; i--){
		int d = (v[i] / base) % 100;
		int indiceOrdenado = aux[d] - 1;
		ordenado[indiceOrdenado] = v[i];
		aux[d]--;
	    }   
	   
	    for(int i = 0; i < v.length; i++){
	        v[i] = ordenado[i];
	    }

	    System.out.println(Arrays.toString(v));
    }

   }

}




