import java.util.Scanner;

class No3 {
    int info;
    No3 prox;

    public No3(int info) {
        this.info = info;
        this.prox = null;
    }
}

class Lista {
    No3 cabeca;
    int tamanho;

    public Lista() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public boolean vazia() {
        return cabeca == null;
    }

    public void inserir(int valor) {
        No3 No3voNo3 = new No3(valor);
        if (vazia() || cabeca.info >= valor) {
            No3voNo3.prox = cabeca;
            cabeca = No3voNo3;
        } else {
            No3 atual = cabeca;
            while (atual.prox != null && atual.prox.info < valor) {
                atual = atual.prox;
            }
            No3voNo3.prox = atual.prox;
            atual.prox = No3voNo3;
        }
        tamanho++;
    }

    public void remover(int valor) {
        if (vazia()) return;

        if (cabeca.info == valor) {
            cabeca = cabeca.prox;
            tamanho--;
        } else {
            No3 atual = cabeca;
            while (atual.prox != null && atual.prox.info != valor) {
                atual = atual.prox;
            }
            if (atual.prox != null) {
                atual.prox = atual.prox.prox;
                tamanho--;
            }
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public static boolean iguais(Lista lista1, Lista lista2) {
        No3 No31 = lista1.cabeca;
        No3 No32 = lista2.cabeca;

        while (No31 != null && No32 != null) {
            if (No31.info != No32.info) return false;
            No31 = No31.prox;
            No32 = No32.prox;
        }
        return No31 == null && No32 == null;
    }

    public double media() {
        if (vazia()) return 0;

        No3 atual = cabeca;
        int soma = 0;
        while (atual != null) {
            soma += atual.info;
            atual = atual.prox;
        }
        return (double) soma / tamanho;
    }

    public boolean busca(int valor) {
        No3 atual = cabeca;
        while (atual != null) {
            if (atual.info == valor) return true;
            atual = atual.prox;
        }
        return false;
    }

    public void elimina(int valor) {
        while (cabeca != null && cabeca.info == valor) {
            cabeca = cabeca.prox;
            tamanho--;
        }
        No3 atual = cabeca;
        while (atual != null && atual.prox != null) {
            if (atual.prox.info == valor) {
                atual.prox = atual.prox.prox;
                tamanho--;
            } else {
                atual = atual.prox;
            }
        }
    }

    public void elimina_(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return;

        if (posicao == 0) {
            cabeca = cabeca.prox;
        } else {
            No3 atual = cabeca;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.prox;
            }
            atual.prox = atual.prox.prox;
        }
        tamanho--;
    }

    public void insereDireita(int posicao, int valor) {
        if (posicao < 0 || posicao >= tamanho) return;

        No3 No3voNo3 = new No3(valor);
        No3 atual = cabeca;
        for (int i = 0; i < posicao; i++) {
            atual = atual.prox;
        }
        No3voNo3.prox = atual.prox;
        atual.prox = No3voNo3;
        tamanho++;
    }

    public void insereEsquerda(int posicao, int valor) {
        if (posicao <= 0 || posicao > tamanho) return;

        No3 No3voNo3 = new No3(valor);
        if (posicao == 1) {
            No3voNo3.prox = cabeca;
            cabeca = No3voNo3;
        } else {
            No3 atual = cabeca;
            for (int i = 0; i < posicao - 2; i++) {
                atual = atual.prox;
            }
            No3voNo3.prox = atual.prox;
            atual.prox = No3voNo3;
        }
        tamanho++;
    }

    public void imprimir() {
        No3 atual = cabeca;
        while (atual != null) {
            System.out.print(atual.info + " ");
            atual = atual.prox;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista();
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir valor");
            System.out.println("2. Remover valor");
            System.out.println("3. Imprimir lista");
            System.out.println("4. Mostrar tamanho da lista");
            System.out.println("5. Mostrar média dos elementos");
            System.out.println("6. Buscar valor");
            System.out.println("7. Eliminar todas as ocorrências de um valor");
            System.out.println("8. Eliminar elemento por posição");
            System.out.println("9. Inserir valor à direita de uma posição");
            System.out.println("10. Inserir valor à esquerda de uma posição");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para inserir: ");
                    int valorInserir = scanner.nextInt();
                    lista.inserir(valorInserir);
                    break;

                case 2:
                    System.out.print("Digite o valor para remover: ");
                    int valorRemover = scanner.nextInt();
                    lista.remover(valorRemover);
                    break;

                case 3:
                    System.out.println("Lista:");
                    lista.imprimir();
                    break;

                case 4:
                    System.out.println("Tamanho: " + lista.tamanho());
                    break;

                case 5:
                    System.out.println("Média: " + lista.media());
                    break;

                case 6:
                    System.out.print("Digite o valor para buscar: ");
                    int valorBuscar = scanner.nextInt();
                    System.out.println("Busca " + valorBuscar + ": " + lista.busca(valorBuscar));
                    break;

                case 7:
                    System.out.print("Digite o valor para eliminar todas as ocorrências: ");
                    int valorElimina = scanner.nextInt();
                    lista.elimina(valorElimina);
                    break;

                case 8:
                    System.out.print("Digite a posição para eliminar: ");
                    int posicaoEliminar = scanner.nextInt();
                    lista.elimina_(posicaoEliminar);
                    break;

                case 9:
                    System.out.print("Digite a posição para inserir à direita: ");
                    int posicaoDireita = scanner.nextInt();
                    System.out.print("Digite o valor para inserir: ");
                    int valorDireita = scanner.nextInt();
                    lista.insereDireita(posicaoDireita, valorDireita);
                    break;

                case 10:
                    System.out.print("Digite a posição para inserir à esquerda: ");
                    int posicaoEsquerda = scanner.nextInt();
                    System.out.print("Digite o valor para inserir: ");
                    int valorEsquerda = scanner.nextInt();
                    lista.insereEsquerda(posicaoEsquerda, valorEsquerda);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente No3vamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}