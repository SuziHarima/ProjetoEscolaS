package br.com.escola.ProjetoEscolaS.model;

public class Cursos {
    private int id;
    private String nome;
    private String descricao;
    private int cargaHoraria;


    private static int ultimoId = 0;

    private static int getNewId() {
        ultimoId++;
        return ultimoId;
    }


}
