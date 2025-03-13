
public class Cla extends Grupo{
  
  private String nome;
  private final double vidaEspecial;

  public Cla(String n, double v, String g){
    nome = n;
    vidaEspecial = (v / 100) + 1;
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

  public double getVidaEspecial(){
    return vidaEspecial;
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

  public void mostrarCla(){
    System.out.println("NOME: " + nome);
    System.out.println("VIDA ESPECIAL: " + (vidaEspecial - 1) * 100 + "%");
    System.out.println("NÚMERO DE MEMBROS: " + super.getQtdMembros());
    System.out.println("GRITO DE GUERRA: " + super.getGritoDeGuerra());
  }
}