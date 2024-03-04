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
import mg.itu.tpcustomeralicia.entity.Customer;

/**
 * Façade pour gérer les Customers.
 *
 * @author alici
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Méthode pour insérer un customer en passant en paramètre le customer à enregistrer.
     * @param customer 
     */
    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    /**
     * Méthode pour récuperer la liste des customers.
     * @return 
     */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    /**
     * Méthode pour modifier un customer en passant en paramètre le customer à mettre à jour.
     * @param customer
     * @return 
     */
    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }
}
