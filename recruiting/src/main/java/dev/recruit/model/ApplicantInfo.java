package dev.recruit.model;

public class ApplicantInfo {

	private String name;
	private String gender; // M, F
	private int age;
	private String lang;
	private String certificate; // O, X
	private String email;
	private int salary;
	
	// 필드 초기화를 위한 생성자
	
	public ApplicantInfo() {}
	
	public ApplicantInfo(String name, String gender, int age, String lang, String certificate, String email, int salary) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = ageDivision(age);
		this.lang = lang;
		this.certificate = certificate;
		this.email = email;
		this.salary = salary;
	}
	
	// getter 함수
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public String getLang() {
		return lang;
	}
	public String getCertificate() {
		return certificate;
	}
	public String getEmail() {
		return email;
	}
	public int getSalary() {
		return salary;
	}

	
	// 나이대 10살 단위 구분 함수. 60대 이상은 모두 60
	private int ageDivision(int age) {
		if(age >= 60) return 60;
		return age-(age%10);
	}
	
	@Override
	public String toString() {
		return "지원자 " + name + ", 성별 : " + gender + ", 나이 : " + age + "대, email : " + email + ", 기술 스택 : " + lang
				+ ", 자격증 여부 : " + certificate + ", 희망 연봉 : " + salary + "\n";
	}
	

}
