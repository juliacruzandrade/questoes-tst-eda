import java.util.*;

public class MarianaEOsLivros{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(",");

	insertionSortParaPalavras(entrada);

    }

    public static void insertionSortParaPalavras(String[] v){
	for(int i = 1; i < v.length; i++){
	    System.out.println(formataSaida(v));
	    int j = i;
	    while(j > 0 && v[j].compareTo(v[j - 1]) < 0){
	    String aux = v[j];
	    v[j] = v[j - 1];
	    v[j - 1] = aux;
	    j--;
	    }
	}
	System.out.println(formataSaida(v));
    }

    public static String formataSaida(String[] arr){
	String saida = "";
	saida += arr[0];
	for(int i = 1; i < arr.length; i++){
	    saida += ", " + arr[i];
	}
	return saida;

    }



}
