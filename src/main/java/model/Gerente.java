package model;

public class Gerente extends Pessoa{
    private String cpf;
    private String telefone;

    public Gerente(String nome, String email, String senha, String cpf,String telefone){
        super(nome,email,senha);
        this.cpf=cpf;
        this.telefone=telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void addItem(){
        System.out.println("Adicionando item");

    }
    public void removerItem(){
        System.out.println("Removendo item");

    }
    public void acompanharPedido(){
        System.out.println("Acompanhando pedido");

    }
    public void mudarStatusPedido(){
        System.out.println("Mudando status do pedido");
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}