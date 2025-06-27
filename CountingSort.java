import java.util.Scanner;



public class CountingSort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        
        int[] a = new int[entrada.length];
        for(int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(entrada[i]);
        }


        int k = sc.nextInt();

        int[] c = new int[k];
        int[] b = new int[a.length];

        for(int i = 0; i < a.length; i++){
            c[a[i] - 1] += 1;
            imprimeArray(c);        
        }

    }


    


    public static void imprimeArray(int[] array){
        String saida = "";
        int x = 0;
        for(int i = 0; i < array.length - 1; i++){
            saida += array[i] + " ";
            x = i;
        }
        saida += array[++x];
        System.out.println(saida);
    }

}
