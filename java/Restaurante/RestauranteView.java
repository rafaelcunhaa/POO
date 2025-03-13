import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RestauranteView extends JFrame {
    private Restaurante restaurante;
    private JLabel nomeLabel;
    private JLabel notaLabel;
    private JLabel horarioLabel;
    private JTextArea cardapioArea;
    private JLabel custoLabel;

    public RestauranteView(Restaurante restaurante) {
        this.restaurante = restaurante;
        initUI();
    }

    private void initUI() {
        nomeLabel = new JLabel("Nome: " + restaurante.getNome());
        notaLabel = new JLabel("Nota: " + restaurante.getNota());
        horarioLabel = new JLabel("Horário: " + restaurante.getHorarioFuncionamento());
        cardapioArea = new JTextArea("Cardápio:\n" + String.join("\n", restaurante.getCardapio()));
        cardapioArea.setEditable(false);
        custoLabel = new JLabel("Custo Médio: R$" + restaurante.getCustoMedio());

        setLayout(new GridLayout(5, 1));
        add(nomeLabel);
        add(notaLabel);
        add(horarioLabel);
        add(new JScrollPane(cardapioArea));
        add(custoLabel);

        setTitle("Informações do Restaurante");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
        public void updateView() {
        nomeLabel.setText("Nome: " + restaurante.getNome());
        notaLabel.setText("Nota: " + restaurante.getNota());
        horarioLabel.setText("Horário: " + restaurante.getHorarioFuncionamento());
        cardapioArea.setText("Cardápio:\n" + String.join("\n", restaurante.getCardapio()));
        custoLabel.setText("Custo Médio: R$" + restaurante.getCustoMedio());
    }
}
