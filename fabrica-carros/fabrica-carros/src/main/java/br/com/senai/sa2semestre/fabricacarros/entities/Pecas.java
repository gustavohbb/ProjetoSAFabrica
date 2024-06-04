package br.com.senai.sa2semestre.fabricacarros.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pecas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPecas;
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "pecas")
    private Estoque estoque;
    @ManyToMany(mappedBy = "pecas")
    private Set<Veiculo> veiculos = new HashSet<>();

    public Pecas(Long idPecas, String nome, String descricao, Estoque estoque) {
        this.idPecas = idPecas;
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = estoque;
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

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pecas pecas = (Pecas) o;
        return idPecas.equals(pecas.idPecas) && Objects.equals(nome, pecas.nome) && Objects.equals(descricao, pecas.descricao) && Objects.equals(estoque, pecas.estoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPecas, nome, descricao, estoque);
    }

    @Override
    public String toString() {
        return "Pecas{" +
                "idPecas=" + idPecas +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estoque=" + estoque +
                '}';
    }
}
