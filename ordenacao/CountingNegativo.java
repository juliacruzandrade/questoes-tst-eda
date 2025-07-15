import java.util.*;

public class CountingNegativo{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");
	int k = sc.nextInt();
	sc.nextLine();
	int menor = sc.nextInt();

	int[] v = new int[entrada.length];
	for(int i = 0; i < v.length; i++) v[i] = Integer.parseInt(entrada[i]);

	countingNegativos(v, k,  menor);


    }

    public static void countingNegativos(int[] v, int k, int menor){
	int[] aux = new int[k + 1 - menor];
	int[] ordenado = new int[v.length];

	//contagem
	for(int i = 0; i < v.length; i++){
	    int indiceAuxiliar = v[i] - menor;
	    aux[indiceAuxiliar]++;
            System.out.println(Arrays.toString(aux));
	}

	//cumulativo
	for(int i = 1; i < aux.length; i++){
	    aux[i] += aux[i - 1];
	}
	System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(aux));

	//ordenando
	for(int i = v.length - 1; i >= 0; i--){
	    int indiceAux = v[i] - menor;
	    int indiceOrdenado = aux[indiceAux] - 1;
	    ordenado[indiceOrdenado] = v[i];
	    aux[indiceAux]--;
	}
       	System.out.println(Arrays.toString(aux));
	
	 
	//copiando ordenado pro array original
	for(int i = 0; i < ordenado.length; i++){
	    v[i] = ordenado[i];
	}

	System.out.println(Arrays.toString(v));

    }

}
