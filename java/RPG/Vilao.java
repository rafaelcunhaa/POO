
public class Vilao extends Personagem{

  private final Gangue gangue;

  public Vilao(String n, double v, double a, Gangue g){
    super.setNome(n);
    super.setNivel(1);
    super.setVida(v);
    super.setAtaque(a * g.getAtaqueEspecial());
    super.setAbates(0);
    this.gangue = g;
  }

  public String getNome(){
    return super.getNome();
  }

  public int getNivel(){
    return super.getNivel();
  }

  public double getVida(){
    return super.getVida();  
  }

  public double getAtaque(){
    return super.getAtaque();
  }

  public int getAbates(){
    return super.getAbates();
  }

  public Gangue getGangue(){
    return gangue;
  }

  public void setNome(String n){
    super.setNome(n);
  }

  public void setNivel(int n){
    super.setNivel(n);
  }

  public void setVida(double v){
    super.setVida(v);
  }

  public void setAbates(int a){
    super.setAbates(a);
  }

  public boolean atacar(Personagem heroi){

    int ataqueComSucesso = (int)(Math.random()*2);

    if(ataqueComSucesso == 0) return false;

    if(heroi.getVida() <= 0){
      System.out.println("O herói está morto!");
      return false;
    }

    heroi.setVida(heroi.getVida() - this.getAtaque());

    if(heroi.getVida() <= 0){
      this.setAbates(this.getAbates() + 1);
      int totalAbates = this.getAbates();
      if(totalAbates >= 3){
        this.setNivel(this.getNivel() + 1);
        this.setVida(this.getVida() * 1.5);
        this.setAtaque(this.getAtaque() * 1.5);
        this.setAbates(0);
      }
    }

    if(heroi.getVida() <= 0) System.out.println("O herói morreu!");

    return true;
  }

  public void mostrarDados(){
    System.out.println("\nNOME: " + this.getNome());
    System.out.println("NÍVEL: " + this.getNivel());
    System.out.println("VIDA: " + this.getVida());
    System.out.println("ATAQUE: " + this.getAtaque());
    System.out.println("ABATES: " + this.getAbates());
    System.out.println("GANGUE: " + this.getGangue().getNome());
  }

  public boolean ehVilao(){
    return true;
  }
}