
// ALUNOS:
// - RAFAEL DA CUNHA
// - JOÃO PEDRO TONATTO FRAGA

import java.util.*;

public class Main {

  public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
  public static ArrayList<Professor> professores = new ArrayList<Professor>();
  public static ArrayList<Curso> cursos = new ArrayList<Curso>();
  public static ArrayList<Turma> turmas = new ArrayList<Turma>();
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int op;

    do{
      System.out.println("\nMENU DE OPÇÕES");
      System.out.println("1. Alunos\n2. Professores\n3. Turmas\n4. Cursos\n5. Sair");
      System.out.println("Selecionado: ");
      op = sc.nextInt();
      sc.nextLine();

      if(op == 1)
        menu_alunos();
      else if(op == 2)
        menu_professores();
      else if(op == 3)
        menu_turmas();
      else if(op == 4)
        menu_cursos();
      else if(op != 5)
        System.out.println("Valor inválido!");
    }while(op != 5);
    System.out.println("Programa encerrado!");
  }

  public static void menu_alunos(){
    Scanner sc = new Scanner(System.in);
    int op;
    String nome, endereco;

    do{
      System.out.println("\nMENU DE ALUNOS");
      System.out.println("1. Adicionar aluno\n2. Remover aluno\n3. Listar alunos\n4. Verificar turmas de um aluno\n5. Sair");
      System.out.println("Selecionado: ");
      op = sc.nextInt();
      sc.nextLine();

      if(op == 1){
        System.out.println("Insira o nome do aluno");
        nome = sc.nextLine();
        System.out.println("Insira o endereço do aluno");
        endereco = sc.nextLine();

        alunos.add(new Aluno(nome, endereco));
      }else if(op == 2){
        System.out.println("Insira o nome do aluno");
        nome = sc.nextLine();

        for(int i=0; i<alunos.size(); i++){
          if(alunos.get(i).getNome().equals(nome)){
            alunos.remove(i);
            break;
          }
        }
      }else if(op == 3){
        System.out.println("Alunos cadastrados:");
        for(int i=0; i<alunos.size(); i++){
          System.out.println(alunos.get(i).toString());
        }
      }else if(op == 4){
        System.out.println("Insira o nome do aluno");
        nome = sc.nextLine();

        for(int i=0; i<alunos.size(); i++){
          if(alunos.get(i).getNome().equals(nome)){
            if(alunos.get(i).getNumeroTurmas() == 0){
              System.out.println("Esse aluno não possui turmas");
            }else{
              alunos.get(i).mostrarTurmas();
            }
            break;
          }
        }
      }else if(op!=5){
        System.out.println("Valor inválido!");
      }
    }while(op != 5);
  }

  public static void menu_professores(){
  Scanner sc = new Scanner(System.in);
  int opcao;
  String nome, endereco;
  do{
    System.out.println("\nMENU DE PROFESSORES");
    System.out.println("1. Adicionar professor\n2. Remover professor\n3. Listar professores\n4. Verificar turmas de um professor\n5. Sair");
    System.out.println("Selecionado: ");
    opcao = sc.nextInt();
    sc.nextLine();
    
   if(opcao == 1){
     System.out.println("Insira o nome do professor");
     nome = sc.nextLine();
     System.out.println("Insira o endereço do professor");
     endereco = sc.nextLine();

     professores.add(new Professor(nome, endereco));
   
   }else if(opcao == 2){
      System.out.println("Insira o nome do professor");
      nome = sc.nextLine();
      
      for(int i=0; i<professores.size(); i++){
        if(professores.get(i).getNome().equals(nome)){
          professores.remove(i);
          break;
        }
      }  
      
   }else if(opcao == 3){
      System.out.println("Professores cadastrados:");
      for(int i=0; i<professores.size(); i++){
        System.out.println(professores.get(i).toString());
      }
    
   }else if(opcao == 4){
      System.out.println("Insira o nome do professor");
      nome = sc.nextLine();
      for(int i=0; i<professores.size(); i++){
        if(professores.get(i).getNome().equals(nome)){
         professores.get(i).mostrarTurmas();
          break;
        }
      }
    }  
  }while(opcao != 5);
  }

  public static void menu_turmas(){
    Scanner sc = new Scanner(System.in);
    int op = 0;
    String semestre, ano, nomeProfessor, nomeCurso;

    do{
      System.out.println("\nMENU DE TURMAS");
      System.out.println("1. Criar turma\n2. Excluir turma\n3. Listar turmas existentes\n4. Verificar informações de uma turma\n5. Adicionar aluno a uma turma\n6. Sair");
      System.out.println("Selecionado: ");
      op = sc.nextInt();
      sc.nextLine();

      if(op == 1){
        System.out.println("Insira o ano da turma");
        semestre = sc.nextLine();
        
        System.out.println("Insira o semestre da turma");
        ano = sc.nextLine();
        
        System.out.println("\nLista de professores:");
        for(int i=0; i<professores.size(); i++){
          System.out.println(professores.get(i).toString());
        }
        System.out.println("Insira o nome do professor");
        nomeProfessor = sc.nextLine();
        for(int j=0; j<professores.size(); j++){
          
          if(professores.get(j).getNome().equals(nomeProfessor)){
            
            System.out.println("\nLista de cursos:");
            for(int k=0; k<cursos.size(); k++){
              System.out.println(cursos.get(k).toString());
            }
            
            System.out.println("Insira o nome do curso");
            nomeCurso = sc.nextLine();
            
            for(int l=0; l<cursos.size(); l++){
              
              if(cursos.get(l).getNome().equals(nomeCurso)){

                int semestreInt = Integer.parseInt(semestre);
                int anoInt = Integer.parseInt(ano);
                Turma novaTurma = new Turma(semestreInt, anoInt, cursos.get(l), professores.get(j));
                cursos.get(l).addTurma(novaTurma);
                professores.get(j).addTurma(novaTurma);
                turmas.add(novaTurma);
                System.out.println("Turma criada com sucesso!");
                break;
              }
            }
          }
        }      
      }
      else if(op == 2){
        System.out.println("Insira o ano da turma");
        semestre = sc.nextLine();

        System.out.println("Insira o semestre da turma");
        ano = sc.nextLine();

        for(int i=0; i<turmas.size(); i++){

          int semestreInt = Integer.parseInt(semestre);
          int anoInt = Integer.parseInt(ano);
          if(turmas.get(i).getSemestre() == semestreInt && turmas.get(i).getAno() == anoInt){
            turmas.remove(i);
          }
        }
      }
      else if(op == 3){
        System.out.println("Turmas cadastradas:");
        for(int i=0; i<turmas.size(); i++){
          System.out.println(turmas.get(i).toString());
        }
      }
      else if(op == 4){
        System.out.println("Insira o ano da turma");
        semestre = sc.nextLine();

        System.out.println("Insira o semestre da turma");
        ano = sc.nextLine();

        for(int i=0; i<turmas.size(); i++){
          
          int semestreInt = Integer.parseInt(semestre);
          int anoInt = Integer.parseInt(ano);
          if(turmas.get(i).getSemestre() == semestreInt && turmas.get(i).getAno() == anoInt){
            
            System.out.println("Informações da turma:");
            
            System.out.println("Ano: " + turmas.get(i).getAno());
            
            System.out.println("Semestre: " + turmas.get(i).getSemestre());
            
            System.out.println("Curso: " + turmas.get(i).getCurso().getNome());
            
            System.out.println("Professor: " + turmas.get(i).getProfessor().getNome());
            
            System.out.println("Alunos: ");
            
            for(int j=0; j<turmas.get(i).getAlunos().size(); j++){
              
              System.out.println("- " + turmas.get(i).getAlunos().get(j).getNome());
            }
            break;
          }
        }     
      }else if (op == 5) {
            System.out.println("Insira o ano da turma:");
            semestre = sc.nextLine();

            System.out.println("Insira o semestre da turma:");
            ano = sc.nextLine();

            Turma turmaSelecionada = null;
            for (Turma turma : turmas) {
                if (turma.getSemestre() == Integer.parseInt(semestre) && turma.getAno() == Integer.parseInt(ano)) {
                    turmaSelecionada = turma;
                    break;
                }
            }
        

            if (turmaSelecionada != null) {
                System.out.println("Alunos cadastrados:");
                for (int i = 0; i < alunos.size(); i++) {
                    System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                }
                System.out.println("Selecione o número do aluno que deseja adicionar à turma:");
                int numeroAluno = sc.nextInt();
                sc.nextLine();

                if (turmaSelecionada.getAlunos().size() <= 40) {
                  alunos.get(numeroAluno-1).addTurma(turmaSelecionada);
                  turmaSelecionada.adicionarAluno(alunos.get(numeroAluno - 1));
                  System.out.println("Aluno adicionado à turma com sucesso!");
                } else {
                    System.out.println("Não é possível adicionar mais alunos à turma, pois ela já atingiu o limite de 40 alunos.");
                }  
            } else {
                System.out.println("Turma não encontrada!");
            }
        }

      else if(op != 6){
        System.out.println("Valor inválido!");
      }
    }while(op != 6);
  }
  
  public static void menu_cursos(){
    Scanner sc = new Scanner(System.in);
    int op;
    String nome, sigla;

    do{
      System.out.println("\nMENU DE CURSOS");
      System.out.println("1. Adicionar novo curso\n2. Remover curso\n3. Listar cursos existentes\n4. Verificar informações de um curso\n5. Sair");
      System.out.println("Selecionado: ");
      op = sc.nextInt();
      sc.nextLine();

      if(op == 1){
        System.out.println("Insira o nome do curso");
        nome = sc.nextLine();

        System.out.println("Insira a sigla do curso");
        sigla = sc.nextLine();

        cursos.add(new Curso(nome, sigla));
      }
      else if(op == 2){
        System.out.println("Insira o nome do curso");
        nome = sc.nextLine();

        for(int i=0; i<cursos.size(); i++){
          if(cursos.get(i).getNome().equals(nome)){
            cursos.remove(i);
            break;
          }
        }
      }
      else if(op == 3){
        System.out.println("Lista de cursos:");
        for(int i=0; i < cursos.size(); i++){
          System.out.println(cursos.get(i).toString());
        }
      }
      else if(op == 4){
        System.out.println("Insira o nome do curso");
        nome = sc.nextLine();

        for(int i=0; i<cursos.size(); i++){
          if(cursos.get(i).getNome().equals(nome)){
            System.out.println(cursos.get(i).toString());
            cursos.get(i).mostrarTurmas();
            break;
          }
        }
      }
      else if(op != 5){
        System.out.println("Valor inválido!");
      }   
    }while(op != 5);
  }
}