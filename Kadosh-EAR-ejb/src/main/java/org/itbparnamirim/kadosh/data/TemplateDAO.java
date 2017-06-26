/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itbparnamirim.kadosh.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class TemplateDAO {
    @PersistenceContext(unitName = "kadosh6PU")
    protected EntityManager em;
}
