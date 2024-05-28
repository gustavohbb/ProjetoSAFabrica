package br.com.senai.sa2semestre.fabricacarros.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
@Entity
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManutencao;
    @ManyToMany
    private Equipamento equipamento;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dateHoraFim;
    private String descricaoServico;
    private String estado;

    public Manutencao(Long idManutencao, Equipamento idEquipamento, LocalDateTime dataHoraInicio, LocalDateTime dateHoraFim, String descricaoServico, String estado) {
        this.idManutencao = idManutencao;
        this.equipamento = idEquipamento;
        this.dataHoraInicio = dataHoraInicio;
        this.dateHoraFim = dateHoraFim;
        this.descricaoServico = descricaoServico;
        this.estado = estado;
    }

    public Manutencao() {
    }

    public Long getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(Long idManutencao) {
        this.idManutencao = idManutencao;
    }

    public Equipamento getIdEquipamento() {
        return equipamento;
    }

    public void setIdEquipamento(Equipamento idEquipamento) {
        this.equipamento = idEquipamento;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDateHoraFim() {
        return dateHoraFim;
    }

    public void setDateHoraFim(LocalDateTime dateHoraFim) {
        this.dateHoraFim = dateHoraFim;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manutencao that = (Manutencao) o;

        if (!idManutencao.equals(that.idManutencao)) return false;
        if (!Objects.equals(equipamento, that.equipamento)) return false;
        if (!Objects.equals(dataHoraInicio, that.dataHoraInicio)) return false;
        if (!Objects.equals(dateHoraFim, that.dateHoraFim)) return false;
        if (!Objects.equals(descricaoServico, that.descricaoServico)) return false;
        return Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        int result = idManutencao.hashCode();
        result = 31 * result + (equipamento != null ? equipamento.hashCode() : 0);
        result = 31 * result + (dataHoraInicio != null ? dataHoraInicio.hashCode() : 0);
        result = 31 * result + (dateHoraFim != null ? dateHoraFim.hashCode() : 0);
        result = 31 * result + (descricaoServico != null ? descricaoServico.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Manutencao{" + "idManutencao=" + idManutencao + ", idEquipamento=" + equipamento + ", dataHoraInicio=" + dataHoraInicio + ", dateHoraFim=" + dateHoraFim + ", descricaoServico='" + descricaoServico + '\'' + ", estado='" + estado + '\'' + '}';
    }
}
