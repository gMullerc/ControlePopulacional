package br.com.magnasistemas.api.enumerator;

public enum enumSituacaoEscolar {
    CURSANDO("Cursando"), COMPLETO("Completo"), INCOMPLETO("Incompleto");

    private String escolaridade;

    enumSituacaoEscolar(String escolaridade) {
        this.escolaridade = escolaridade;
    }

	public String getEscolaridade() {
		return escolaridade;
	}
    
    
}
