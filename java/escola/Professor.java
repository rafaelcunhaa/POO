import java.util.*;

public class Professor {
  private String nome;
  private String endereco;
  private static ArrayList<Turma> turmas = new ArrayList<Turma>();

  //CONSTRUTOR 
  public Professor(String n, String e){
    nome = n;
    endereco = e;
    turmas = new ArrayList<Turma>();
  }

  //GETS E SETS
  public String getNome(){
    return nome;
  }

  public String getEndereco(){
    return endereco;
  }

  public void setNome(String n){
    nome = n;
  }

  public void setEndereco(String e){
    endereco = e;
  }


  //METODOS GERAIS
  public String toString(){
    return "- " + nome + " (" + endereco + ")";
  }

  public void mostrarTurmas(){
    if(turmas.size() == 0){
      System.out.println("Esse professor não possui turmas");
      return;
    }
    for(int i=0; i < turmas.size(); i++){
      turmas.get(i).infoTurma();
    }
  }

  public void addTurma(Turma t){
    turmas.add(t);
  }
  
}