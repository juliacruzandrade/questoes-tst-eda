import java.util.*;

public class Parenteses{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        Pilha pilha = new Pilha(entrada.length());
        System.out.println(pilha.parenteses(entrada));
    
    }


    public static class Pilha{
	String[] pilha;
	int topo;

	public Pilha(int capacidade){
	    this.pilha = new String[capacidade];
	    this.topo = -1;
	}

	public boolean isFull(){
	    return this.topo == this.pilha.length - 1;
	}

	public boolean isEmpty(){
	    return this.topo == -1;
	}

	public void push(String element){
	    if(isFull()) throw new RuntimeException();
	    this.pilha[++this.topo] = element;
	}

	public String pop(){
	    if(isEmpty()) throw new NoSuchElementException();
	    return this.pilha[this.topo--];
	}

	public String peek(){
	    if(isEmpty()) throw new NoSuchElementException();
	    return this.pilha[this.topo];
	}

	public String get(int index){
	    if(index < 0 || index > this.topo) throw new IndexOutOfBoundsException();
	    Pilha aux = new Pilha(this.pilha.length);
	    int cont = 0;
	    String retorno = "";
	    while(!isEmpty()){
		String elemento = this.pop();
		aux.push(elemento);
		if(cont == index){
		    retorno = elemento;
		    break;
		}
	        cont++;
	    }
	    retornaElementosParaPilha(aux);
	    return retorno;
	}


	public void retornaElementosParaPilha(Pilha aux){
	    while(!aux.isEmpty()){
		this.push(aux.pop());
	    }
	}


	public int size(){
	    return this.topo + 1;
	}

	

	@Override
	public String toString(){
	    Pilha aux = new Pilha(this.pilha.length);
	    String saida = "-" + "\n";
	    while(!isEmpty()){
		String elemento = this.pop();
		saida += elemento + "\n";
		aux.push(elemento);
	    }

	    retornaElementosParaPilha(aux);
	    return saida;
	}


    
    //avalia se uma sequência de parênteses é bem formada usando uma pilha
    public String parenteses(String str){
        int tamPilha = str.length();
        String[] elementos = str.split("");
        for(int i = 0; i < tamPilha; i++){
            if(elementos[i].equals("(")) this.push(elementos[i]);
            if(isEmpty() && elementos[i].equals(")")) return "N";
            if(elementos[i].equals(")")) this.pop();
        }
        if(isEmpty()) return "S";
        else return "N";
    }


    }





}
