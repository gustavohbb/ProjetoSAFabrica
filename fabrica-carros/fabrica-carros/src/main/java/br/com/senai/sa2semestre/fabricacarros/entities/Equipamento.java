package br.com.senai.sa2semestre.fabricacarros.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * Classe que representa um equipamento com id, tipo, dscrição e estado.
 */
@Entity
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamento;
    private String tipoEquipamento;
    private String descricao;
    private String estado;
    @OneToMany(mappedBy = "equipamento")
    private List<Manutencao> listaDemanutencoes;

    public Equipamento(Long idEquipameto, String tipoEquipamento, String descricao, String estado, List<Manutencao> listaDemanutencoes) {
        this.idEquipamento = idEquipameto;
        this.tipoEquipamento = tipoEquipamento;
        this.descricao = descricao;
        this.estado = estado;
        this.listaDemanutencoes = listaDemanutencoes;
    }

    public Equipamento() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipamento that = (Equipamento) o;

        if (!idEquipamento.equals(that.idEquipamento)) return false;
        if (!Objects.equals(tipoEquipamento, that.tipoEquipamento))
            return false;
        if (!Objects.equals(descricao, that.descricao)) return false;
        if (!Objects.equals(estado, that.estado)) return false;
        return Objects.equals(listaDemanutencoes, that.listaDemanutencoes);
    }

    @Override
    public int hashCode() {
        int result = idEquipamento.hashCode();
        result = 31 * result + (tipoEquipamento != null ? tipoEquipamento.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (listaDemanutencoes != null ? listaDemanutencoes.hashCode() : 0);
        return result;
    }

    public List<Manutencao> getListaDemanutencoes() {
        return listaDemanutencoes;
    }

    public void setListaDemanutencoes(List<Manutencao> listaDemanutencoes) {
        this.listaDemanutencoes = listaDemanutencoes;
    }

    public Long getIdEquipameto() {
        return idEquipamento;
    }

    public void setIdEquipameto(Long idEquipameto) {
        this.idEquipamento = idEquipameto;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Equipamennto{" +
                "idEquipameto=" + idEquipamento +
                ", tipoEquipamento='" + tipoEquipamento + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estado='" + estado + '\'' +
                ", listaDemanutencoes=" + listaDemanutencoes +
                '}';
    }
}
