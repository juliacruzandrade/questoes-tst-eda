import java.util.*;


public class WordCloud{
  
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       String[] entrada = sc.nextLine().split(" ");
       WordCloud wc = new WordCloud();
       wc.adicionaElementosMapa(entrada);
       while(true){
           String p = sc.nextLine();
           if(p.equals("fim")) break;
           System.out.println(wc.retornaFrequenciaDePalavra(p));
       }
   }      
  
  
   HashMap<String, Integer> palavras;


   public WordCloud(){
       palavras = new HashMap<>();
   }


   public void adicionaElementosMapa(String[] entrada){
       for(int i = 0; i < entrada.length; i++){
           if(!palavras.containsKey(entrada[i])) palavras.put(entrada[i], 1);
           else palavras.put(entrada[i], palavras.get(entrada[i]) + 1);
       }
   }


   public int retornaFrequenciaDePalavra(String palavra){
       if(this.palavras.containsKey(palavra)) return this.palavras.get(palavra);
       else return 0;
   }


  
}










