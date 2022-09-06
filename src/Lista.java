public class Lista {
    private Nodo head;
    private Nodo tail;
    private int quantidade;

    public Lista(){
        this.head = null;
        this.tail = null;
        this.quantidade = 0;
    }

    public void add(int valor){
        Nodo nodo = new Nodo(valor);
        this.quantidade++;
        if(this.head == null){
            this.head = nodo;
            this.tail = nodo;
            return;
        }
        Nodo oldTail = this.tail;
        this.tail = nodo;
        oldTail.proximo = this.tail;
    }

    public void add(int valor, int index){
        if(index < 0 || index >= this.quantidade){
            throw new IndexOutOfBoundsException();
        }
        Nodo nodo = new Nodo(valor);
        if(index == 0){
            nodo.proximo = this.head;
            this.head = nodo;
            this.quantidade++;
            return;
        }

        if(index == this.quantidade - 1){
            this.add(valor);
            return;
        }

        Nodo aux = this.head;
        for(int i = 0; i < index - 1; i++){
            aux = aux.proximo;
        }
        nodo.proximo = aux.proximo;
        aux.proximo = nodo;
        this.quantidade++;
        return;
    }

    public int popByIndex(int index){
        Nodo aux = this.head;
        Nodo element;
        if(index == 0){
            this.head = aux.proximo;
            element = aux;
            aux = null;
            this.quantidade--;
            return element.valor;
        }
        for(int i = 0; i < index - 1; i++){
            aux = aux.proximo;
        }
        this.quantidade--;
        element = aux.proximo;
        aux.proximo = aux.proximo.proximo;
        return element.valor;
    }

    public int pop(int element){
        int index = this.indexOf(element);
        return this.popByIndex(index);
    }

    public int size(){
        return this.quantidade;
    }

    public int get(int index){
        Nodo aux = this.head;
        for(int i = 0; i < index; i++){
            aux = aux.proximo;
        }
        return aux.valor;
    }

    public int indexOf(int element){
        int index = 0;
        Nodo aux = this.head;
        while(true){
            if(aux == null){
                return -1;
            }

            if(aux.valor == element){
                break;
            }

            aux = aux.proximo;
            index++;
        }

        return index;
    }

    public boolean isEmpty(){
        return this.quantidade == 0;
    }

    public boolean contains(int element){
        Nodo aux = this.head;
        while(true){
            if(aux == null){
                return false;
            }

            if(aux.valor == element){
                break;
            }

            aux = aux.proximo;
        }

        return true;
    }

    public void override(int index, int element){
        Nodo aux = this.head;
        for(int i = 0; i < index; i++){
            aux = aux.proximo;
        }
        aux.valor = element;
    }

    public void clear(){
        Nodo aux = this.head;
        while(true){
            if(aux == null){
                break;
            }
            this.pop(aux.valor);
            aux = aux.proximo;
        }
    }

    @Override
    public String toString() {
        String str = "";
        Nodo aux = this.head;
        int index = 0;
        while(aux != null){
            str += "Posição: " + index + "; Valor: " + aux.valor + ".";
            aux = aux.proximo;
            index++;
        }
        return str + "\n";
    }
}
