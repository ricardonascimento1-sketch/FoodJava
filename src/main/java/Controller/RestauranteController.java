package Controller;
import exception.DocumentoInvalidoException;
import exception.SenhaInvalidaException;
import model.Gerente;
import model.Restaurante;
import repository.AppData;
import util.DocumentoValidator;
import util.SenhaUtil;


public class RestauranteController {
    private final AppData db;

    public RestauranteController(AppData db) {
        this.db = db;
    }
    public boolean configurado() {
        return db.restauranteConfigurado();
    }
    public Restaurante carregar() {
        return db.carregarRestaurante();
    }
    public Restaurante configurar(String nome, String cnpj, String endereco, String telefone, String categoria,
                                  String logotipoPath, String emailGerente, String senhaGerente)
            throws DocumentoInvalidoException, SenhaInvalidaException {
        if (!DocumentoValidator.cnpjValido(cnpj)) {
            throw new DocumentoInvalidoException("CNPJ inválido.");
        }
        SenhaUtil.validar(senhaGerente);
        Restaurante restaurante = new Restaurante(nome, DocumentoValidator.apenasDigitos(cnpj), endereco, telefone, categoria,
                logotipoPath, new Gerente(nome, emailGerente, SenhaUtil.hash(senhaGerente)));
        db.salvarRestaurante(restaurante);
        return restaurante;
    }
}
