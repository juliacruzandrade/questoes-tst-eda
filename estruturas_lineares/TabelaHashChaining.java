import java.util.*;


public class TabelaHashChaining{
  
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int tamanho = sc.nextInt();
       sc.nextLine();
       TabelaHashChaining tabela = new TabelaHashChaining(tamanho);
       while(true){
           String[] entrada = sc.nextLine().split(" ");
           String comando = entrada[0];
           if("end".equals(comando)) break;   


           switch(comando){
               case "put":
                   tabela.put(Integer.parseInt(entrada[1]), entrada[2]);
                   System.out.println(tabela.toString());
                   break;
               case "remove":
           	   tabela.remove(Integer.parseInt(entrada[1]));
                   System.out.println(tabela.toString());
           	   break;
               case "keys":
           	   System.out.println(tabela.toStringKeys());
           	   break;
               case "values":
           	   System.out.println(tabela.toStringValues());
               default:
           	   break;
   }
  
   }
}
  
          
   private ArrayList<Pair>[] tabela;
   private ArrayList<Integer> keys;
   private ArrayList<String> values;




   @SuppressWarnings("unchecked")
   public TabelaHashChaining(int capacidade){
       this.tabela = (ArrayList<Pair>[]) new ArrayList[capacidade];
       for (int i = 0; i < capacidade; i++) this.tabela[i] = new ArrayList<>(); // inicializa cada lista
       this.keys = new ArrayList<>();
       this.values = new ArrayList<>();
   }


   public int hash(Integer chave){
       return chave % this.tabela.length;
   }


   public void put(Integer chave, String valor){
       int hash = this.hash(chave);
       ArrayList<Pair> elemento = this.tabela[hash];
       Pair dupla = new Pair(chave, valor);


       if(elemento.isEmpty()){
           elemento.add(dupla);
           this.keys.add(chave);
           this.values.add(valor);
       }else{
           for(int i = 0; i < elemento.size(); i++){
               if(chave.equals(elemento.get(i).getKey())){
                   values.remove(elemento.get(i).getValue());
                   elemento.get(i).setValue(valor);
                   values.add(valor);
                   return;
               }  
           }
       elemento.add(dupla);
       keys.add(chave);
       values.add(valor);
       }
   }


   public void remove(Integer chave){
       int hash = this.hash(chave);
       ArrayList<Pair> elementos = this.tabela[hash];
       if(elementos.isEmpty())return;
       for(int i = 0; i < elementos.size(); i++){
           if(chave.equals(elementos.get(i).getKey())){
               values.remove(elementos.get(i).getValue());
               keys.remove(chave);
       	        elementos.remove(i);
           }
       }
   }


   public String toStringKeys(){
       Collections.sort(this.keys);
       return keys.toString();
   }


   public String toStringValues(){
       Collections.sort(this.values);
       return values.toString();
   }


   @Override
   public String toString(){
       return Arrays.toString(tabela);
   }




public class Pair{
   Integer chave;
   String valor;


   public Pair(Integer chave, String valor){
       this.chave = chave;
       this.valor = valor;
   }


   public Integer getKey(){
       return chave;
   }


   public String getValue(){
       return valor;
   }


   public void setValue(String newValue){
       this.valor = newValue;
   }


   @Override
   public String toString(){
       return "<" + chave + ", " + valor + ">";
   }


}


      
}










