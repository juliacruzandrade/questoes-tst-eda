import java.util.*;

public class InvertePilha{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int capacidade = sc.nextInt();
	Pilha pilha = new Pilha(capacidade);
	sc.nextLine();
	String[] entrada = sc.nextLine().split(" ");
	for(int i = 0; i < entrada.length; i++) pilha.push(Integer.parseInt(entrada[i]));
	pilha.invertePilha();
	System.out.print(pilha.toString());
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

	public int get(int index){
	    if(index < 0 || index > this.topo) throw new IndexOutOfBoundsException();
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
	    return retorno;
	}


	public void retornaElementosParaPilha(Pilha aux){
	    while(!aux.isEmpty()){
		this.push(aux.pop());
	    }
	}

	
	public int getTopo(){
	    return this.topo;
	}


	public void invertePilha(){
	    Fila fila = new Fila(this.pilha.length);
	    while(!isEmpty()){
		fila.addLast(this.pop());
	    }
	    
            while(!fila.isEmpty()){
		this.push(fila.removeFirst());
	    }	    
	}

	@Override
	public String toString(){
	    Pilha aux = new Pilha(this.pilha.length);
	    String saida = "";
	    while(!isEmpty()){
		int elemento = this.pop();
		aux.push(elemento);
		saida += elemento + "\n";
	    }
	    retornaElementosParaPilha(aux);
	    return saida;
	}


    }


public static class Fila{
    int[] fila;
    int head;
    int tail;
    int size;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size >= fila.length;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
       	
	if(isFull()) throw new RuntimeException();    
	if(isEmpty()) this.head = 0; 
	
 	this.size++;	

	this.tail = (this.tail + 1) % this.fila.length;
       	this.fila[tail] = valor;

    }



    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty()) throw new NoSuchElementException();
	
	//Temos que retornar o elemento que será removido. Preciso, então, guardar seu valor
	int saida = this.fila[head];

	//Nunca mexemos no tail, a não ser que a fila só tenha um elemento
	//mexemos sempre no head
	if(this.head == this.tail){
	    this.head = -1;
	    this.tail = -1;
	}else{
	    this.head = (this.head + 1) % this.fila.length;
	}

	//Sempre decremento o tamanho
	this.size--;
	return saida;

    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        if(isEmpty()) throw new NoSuchElementException();
	return this.fila[this.head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
        if(isEmpty()) throw new NoSuchElementException();
	return this.fila[this.tail];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        Fila aux = new Fila(this.fila.length);
	String saida = "";
	if(!isEmpty()){
	    while(!isEmpty()){
		int elemento = this.removeFirst();   
	    	aux.addLast(elemento);
		if(this.size > 0) saida += elemento + ", ";
		else saida += elemento;
	    }
	}

	retornaElementosParaFila(aux);
	return saida;
    }

    public void retornaElementosParaFila(Fila aux){
	while(aux.size > 0){
	    this.addLast(aux.removeFirst());
	}
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
	Fila aux = new Fila(this.fila.length);
	int saida = -1;
	boolean achou = false;
	int cont = 0;
	if(!isEmpty()){
	    while(!isEmpty()){ 
		if(!achou) saida = cont;
		int elemento = this.removeFirst();
		cont++;
	    	aux.addLast(elemento);
		if(elemento == valor) achou = true;
	    }	
	}
	
	retornaElementosParaFila(aux);
	return saida;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Fila aux = new Fila(this.fila.length);
	int saida = -1;
	int cont = -1;
	if(!isEmpty()){
	    while(!isEmpty()){ 
		int elemento = this.removeFirst();
		cont++;
	    	aux.addLast(elemento);
		if(elemento == valor) saida = cont;
	    }	
	}
	
	retornaElementosParaFila(aux);
	return saida;

    }
    
    public int size() {
        return this.size;
    }


    } 



}
