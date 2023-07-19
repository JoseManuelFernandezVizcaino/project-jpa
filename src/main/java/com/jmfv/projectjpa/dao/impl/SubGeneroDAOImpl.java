/**
 * 
 */
package com.jmfv.projectjpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jmfv.projectjpa.dao.SubGeneroDAO;
import com.jmfv.projectjpa.entity.SubGenero;

/**
 * @author jmfer Clase que implementa el CRUD para las transacciones a la tabla
 *         subgenero
 */
public class SubGeneroDAOImpl implements SubGeneroDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceJMFV");

	/**
	 * Metodo que permite guardar un subgenero
	 * 
	 * @param subGenero {@link SubGenero} objeto a guardar
	 */
	@Override
	public void guardar(SubGenero subgenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(subgenero);
			et.commit();
		}catch(Exception e) {
			
			if(et != null) {
				et.rollback();
			}
			
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	/**
	 * Metodo que permite actualizar un subgenero
	 * 
	 * @param subGenero {@link SubGenero} objeto a guardar
	 */
	@Override
	public void actualizar(SubGenero subgenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.merge(subgenero);
			et.commit();
		}catch(Exception e) {
			
			if(et != null) {
				et.rollback();
			}
			
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	/**
	 * Metodo que permite eliminar un subgenero
	 * 
	 * @param id {@link Long} identificador del subgenero a eliminar
	 */
	@Override
	public void eliminar(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		SubGenero subGeneroConsultado = em.find(SubGenero.class, id);
		
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.remove(subGeneroConsultado);
			et.commit();
		}catch(Exception e) {
			
			if(et != null) {
				et.rollback();
			}
			
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	/**
	 * Metodo que permite consultar un subgenero
	 * 
	 * @param {@link List}lista de subgeneros consultados
	 */
	@Override
	public List<SubGenero> consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<SubGenero> queryTyped = (TypedQuery<SubGenero>) em.createQuery("FROM SubGenero ORDER BY descripcion");
		
		return queryTyped.getResultList();
	}

	/**
	 * Metodo que permite consultar un subgenero
	 * 
	 * @param id {@link Long} identificador del subgenero
	 */
	@Override
	public SubGenero consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		return em.find(SubGenero.class, id);
		
	}

}
