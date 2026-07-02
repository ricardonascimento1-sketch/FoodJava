package model;

public class Cliente extends Pessoa{
    private String CPF;
    private String telefone;
    private String endereco;

    public Cliente(String nome, String email, String senha, String CPF, String telefone, String endereco){
        super(nome,email,senha);
        this.CPF=CPF;
        this.telefone=telefone;
        this.endereco=endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }
    public void verPedido(){
        System.out.println("Vendo!");
    }
    public void fazerPedido(){
        System.out.println("Fazendo pedido");
    }
    public void acompanharPedido(){
        System.out.println("Acompanhando");
    }
    public void cancelarPedido(){
        System.out.println("Mudando status do pedido");
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "CPF='" + CPF + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
