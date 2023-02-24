package one.digitalinnovation.gof.strategy;

public class Pedido {
    private Pagamento pagamento;

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void pagar() {
        pagamento.pagar();
    }

}