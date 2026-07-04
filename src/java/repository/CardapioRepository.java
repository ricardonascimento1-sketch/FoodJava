package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CardapioRepository {
    public static final String FILE_PATH =
            "src/data/cardapio.json";
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File arquivo = new File(FILE_PATH);
        try {
            // verifica todas as pastas e cria as inexistentes ->
            if (arquivo.getParentFile() != null) {
                arquivo.getParentFile().mkdirs();
            }
            // verifica se o arquivo existe ->
            if (!arquivo.exists()) {
                arquivo.createNewFile();
                // escreve uma listav vazia no arquivo ->
                try (FileWriter writer = new FileWriter(FILE_PATH)) {
                    gson.toJson(new ArrayList<>(), writer);
                } catch (IOException e) {
                    System.err.println("ERRO: " + e.getMessage());
                }
            }

        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }


}
