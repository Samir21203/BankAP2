
package model.produtos;

import java.io.Serializable;
import model.Cliente;
import util.TipoProduto;

public interface ProdutoBancario extends Serializable {
    long getCodigo();
    void setCodigo(long codigo);
    
    Cliente getCliente();
    String getDescricao();
    TipoProduto getTipoProduto();
}
