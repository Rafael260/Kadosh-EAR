/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.ejb;

import javax.ejb.Local;
import org.itbparnamirim.kadosh.model.Meditacao;
import org.itbparnamirim.kadosh.model.Membro;

/**
 *
 * @author rafao
 */
@Local
public interface MeditacaoBeanLocal {

    void iniciarMeditacao(Meditacao meditacao, Membro membro);
    boolean acertouVersiculo(String versiculo);
    void finalizarMeditacao();
    
}
