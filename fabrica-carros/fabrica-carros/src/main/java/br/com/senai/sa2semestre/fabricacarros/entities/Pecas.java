package br.com.senai.sa2semestre.fabricacarros.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pecas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPecas;
    private String nome;
    private String descricao;
    private Long quantidade;
    @OneToMany(mappedBy = "pecas")
    private List<Estoque> listaDeEstoque;
    @OneToMany(mappedBy = "pecas")
    private  List<Producao> listaDeProducao;
    @ManyToMany(mappedBy = "pecas")
    private Set<Veiculo> veiculos = new HashSet<>();

    public Pecas(Long idPecas, String nome, String descricao, Long quantidade, List<Estoque> listaDeEstoque, List<Producao> listaDeProducao, Set<Veiculo> veiculos) {
        this.idPecas = idPecas;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.listaDeEstoque = listaDeEstoque;
        this.listaDeProducao = listaDeProducao;
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

    public List<Producao> getListaDeProducao() {
        return listaDeProducao;
    }

    public void setListaDeProducao(List<Producao> listaDeProducao) {
        this.listaDeProducao = listaDeProducao;
    }

    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pecas pecas = (Pecas) o;
        return idPecas.equals(pecas.idPecas) && Objects.equals(nome, pecas.nome) && Objects.equals(descricao, pecas.descricao) && Objects.equals(quantidade, pecas.quantidade) && Objects.equals(listaDeEstoque, pecas.listaDeEstoque) && Objects.equals(listaDeProducao, pecas.listaDeProducao) && Objects.equals(veiculos, pecas.veiculos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPecas, nome, descricao, quantidade, listaDeEstoque, listaDeProducao, veiculos);
    }

    @Override
    public String toString() {
        return "Pecas{" +
                "idPecas=" + idPecas +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", listaDeEstoque=" + listaDeEstoque +
                ", listaDeProducao=" + listaDeProducao +
                ", veiculos=" + veiculos +
                '}';
    }
}
