package hu.diplomatervezes.shared;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class _SimpleSchoolClass implements Serializable{

	private String id;
	private String grade;
	private List<_SimpleStudent> studentList;
	
	public _SimpleSchoolClass(){
	}

	public _SimpleSchoolClass(String id, String grade,
			List<_SimpleStudent> studentList) {
		super();
		this.id = id;
		this.grade = grade;
		this.studentList = studentList;
	}

	//Be�ll�t�, kiolvas� met�dusok
	public String getId() {
		return id;
	}
	public void setId(String id){
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<_SimpleStudent> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<_SimpleStudent> studentList) {
		this.studentList = studentList;
	}
}
