import java.util.*;

public class SelectionSortPassoAPasso{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");

	int[] v = new int[entrada.length];

	for(int i = 0; i < v.length; i++){
	    v[i] = Integer.parseInt(entrada[i]);
	}

	selectionSort(v);
    }


    public static void selectionSort(int[] v){
	
	for(int j = 0; j < v.length; j++){    
	    boolean imprime = true;
	    int iMenor = j;
	    for(int i = j + 1; i < v.length; i++){
	        if(v[i] < v[iMenor]) iMenor = i; 
	    }

	     
	    if(iMenor == j) imprime = false;
	    int aux = v[iMenor];
	    v[iMenor] = v[j];
	    v[j] = aux;
	    
	    if(imprime) System.out.println(Arrays.toString(v));

        }

    }

}
