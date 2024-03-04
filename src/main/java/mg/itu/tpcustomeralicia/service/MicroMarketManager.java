/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpcustomeralicia.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.itu.tpcustomeralicia.entity.MicroMarket;

/**
 *  Façage pour gérer les MicroMarkets.
 * @author alici
 */
@RequestScoped
public class MicroMarketManager {
    @PersistenceContext(unitName = "microMarketPU")
    private EntityManager em;

    /**
     * Méthode pour insérer un microMarket en passant en paramètre le microMarket à enregistrer.
     * @param microMarket 
     */
    @Transactional
    public void persist(MicroMarket microMarket) {
        em.persist(microMarket);
    }

    /**
     * Méthode pour récuperer la liste des microMarkets.
     * @return 
     */
    public List<MicroMarket> getAllMicroMarkets() {
        Query query = em.createNamedQuery("MicroMarket.findAll");
        return query.getResultList();
    }

    /**
     * Méthode pour modifier un microMarket en passant en paramètre le microMarket à mettre à jour.
     * @param microMarket
     * @return 
     */
    @Transactional
    public MicroMarket update(MicroMarket microMarket) {
        return em.merge(microMarket);
    }
}
