import java.util.ArrayList;
import java.util.Scanner;

public class listaCompras {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> compras = new ArrayList<>();
        char resp;

        System.out.println("Seja Bem-Vindo(a)!");

        do {
            System.out.print("\nO que deseja fazer?\n1- Adicionar Produto;\n2- Remover Produto;\n3- Consultar Produtos;\n0- Sair.\n");
            resp = sc.next().charAt(0);

            switch (resp) {
                case '0':
                    break;
                case '1':
                    AdicionarProduto(compras);
                    break;
                case '2':
                    //verifica se a lista está != null
                    if (compras.size() != 0) {
                        RemoverProduto(compras);
                    } else {
                        System.out.print("A lista está vazia!\n");
                    }
                    break;
                case '3':
                    //verifica se a lista está != null
                    if (compras.size() != 0) {
                        ConsultarProduto(compras);
                    } else {
                        System.out.print("A lista está vazia!\n");
                    }
                    break;
                default:
                    System.out.print("Opção Inválida!\n");
                    break;
            }
        } while (resp != '0');
    }

    public static void AdicionarProduto(ArrayList<String> lista) {

        Scanner sc = new Scanner(System.in);
        char resp;
        boolean k = true;
        String produto;

        System.out.println("Informe o produto a ser adicionado: ");
        produto = sc.next();
        if(lista.size() > 0){
            if (ComparaProdutos(lista, produto) == true){
                lista.add(produto);
            }
        } else{
            lista.add(produto);
        }

        do {
            System.out.println("Deseja adicionar um novo produto? (S/N)");
            resp = sc.next().charAt(0);
            switch (resp) {
                case 's':
                case 'S':
                    k = false;
                    //função recursiva para adicionar novo produto
                    AdicionarProduto(lista);
                    break;
                case 'n':
                case 'N':
                    k = false;
                    break;
                default:
                    System.out.println("Opção Inválida.\n");
                    break;
            }
        } while (k);
    }

    public static Boolean ComparaProdutos(ArrayList<String> lista, String x) {

        Scanner sc = new Scanner(System.in);
        int n = lista.size();
        boolean k = true;
        for (int i = 0; i < n; i++) {
            if (lista.contains(x)) {
                System.out.println("Este produto já existe.");
                k = false;
                break;
            }
        }

        return k;
    }

    public static void ConsultarProduto(ArrayList<String> lista) {

        int n = lista.size();
        for (int i = 0; i < n; i++) {
            System.out.printf("Produto %d- %s\n", i + 1, lista.get(i));
        }
    }

    public static void RemoverProduto(ArrayList<String> lista) {

        Scanner sc = new Scanner(System.in);
        char resp;
        int prod;
        boolean k = true;

        do {
            System.out.println("Qual produto você deseja remover?");
            ConsultarProduto(lista);
            try {
                prod = sc.nextInt() - 1;
                lista.remove(prod);
                System.out.println("Deseja remover outro produto? (S/N)");
                resp = sc.next().charAt(0);
                switch (resp) {
                    case 's':
                    case 'S':
                        k = false;
                        //função recursiva para adicionar novo produto
                        RemoverProduto(lista);
                        break;
                    case 'n':
                    case 'N':
                        k = false;
                        break;
                    default:
                        System.out.println("Opção Inválida.\n");
                        k = false;
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Produto Inexistente!");
                break;
            }
        } while (k);
    }
}

