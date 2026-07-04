package model;

public class Gerente extends Pessoa{
    private String cpf;

    public Gerente(String id, String nome, String email, String senha, String cpf){
        super(id,nome,email,senha);
        this.cpf=cpf;
    }
    public String getTipo(){
        return "Gerente";
    }

    public String getCpf() {
        return cpf;
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
                '}';
    }
}