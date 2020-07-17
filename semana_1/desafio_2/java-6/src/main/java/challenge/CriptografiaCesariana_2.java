package challenge;


import java.util.List;

import java.util.ArrayList;


public class CriptografiaCesariana implements Criptografia {


    @Override

    public String criptografar(String texto) {

        if (texto.isEmpty()) {

            throw new IllegalArgumentException();

        }

        int i;

        String textomin = "";

        String carac = "";

        textomin = texto.toLowerCase();

        char caractere;


        for (i = 0; i < textomin.length(); i++) {

            caractere = textomin.charAt(i);

            if (caractere >= '0' && caractere <= '9') {

                carac = carac + caractere;

            } else if (caractere == ' ') {

                carac = carac + caractere;

            } else {


                caractere = (char) (caractere + 3);

                carac = carac + caractere;

            }

        }

        return carac;

    }


    @Override

    public String descriptografar(String texto) {


        if (texto.isEmpty()) {

            throw new IllegalArgumentException();

        }


        int i;

        String textomin2 = "";

        String descarac = "";

        textomin2 = texto.toLowerCase();

        char caractere;


        for (i = 0; i < textomin2.length(); i++) {

            caractere = textomin2.charAt(i);


            if (caractere >= '0' && caractere <= '9') {

                descarac = descarac + caractere;

            } else if (caractere == ' ') {

                descarac = descarac + caractere;

            } else {

                caractere = (char) (caractere - 3);

                descarac = descarac + caractere;

            }

        }

        return descarac;

    }

}








