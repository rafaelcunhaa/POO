import java.util.List;

public class Restaurante {
    private String nome;
    private double nota;
    private String horarioFuncionamento;
    private List<String> cardapio;
    private double custoMedio;

    public Restaurante(String nome, double nota, String horarioFuncionamento, List<String> cardapio, double custoMedio) {
        this.nome = nome;
        this.nota = nota;
        this.horarioFuncionamento = horarioFuncionamento;
        this.cardapio = cardapio;
        this.custoMedio = custoMedio;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public List<String> getCardapio() {
        return cardapio;
    }

    public void setCardapio(List<String> cardapio) {
        this.cardapio = cardapio;
    }

    public double getCustoMedio() {
        return custoMedio;
    }

    public void setCustoMedio(double custoMedio) {
        this.custoMedio = custoMedio;
    }
}
