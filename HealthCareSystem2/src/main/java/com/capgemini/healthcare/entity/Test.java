package com.capgemini.healthcare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "testId_generator")
	@SequenceGenerator(name = "testId_generator", initialValue = 101,allocationSize = 1)
	private long testId;
	private String testName;

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + "]";
	}

	public Test(long testId, String testName) {

		this.testId = testId;
		this.testName = testName;
	}

	public Test() {

	}

}