package org.itbparnamirim.kadosh.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Geraldo Jr
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id",  
        nullable = false, columnDefinition = "BIGINT UNSIGNED"))
@NamedQuery(name = "findAllNoticias", query = "SELECT n FROM Noticia n")
public class Noticia extends AbstractModel implements Serializable {
    
    private String manchete;
    private String textoDaNoticia;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date validade;
    
    private String destinatario;

    public Noticia() {
    }
    
    public String getManchete() {
        return manchete;
    }

    public void setManchete(String manchete) {
        this.manchete = manchete;
    }

    public String getTextoDaNoticia() {
        return textoDaNoticia;
    }

    public void setTextoDaNoticia(String textoDaNoticia) {
        this.textoDaNoticia = textoDaNoticia;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
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
        final Noticia other = (Noticia) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
}
