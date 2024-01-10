package dev.recruit.checker;

import java.util.ArrayList;
import java.util.function.Consumer;

import dev.recruit.logging.ResultLog;
import dev.recruit.model.ApplicantInfo;
import dev.recruit.Main;

public class Checker {

	
	
	private ArrayList<ApplicantInfo> applicantInfos;

	public Checker(ArrayList<ApplicantInfo> applicantInfos) {
		this.applicantInfos = applicantInfos;
	}
	// after4 checker 인터페이스 만든다. checker 종류마다 매개변수의 타입이 다르므로 generic을 이용해 <T> 처럼 쓴다.
	
	
	// after3 myfile.log 에 로그 저장하는 코드 추가. 
	public void genderChecker(String gender) { 
	
		Consumer<ApplicantInfo> filterGender = (applicant) -> {
			if (applicant.getGender().equals(gender)) {
				System.out.print(applicant.toString());
				Main.resultLog.saveLog(Main.logger, applicant.toString());
			}
		};
		for (ApplicantInfo applicantInfo : applicantInfos) {

			filterGender.accept(applicantInfo);
		}
	}
	
	
//	// after2 ifFilter.java의 역할이 Consumer interface, accept method와 같다. Consumer 만들었음.
//	public void genderChecker(String gender) { 
//		Consumer<ApplicantInfo> filterGender = (applicant) -> {
//			if (applicant.getGender().equals(gender))
//				System.out.print(applicant.toString());
//		};
//		for (ApplicantInfo applicantInfo : applicantInfos) {
//
//			filterGender.accept(applicantInfo);
//		}
//	}
	
//	// after1 Checker 함수들의 기능 동일
//	// for문을 돌려서 매개변수 값과 지원자의 정보가 일치하는지 확인해서 일치하면 프린트하는 기능이 동일하다.
//	// checker 함수에 들어가는 매개변수의 타입만 다름
//	public void genderChecker(String gender) { 
//		IfFilter filterGender = (applicant) -> {
//			if (applicant.getGender().equals(gender))
//				System.out.print(applicant.toString());
//		};
//		for (ApplicantInfo applicantInfo : applicantInfos) {
//
//			filterGender.filterApplicant(applicantInfo);
//		}
//	}
	
// before : checker함수 구현
//	public void genderChecker(String gender) {
//		for (int i = 0; i < applicantInfos.size(); i++) {
//			if (applicantInfos.get(i).getGender().equals(gender)) {
//				System.out.print(applicantInfos.get(i).toString());
//			}
//		}
//	}

	//after
	public void ageChecker(int age) {
		IfFilter ageFilter = (applicant) -> {
			if (age <= 0 || age > 6) {
				System.out.println("나이대를 잘못 입력하셨습니다.");
			}
			if (applicant.getAge() == age * 10) System.out.print(applicant.toString());	
		};
		for(ApplicantInfo applicantInfo : applicantInfos) {
			ageFilter.filterApplicant(applicantInfo);
		}
}
	
	// before
//	public void ageChecker(int age) {
//		if (age <= 0 || age > 6) {
//			System.out.println("나이대를 잘못 입력하셨습니다.");
//		}
//		for (int i = 0; i < applicantInfos.size(); i++) {
//			if (applicantInfos.get(i).getAge() == age * 10) {
//				System.out.print(applicantInfos.get(i).toString());
//			}
//		}
//	}

	public void langChecker(String lang) {
		if (lang.equals("JAVA")) {
			lang = "JAVA,";
		} else if (lang.equals("C")) {
			lang = "C,";
		}
		for (int i = 0; i < applicantInfos.size(); i++) {
			if (applicantInfos.get(i).getLang().contains(lang)) {
				System.out.print(applicantInfos.get(i).toString());
			}
		}
	}

	public void certificateChecker(String certificate) {
		for (int i = 0; i < applicantInfos.size(); i++) {
			if (applicantInfos.get(i).getCertificate().equals(certificate)) {
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
					&& applicantInfos.get(i).getEmail().contains(".com") && applicantInfos.get(i).getSalary() <= 5000) {
				System.out.println(applicantInfos.get(i).toString());
			}
		}
	}
}
