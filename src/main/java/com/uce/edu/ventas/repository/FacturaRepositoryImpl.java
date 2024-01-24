package com.uce.edu.ventas.repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Factura seleccionarPorNumero(String numero) {
        TypedQuery<Factura> myQuery =
                this.entityManager.createQuery("SELECT f FROM Factura f WHERE numero = :numero", Factura.class);
        myQuery.setParameter("numero", numero);
        Factura fact = myQuery.getSingleResult();
        fact.getDetallesFactura().size(); // Carga el detalle bajo demanda
        return fact;
    }

    @Override
    public void insertar(Factura factura) {
        this.entityManager.persist(factura);
    }
}
