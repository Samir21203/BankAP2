
package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.produtos.ProdutoBancario;
import util.Constantes;

public class ProdutoDAO {
    private static ProdutoDAO instancia;
    private List<ProdutoBancario> produtos;
    
    private ProdutoDAO () {
        this.produtos = carregarProdutos();
    }
    
    public static ProdutoDAO getInstance () {
        if (instancia == null) {
            instancia = new PodutoDAO();
        }
        return instancia;
    }
    
    private long gerarProximoCodigo() {
        long maxCodigo = 0L;
        for (ProdutoBancario produto : produtos) {
            if (produto.getCodigo() > maxCodigo) {
                maxCodigo = produto.getCodigo();
            }
        }
        return maxCodigo + 1;
    }
    
    private void salvarNoArquivo () {
        try {
            ArquivoUtil.gravar(this.produtos, Constantes.ARQUIVO_PRODUTOS);
        } catch (IOException e) {
            System.err.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }
    
    private List<ProdutoBancario> carregarProdutos() {
        File arquivo = new File(Constantes.ARQUIVO_PRODUTOS);
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }
        
        try {
            return (List<ProdutoBancario>) ArquivoUtil.ler(Constantes.ARQUIVO_PRODUTOS);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar produtos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    // CRUD
    public List<ProdutoBancario> getAll() {
        return this.produtos;
    }
    
    public void add(ProdutoBancario produto) {
        produto.setCodigo(gerarProximoCodigo());
        this.produtos.add(produto);
        salvarNoArquivo();
    }
    
    public void update(ProdutoBancario produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == produtoAtualizado.getCodigo()) {
                produtos.set(i, produtoAtualizado);
                salvarNoArquivo();
                break;
            }
        }
    }
    
    public void delete(ProdutoBancario produtoParaExcluir) {
        this.produtos.remove(produtoParaExcluir);
        salvarNoArquivo();
    }
    
    public ProdutoBancario getByCodigo(long codigo) {
        for (ProdutoBancario produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }
}
