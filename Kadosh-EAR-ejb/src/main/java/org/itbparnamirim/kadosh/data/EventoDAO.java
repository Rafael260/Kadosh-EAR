package org.itbparnamirim.kadosh.data;

import javax.ejb.Stateless;
import org.itbparnamirim.kadosh.model.Evento;

@Stateless
public class EventoDAO extends AbstractDAO<Evento> {

    public EventoDAO() {
        super(Evento.class);
    }
}
