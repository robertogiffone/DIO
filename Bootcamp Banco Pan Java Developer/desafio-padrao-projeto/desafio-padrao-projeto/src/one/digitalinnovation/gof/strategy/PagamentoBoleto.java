package one.digitalinnovation.gof.strategy;

public class PagamentoBoleto implements Pagamento {

    @Override
    public void pagar() {
        System.out.println("Pagamento com boleto");
    }
    
}