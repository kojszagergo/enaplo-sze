package hu.diplomatervezes.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Random;

public class _RatingGen {

	private static final int[] ERDEMJEGY = {
		1, 2, 3, 4, 5
	};
	
	private static final String[] ERDEMJEGY_STR = {
		"Elégtelen", "Elégséges", "Közepes", "Jó", "Jeles"
	};
	
	private static final String[] TIPUS = {
		"Felelet", "Dolgozat", "Témazáró", "Házi dolgozat"
	};
	
	List<_OsztalyzatMOCK> osztalyzatok;
	
	private _RatingGen() {
		osztalyzatok = getOsztalyzatok();
	}
	
	private static _RatingGen instance;
	private int id = 0;
	
	
	
	public static _RatingGen get() {
		if (instance == null) {
			instance = new _RatingGen();
		}
		return instance = new _RatingGen();
	}
	
	public List<_OsztalyzatMOCK> getOsztalyzat() {
		return osztalyzatok;
	}
	
	public Double getAtlag() {
		Double osszeg = 0.0;
		for (_OsztalyzatMOCK jegy : osztalyzatok)
			osszeg += jegy.getOsztalyzat();
		return osszeg/osztalyzatok.size();
	}
	
	private List<_OsztalyzatMOCK> getOsztalyzatok() {
		List<_OsztalyzatMOCK> osztalyzatok = new ArrayList<_OsztalyzatMOCK>();
		
		for (int i = 0; i < Random.nextInt(9-7)+7; ++i) {
			osztalyzatok.add(create_OsztalyzatMOCK());
		}
		return osztalyzatok;
	}
	
	private _OsztalyzatMOCK create_OsztalyzatMOCK() {
		_OsztalyzatMOCK osztalyzat = new _OsztalyzatMOCK();
		int jegy = Random.nextInt(ERDEMJEGY.length);
		osztalyzat.setId(String.valueOf(id));
		osztalyzat.setOsztalyzat(ERDEMJEGY[jegy]);
		osztalyzat.setOsztalyzatStr(ERDEMJEGY_STR[jegy]);
		osztalyzat.setTipus(nextValue(TIPUS));
		++id;
		return osztalyzat;
	}
	
	private <T> T nextValue(T[] array) {
	    return array[Random.nextInt(array.length)];
	  }
}
