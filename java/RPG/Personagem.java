
abstract class Personagem{
  private String nome;
  private int nivel;
  private double vida;
  private double ataque;  
  private int abates;

  public String getNome(){
    return nome;
  }

  public int getNivel(){
    return nivel;
  }

  public double getVida(){
    return vida;
  }

  public double getAtaque(){
    return ataque;
  }

  public int getAbates(){
    return abates;
  }

  public void setNome(String n){
    nome = n;
  }
  
  public void setNivel(int n){
    nivel = n;
  }

  public void setVida(double v){
    vida = v;
  }

  public void setAtaque(double a){
    ataque = a;
  }

  public void setAbates(int a){
    abates = a;
  }

  public abstract boolean atacar(Personagem p);

  public void curar(double c){
    this.vida += c;
  }
}