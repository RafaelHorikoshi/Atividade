package modelo;

public class Situacao extends Objeto{
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Situacao() {
    }

    public Situacao(String descricao, int id) {
        super(id);
        this.descricao = descricao;
    }

    public Situacao(String descricao) {
        this.descricao = descricao;
    }
    
}
