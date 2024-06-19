package br.com.senai.sa2semestre.fabricacarros.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * Classe Peça com as seguintes descricoes Id da Peca, Nome, Descricaoo e Quantidade.
 */
@Entity
public class Pecas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPecas;
    private String nome;
    private String descricao;
    private Long quantidade;
    @OneToMany(mappedBy = "pecas", cascade = {CascadeType.ALL})
    private List<Estoque> listaDeEstoque;
    @OneToMany(mappedBy = "pecas", cascade = {CascadeType.ALL})
    private List<Producao> producao;
    @ManyToMany(mappedBy = "pecas")
    private List<Veiculo> veiculos;

    /**
     * Construtor para a classe Pecas.
     *
     * @param idPecas        O identificador único da peça.
     * @param nome           O nome da peca.
     * @param descricao      A descricao da peca.
     * @param quantidade     A quantidade total da peca.
     * @param listaDeEstoque A lista de estoques onde a peca está disponível.
     * @param producao       A lista de producoes onde a peca é utilizada.
     * @param veiculos       A lista de veiculos que utilizam a peça.
     */
    public Pecas(Long idPecas, String nome, String descricao, Long quantidade, List<Estoque> listaDeEstoque, List<Producao> producao, List<Veiculo> veiculos) {
        this.idPecas = idPecas;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.listaDeEstoque = listaDeEstoque;
        this.producao = producao;
        this.veiculos = veiculos;
    }

    public Pecas() {
    }

    public Long getIdPecas() {
        return idPecas;
    }

    public void setIdPecas(Long idPecas) {
        this.idPecas = idPecas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public List<Estoque> getListaDeEstoque() {
        return listaDeEstoque;
    }

    public void setListaDeEstoque(List<Estoque> listaDeEstoque) {
        this.listaDeEstoque = listaDeEstoque;
    }

    public List<Producao> getProducao() {
        return producao;
    }

    public void setProducao(List<Producao> producao) {
        this.producao = producao;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pecas pecas = (Pecas) o;

        if (!idPecas.equals(pecas.idPecas)) return false;
        if (!Objects.equals(nome, pecas.nome)) return false;
        if (!Objects.equals(descricao, pecas.descricao)) return false;
        if (!Objects.equals(quantidade, pecas.quantidade)) return false;
        if (!Objects.equals(listaDeEstoque, pecas.listaDeEstoque))
            return false;
        if (!Objects.equals(producao, pecas.producao)) return false;
        return Objects.equals(veiculos, pecas.veiculos);
    }

    @Override
    public int hashCode() {
        int result = idPecas.hashCode();
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (quantidade != null ? quantidade.hashCode() : 0);
        result = 31 * result + (listaDeEstoque != null ? listaDeEstoque.hashCode() : 0);
        result = 31 * result + (producao != null ? producao.hashCode() : 0);
        result = 31 * result + (veiculos != null ? veiculos.hashCode() : 0);
        return result;
    }

    /**
     * Faz uma representacao do objeto em formato de String
     *
     * @return Representcao em formato de String
     */
    @Override
    public String toString() {
        return "Pecas{" +
                "idPecas=" + idPecas +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", listaDeEstoque=" + listaDeEstoque +
                ", producao=" + producao +
                ", veiculos=" + veiculos +
                '}';
    }
}