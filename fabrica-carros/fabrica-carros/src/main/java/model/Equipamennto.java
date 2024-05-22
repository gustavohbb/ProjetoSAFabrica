package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Equipamennto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipameto;
    private String tipoEquipamento;
    private String descricao;
    private String estado;

    public Equipamennto(Long idEquipameto, String tipoEquipamento, String descricao, String estado) {
        this.idEquipameto = idEquipameto;
        this.tipoEquipamento = tipoEquipamento;
        this.descricao = descricao;
        this.estado = estado;
    }

    public Equipamennto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipamennto that = (Equipamennto) o;

        if (!idEquipameto.equals(that.idEquipameto)) return false;
        if (!Objects.equals(tipoEquipamento, that.tipoEquipamento))
            return false;
        if (!Objects.equals(descricao, that.descricao)) return false;
        return Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        int result = idEquipameto.hashCode();
        result = 31 * result + (tipoEquipamento != null ? tipoEquipamento.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Long getIdEquipameto() {
        return idEquipameto;
    }

    public void setIdEquipameto(Long idEquipameto) {
        this.idEquipameto = idEquipameto;
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
                "idEquipameto=" + idEquipameto +
                ", tipoEquipamento='" + tipoEquipamento + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
