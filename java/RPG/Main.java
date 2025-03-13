
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  public static ArrayList<Heroi> herois = new ArrayList<Heroi>();
  public static ArrayList<Vilao> viloes = new ArrayList<Vilao>();
  public static ArrayList<Cla> clas = new ArrayList<Cla>();
  public static ArrayList<Gangue> gangues = new ArrayList<Gangue>();
  
  public static void main(String[] args) {
    int opcao;
    Scanner sc = new Scanner(System.in);
    
    do{
      System.out.println("\n\tMENU DE AÇÕES");
      System.out.println("01. Criar um CLÃ");
      System.out.println("02. Criar uma GANGUE");
      System.out.println("03. Criar um HERÓI");
      System.out.println("04. Criar um VILÃO");
      System.out.println("05. Exibir dados de um HERÓI");
      System.out.println("06. Exibir dados de um VILÃO");
      System.out.println("07. Gerar um ataque");
      System.out.println("08. Adicionar vida a um personagem");
      System.out.println("00. Sair");
      System.out.print("Digite a opção desejada: ");
      opcao = sc.nextInt();

      if(opcao == 1){
        CriarCla(sc);
      }
      else if(opcao == 2){
        CriarGangue(sc);
      }
      else if(opcao == 3){
        CriarHeroi(sc);
      }
      else if(opcao == 4){
        CriarVilao(sc);
      }
      else if(opcao == 5){
        ExibirDadosDeHeroi(sc);
      }
      else if(opcao == 6){
        ExibirDadosDeVilao(sc);
      }
      else if(opcao == 7){
        GerarAtaque(sc);
      }
      else if(opcao == 8){
        AdicionarVida(sc);
      }
      
    }while(opcao != 0);

    sc.close();
  }

  public static void mostrarClas(){
    for(int i = 0; i < clas.size(); i++){
      System.out.println("\n" + i + ":");
      clas.get(i).mostrarCla();
    }
  }

  public static void mostrarGangues(){
    for(int i = 0; i < gangues.size(); i++){
      System.out.println("\n" + i + ":");
      gangues.get(i).mostrarGangue();
    }
  }

  public static void mostrarHerois(){
    for(int i=0; i < herois.size(); i++){
      System.out.println(i + ". " + herois.get(i).getNome());
    }
  }
  
  public static void mostrarViloes(){
    for(int i=0; i < viloes.size(); i++){
      System.out.println(i + ". " + viloes.get(i).getNome());
    }
  }
  
  public static void CriarCla(Scanner sc){

    String nome, gritoDeGuerra;
    double vidaEspecial;

    sc.nextLine();
    System.out.println("Digite o nome do CLÃ");
    nome = sc.nextLine();

    System.out.println("Insira o grito de guerra do CLÃ");
    gritoDeGuerra = sc.nextLine();

    System.out.println("Insira a porcentagem de vida extra dos membros do CLÃ");
    vidaEspecial = sc.nextDouble();

    Cla novoCla = new Cla(nome, vidaEspecial, gritoDeGuerra);
    clas.add(novoCla);
    
  }

  public static void CriarGangue(Scanner sc){

    String nome, gritoDeGuerra;
    double ataqueEspecial;

    sc.nextLine();
    System.out.println("Digite o nome da GANGUE");
    nome = sc.nextLine();

    System.out.println("Insira o grito de guerra da GANGUE");
    gritoDeGuerra = sc.nextLine();

    System.out.println("Insira a porcentagem de vida extra dos membros da GANGUE: ");
    ataqueEspecial = sc.nextDouble();

    Gangue novaGangue = new Gangue(nome, ataqueEspecial, gritoDeGuerra);
    gangues.add(novaGangue);

  }

  public static void CriarHeroi(Scanner sc){

    String nome;
    double vida, ataque;
    Cla cla;

    if(clas.isEmpty()){
      System.out.println("Não há CLÃs cadastrados");
      return;
    };

    sc.nextLine();
    System.out.println("Digite o nome do HEROI");
    nome = sc.nextLine();

    System.out.println("Digite a vida do HEROI");
    vida = sc.nextDouble();

    System.out.println("Digite o ataque do HEROI");
    ataque = sc.nextDouble();

    mostrarClas();
    System.out.println("\nDigite o numero do cla do HEROI");
    cla = clas.get(sc.nextInt());

    Heroi novoHeroi = new Heroi(nome, vida, ataque, cla);
    herois.add(novoHeroi);
  }

  public static void CriarVilao(Scanner sc){

    String nome;
    double vida, ataque;
    Gangue gangue;

    if(gangues.isEmpty()){
      System.out.println("Não há GANGUES cadastradas");
      return;
    };

    sc.nextLine();
    System.out.println("Digite o nome do VILÃO");
    nome = sc.nextLine();

    System.out.println("Digite a vida do VILÃO");
    vida = sc.nextDouble();

    System.out.println("Digite o ataque do VILÃO");
    ataque = sc.nextDouble();

    mostrarGangues();
    System.out.println("\nDigite o numero do cla do VILÃO");
    gangue = gangues.get(sc.nextInt());

    Vilao novoVilao = new Vilao(nome, vida, ataque, gangue);
    viloes.add(novoVilao);
  }

  public static void ExibirDadosDeHeroi(Scanner sc){
    mostrarHerois();
    System.out.println("\nDigite o numero do herói desejado");
    Heroi heroi = herois.get(sc.nextInt());
    heroi.mostrarDados();
  }
  
  public static void ExibirDadosDeVilao(Scanner sc){
    mostrarViloes();
    System.out.println("\nDigite o numero do vilão desejado");
    Vilao vilao = viloes.get(sc.nextInt());
    vilao.mostrarDados();
  }

  public static void GerarAtaque(Scanner sc){
    int opcao;
    Heroi heroi;
    Vilao vilao;

    mostrarHerois();
    System.out.println("\nDigite o numero do herói desejado");
    heroi = herois.get(sc.nextInt());

    mostrarViloes();
    System.out.println("\nDigite o numero do vilão desejado");
    vilao = viloes.get(sc.nextInt());

    System.out.println("\nDigite 1 para atacar o VILÃO ou 2 para atacar o HERÓI");
    opcao = sc.nextInt();

    if(opcao == 1){
      if(heroi.atacar(vilao)) System.out.println("\nO HERÓI atacou o VILÃO");
      else System.out.println("\nO VILÃO desviou do ataque do HERÓI");
    }
    else if(opcao == 2){
      if(vilao.atacar(heroi)) System.out.println("\nO VILÃO atacou o HERÓI");
      else System.out.println("\nO HERÓI desviou do ataque do VILÃO");
    }
    else System.out.println("\nOpção inválida");
  }

  public static void AdicionarVida(Scanner sc){
    int opcao;
    double cura;
    Heroi heroi = null;
    Vilao vilao = null;

    mostrarHerois();
    System.out.println("\nDigite o numero do herói desejado(-1 para vilão)");
    opcao = sc.nextInt();
    
    if(opcao == -1){
      mostrarViloes();
      System.out.println("\nDigite o numero do vilão desejado");
      vilao = viloes.get(sc.nextInt());
    }else{
      heroi = herois.get(opcao);
    }
    
    System.out.println("\nDigite a quantidade de vida a ser adicionada");
    cura = sc.nextDouble();

    if(opcao == -1){
      vilao.curar(cura);
    }else{
      heroi.curar(cura);
    }
  }
}