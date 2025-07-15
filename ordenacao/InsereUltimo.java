import java.util.*;

public class InsereUltimo{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String[] entrada = sc.nextLine().split(" ");

	int[] v = new int[entrada.length];

	for(int i = 0; i < v.length; i++){
	    v[i] = Integer.parseInt(entrada[i]);
	}

	insereUltimo(v);

	System.out.println(Arrays.toString(v));

    }

    //recebe um array ordenado exceto pelo último elemento
    public static void insereUltimo(int[]v){
	int i = v.length - 1;
        while(i > 0 &&v[i] < v[i - 1]){
	    int aux = v[i];
	    v[i] = v[i -1];
	    v[i - 1] = aux;
	    i--;
	}
    }

}
