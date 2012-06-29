package hu.diplomatervezes.shared;

import java.io.Serializable;
import java.util.Date;

public class _OsztalyzatMOCK implements Serializable {

	private String id;
	private Date mikor;
	private int osztalyzat;
	private String osztalyzatStr;
	private String tipus;
	
	public _OsztalyzatMOCK(){
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getMikor() {
		return mikor;
	}

	public void setMikor(Date mikor) {
		this.mikor = mikor;
	}

	public int getOsztalyzat() {
		return osztalyzat;
	}

	public void setOsztalyzat(int osztalyzat) {
		this.osztalyzat = osztalyzat;
	}

	public String getOsztalyzatStr() {
		return osztalyzatStr;
	}

	public void setOsztalyzatStr(String osztalyzatStr) {
		this.osztalyzatStr = osztalyzatStr;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	
	
}
