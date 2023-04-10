package br.com.magnasistemas.api.enumerator;

public enum enumEtnia {
    PARDO(1), PRETO(2), BRANCO(3);

    private Integer etnia;

    enumEtnia(Integer etnia) {
        this.etnia = etnia;
    }

	public Integer getEtnia() {
		return etnia;
	}
    
    
    
}
