package com.capgemini.healthcare.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class DiagnosticCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "centerId_generator")
	@SequenceGenerator(name = "centerId_generator", initialValue = 1001, allocationSize = 1)
	private long centerId;

	@Column(name="center_name",length=25)
	private String centerName;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Test.class)
	@JoinColumn(name = "center_Id", referencedColumnName = "centerId")
	private List<Test> test;

	public long getCenterId() {
		return centerId;
	}

	public void setCenterId(long centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public List<Test> getTest() {
		return test;
	}

	public void setTest(List<Test> test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "Center [centerId=" + centerId + ", centerName=" + centerName + ", test=" + test + "]";
	}

	public DiagnosticCenter(long centerId, String centerName) {

		this.centerId = centerId;
		this.centerName = centerName;
	}

	public DiagnosticCenter() {

	}
}
