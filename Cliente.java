package projeto.cap.oito.fiap;

// Supõe-se que Pessoa já possui id, nome, telefone e endereco.
public class Cliente extends Pessoa {

    private String cpf;
    private String rg;

    public Cliente(int id, String nome, String telefone, String endereco, String cpf, String rg) {
        super(id, nome, telefone, endereco); // Chama o construtor da superclasse
        this.cpf = cpf;
        this.rg = rg;
    }

    // Getters e setters para cpf e rg apenas, pois nome, telefone, e endereco são herdados de Pessoa
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public void ShowClient() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + this.cpf);
        System.out.println("RG: " + this.rg);
        System.out.println("Endereco: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + getNome() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", rg='" + getRg() + '\'' +
                '}';
    }
}
