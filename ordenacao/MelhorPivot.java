import java.util.Scanner;

public class MelhorPivot{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
	
	String[] entrada = sc.nextLine().split(" ");
	String[] entrada2 = sc.nextLine().split(" ");

	int[] v = new int[entrada.length];
	int i = Integer.parseInt(entrada2[0]);
	int j = Integer.parseInt(entrada2[1]);
	
	for(int k = 0; k < v.length; k++){
	    v[k] = Integer.parseInt(entrada[k]);
	}

	System.out.println(melhorPivot(v, i, j));

    }


    public static int melhorPivot(int[] v, int i, int j){
	//encontrar quantos elementos são maiores que v[i]
	//Isso nos dirá quantos ficarão à sua direita no particionamento
	int maioresQuei = 0;
	int candidato1 = v[i];
	for(int k = 0; k < v.length; k++){
	    if(v[k] > candidato1) maioresQuei++;
	}

	//fazer o mesmo para v[j]
	int maioresQuej = 0;
	int candidato2 = v[j];
	for(int k = 0; k < v.length; k++){
	    if(v[k] > candidato2) maioresQuej++;
	}
    

	int metade = v.length/2;
	
	//a está associado a i e b está associado a j
	//queremos o elemento cuja quantidade de elementos à sua direita após o particionamento seja mais próximo da metade do tamanho
	//do array. Ou seja, o que fica mais próximo de dividir o array no meio.
	
	int a = Math.abs(metade - maioresQuei);
	int b = Math.abs(metade - maioresQuej);

	if(Math.abs(a) == Math.abs(b)) return i;

	if(Math.min(a, b) == a) return i;
	else return j;

    
    }
}
