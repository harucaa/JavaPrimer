package task;

class Student83 extends Person83 {
	private String studentId;
	private String comment;

	public Student83() {
	}

	public Student83(String studentId, int age, String name) {
		setStudentId(studentId);
		setAge(age);
		setName(name);
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
}
