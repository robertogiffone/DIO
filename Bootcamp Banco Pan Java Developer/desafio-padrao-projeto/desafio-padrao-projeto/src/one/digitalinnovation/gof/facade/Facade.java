package one.digitalinnovation.gof.facade;

public class Facade {
    
    public void enviarProduto(int idProduto){
        Produto produto = new Produto();
        produto.id = idProduto;
        if(ServicoEstoque.estaDisponivel(produto)){
            ServicoEntrega.enviarProduto(produto);
        }
    }

}