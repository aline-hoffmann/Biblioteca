import java.util.Comparator;
import java.util.Scanner;
import java.util.List;

public class Main {
    static Biblioteca biblio = new Biblioteca();
    static Scanner input = new Scanner(System.in);

    private static int inputNumerico(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.println(mensagem);
        do {
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Erro. Por favor informe um número Inteiro válido.");
            }
        } while (!entradaValida);
        return valor;
    }


    private static void listar() {
        // List<Livro> livros = biblio.pesquisarTodos();
        var livros = biblio.pesquisarTodos();
        livros.sort(Comparator.comparing(Livro::getTitulo));

        System.out.println("======== LISTA DE LIVROS =========");
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano: " + livro.getAnoPublicacao());
            System.out.println("N. Páginas: " + livro.getnPaginas());
        }
    }

    public static void removerPorTitulo() {
        System.out.println("Remover por título.");
        System.out.println("");;
        System.out.println("Iforme o título do livro que deseja remover");
        String titulo = input.nextLine();
 
        try {
            biblio.removerPorTitulo(titulo);
            System.out.println("Livro removido com sucesso!");
        } catch (Exception e) {
            System.out.println("ERRO :" + e.getMessage());
        }
    }    

    public static void pesquisarPorTitulo(){
        System.out.println("Pesquisar por título");
        System.out.println("");
        System.out.println("Informe o título do livro que deseja pesquisar:");
        String titulo = input.nextLine();

        try{
            List<Livro> livrosEncontrados = biblio.pesquisarPorTitulo(titulo);
            if (!livrosEncontrados.isEmpty()) {
                System.out.println("");
                System.out.println("Livro encontrado!");
                for (Livro livro : livrosEncontrados) {
                    System.out.println("Título: " + livro.getTitulo());
                    System.out.println("Autor: " + livro.getAutor());
                    System.out.println("Ano: " + livro.getAnoPublicacao());
                    System.out.println("N. Páginas: " + livro.getnPaginas());
                }
            } else {
                System.out.println("Nenhum livro encontrado com o título: " + titulo);
            }
        } catch  (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private static void adicionar() {
        Livro novoLivro = new Livro();
        System.out.println("======== ADICIONANDO NOVO LIVRO ========");
        System.out.print("Informe o título do livro que deseja adicionar: ");
        String titulo = input.nextLine();
        novoLivro.setTitulo(titulo);

        System.out.print("Informe o nome do autor: ");
        novoLivro.setAutor(input.nextLine());

        System.out.print("Informe o ano de publicação: ");
        novoLivro.setAnoPublicacao(input.nextInt());
        input.nextLine(); // buffer

        System.out.print("Informe o número de páginas: ");
        novoLivro.setnPaginas(input.nextInt());
        input.nextLine(); // buffer

        try {
            biblio.adicionar(novoLivro);
            System.out.println("Livro adicionado com Sucesso!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        input.nextLine(); // espera o usuário dar um enter para continuar
    }

    public static void main(String[] args) {

        String menu = """
                SISTEMA DE GERENCIAMENTO DE BIBLIOTECA
                Escolha uma das opções:
                1 - Adicionar novo livro;
                2 - Listar todos os livros;
                3 - Pesquisar livro;
                4 - Remover livro;
                0 - Sair;
                """;
        int opcao;
        do {
            //System.out.println(menu);
            //opcao = input.nextInt();
            //input.nextLine(); // limpar buffer
            opcao = inputNumerico(menu);
            switch (opcao) {
                case 0:
                    System.out.println("VOLTE SEMPRE!!!");
                    espera();
                    clear();
                    break;
                case 1:
                    adicionar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    // pesquisar por titulo
                    break;
                case 4:
                    // remover
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    input.nextLine();
                    break;
            }
        } while (opcao != 0);
    }

    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void espera(){
        try {Thread.sleep(1000);} catch (Exception erro){}}
    }

    
