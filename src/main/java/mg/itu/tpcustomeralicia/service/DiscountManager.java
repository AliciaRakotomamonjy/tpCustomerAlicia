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
import mg.itu.tpcustomeralicia.entity.Discount;

/**
 *  Façage pour gérer les Discounts.
 * @author alici
 */
@RequestScoped
public class DiscountManager {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Méthode pour insérer un discount en passant en paramètre le discount à enregistrer.
     * @param discount 
     */
    @Transactional
    public void persist(Discount discount) {
        em.persist(discount);
    }

    /**
     * Méthode pour récuperer la liste des discounts.
     * @return 
     */
    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    /**
     * Méthode pour modifier un discount en passant en paramètre le discount à mettre à jour.
     * @param discount
     * @return 
     */
    @Transactional
    public Discount update(Discount discount) {
        return em.merge(discount);
    }
}
