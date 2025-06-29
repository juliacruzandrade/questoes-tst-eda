import java.util.Scanner;

public class MergeSortPassoAPasso{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");

	int[] v = new int[entrada.length];

	for(int i = 0; i < v.length; i++){
	    v[i] = Integer.parseInt(entrada[i]);
	}

	mergeSort(v, 0, v.length - 1);

    }

    public static void mergeSort(int[]v, int ini, int fim){
	System.out.println(retornaArrayFormatado(v, ini, fim));

	if(ini >= fim) return;

	int meio = (ini + fim) / 2;

	mergeSort(v, ini, meio);

	mergeSort(v, meio + 1, fim);

	merge(v, ini, fim);

	System.out.println(retornaArrayFormatado(v, ini, fim));


    }
    
    
    public static void merge(int[] v, int ini, int fim){
	int meio = (ini + fim)/ 2;

	int i = ini;
	int j = meio + 1;
	int[] saida = new int[v.length];
   	int k = ini;

	while(i <= meio && j <= fim){
	    if(v[i] <= v[j]){
	        saida[k++] = v[i++];
	    }else{
		saida[k++] = v[j++];
	    }
	}

	while(i <= meio){
	    saida[k++] = v[i++];
	}

	while(j <= fim){
	    saida[k++] = v[j++];
	}

	for(int x = ini; x <= fim; x++){
	    v[x] = saida[x];
	}

	
	
    }

    public static String retornaArrayFormatado(int[] v, int ini, int fim){
        String saida = "[" + v[ini];
	
	for(int i = ini + 1; i <= fim; i++){
	    saida +=  ", " + v[i];
	}
    	saida += "]";
	return saida;
    }


}
