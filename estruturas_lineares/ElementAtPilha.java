import java.util.*;

public class ElementAtPilha{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Pilha pilha = new Pilha(20);
	String[] entrada = sc.nextLine().split(" ");
	for(int i = 0; i < entrada.length; i++) pilha.push(Integer.parseInt(entrada[i]));
	int indice = sc.nextInt();
	System.out.println(pilha.get(pilha.getTopo() - indice));
    }


    public static class Pilha{
	int[] pilha;
	int topo;

	public Pilha(int capacidade){
	    this.pilha = new int[capacidade];
	    this.topo = -1;
	}

	public boolean isFull(){
	    return this.topo == this.pilha.length - 1;
	}

	public boolean isEmpty(){
	    return this.topo == -1;
	}

	public void push(int element){
	    if(isFull()) throw new RuntimeException();
	    this.pilha[++this.topo] = element; 
	}

	public int pop(){
	    if(isEmpty()) throw new NoSuchElementException();
	    return this.pilha[this.topo--];
	}

	public int peek(){
	    if(isEmpty()) throw new NoSuchElementException();
	    return this.pilha[this.topo];
	}

	public String get(int index){
	    if(index < 0 || index > this.topo) return("indice invalido");
	    Pilha aux = new Pilha(this.pilha.length);
	    int cont = 0;
	    int retorno = 0;
	    while(!isEmpty()){
		int elemento = this.pop();
		aux.push(elemento);
		if(cont == index){
		    retorno = elemento;
		    break;
		}
	        cont++;
	    }
	    retornaElementosParaPilha(aux);    
	    return String.valueOf(retorno);
	}


	public void retornaElementosParaPilha(Pilha aux){
	    while(!aux.isEmpty()){
		this.push(aux.pop());
	    }
	}

	
	public int getTopo(){
	    return this.topo;
	}





    }

}
