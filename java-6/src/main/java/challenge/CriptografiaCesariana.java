package challenge;

import java.util.ArrayList;

public class CriptografiaCesariana implements Criptografia {
    @Override
    public String criptografar(String texto) {
        return criptografarJulioCezar(texto,3);
    }
    @Override
    public String descriptografar(String texto) {
        return criptografarJulioCezar(texto,-3);
    }

    public static String criptografarJulioCezar(String texto, int numCasas){

        if (texto.trim().isEmpty()) throw new IllegalArgumentException("Error: texto vazio");
        if (texto == null) throw new NullPointerException("Error: texto == null");

        texto = texto.toLowerCase();

        ArrayList<Character> alphabet = new ArrayList<>();

        for (char letter = 'a'; letter <= 'z'; letter++) alphabet.add(letter);

        int indice;
        char letter;
        String result = "";

        for (int i=0; i < texto.length();i++){
            letter = texto.charAt(i);
            if(letter == ' ' || Character.isDigit(letter)){
                result += letter;
            }else{
                indice = alphabet.indexOf(letter);
                indice+=numCasas;

                if(indice > alphabet.indexOf('z')){
                    result += alphabet.get(indice - alphabet.indexOf('z') - 1);
                }else if(indice < alphabet.indexOf('a')){
                    result += alphabet.get(alphabet.indexOf('z') + indice + 1);
                }else{
                    result += alphabet.get(indice);
                }
            }
        }
        return result;
    }
}
