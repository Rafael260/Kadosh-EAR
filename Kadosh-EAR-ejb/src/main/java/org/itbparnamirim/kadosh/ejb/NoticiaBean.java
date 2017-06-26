/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.itbparnamirim.kadosh.model.Noticia;

/**
 *
 * @author rafao
 */
@Stateless
public class NoticiaBean implements NoticiaBeanLocal {

    @Override
    public List<Noticia> getUltimasNoticias(List<Noticia> noticias) {
        List<Noticia> ultimasNoticias = new ArrayList<>();
        int numeroUltimasNoticias = 5;
        int qtdeNoticias = noticias.size();
        if (qtdeNoticias < numeroUltimasNoticias){
            numeroUltimasNoticias = qtdeNoticias;
        }
        
        for (int i = 1; i <= numeroUltimasNoticias; i++){
            ultimasNoticias.add(noticias.get(qtdeNoticias-i));
        }
        return ultimasNoticias;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
