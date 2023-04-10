package br.com.magnasistemas.api.enumerator;

public enum enumEscolaridade {
    SUPERIOR("Superior"), MEDIO("Medio"), FUNDAMENTAL("Fundamental");

    private String escolaridade;

    enumEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

	public String getEscolaridade() {
		return escolaridade;
	}
    
    
}
