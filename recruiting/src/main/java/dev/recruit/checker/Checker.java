package dev.recruit.checker;

import java.util.ArrayList;

import dev.recruit.model.ApplicantInfo;

public class Checker {

	private ArrayList<ApplicantInfo> applicantInfos;

	public Checker(ArrayList<ApplicantInfo> applicantInfos) {
		this.applicantInfos = applicantInfos;
	}

	public void genderChecker(String gender) {
		for (int i = 0; i < applicantInfos.size(); i++) {
			if (applicantInfos.get(i).getGender().equals(gender)) {
				System.out.print(applicantInfos.get(i).toString());
			}
		}
	}

	public void ageChecker(int age) {
		if (age <= 0 || age > 6) {
			System.out.println("나이대를 잘못 입력하셨습니다.");
		}
		for (int i = 0; i < applicantInfos.size(); i++) {
			if (applicantInfos.get(i).getAge() == age * 10) {
				System.out.print(applicantInfos.get(i).toString());
			}
		}
	}
	
	public void langChecker(String lang) {
		if(lang.equals("JAVA")) {
			lang = "JAVA,";
		} else if(lang.equals("C")) {
			lang = "C,";
		}
		for (int i = 0; i < applicantInfos.size(); i++) {
			if(applicantInfos.get(i).getLang().contains(lang)) {
				System.out.print(applicantInfos.get(i).toString());
			}
		}
	}
	
	public void certificateChecker(String certificate) {
		for (int i = 0; i < applicantInfos.size(); i++) {
			if(applicantInfos.get(i).getCertificate().equals(certificate)) {
				System.out.print(applicantInfos.get(i).toString());
			}
		}
	}
	
	public void salaryChecker(int salary) {
		for (int i = 0; i < applicantInfos.size(); i++) {
			if (applicantInfos.get(i).getSalary() <= salary) {
				System.out.print(applicantInfos.get(i).toString());
			}
		}
	}
	
	public void CandidateChecker() {
		for (int i = 0; i < applicantInfos.size(); i++) {
			if (applicantInfos.get(i).getAge() >= 20 && applicantInfos.get(i).getLang().contains("JAVA,")
					&& applicantInfos.get(i).getCertificate().equals("O")
					&& applicantInfos.get(i).getEmail().contains("@")
					&& applicantInfos.get(i).getEmail().contains(".com")
					&& applicantInfos.get(i).getSalary() <= 5000) {
				System.out.println(applicantInfos.get(i).toString());
			}
		}
	}
}
