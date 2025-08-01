import java.util.*;


public class OrdenaPilhaInvertendo{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tam = sc.nextInt();
        sc.nextLine();
        String[] entrada = sc.nextLine().split(" ");
        Pilha pilha = new Pilha(tam);
        for(int i = 0; i < tam; i++) pilha.push(Integer.parseInt(entrada[i]));

    }




    public static class Pilha {

    private int topo;
    private int[] pilha;
    
    
    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo + 1 == pilha.length;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if(isFull()) throw new RuntimeException();
        this.pilha[++this.topo] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if(isEmpty()) throw new NoSuchElementException();
        return(this.pilha[this.topo--]);
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if(isEmpty()) throw new NoSuchElementException();
        return (this.pilha[this.topo]);
    }



    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        String saida = "";
        
        if(!isEmpty()){
    
            Pilha aux = new Pilha(this.pilha.length);
            while(!isEmpty()){
                aux.push(this.peek());
                if(this.size() > 1) saida += String.valueOf(this.pop()) + ", ";
                else saida += String.valueOf(this.pop());
            }

            retornaElementosParaPilha(aux);
        }

        return saida;
    }


    public void retornaElementosParaPilha(Pilha aux){
        while(aux.size() > 0){
            this.push(aux.pop());
        }
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. Note que
    // o topo sempre está na primeira posição (0), abaixo do topo é a posição 1 etc. Não confunda
    // com os índices do array. Interprete os testes para a especificação mais detalhada.
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        int saida = -1;
        int cont = 0;
        Pilha aux = new Pilha(this.size());
        while(!isEmpty()){
            aux.push(this.pop());
            if(aux.peek() == valor){
                saida = cont;
            }
            cont++;
        }

        retornaElementosParaPilha(aux);

        return saida;
    }

    public int size() {
        return topo + 1;
    }


    public int size() {
        return topo + 1;
    }


    public int getMax(int index){
	int qnt = this.pilha.length - index;
	Pilha aux = new Pilha(qnt);
        int maior = this.pop();
	aux.push(maior);
	qnt--;
	for(int i = 0; i < qnt; i++){
	    int num = this.pop();
	    if(num > maior) maior = num;
	    aux.push(num);
	}
	
	retornaElementosParaPilha(aux);
	return maior;
    }

    
	public void invertePartindoIndex(int index){
	    int tamFila = this.pilha.length - index;
	    Fila fila = new Fila(tamFila);	    
	    for(int i = 0; i <= tamFila - 1; i++){
		int elemento = this.pop();
		fila.addLast(elemento);
	    }

	    for(int i = 0; i <= tamFila - 1; i++){
		int elemento = fila.removeFirst();
		this.push(elemento);
	    }
	
	}



}





}
