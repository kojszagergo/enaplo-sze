package hu.diplomatervezes.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Random;

public class _SimpleDataBase {

	  private static final String[] FIRST_NAMES = {
	      "James", "John", "Robert", "Michael", "William", "David", "Richard",
	      "Charles", "Joseph", "Thomas", "Christopher", "Daniel", "Paul", "Mark",
	      "Donald", "George", "Kenneth", "Steven", "Edward", "Brian", "Ronald",
	      "Anthony", "Kevin", "Jason", "Matthew", "Gary", "Timothy", "Jose",
	      "Larry", "Jeffrey", "Frank", "Scott", "Eric", "Stephen", "Andrew",
	      "Raymond", "Gregory", "Joshua", "Jerry", "Dennis", "Walter", "Patrick",
	      "Peter", "Harold", "Douglas", "Henry", "Carl", "Arthur", "Ryan", "Roger",
	      "Joe", "Juan", "Jack", "Albert", "Jonathan", "Justin", "Terry", "Gerald",
	      "Keith", "Samuel", "Willie", "Ralph", "Lawrence", "Nicholas", "Roy",
	      "Benjamin", "Bruce", "Brandon", "Adam", "Harry", "Fred", "Wayne", "Billy",
	      "Steve", "Louis", "Jeremy", "Aaron", "Randy", "Howard", "Eugene",
	      "Carlos", "Russell", "Bobby", "Victor", "Martin", "Ernest", "Phillip",
	      "Todd", "Jesse", "Craig", "Alan", "Shawn", "Clarence", "Sean", "Philip",
	      "Chris", "Johnny", "Earl", "Jimmy", "Antonio", "Danny", "Bryan", "Tony",
	      "Luis", "Mike", "Stanley", "Leonard", "Nathan", "Dale", "Manuel",
	      "Rodney", "Curtis", "Norman", "Allen", "Marvin", "Vincent", "Glenn",
	      "Jeffery", "Travis", "Jeff", "Chad", "Jacob", "Lee", "Melvin", "Alfred",
	      "Kyle", "Francis", "Bradley", "Jesus", "Herbert", "Frederick", "Ray",
	      "Joel", "Edwin", "Don", "Eddie", "Ricky", "Troy", "Randall", "Barry",
	      "Alexander", "Bernard", "Mario", "Leroy", "Francisco", "Marcus",
	      "Micheal", "Theodore", "Clifford", "Miguel", "Oscar", "Jay", "Jim", "Tom",
	      "Calvin", "Alex", "Jon", "Ronnie", "Bill", "Lloyd", "Tommy", "Leon",
	      "Derek", "Warren", "Darrell", "Jerome", "Floyd", "Leo", "Alvin", "Tim",
	      "Wesley", "Gordon", "Dean", "Greg", "Jorge", "Dustin", "Pedro", "Derrick",
	      "Dan", "Lewis", "Zachary", "Corey", "Herman", "Maurice", "Vernon",
	      "Roberto", "Clyde", "Glen", "Hector", "Shane", "Ricardo", "Sam", "Rick",
	      "Lester", "Brent", "Ramon", "Charlie", "Tyler", "Gilbert", "Gene",
	      "Gábor", "László", "Tibor", "Péter", "Rajmund", "Miklós", "Balázs", "Norber",
	      "Tamás", "Dániel", "Dénes", "Gergely", "Csaba", };
	  
