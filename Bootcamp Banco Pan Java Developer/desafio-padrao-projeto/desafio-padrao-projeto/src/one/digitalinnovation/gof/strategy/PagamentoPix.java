package one.digitalinnovation.gof.strategy;

public class PagamentoPix implements Pagamento {

    @Override
    public void pagar() {
        System.out.println("Pagamento com pix");
    }
    
}