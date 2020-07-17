package challenge;


public class CriptografiaCesariana implements Criptografia {



    @Override

    public String criptografar(String texto) {

        return this.criptografiaGenerica(texto, +3);

    }



    @Override

    public String descriptografar(String texto) {

        return this.criptografiaGenerica(texto, -3);

    }



    private String criptografiaGenerica(String texto, int number) {


        if (texto.isEmpty()) {

            throw new IllegalArgumentException();

        }

        int i;

        String textomin = "";

        String carac = "";

        textomin = texto.toLowerCase();

        char caractere;

        String expressao;

        for (i = 0; i < textomin.length(); i++) {

            caractere = textomin.charAt(i);

            if (caractere >= '0' && caractere <= '9') {

                carac = carac + caractere;

            } else if (caractere == ' ') {

                carac = carac + caractere;

            } else {

                caractere = (char) (caractere+number);

                carac = carac + caractere;

            }

        }

        return carac;

    }

}









