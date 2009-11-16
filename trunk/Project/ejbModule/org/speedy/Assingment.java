package org.speedy;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the assingments database table.
 * 
 */
@Entity
@Table(name="assingments")
public class Assingment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int assID;

	//bi-directional many-to-one association to Programmer
    @ManyToOne
	@JoinColumn(name="prgID")
	private Programmer programmer;

	//bi-directional many-to-one association to Task
    @ManyToOne
	@JoinColumn(name="tskID")
	private Task task;

    public Assingment() {
    }

	public int getAssID() {
		return this.assID;
	}

	public void setAssID(int assID) {
		this.assID = assID;
	}

	public Programmer getProgrammer() {
		return this.programmer;
	}

	public void setProgrammer(Programmer programmer) {
		this.programmer = programmer;
	}
	
	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
}