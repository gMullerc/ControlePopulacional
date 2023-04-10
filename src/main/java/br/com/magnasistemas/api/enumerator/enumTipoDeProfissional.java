package br.com.magnasistemas.api.enumerator;

public enum enumTipoDeProfissional {
	CLT("clt"), AUTONOMO("Autonomo");

    private String tipoDeProfissional;

	enumTipoDeProfissional(String tipoDeProfissional) {
        this.tipoDeProfissional = tipoDeProfissional;
    }

	public String getTipoDeProfissional() {
		return tipoDeProfissional;
	}
    
}
