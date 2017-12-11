package org.itbparnamirim.kadosh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Geraldo e Rafael
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id",  
        nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class Membro extends AbstractModel implements Serializable {

    private String nome;
    private String telefone;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    private String usuario;
    private String senha;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataBatismoApresentacao;

    private Boolean lider;
    private Boolean tesoureiro;
    private Boolean professor;
    private Boolean administrador;

    @ManyToOne(optional = true)
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Ministerio> ministerios;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Turma> turmas;
   
//    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy="membros")
    private List<Meditacao> meditacoes;
    
    @OneToMany
    private List<Matricula> matriculas;
    
    public Membro() {
        nome = "";
        telefone = "";
        email = "";
        dataNascimento = null;
        usuario = "";
        senha = "";
        dataBatismoApresentacao = null;
        grupo = null;
        lider = false;
        tesoureiro = false;
        professor = false;
        administrador = false;
        ministerios = new ArrayList<>();
        turmas = new ArrayList<>();
        meditacoes = new ArrayList<>();
    }

    public Boolean getLider() {
        return lider;
    }

    public void setLider(Boolean lider) {
        this.lider = lider;
    }

    public Boolean getTesoureiro() {
        return tesoureiro;
    }

    public void setTesoureiro(Boolean tesoureiro) {
        this.tesoureiro = tesoureiro;
    }

    public Boolean getProfessor() {
        return professor;
    }

    public void setProfessor(Boolean professor) {
        this.professor = professor;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataBatismoApresentacao() {
        return dataBatismoApresentacao;
    }

    public void setDataBatismoApresentacao(Date dataBatismoApresentacao) {
        this.dataBatismoApresentacao = dataBatismoApresentacao;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Ministerio> getMinisterios() {
        return ministerios;
    }

    public void setMinisterios(List<Ministerio> ministerios) {
        this.ministerios = ministerios;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public List<Meditacao> getMeditacoes() {
        return meditacoes;
    }

    public void setMeditacoes(List<Meditacao> meditacoes) {
        this.meditacoes = meditacoes;
    }
    
    public void adicionarMinisterio(Ministerio ministerio) {
        this.ministerios.add(ministerio);
    }

    public void removerMinisterio(Ministerio ministerio) {
        this.ministerios.remove(ministerio);
    }
    
    public void adicionarMeditacao(Meditacao meditacao){
        this.meditacoes.add(meditacao);
        meditacao.adicionarMembro(this);
    }

    public void removerMeditacao(Meditacao meditacao){
        this.meditacoes.remove(meditacao);
        meditacao.removerMembro(this);
    }
    
    public boolean naoMeditou(Meditacao meditacao){
        return !this.meditacoes.contains(meditacao);
    }
    
    @Override
    public boolean equals(Object outro) {
        if (!(outro instanceof Membro)) {
            return false;
        }
        Membro outroMembro = (Membro) outro;
        if (this.id == null || outroMembro.getId() == null) {
            return false;
        }
        return this == outroMembro || this.id.equals(outroMembro.getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
