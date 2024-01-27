package com.uce.edu.ventas.repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Factura> seleccionarFacturasInnerJoin() {
        // SQL: SELECT * FROM factura f INNER JOIN detalle_factura d ON f.fact_id = d.defa_id_factura
        // JPQL: SELECT f FROM Factura f INNER JOIN f.detallesFactura

        // Hibernate: select f1_0.fact_id,f1_0.fact_cedula,f1_0.fact_fecha,f1_0.fact_numero from factura f1_0 join detalle_factura df1_0 on f1_0.fact_id=df1_0.defa_id_factura

        TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f INNER JOIN f.detallesFactura", Factura.class);

        myQuery.getResultList().forEach(System.out::println);
        return myQuery.getResultList();
    }

    @Override
    public List<Factura> seleccionarFacturasRightJoin() {
        // SQL: SELECT * FROM factura f RIGHT JOIN detalle_factura d ON f.fact_id = d.defa_id_factura
        // JPQL: SELECT f FROM Factura f RIGHT JOIN f.detallesFactura

        TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detallesFactura", Factura.class);

        myQuery.getResultList().forEach(fact -> fact.getDetallesFactura().size());
        return myQuery.getResultList();
    }

    @Override
    public List<Factura> seleccionarFacturasLeftJoin() {
        // SQL: SELECT * FROM factura f LEFT JOIN detalle_factura d ON f.fact_id = d.defa_id_factura
        // JPQL: SELECT f FROM Factura f LEFT JOIN f.detallesFactura

        TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detallesFactura", Factura.class);

        myQuery.getResultList().forEach(fact -> fact.getDetallesFactura().size());
        return myQuery.getResultList();
    }

    @Override
    public List<Factura> seleccionarFacturasFullJoin() {
        // SQL: SELECT * FROM factura f FULL JOIN detalle_factura d ON f.fact_id = d.defa_id_factura
        // JPQL: SELECT f FROM Factura f FULL JOIN f.detallesFactura

        TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f FULL JOIN f.detallesFactura", Factura.class);

        myQuery.getResultList().forEach(fact -> fact.getDetallesFactura().size());
        return myQuery.getResultList();
    }
}
