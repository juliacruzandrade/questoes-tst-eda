import java.util.Scanner;

public class CountingSortPassoAPasso{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        
        int[] a = new int[entrada.length];
        for(int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(entrada[i]);
        }


        int k = sc.nextInt();

        int[] c = new int[k + 1];
        int[] b = new int[a.length];

        //contagem
	for(int i = 0; i < a.length; i++){
            c[a[i]] += 1;
            System.out.println(formataArrayParaImpressao(c));        
        }
	
	//cumulativa do vetor contagem
	for(int i = 1; i < c.length; i++){
	    c[i] = c[i - 1] + c[i];
	}
	System.out.println("Cumulativa do vetor de contagem - " + formataArrayParaImpressao(c));

	
	//colocando os elementos ordenados
	for(int i = a.length - 1; i >= 0; i--){
	    int numero = a[i];
	    int indiceC = numero;
	    int indiceB = c[indiceC] - 1;	
	    b[indiceB] = numero;
	    c[indiceC] -= 1;
	}

	System.out.println(formataArrayParaImpressao(c));
	System.out.println(formataArrayParaImpressao(b));



    }


    


    public static String formataArrayParaImpressao(int[] array){
        String saida = "";
        int x = 0;
        for(int i = 0; i < array.length - 1; i++){
            saida += array[i] + " ";
            x = i;
        }
        saida += array[++x];
        return(saida);
    }

}
