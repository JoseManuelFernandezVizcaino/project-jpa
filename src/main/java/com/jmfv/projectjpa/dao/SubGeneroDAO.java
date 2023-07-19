/**
 * 
 */
package com.jmfv.projectjpa.dao;

import java.util.List;

import com.jmfv.projectjpa.entity.SubGenero;

/**
 * @author jmfer
 * Interface DAO que realiza el CRUD con JPA para la tabla subgenero
 */
public interface SubGeneroDAO {
	
	void guardar(SubGenero subgenero);
	
	void actualizar(SubGenero subgenero);
	
	void eliminar(Long id);
	
	List<SubGenero> consultar();
	
	SubGenero consultarById(Long id);
}
