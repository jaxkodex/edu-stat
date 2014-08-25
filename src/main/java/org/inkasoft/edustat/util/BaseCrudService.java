package org.inkasoft.edustat.util;

import java.util.List;

public interface BaseCrudService <T, ID> {
	
	public T create(T object) throws Exception;
	public T loadById(ID id);
	public List<T> findAll ();
	public T update (T object) throws Exception;
	public void delete (ID id);

}
