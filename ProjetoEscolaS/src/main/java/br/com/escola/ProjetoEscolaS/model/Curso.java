package br.com.escola.ProjetoEscolaS.model;

import lombok.*;

import java.util.ArrayList;

@Data
public class Curso {
    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;


    private static int ultimoId = 0;

    private static int getNewId() {
        ultimoId++;
        return ultimoId;
    }


    @Getter static ArrayList<Curso> cursos = new ArrayList<>();

    public static Curso salvar(Curso curso) {
        curso.id = getNewId();
        cursos.add(curso);
        return curso;
    }


}
