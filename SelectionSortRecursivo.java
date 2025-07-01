import java.util.*;

public class SelectionSortRecursivo{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");

	int[] v = new int[entrada.length];

	for(int i = 0; i < v.length; i++) v[i] = Integer.parseInt(entrada[i]);

	selectionSortRecursivo(v, 0, v.length - 1);
    }

    public static void selectionSortRecursivo(int[] v, int ini, int fim){
	boolean imprime = true;
	if(ini == 0) imprime = false;
	if(imprime) System.out.println(Arrays.toString(v));
	if(ini >= fim)return;

	int iMenor = ini;
	for(int i = ini; i <= fim; i++){
	    if(v[i] < v[iMenor]) iMenor = i;
	}

	int aux = v[iMenor];
	v[iMenor] = v[ini];
	v[ini] = aux;

	selectionSortRecursivo(v, ini + 1, fim);
    }

}
