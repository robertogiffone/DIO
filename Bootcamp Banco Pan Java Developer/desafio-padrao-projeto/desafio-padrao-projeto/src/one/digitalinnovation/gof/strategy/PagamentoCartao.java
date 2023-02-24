package one.digitalinnovation.gof.strategy;

public class PagamentoCartao implements Pagamento {

    @Override
    public void pagar() {
        System.out.println("Pagamento com cartão");
    }
    
}