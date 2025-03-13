import java.util.*;

public class Curso{
  private String nome;
  private String sigla;
  private static ArrayList<Turma> turmas = new ArrayList<Turma>();

  //CONSTRUTOR
  public Curso(String n, String s){
    nome = n;
    sigla = s;
    turmas = new ArrayList<Turma>();
  }
  
        
  //GETS E SETS
  public String getNome(){
    return nome;
  }

  public String getSigla(){
    return sigla;
  }

  public void setNome(String n){
    nome = n;
  }

  public void setSigla(String s){
    sigla = s;
  }

  //METODOS GERAIS
  public String toString(){
    return "Curso: " + nome + " (" + sigla + ")";
  }
  
  public void mostrarTurmas(){
    if(turmas.size() == 0){
      System.out.println("Esse curso não possui turmas");//verifica se o curso possui turmas
      return;
    }
    for(int i=0; i < turmas.size(); i++){//mostra as turmas do curso
      turmas.get(i).infoTurma();//mostra as turmas do curso
    }
  }

  public void addTurma(Turma t){
    turmas.add(t);
  }
  
}