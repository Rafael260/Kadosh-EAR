package org.itbparnamirim.kadosh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.NamedQuery;

/**
 * Classe responsável por gerenciar os ministérios da igreja
 * @author Geraldo
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id",  
        nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@NamedQuery(name = "findAllMinisterios", query = "SELECT m FROM Ministerio m")
public class Ministerio extends AbstractModel implements Serializable {

    private String nome;
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "lider_id")
    private Membro lider;
    
    @ManyToMany
    List<Evento> eventosRelacionados;
    
    /**
     * Ministério possui uma lista de membros
     */
    @ManyToMany(fetch = FetchType.EAGER, mappedBy="ministerios", cascade=CascadeType.ALL)
    private List<Membro>membrosMinisterio = new ArrayList();

    public Ministerio() {
        eventosRelacionados = new ArrayList<>();
    }


    public void setMembrosDoMinisterio (List<Membro> membros){
        this.membrosMinisterio = membros;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Membro getLider() {
        return lider;
    }

    public void setLider(Membro lider) {
        this.lider = lider;
    }

    public List<Evento> getEventosRelacionados() {
        return eventosRelacionados;
    }

    public void setEventosRelacionados(List<Evento> eventosRelacionados) {
        this.eventosRelacionados = eventosRelacionados;
    }
    
    public List<Membro> getMembrosMinisterio() {
        return membrosMinisterio;
    }

    public void setMembrosMinisterio(List<Membro> membrosMinisterio) {
        this.membrosMinisterio = membrosMinisterio;
    }
    
    public void adicionarMembro (Membro membro){
        this.membrosMinisterio.add(membro);
        membro.adicionarMinisterio(this);
    }
    
    public void removerMembro (Membro membro){
        this.membrosMinisterio.remove(membro);
        membro.removerMinisterio(this);
    }
    
    @Override
    public String toString(){
        return this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ministerio other = (Ministerio) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
}
