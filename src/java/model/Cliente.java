package model;

public class Cliente extends Pessoa{
    private String cpf;
    private String telefone;
    private String endereco;

    public Cliente(String id, String nome, String email, String senha, String cpf, String telefone, String endereco){
        super(id,nome,email,senha);
        this.cpf=cpf;
        this.telefone=telefone;
        this.endereco=endereco;
    }
    public String getTipo(){
        return "Cliente";
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
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
                "CPF='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
