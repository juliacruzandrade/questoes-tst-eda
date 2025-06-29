import java.util.Scanner;

public class QuickSortPassoAPasso{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
	
	String[] entrada = sc.nextLine().split(" ");

	int[] v = new int[entrada.length];

	for(int i = 0; i < v.length; i++){
	    v[i] = Integer.parseInt(entrada[i]);
	}

	quickSort(v, 0, v.length - 1);

    }


    public static void quickSort(int[] v, int ini, int fim){
	if(ini >= fim) return;

	int index_pivo = particionamentoLomuto(v, ini, fim);
	System.out.println(formataArray(v));

	quickSort(v, ini, index_pivo - 1);
	quickSort(v, index_pivo + 1, fim);
    }
    
    public static int particionamentoLomuto(int[] v, int ini, int fim){
	int pivo = v[ini];
	int i = ini;
	
	for(int j = ini + 1; j <= fim; j++){
	    if(v[j] <= pivo){
	        i++;
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	    }
	}

	v[ini] = v[i];
	v[i] = pivo;	  
	
	
	//retorna a posição do pivô
    	return i;

    }

    public static String formataArray(int[] v){
	String saida = ""; 
	saida += v[0];
	for(int i = 1; i < v.length; i++){
	    saida += " " + v[i];
	}
	return saida;
    }


}
