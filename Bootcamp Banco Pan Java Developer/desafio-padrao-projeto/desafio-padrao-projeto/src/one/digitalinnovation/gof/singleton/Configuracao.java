package one.digitalinnovation.gof.singleton;

public class Configuracao {
    private static Configuracao instancia;

    private Configuracao() {
		super();
	}
    
    public static Configuracao getInstancia() {
		if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
	}

}