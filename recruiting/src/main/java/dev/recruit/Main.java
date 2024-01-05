package dev.recruit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dev.recruit.checker.AgeChecker;
import dev.recruit.model.ApplicantInfo;
import dev.recruit.parser.Parser;

public class Main {
	public static void main(String[] args) throws IOException {

		// 1. 파일 읽어오기
		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/applicant.txt"));
		ArrayList<String> list = new ArrayList<>();

		String str;
		while ((str = reader.readLine()) != null) {
			list.add(str);
		}

		reader.close();

		// 2. 읽어들인 데이터 파싱 처리
		ArrayList<ApplicantInfo> applicantInfos = new Parser().parseLinesFrom(list);

		// 3. 카테고리 별로 조건에 맞는 지원자 출력하기

		// 성별 별로 출력
//		for (int i = 0; i < applicantInfos.size(); i++) {
//			if(applicantInfos.get(i).getSex().equals("F")) {
//				System.out.println(applicantInfos.get(i).toString());
//			}
//		}

		// 나이대 별로 출력
//		for (int i = 0; i < applicantInfos.size(); i++) {
//			if(applicantInfos.get(i).getAge()==20) {
//				System.out.println(applicantInfos.get(i).toString());
//			}
//		}

		// 기술 스택에 JAVA가 포함된 지원자 정보 출력
//		for (int i = 0; i < applicantInfos.size(); i++) {
//			if (applicantInfos.get(i).getLang().contains("JAVA")) {
//				System.out.println(applicantInfos.get(i).toString());
//			}
//		}

		// 자격증이 있는 지원자 정보 출력
//		for (int i = 0; i < applicantInfos.size(); i++) {
//			if (applicantInfos.get(i).getCertificate().equals("O")) {
//				System.out.println(applicantInfos.get(i).toString());
//			}
//		}

		// @와 .com가 모두 있는 정확한 이메일을 기재한 지원자 정보 출력
//		for (int i = 0; i < applicantInfos.size(); i++) {
//			if(applicantInfos.get(i).getEmail().contains("@") && 
//					applicantInfos.get(i).getEmail().contains("com")) {
//				System.out.println(applicantInfos.get(i).toString());
//			}
//		}

		// 4. 예비 합격자 정보 출력
		// 20살 이상, JAVA 사용자, 자격증 보유, 정확한 이메일 기재, 연봉 5000이하를 기재한 예비 합격자 정보 출력
//		for (int i = 0; i < applicantInfos.size(); i++) {
//			if (applicantInfos.get(i).getAge() >= 20 &&
//					applicantInfos.get(i).getLang().contains("JAVA") &&
//					applicantInfos.get(i).getCertificate().equals("O") &&
//					applicantInfos.get(i).getEmail().contains("@") && 
//					applicantInfos.get(i).getEmail().contains(".com") &&
//					applicantInfos.get(i).getSalary() <= 5000) {
//				System.out.println(applicantInfos.get(i).toString());
//			}
//		}

		// 스캐너

		AgeChecker agechecker = new AgeChecker(applicantInfos);

		System.out.println("번호를 입력하세요.\n1번 : 항목별 조회\n2번 : 예비합격자 조회");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		switch (a) {
		case 1:
			System.out.println("번호를 입력하세요.\n1번 : 성별 \n2번 : 나이\n3번 : 언어\n4번 : 자격증\n ");
			int b = sc.nextInt();
			switch (b) {
			case 2:
				System.out.println("나이대를 입력하세요");
				System.out.println("1번 : 10대");
				System.out.println("2번 : 20대");
				System.out.println("3번 : 30대");
				System.out.println("4번 : 40대");
				System.out.println("5번 : 50대");
				System.out.println("6번 : 60대 이상");
				int c = sc.nextInt();
				agechecker.AgeInput(c);
				
				break;
			}
			break;
			
		case 2:
			for (int i = 0; i < applicantInfos.size(); i++) {
				if (applicantInfos.get(i).getAge() >= 20 && applicantInfos.get(i).getLang().contains("JAVA")
						&& applicantInfos.get(i).getCertificate().equals("O")
						&& applicantInfos.get(i).getEmail().contains("@")
						&& applicantInfos.get(i).getEmail().contains(".com")
						&& applicantInfos.get(i).getSalary() <= 5000) {
					System.out.println(applicantInfos.get(i).toString());
				}
			}
			break;
		case 3:
			System.out.println("fdfdf");
			break;
		}
	}
}
