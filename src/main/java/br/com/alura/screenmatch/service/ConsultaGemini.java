package br.com.alura.screenmatch.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ConsultaGemini {
        public static String obterTraducao (String texto){
            String apiKey = System.getenv("GEMINI_API_KEY");

            if (apiKey == null || apiKey.isEmpty()) {
                throw new RuntimeException("A variável de ambiente GEMINI_API_KEY não foi configurada.");
            }

            Client client = Client.builder().apiKey(apiKey).build();

            GenerateContentResponse response =
                    client.models.generateContent(
                            "gemini-3-flash-preview", // Note que o modelo mudou recentemente para gemini-2.0-flash ou gemini-1.5-flash
                            "Traduza para língua portuguesa o seguinte trecho da forma mais direta, não pergunte mais nada, apenas faça: " + texto,
                            null);

            return response.text();
        }
}
