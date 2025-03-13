
public class Heroi extends Personagem{

  
  private final Cla cla; //
  
  public Heroi(String n, double v, double a, Cla c){
    super.setNome(n);
    super.setNivel(1);
    super.setVida(v * c.getVidaEspecial());
    super.setAtaque(a);
    super.setAbates(0);
    this.cla = c;
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

  public Cla getCla(){
    return cla;
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

  public boolean atacar(Personagem vilao){
    
    int ataqueComSucesso = (int)(Math.random()*2);

    if(ataqueComSucesso == 0) return false;

    if(vilao.getVida() <= 0){
      System.out.println("O vilão está morto!");
      return false;
    }

    vilao.setVida(vilao.getVida() - this.getAtaque());
    
   // caso o vilão estar com 0 ou menos de vida 
    if(vilao.getVida() <= 0){
      this.setAbates(this.getAbates() + 1);
      int totalAbates = this.getAbates();
      if(totalAbates >= 3){
        this.setNivel(this.getNivel() + 1);
        this.setVida(this.getVida() * 1.5);
        this.setAtaque(this.getAtaque() * 1.5);
        this.setAbates(0);
      }
    }

    if(vilao.getVida() <= 0) System.out.println("O vilão morreu!");
    
    return true;
  }

  public void mostrarDados(){
    System.out.println("\nNOME: " + this.getNome());
    System.out.println("NÍVEL: " + this.getNivel());
    System.out.println("VIDA: " + this.getVida());
    System.out.println("ATAQUE: " + this.getAtaque());
    System.out.println("ABATES: " + this.getAbates());
    System.out.println("CLA: " + this.getCla().getNome());
  }

  public boolean ehVilao(){
    return false;
  }

}