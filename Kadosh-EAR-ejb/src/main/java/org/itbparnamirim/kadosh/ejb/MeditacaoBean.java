/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import org.itbparnamirim.kadosh.data.MembroDAO;
import org.itbparnamirim.kadosh.model.Meditacao;
import org.itbparnamirim.kadosh.model.Membro;

/**
 *
 * @author rafao
 */
@Stateful
public class MeditacaoBean implements MeditacaoBeanLocal {

    private Meditacao meditacao;
    private Membro membro;

    @EJB MembroDAO membroDAO;
    
    @Override
    public void iniciarMeditacao(Meditacao meditacao, Membro membro) {
        this.meditacao = meditacao;
        this.membro = membro;
    }
    
    //Metodo responsavel em colocar a string na forma normal para realizarmos a comparacao, 
    //de modo que exista certa tolerancia nas diferenças da tentativa do versiculo real
    private String getVersiculoFormaNormal(String versiculo){
        return versiculo.replace(",", "").replace(".", "").toLowerCase();
    }
    
    @Override
    public boolean acertouVersiculo(String versiculoTentativa){
        String versiculo = getVersiculoFormaNormal(meditacao.getVersiculoBase());
        String versiculoTentativaFN = getVersiculoFormaNormal(versiculoTentativa);
        return versiculo.equals(versiculoTentativaFN);
    }

    @Override
    public void finalizarMeditacao() {
        
    }

    
    
}
