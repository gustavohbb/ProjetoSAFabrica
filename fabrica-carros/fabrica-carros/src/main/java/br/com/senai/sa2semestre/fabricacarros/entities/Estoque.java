package br.com.senai.sa2semestre.fabricacarros.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Classe que representa um estoque com um indetificador, pecas e quantidade disponivel.
 */
@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idPecas", referencedColumnName = "idPecas")
    @JsonIgnore
    private Pecas pecas;
    private int quantidadeDisponivel;

    /**
     * Construtor para a classe Estoque.
     *
     * @param id                   O identificador único do estoque.
     * @param pecas                A peça associada ao estoque.
     * @param quantidadeDisponivel A quantidade disponivel da peca em estoque.
     */
    public Estoque(Long id, Pecas pecas, int quantidadeDisponivel) {
        this.id = id;
        this.pecas = pecas;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Estoque() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pecas getPecas() {
        return pecas;
    }

    public void setPecas(Pecas pecas) {
        this.pecas = pecas;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estoque estoque = (Estoque) o;

        if (quantidadeDisponivel != estoque.quantidadeDisponivel) return false;
        if (!id.equals(estoque.id)) return false;
        return Objects.equals(pecas, estoque.pecas);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (pecas != null ? pecas.hashCode() : 0);
        result = 31 * result + quantidadeDisponivel;
        return result;
    }

    /**
     * Faz uma representacao do objeto em formato de String
     *
     * @return Representcao em formato de String
     */
    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", pecas=" + pecas +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }
}
