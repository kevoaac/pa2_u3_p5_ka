package com.uce.edu.ventas.repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Factura seleccionarPorNumero(String numero) {
        TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE numero = :numero", Factura.class);
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
    public void actualizar(Factura factura) {
        this.entityManager.merge(factura);
    }

    @Override
    public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
        // SQL: UPDATE factura SET fact_fecha=:fechaNueva WHERE fact_fecha >= :fechaActual
        // JPQL: UPDATE Factura f SET f.fecha = :fechNueva WHERE f.fecha >= :fechaActual

        Query myQuery = this.entityManager.createQuery("UPDATE Factura f SET f.fecha = :fechaNueva WHERE f.fecha >= :fechaActual");
        myQuery.setParameter("fechaNueva", fechaNueva);
        myQuery.setParameter("fechaActual", fechaActual);

        return myQuery.executeUpdate();
    }

    public Factura buscar(Integer id) {
        return this.entityManager.find(Factura.class, id);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.buscar(id));
    }

    @Override
    public int eliminarPorNumero(String numero) {
        // SQL: DELETE FROM factura f WHERE f.fact_numero = :numero
        // JPQL: DELETE FROM Factura f WHERE f.numero = :numero

        Query myQuery = this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero = :numero");
        myQuery.setParameter("numero", numero);

        return myQuery.executeUpdate();
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

    // JOIN WHERE
    @Override
    public List<Factura> seleccionarFacturasWhereJoin() {
        // SQL: SELECT f.* FROM factura f, detalle_factura d WHERE f.fact_id = d.defa_id_factura
        // JPQL: SELECT f FROM Factura f , DetalleFactura d WHERE f.id = d.factura.id
        // JPQL Simplificado: SELECT f FROM Factura f , DetalleFactura d WHERE f = d.factura (Comparamos Factura = Factura)

        // Hibernate: select f1_0.fact_id,f1_0.fact_cedula,f1_0.fact_fecha,f1_0.fact_numero from factura f1_0,detalle_factura df1_0 where f1_0.fact_id=df1_0.defa_id_factura
        TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f , DetalleFactura d WHERE f = d.factura", Factura.class);

        List<Factura> lista = myQuery.getResultList();
        for (Factura fact : lista) {
            fact.getDetallesFactura().size();
        }
        return lista;
    }

    // FETCH JOIN
    @Override
    public List<Factura> seleccionarFacturasFetchJoin() {
        // INNER JOIN
        // JPQL: SELECT f FROM Factura f INNER JOIN f.detallesFactura

        // FETCH JOIN
        // JPQL: SELECT f FROM Factura f JOIN FETCH f.detalleFactura d
        TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH f.detallesFactura d", Factura.class);

        return myQuery.getResultList();
    }

    @Override
    public List<FacturaDTO> seleccionarFacturasDTO() {
        TypedQuery<FacturaDTO> myQuery = this.entityManager.createQuery(
                "SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero, f.fecha) FROM Factura f "
                , FacturaDTO.class);
        return myQuery.getResultList();
    }
}
