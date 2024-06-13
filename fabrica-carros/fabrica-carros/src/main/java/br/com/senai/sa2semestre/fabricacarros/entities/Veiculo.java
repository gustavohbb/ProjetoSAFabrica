package br.com.senai.sa2semestre.fabricacarros.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe que representa um veiculo com chassi, modelo, ano, cor e peças.
 */
@Entity
public class Veiculo {
    @Id
    @Column(name = "chassi", unique = true)
    private String chassi;
    private String modelo;
    private int ano;
    private String cor;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "veiculos_pecas",
            joinColumns = {@JoinColumn(name = "chassi")},
            inverseJoinColumns = {@JoinColumn(name = "idPecas")}
    )
    private Set<Pecas> pecas = new HashSet<>();

    public Veiculo(String chassi, String modelo, int ano, String cor, Set<Pecas> pecas) {
        this.chassi = chassi;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.pecas = pecas;
    }

    public Veiculo() {
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Set<Pecas> getPecas() {
        return pecas;
    }

    public void setPecas(Set<Pecas> pecas) {
        this.pecas = pecas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Veiculo veiculo = (Veiculo) o;

        if (ano != veiculo.ano) return false;
        if (!chassi.equals(veiculo.chassi)) return false;
        if (!Objects.equals(modelo, veiculo.modelo)) return false;
        if (!Objects.equals(cor, veiculo.cor)) return false;
        return Objects.equals(pecas, veiculo.pecas);
    }

    @Override
    public int hashCode() {
        int result = chassi.hashCode();
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + ano;
        result = 31 * result + (cor != null ? cor.hashCode() : 0);
        result = 31 * result + (pecas != null ? pecas.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "chassi=" + chassi +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", pecas=" + pecas +
                '}';
    }
}
