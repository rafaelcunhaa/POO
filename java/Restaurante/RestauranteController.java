import java.util.List;

public class RestauranteController {
    private Restaurante model;
    private RestauranteView view;

    public RestauranteController(Restaurante model, RestauranteView view) {
        this.model = model;
        this.view = view;
        // Aqui você pode adicionar listeners para a view, por exemplo:
        // this.view.addRatingListener(new RatingListener());
    }

    // Método para atualizar a nota do restaurante
    public void setNota(double nota) {
        model.setNota(nota);
        view.updateView();
    }

    // Método para adicionar um item ao cardápio
    public void addItemCardapio(String item) {
        List<String> cardapio = model.getCardapio();
        cardapio.add(item);
        model.setCardapio(cardapio);
        view.updateView();
    }

}

