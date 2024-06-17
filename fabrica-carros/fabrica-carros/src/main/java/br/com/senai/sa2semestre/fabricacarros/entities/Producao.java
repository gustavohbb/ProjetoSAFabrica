package br.com.senai.sa2semestre.fabricacarros.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Classe que representa a produção co  identificador, data e hora, peças, quantidade produzida e estado.
 */
@Entity
public class Producao {
    @Id
    @GeneratedValue
    private Long idProducao;
    private LocalDateTime datahora;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "IdPecas", referencedColumnName = "idPecas")
    private Pecas pecas;
    @OneToMany(mappedBy = "producao")
    private List<Qualidade> listaDeQualidade;
    private Long quantidadeProduzida;
    private String estado;

    /**
     * Constroi o objeto produção
     * @param idProducao Identificador da produção
     * @param datahora   Data e hora da produção
     * @param pecas  Peça sendo produzida
     * @param listaDeQualidade Inspeção da produção
     * @param quantidadeProduzida Quantidade produzida
     * @param estado Estado da produção
     */
    public Producao(Long idProducao, LocalDateTime datahora, Pecas pecas, List<Qualidade> listaDeQualidade, Long quantidadeProduzida, String estado) {
        this.idProducao = idProducao;
        this.datahora = datahora;
        this.pecas = pecas;
        this.listaDeQualidade = listaDeQualidade;
        this.quantidadeProduzida = quantidadeProduzida;
        this.estado = estado;
    }

    public Producao() {
    }

    public Long getIdProducao() {
        return idProducao;
    }

    public void setIdProducao(Long idProducao) {
        this.idProducao = idProducao;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public Pecas getPecas() {
        return pecas;
    }

    public void setPecas(Pecas pecas) {
        this.pecas = pecas;
    }

    public List<Qualidade> getListaDeQualidade() {
        return listaDeQualidade;
    }

    public void setListaDeQualidade(List<Qualidade> listaDeQualidade) {
        this.listaDeQualidade = listaDeQualidade;
    }

    public Long getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public void setQuantidadeProduzida(Long quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
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

        Producao producao = (Producao) o;

        if (!idProducao.equals(producao.idProducao)) return false;
        if (!Objects.equals(datahora, producao.datahora)) return false;
        if (!Objects.equals(pecas, producao.pecas)) return false;
        if (!Objects.equals(listaDeQualidade, producao.listaDeQualidade))
            return false;
        if (!Objects.equals(quantidadeProduzida, producao.quantidadeProduzida))
            return false;
        return Objects.equals(estado, producao.estado);
    }

    @Override
    public int hashCode() {
        int result = idProducao.hashCode();
        result = 31 * result + (datahora != null ? datahora.hashCode() : 0);
        result = 31 * result + (pecas != null ? pecas.hashCode() : 0);
        result = 31 * result + (listaDeQualidade != null ? listaDeQualidade.hashCode() : 0);
        result = 31 * result + (quantidadeProduzida != null ? quantidadeProduzida.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    /**
     * Faz uma representação do objeto em formato de String
     * @return Representção em formato de String
     */
    @Override
    public String toString() {
        return "Producao{" +
                "idProducao=" + idProducao +
                ", datahora=" + datahora +
                ", pecas=" + pecas +
                ", listaDeQualidade=" + listaDeQualidade +
                ", quantidadeProduzida=" + quantidadeProduzida +
                ", estado='" + estado + '\'' +
                '}';
    }
}
