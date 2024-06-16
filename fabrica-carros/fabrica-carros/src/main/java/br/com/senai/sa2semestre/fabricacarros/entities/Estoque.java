package br.com.senai.sa2semestre.fabricacarros.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Classe que representa um estoque com um indetificador, peças e quantidade disponivel.
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

    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", pecas=" + pecas +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }
}
