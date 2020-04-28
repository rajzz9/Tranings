package com.spring.vardhan.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Marks {
	private Integer english;
	private Integer hindhi;
	private Integer maths;
	private Integer science;
	private Integer social;
	private Integer french;

	public Marks() {
		super();
	}

	public Marks(Integer english, Integer hindhi, Integer maths) {
		super();
		this.english = english;
		this.hindhi = hindhi;
		this.maths = maths;
	}

	public Marks(Integer english, Integer hindhi, Integer maths, Integer science) {
		this(english, hindhi, maths);
		this.science = science;
	}

	public Marks(Integer english, Integer hindhi, Integer maths, Integer science, Integer social) {
		this(english, hindhi, maths, science);
		this.social = social;
	}

	public Marks(Integer english, Integer hindhi, Integer maths, Integer science, Integer social, Integer french) {
		this(english, hindhi, maths, science, social);
		this.french = french;
	}

	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}

	public Integer getHindhi() {
		return hindhi;
	}

	public void setHindhi(Integer hindhi) {
		this.hindhi = hindhi;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Integer getScience() {
		return science;
	}

	public void setScience(Integer science) {
		this.science = science;
	}

	public Integer getSocial() {
		return social;
	}

	public void setSocial(Integer social) {
		this.social = social;
	}

	public Integer getFrench() {
		return french;
	}

	public void setFrench(Integer french) {
		this.french = french;
	}

	@Override
	public String toString() {
		return "Marks [english=" + english + ", hindhi=" + hindhi + ", maths=" + maths + ", science=" + science
				+ ", social=" + social + ", french=" + french + "]";
	}

}
