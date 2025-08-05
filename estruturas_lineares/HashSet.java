import java.util.*;


public class HashSet{


  public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int tamanho = sc.nextInt();
       sc.nextLine();
       HashSet tabela = new HashSet(tamanho);
       while(true){
           String[] entrada = sc.nextLine().split(" ");
           if(entrada[0].equals("end")) break;
           if(entrada[0].equals("put")){
               tabela.put(Integer.parseInt(entrada[1]));
               System.out.println(tabela.toString());
           }
           if(entrada[0].equals("remove")){
               tabela.remove(Integer.parseInt(entrada[1]));
               System.out.println(tabela.toString());
           }
           if(entrada[0].equals("contains")){
               System.out.println(tabela.contains(Integer.parseInt(entrada[1])));
           }
      
       }
  }






  private int capacity;
  private Integer[] tabela;
  private static final Integer DELETED = Integer.MIN_VALUE;


  public HashSet(int capacidade){
      this.capacity = capacidade;
      this.tabela = new Integer[capacidade];
  }


  public int hash(int valor){
      return valor % this.capacity;
  }


  public void put(Integer element){
      if(this.contains(element)) return;
      int probing = 0;
      int hash;
      int insertionIndex = -1;
      while(probing < this.tabela.length){
          hash = (this.hash(element) + probing) % this.tabela.length;
          Integer temp = this.tabela[hash];
          if(temp == null){
              insertionIndex = hash;
              break;
          }
          if(temp.equals(DELETED)){
              insertionIndex = hash;
              break;
          }
          probing++;
   }


      if(insertionIndex != -1) this.tabela[insertionIndex] = element;
  }


  public void remove(Integer valor){
      int probing = 0;
      int hash;
      while(probing < this.tabela.length){
          hash = (hash(valor) + probing) % this.tabela.length;
          Integer temp = this.tabela[hash];
          if(temp == null) return;
          if(temp.equals(valor)){
              tabela[hash] = DELETED;
          }
       probing++;
   }
  }


  public boolean contains(Integer valor){
   int probing = 0;
   int hash;
   while(probing < this.tabela.length){
       hash = (this.hash(valor) + probing) % this.tabela.length;
       Integer temp = this.tabela[hash];
       if(temp == null) return false;
       if(temp.equals(valor)) return true;
       probing++;
   }
   return false;
  }


  @Override
  public String toString(){
   String saida = "[";
   for(int i = 0; i < this.tabela.length; i++){
       if(this.tabela[i] != null && this.tabela[i].equals(DELETED)) saida += "null" + ", ";
       else saida += this.tabela[i] + ", ";
   }
   saida = saida.substring(0, saida.length() - 2);
   saida += "]";
   return saida;
  }




}






