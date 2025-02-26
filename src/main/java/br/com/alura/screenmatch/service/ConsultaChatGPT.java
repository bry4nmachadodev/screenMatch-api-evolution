package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}