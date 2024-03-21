package br.com.escola.ProjetoEscolaS.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Data
public class Aluno {
    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private Date nascimento;

    private static Integer ultimoId = 0;

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

    @Getter
    static ArrayList<Aluno> alunos = new ArrayList<>();

    public static Aluno salvar(Aluno aluno) {
        aluno.id = getNewId();
        alunos.add(aluno);
        return aluno;
    }

    public static Aluno buscaPorId(Integer id) throws Exception {
        for (Aluno aluno : alunos){
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        throw new Exception("Aluno não encontrado");
    }




}
