package com.vinivictor.api_cliente.integration;

import com.vinivictor.api_cliente.entity.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoIntegrationImpl implements EnderecoIntegration {

    @Override
    public Endereco buscarDetalhesCep(String cepParaBusca) {
        // Criamos o cliente que faz a requisição HTTP
        RestTemplate rest = new RestTemplate();
        String endpoint = "https://viacep.com.br/ws/" + cepParaBusca + "/json/";

        try {
            // Faz a chamada e recebe os dados no nosso objeto de resposta
            ViaCepResponse dadosBrutos = rest.getForObject(endpoint, ViaCepResponse.class);

            if (dadosBrutos != null && dadosBrutos.getCepRecebido() != null) {
                // "Traduzimos" do objeto da API externa para o nosso Endereco do Domain
                return new Endereco(
                        dadosBrutos.getCepRecebido(),
                        dadosBrutos.getRuaCompleta(),
                        dadosBrutos.getNomeCidade(),
                        dadosBrutos.getSiglaEstado()
                );
            }
        } catch (Exception e) {
            // Caso dê erro na API, retorna um objeto vazio para não quebrar o sistema
            return new Endereco(cepParaBusca, "Não encontrado", "", "");
        }
        return new Endereco();
    }
}