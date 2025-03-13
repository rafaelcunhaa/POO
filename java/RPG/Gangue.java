
public class Gangue extends Grupo{

  private String nome;
  private final double ataqueEspecial;

  public Gangue(String n, double v, String g){
    nome = n;
    ataqueEspecial = (v / 100) + 1;
    super.setQtdMembros(0);
    super.setGritoDeGuerra(g);
  }

  public String getGritoDeGuerra(){
    return super.getGritoDeGuerra();
  }

  public int getQtdMembros(){
    return getQtdMembros();
  }

  public String getNome(){
    return nome;
  }

  public double getAtaqueEspecial(){
    return ataqueEspecial;
  }

  public void setGritoDeGuerra(String g){
    super.setGritoDeGuerra(g);
  }

  public void setQtdeMembros(int q){
    super.setQtdMembros(q);
  }

  public void setNome(String n){
    nome = n;
  }

  public void mostrarGangue(){
    System.out.println("NOME: " + nome);
    System.out.println("Ataque ESPECIAL: " + (ataqueEspecial - 1) * 100 + "%");
    System.out.println("NÚMERO DE MEMBROS: " + super.getQtdMembros());
    System.out.println("GRITO DE GUERRA: " + super.getGritoDeGuerra());
  }
}