package br.com.senai.sa2semestre.fabricacarros.entities;

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
        return quantidadeDisponivel == estoque.quantidadeDisponivel && id.equals(estoque.id) && Objects.equals(pecas, estoque.pecas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pecas, quantidadeDisponivel);
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
