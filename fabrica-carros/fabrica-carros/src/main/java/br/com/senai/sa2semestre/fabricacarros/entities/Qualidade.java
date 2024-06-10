package br.com.senai.sa2semestre.fabricacarros.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Qualidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInspecao;
    @ManyToOne
    @JoinColumn(name = "idProducao", referencedColumnName = "idProducao")
    private Producao producao;
    private LocalDateTime DataHora;
    private String resultado;
    private String comentarios;

    public Qualidade(Long idInspecao, Producao producao, LocalDateTime dataHora, String resultado, String comentarios) {
        this.idInspecao = idInspecao;
        this.producao = producao;
        DataHora = dataHora;
        this.resultado = resultado;
        this.comentarios = comentarios;
    }

    public Qualidade() {
    }

    public Long idInspecao() {
        return idInspecao;
    }

    public void setIdInspecao(Long idInspecao) {
        this.idInspecao = idInspecao;
    }

    public Producao producao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    public LocalDateTime DataHora() {
        return DataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        DataHora = dataHora;
    }

    public String resultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String comentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Qualidade qualidade = (Qualidade) o;

        if (!idInspecao.equals(qualidade.idInspecao)) return false;
        if (!Objects.equals(producao, qualidade.producao)) return false;
        if (!Objects.equals(DataHora, qualidade.DataHora)) return false;
        if (!Objects.equals(resultado, qualidade.resultado)) return false;
        return Objects.equals(comentarios, qualidade.comentarios);
    }

    @Override
    public int hashCode() {
        int result = idInspecao.hashCode();
        result = 31 * result + (producao != null ? producao.hashCode() : 0);
        result = 31 * result + (DataHora != null ? DataHora.hashCode() : 0);
        result = 31 * result + (resultado != null ? resultado.hashCode() : 0);
        result = 31 * result + (comentarios != null ? comentarios.hashCode() : 0);
        return result;
    }
}
