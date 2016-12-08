package DAO;

import java.io.Serializable;

public class PersistableObject implements Serializable {
	
	private static final long serialVersionUID = 100L;
	
	protected Integer id;
	
	/*
	 * Constrictor for new Objects
	 */
	public PersistableObject() {
		this.id = -1;
	}
	
	/*
	 * Constrictor for existend Objects
	 */
	public PersistableObject(int id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}
}
