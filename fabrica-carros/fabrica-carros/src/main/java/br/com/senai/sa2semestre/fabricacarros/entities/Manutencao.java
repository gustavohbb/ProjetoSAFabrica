package br.com.senai.sa2semestre.fabricacarros.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Classe que representa uma manutencao com identificador, equipamento usado, data e hora de inicio, data e hora do fim, descricao e estado.
 */
@Entity
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManutencao;
    @ManyToOne
    @JoinColumn(name = "idEquipamento", referencedColumnName = "idEquipamento")
    @JsonIgnore
    private Equipamento equipamento;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String descricaoServico;
    private String estado;

    /**
     * Cria uma instância do objeto Manutencao
     * @param idManutencao Identificador unico
     * @param idEquipamento Identificador do equipamento utilizado
     * @param dataHoraInicio Data e Hora do inicio da manutecao
     * @param dateHoraFim Data e Hora do fim da manuntecao
     * @param descricaoServico Descricao do que foi feito
     * @param estado Estado atual da manutencao
     */
    public Manutencao(Long idManutencao, Equipamento idEquipamento, LocalDateTime dataHoraInicio, LocalDateTime dateHoraFim, String descricaoServico, String estado) {
        this.idManutencao = idManutencao;
        this.equipamento = idEquipamento;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dateHoraFim;
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

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dateHoraFim) {
        this.dataHoraFim = dateHoraFim;
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
        if (!Objects.equals(dataHoraFim, that.dataHoraFim)) return false;
        if (!Objects.equals(descricaoServico, that.descricaoServico)) return false;
        return Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        int result = idManutencao.hashCode();
        result = 31 * result + (equipamento != null ? equipamento.hashCode() : 0);
        result = 31 * result + (dataHoraInicio != null ? dataHoraInicio.hashCode() : 0);
        result = 31 * result + (dataHoraFim != null ? dataHoraFim.hashCode() : 0);
        result = 31 * result + (descricaoServico != null ? descricaoServico.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    /**
     * Faz uma representacao do objeto em formato de String
     *
     * @return Representacao em formato de String
     */
    @Override
    public String toString() {
        return "Manutencao{" + "idManutencao=" + idManutencao + ", idEquipamento=" + equipamento + ", dataHoraInicio=" + dataHoraInicio + ", dateHoraFim=" + dataHoraFim + ", descricaoServico='" + descricaoServico + '\'' + ", estado='" + estado + '\'' + '}';
    }
}
