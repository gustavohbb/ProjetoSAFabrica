package br.com.senai.sa2semestre.fabricacarros.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Producao {
    @Id
    @GeneratedValue
    private Long idProducao;
    private LocalDateTime datahora;
    @ManyToOne
    @JoinColumn(name = "IdPecas", referencedColumnName = "idPecas")
    private Pecas pecas;
    @OneToMany(mappedBy = "producao")
    private List<Qualidade> listaDeQualidade;
    private Long quantidadeProduzida;
    private String estado;

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
        return idProducao.equals(producao.idProducao) && Objects.equals(datahora, producao.datahora) && Objects.equals(pecas, producao.pecas) && Objects.equals(listaDeQualidade, producao.listaDeQualidade) && Objects.equals(quantidadeProduzida, producao.quantidadeProduzida) && Objects.equals(estado, producao.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducao, datahora, pecas, listaDeQualidade, quantidadeProduzida, estado);
    }

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
