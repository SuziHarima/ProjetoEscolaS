package br.com.escola.ProjetoEscolaS.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {
    private int id;
    private String nome;
    private Date nascimento;

    private static int ultimoId = 0;

    public Aluno(String nome, String nascimento) {
        this.id = getNewId();
        this.nome = nome;
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.nascimento = formatador.parse(nascimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getNewId() {
        ultimoId++;
        return ultimoId;
    }


}
