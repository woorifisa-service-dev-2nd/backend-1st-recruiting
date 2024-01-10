package dev.recruit;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import dev.recruit.checker.Checker;
import dev.recruit.model.ApplicantInfo;


public class PrintApplicants {
	private ArrayList<ApplicantInfo> applicantInfos;

	public PrintApplicants(ArrayList<ApplicantInfo> applicantInfos) {
		this.applicantInfos = applicantInfos;
	}
	
	public void printByInputCondition() {
		Checker checker = new Checker(applicantInfos);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("번호를 입력하세요.\n1번 : 항목 별 조회\n2번 : 예비 합격자 조회");
		int a = sc.nextInt();
		sc.nextLine();
		if(!(a == 1 || a == 2)) {
			System.out.println("잘못 입력하셨습니다.");
			askCheckAgain();
		}
		
		switch (a) {
		case 1: // 항목 별 조회
			System.out.println("번호를 입력하세요.\n1번 : 성별 \n2번 : 나이\n3번 : 기술 스택\n4번 : 자격증\n5번 : 연봉");
			int b = sc.nextInt();
			sc.nextLine();
			switch (b) {
			case 1:
				System.out.println("성별을 입력하세요.");
				System.out.println("M : 남성");
				System.out.println("F : 여성");
				String gender = sc.nextLine();
				checker.genderChecker(gender);
				askCheckAgain();
				break;
			case 2:
				System.out.println("나이대를 입력하세요.");
				System.out.println("1번 : 10대");
				System.out.println("2번 : 20대");
				System.out.println("3번 : 30대");
				System.out.println("4번 : 40대");
				System.out.println("5번 : 50대");
				System.out.println("6번 : 60대 이상");
				int age = sc.nextInt();
				sc.nextLine(); // 버퍼 비우기
				checker.ageChecker(age);
				askCheckAgain();
				break;
			case 3:
				System.out.println("C, C#, C++, PYTHON, JAVA, JAVASCRIPT 중 원하는 기술을 1개 입력하세요.");
				String lang = sc.nextLine();
				checker.langChecker(lang);
				askCheckAgain();
				break;
			case 4:
				System.out.println("자격증 여부를 입력하세요.");
				String certificate = sc.nextLine();
				checker.certificateChecker(certificate);
				askCheckAgain();
				break;
			case 5:
				System.out.println("원하는 연봉을 입력하세요.");
				int salary = sc.nextInt();
				sc.nextLine(); // 버퍼 비우기
				checker.salaryChecker(salary);
				askCheckAgain();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				askCheckAgain();
				
			}
			break;
			
		case 2: // 예비 합격자 정보 출력
			checker.CandidateChecker();
			askCheckAgain();
			break;
		}
	}
	
	public void askCheckAgain() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("\n다시 조회하시겠습니까? (Y/N)");
		String ifAgain = sc2.nextLine();
		if(ifAgain.equals("Y") || ifAgain.equals("y") ) {
			printByInputCondition();
		} else {
			System.out.println("프로그램이 종료되었습니다.");
			Logging.log(Level.INFO, "사용자가 프로그램을 종료함");
		}
	}
}
