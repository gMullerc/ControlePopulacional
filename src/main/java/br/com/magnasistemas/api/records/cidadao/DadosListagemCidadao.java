package br.com.magnasistemas.api.records.cidadao;

import java.util.List;

import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumGenero;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;
import br.com.magnasistemas.api.model.Cidadao;
import br.com.magnasistemas.api.model.Contato;
import br.com.magnasistemas.api.model.Documento;
import br.com.magnasistemas.api.model.Endereco;

public record DadosListagemCidadao(Long id, String nome, enumGenero genero, List<Endereco> endereco, List<Contato> contato, enumSituacaoEscolar situacaoEscolar, enumEscolaridade Escolaridade, Documento documentos) {

    public DadosListagemCidadao(Cidadao cid){
        this(cid.getId(), cid.getNome(), cid.getGenero(), cid.getEndereco(), cid.getContato(), cid.getSituacaoEscolar(), cid.getEscolaridade(), cid.getDocumentos());
    }



	
}
