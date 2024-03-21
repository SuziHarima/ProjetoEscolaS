package br.com.escola.ProjetoEscolaS.model;

import lombok.*;

import java.util.ArrayList;

@Data
public class Curso {
    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    private ArrayList<Aluno> alunosMatriculados = new ArrayList<>();


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

    public static Curso buscarPorId(Integer id) throws Exception {
        for (Curso curso : cursos) {
            if (curso.getId().equals(id)){
                return curso;
            }
        }
        throw new Exception("Curso não encontrado");
    }

    public static void matricular(Curso curso, Aluno aluno) {
        curso.alunosMatriculados.add(aluno);
    }

}
