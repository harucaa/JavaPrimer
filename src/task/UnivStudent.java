package task;

// 練習問題#8  Practice_08_02.java

//
//   問題（２）
//   (オプション)
//     先生・学生を表すクラスをさらに継承し、
//     大学教授を表すクラス、高校教師を表すクラスなど
//     クラスを3つ作成せよ。
//
//  先生 --- 大学教授（学部, 学科）、高校教師（部活、ホームルーム）
//  生徒 --- 大学生（学籍番号、学部、学科）
// 
// faculty, department, bukatsu, homeroom, studentId

class UnivStudent extends Student8 {

	private String faculty;
	private String department;

	public UnivStudent() {
	}

	public UnivStudent(String name, String faculty, String department, int grade) {
		setName(name);
		setFaculty(faculty);
		setDepartment(department);
		setGrade(grade);
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}

// 情報学部：Faculty of Informatics
//   科学情報学科Department of Computer Science
//   行動情報科学科:Department of Behavior Informatics
//   社会情報学科：Department of Socio-Information Studies