package br.com.fiap.toytrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TDS_TB_BRINQUEDOS")
public class Brinquedo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brinquedo_seq"
    )
    @SequenceGenerator(
            name = "brinquedo_seq",
            sequenceName = "SQ_TDS_BRINQUEDOS",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column( nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, length = 20)
    private String classificacao;

    @Column(nullable = false, length = 20)
    private String tamanho;

    @Column(nullable = false)
    private Double preco;

    public Brinquedo() {}

    public Brinquedo(
            String nome,
            String tipo,
            String classificacao,
            String tamanho,
            Double preco
    ) {
        this.nome = nome;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
