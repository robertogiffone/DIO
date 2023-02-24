package one.digitalinnovation.gof;

import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.singleton.Configuracao;
import one.digitalinnovation.gof.strategy.Pagamento;
import one.digitalinnovation.gof.strategy.PagamentoBoleto;
import one.digitalinnovation.gof.strategy.PagamentoCartao;
import one.digitalinnovation.gof.strategy.PagamentoPix;
import one.digitalinnovation.gof.strategy.Pedido;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        
        Configuracao configuracao = Configuracao.getInstancia();
        System.out.println(configuracao);
        configuracao = Configuracao.getInstancia();
        System.out.println(configuracao);
        
        // Strategy
		
		Pagamento cartao = new PagamentoCartao();
		Pagamento boleto = new PagamentoBoleto();
		Pagamento pix = new PagamentoPix();
		
		Pedido pedido = new Pedido();
		pedido.setPagamento(cartao);
		pedido.pagar();
        pedido.pagar();
        pedido.setPagamento(boleto);
		pedido.pagar();
        pedido.setPagamento(pix);
		pedido.pagar();

        // Facade
		
		Facade facade = new Facade();
        facade.enviarProduto(1);
    }
}
