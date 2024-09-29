import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Biblioteca {
    //BD em memória
    private List<Livro> acervo = new ArrayList<>();

    public void adicionar(Livro livro) throws Exception{
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty())
            throw new Exception("Não é permitido cadastrar livro sem título.");

        if (livro.getAutor() == null || livro.getAutor().isEmpty())    
            {throw new Exception("Não é permitido cadastrar livro sem autor.");}

        int anoAtual = LocalDate.now().getYear();
        if (livro.getAnoPublicacao() < 1400 || livro.getAnoPublicacao() > anoAtual) 
            {throw new Exception("Ano de publicação deve ser entre 1400 e " + anoAtual);
        }


        if (livro.getAnoPublicacao() <=0){
            throw new Exception("Ano de publicação deve ser maior que zero.");
        }    

        if (livro.getnPaginas() <= 0)
            throw new Exception("O livro precisa ter no mínimo uma página!");

        for (Livro livroAcervo : acervo) {
            if (livroAcervo.getTitulo().equalsIgnoreCase(livro.getTitulo()))
                throw new Exception("Já existe livro cadastrado com este título");
        }
        acervo.add(livro);
    }

    public List<Livro> pesquisarPorTitulo(String titulo){
        List<Livro> livrosEncontrados = new ArrayList<>();

        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }

    public void removerPorTitulo(String titulo) throws Exception{
        boolean livroRemovido = false;

        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                acervo.remove(livro);
                livroRemovido = true;
                break;
            }
        }
    if (!livroRemovido) {
        throw new Exception("Nenhum livro encontrado com o título: " + titulo);
        
    }    
}

    public List<Livro> pesquisarTodos(){
        return this.acervo;
    }
    
}