	  private static final String[] LAST_NAMES = {
	      "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller",
	      "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White",
	      "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark",
	      "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young",
	      "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams",
	      "Baker", "Gonzalez", "Nelson", "Carter", "Mitchell", "Perez", "Roberts",
	      "Turner", "Phillips", "Campbell", "Parker", "Evans", "Edwards", "Collins",
	      "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan",
	      "Bell", "Murphy", "Bailey", "Rivera", "Cooper", "Richardson", "Cox",
	      "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez", "James",
	      "Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood",
	      "Barnes", "Ross", "Henderson", "Coleman", "Jenkins", "Perry", "Powell",
	      "Long", "Patterson", "Hughes", "Flores", "Washington", "Butler",
	      "Simmons", "Foster", "Gonzales", "Bryant", "Alexander", "Russell",
	      "Griffin", "Diaz", "Hayes", "Myers", "Ford", "Hamilton", "Graham",
	      "Sullivan", "Wallace", "Woods", "Cole", "West", "Jordan", "Owens",
	      "Reynolds", "Fisher", "Ellis", "Harrison", "Gibson", "Mcdonald", "Cruz",
	      "Marshall", "Ortiz", "Gomez", "Murray", "Freeman", "Wells", "Webb",
	      "Simpson", "Stevens", "Tucker", "Porter", "Hunter", "Hicks", "Crawford",
	      "Henry", "Boyd", "Mason", "Morales", "Kennedy", "Warren", "Dixon",
	      "Ramos", "Reyes", "Burns", "Gordon", "Shaw", "Holmes", "Rice",
	      "Robertson", "Hunt", "Black", "Daniels", "Palmer", "Mills", "Nichols",
	      "Grant", "Knight", "Ferguson", "Rose", "Stone", "Hawkins", "Dunn",
	      "Perkins", "Hudson", "Spencer", "Gardner", "Stephens", "Payne", "Pierce",
	      "Berry", "Matthews", "Arnold", "Wagner", "Willis", "Ray", "Watkins",
	      "Olson", "Carroll", "Duncan", "Snyder", "Hart", "Cunningham", "Bradley",
	      "Lane", "Andrews", "Ruiz", "Harper", "Fox", "Riley", "Armstrong",
	      "Carpenter", "Weaver", "Greene", "Lawrence", "Elliott", "Chavez", "Sims",
	      "Austin", "Peters", "Kelley", "Franklin", "Lawson", "Szép", "Kojsza",
	      "Horváth", "Tóth", "Nagy", "Kis", "Kiss", "Magyar", "Kálai", "Lakatos",
	      "Kovács", "Fehér", "Fekete", "Orbán", "Kásás", "Benedek", "Kemény",
	      "Szívós", "Madaras", "Fodor", "Dala", "Vincze", "Szécsi", "Steinmetz",
	      "D. Nagy", "Hárai", "Biros", "Baksa", "Hegedüs", "Varga", "Varga2"};	  
	  
	  private static final String[] CLASS = {
		  "9A", "10A", "11A", "12A",
	  };
	  
	  List<_SimpleSchoolClass> schoolClasses;
	  
	  private _SimpleDataBase() {
		  schoolClasses = getSchoolClasses();
	  }

	  
	  private static _SimpleDataBase instance;
	  
	  public static _SimpleDataBase get() {
		  if (instance == null) {
			  instance = new _SimpleDataBase();
		  }
		  return instance;
	  }

	  public List<_SimpleSchoolClass> getIskolaOsztalyok(){
		  return schoolClasses;
	  }
	  
	private List<_SimpleStudent> generateStudent(int count) {
		List<_SimpleStudent> students = new ArrayList<_SimpleStudent>();
		for (int i = 0; i < count; i++) {
			students.add(createStudent());
		}
	return students;
	}
	
	private List<_SimpleSchoolClass> getSchoolClasses() {
		List<_SimpleSchoolClass> schoolClasses = new ArrayList<_SimpleSchoolClass>();
		
		for (int i = 0; i < CLASS.length; i++) {
			schoolClasses.add(createSimpleSchoolClass(i));
		}
		return schoolClasses;
	}
	
	private _SimpleStudent createStudent() {
		_SimpleStudent student = new _SimpleStudent();
		student.setLastName(nextValue(LAST_NAMES));
		student.setFirstName(nextValue(FIRST_NAMES));
		student.setId(student.getLastName() + Random.nextInt(999));
		
		return student;
	}
	
	private _SimpleSchoolClass createSimpleSchoolClass(int classNr) {
		_SimpleSchoolClass schoolClass = new _SimpleSchoolClass();
		schoolClass.setGrade(CLASS[classNr]);
		schoolClass.setId(schoolClass.getGrade());
		schoolClass.setStudentList(generateStudent(30));
		
		return schoolClass;
	}
	
	
	
	private <T> T nextValue(T[] array) {
	    return array[Random.nextInt(array.length)];
	  }
	
}
