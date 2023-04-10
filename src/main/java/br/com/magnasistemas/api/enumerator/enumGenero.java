package br.com.magnasistemas.api.enumerator;

public enum enumGenero {
    FEMININO("Feminino"), MASCULINO("Masculino"), NAOBINARIO("NaoBinario");

    private String genero;

    enumGenero(String g) {
        this.genero = g;
    }
    
	public String getGenero() {
		return genero;
	}
}
