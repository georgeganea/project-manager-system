package org.speedy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the programmers database table.
 * 
 */
@Entity
@Table(name="programmers")
public class Programmer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String status;

	//bi-directional many-to-one association to Assingment
	@OneToMany(mappedBy="programmer")
	private Set<Assingment> assingments;

    public Programmer() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Assingment> getAssingments() {
		return this.assingments;
	}

	public void setAssingments(Set<Assingment> assingments) {
		this.assingments = assingments;
	}
	
}