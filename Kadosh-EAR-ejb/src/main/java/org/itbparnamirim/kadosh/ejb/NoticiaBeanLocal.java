/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.ejb;

import java.util.List;
import javax.ejb.Local;
import org.itbparnamirim.kadosh.model.Noticia;

/**
 *
 * @author rafao
 */
@Local
public interface NoticiaBeanLocal {

    List<Noticia> getUltimasNoticias(List<Noticia> noticias);
    
}
