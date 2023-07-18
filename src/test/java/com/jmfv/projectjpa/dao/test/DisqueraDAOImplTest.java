/**
 * 
 */
package com.jmfv.projectjpa.dao.test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jmfv.projectjpa.dao.DisqueraDAO;
import com.jmfv.projectjpa.dao.impl.DisqueraDAOImpl;
import com.jmfv.projectjpa.entity.Disquera;

/**
 * @author jmfer
 *
 */
class DisqueraDAOImplTest {
	
	private DisqueraDAO disqueraDAO = new DisqueraDAOImpl();
	
	/**
	 * Test method for {@link com.jmfv.projectjpa.dao.impl.DisqueraDAOImpl#guardar(com.jmfv.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {
		
		Disquera disquera = new Disquera();
		
		disquera.setDescripcion("Elektrik");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		this.disqueraDAO.guardar(disquera);
	}

	/**
	 * Test method for {@link com.jmfv.projectjpa.dao.impl.DisqueraDAOImpl#actualizar(com.jmfv.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		 Disquera disqueraConsultada = this.disqueraDAO.consultarById(9L);
		 
		 disqueraConsultada.setDescripcion("Disquera IronMaiden");
		 
		 this.disqueraDAO.actualizar(disqueraConsultada);
	}

	/**
	 * Test method for {@link com.jmfv.projectjpa.dao.impl.DisqueraDAOImpl#eliminar(com.jmfv.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Long id = 9L;
		
		this.disqueraDAO.eliminar(id);
	}

	/**
	 * Test method for {@link com.jmfv.projectjpa.dao.impl.DisqueraDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {

		List<Disquera> disqueraConsultadas = this.disqueraDAO.consultar();
		
		assertTrue(disqueraConsultadas.size() > 0);
		
		disqueraConsultadas.forEach(disquera ->{
			System.out.println("Disquera: " + disquera.getDescripcion());
		});
	}

	/**
	 * Test method for {@link com.jmfv.projectjpa.dao.impl.DisqueraDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera = this.disqueraDAO.consultarById(9L);
		
		System.out.println("Disquera" + disquera.getDescripcion());
	}

}
