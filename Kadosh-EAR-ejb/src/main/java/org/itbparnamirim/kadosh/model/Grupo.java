package org.itbparnamirim.kadosh.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author geral_001
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id",  
        nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@NamedQuery(name = "findAllGrupos", query = "SELECT g FROM Grupo g")
public class Grupo extends AbstractModel implements Serializable {

    @OneToOne
    @JoinColumn(name = "tipo_grupo_id")
    private TipoGrupo tipo;
    
    private String localReuniao;
    private String diaSemana;

    @Temporal(TemporalType.TIME)
    private Date hora;

    @OneToOne
    private Membro lider;

    //EAGER significa guloso, ou seja, ja ira carregar essa lista ao retornar o grupo
    //mappedBy (atributo da classe) faz com que o mapeamento seja realizado sem criar tabela no meio (grupo_membro)
    @OneToMany(mappedBy = "grupo", targetEntity = Membro.class, fetch = FetchType.EAGER)
    private List<Membro> membrosGrupo = new ArrayList<>();

    public Grupo() {
        tipo = null;
        localReuniao = null;
        diaSemana = null;
        hora = null;
        lider = null;
    }

    public TipoGrupo getTipo() {
        return tipo;
    }

    public void setTipo(TipoGrupo tipo) {
        this.tipo = tipo;
    }

    public String getLocalReuniao() {
        return localReuniao;
    }

    public void setLocalReuniao(String localReuniao) {
        this.localReuniao = localReuniao;
    }

    public String getDiaSemana() {
        return this.diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Membro getLider() {
        return lider;
    }

    public void setLider(Membro lider) {
        this.lider = lider;
    }

    public List<Membro> getMembrosGrupo() {
        return membrosGrupo;
    }

    public void setMembrosGrupo(List<Membro> membrosGrupo) {
        this.membrosGrupo = membrosGrupo;
    }
    
    public void adicionarMembro(Membro membro){
        this.membrosGrupo.add(membro);
        membro.setGrupo(this);
    }
    
    public void removerMembro(Membro membro){
       this.membrosGrupo.remove(membro);
       membro.setGrupo(null);
    }

    //ToString para aparecer as informações dos grupos na lista, para o cadastro de membros
    @Override
    public String toString() {
        return this.tipo + "-" + this.localReuniao + "-" + this.diaSemana;
    }

    //Metodo sobrescrito para o converter do JSF retornar o objeto Grupo na lista, isso na tela de cadastro de membro
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Grupo)){
            return false;
        }
        Grupo outro = (Grupo) object;
        
        if (this.id == null || outro.getId() == null) {
            return false;
        }
        return this == object || this.id.equals(outro.getId());
    }

    //Outro metodo necessario para o converter
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
