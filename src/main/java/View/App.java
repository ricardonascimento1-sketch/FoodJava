package View;

import Controller.AuthController;
import Controller.CardapioController;
import Controller.PedidoController;
import Controller.RestauranteController;
import exception.FoodJavaException;
import model.Categoria;
import model.Cliente;
import model.Gerente;
import model.ItemCardapio;
import model.ItemPedido;
import model.Pedido;
import model.StatusPedido;
import model.Pessoa;
import repository.AppData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.util.List;

public class App extends Application {
    private final AppData db = new AppData();
    private final RestauranteController restauranteController = new RestauranteController(db);
    private final AuthController authController = new AuthController(db);
    private final CardapioController cardapioController = new CardapioController(db);
    private final PedidoController pedidoController = new PedidoController(db);
    private Stage stage;
    private Pessoa usuarioLogado;
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("FoodJava");
        if (restauranteController.configurado()) {
            mostrarLogin();
        } else {
            mostrarConfiguracaoInicial();
        }
        stage.show();
    }

}
