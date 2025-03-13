import java.util.*;

public class Turma{
  private int semestre;
  private int ano;
  private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
  private Curso curso;
  private Professor professor;

  //CONSTRUTOR
  public Turma(int semestre, int ano, Curso curso, Professor professor){
    this.semestre = semestre;
    this.ano = ano;
    this.alunos = new ArrayList<Aluno>();
    this.curso = curso;
    this.professor = professor;
  }
  
  //GETS E SETS

  public int getSemestre(){
    return semestre;
  }

  public int getAno(){
    return ano;
  }

  public Curso getCurso(){
    return curso;
  }

  public Professor getProfessor(){
    return professor;
  }

  public ArrayList<Aluno> getAlunos(){
    return alunos;
  }

  public void setSemestre(int s){
    semestre = s;
  }

  public void setAno(int a){
    ano = a;
  }

  public void setNovoAluno(Aluno a){
    alunos.add(a);
  }


  //METODOS GERAIS
  public String toString(){
    return "Turma de " + curso.getNome() +" - "+ semestre + " (" + ano + ")";
  }

  public String infoTurma(){
    return curso.getNome() + " - " + semestre + " (" + ano + ")";
  }

  public void adicionarAluno(Aluno a){
    alunos.add(a);
  }
  
}