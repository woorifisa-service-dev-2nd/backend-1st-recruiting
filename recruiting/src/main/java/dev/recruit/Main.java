package dev.recruit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import dev.recruit.checker.AgeChecker;
import dev.recruit.checker.Checker;
import dev.recruit.model.ApplicantInfo;
import dev.recruit.parser.Parser;


public class Main {
	// 1. 파일 읽어오기. jar 용
	private static final String RESOURCES = "/resources/";
	
	public static void main(String[] args) throws IOException {

		// 1. 파일 읽어오기. jar 용
		ArrayList<String> list = new ArrayList<>();
		
		InputStream inputStream = Main.class.getResourceAsStream(RESOURCES + args[0] + ".txt");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//		// 1. 파일 읽어오기. 테스트 용
//		ArrayList<String> list = new ArrayList<>();
//
//		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/applicant.txt"));
//
//		String str;
//		while ((str = reader.readLine()) != null) {
//			list.add(str);
//		}
//		reader.close();
//		

		// 2. 읽어들인 데이터 파싱 처리
		ArrayList<ApplicantInfo> applicantInfos = new Parser().parseLinesFrom(list);

		// 3. 카테고리 별로 조건에 맞는 지원자 출력하기

		Checker checker = new Checker(applicantInfos);

		System.out.println("번호를 입력하세요.\n1번 : 항목 별 조회\n2번 : 예비 합격자 조회");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
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
				break;
			case 3:
				System.out.println("C, C#, C++, PYTHON, JAVA, JAVASCRIPT 중 원하는 기술을 1개 입력하세요.");
				String lang = sc.nextLine();
				checker.langChecker(lang);
				break;
			case 4:
				System.out.println("자격증 여부를 입력하세요.");
				String certificate = sc.nextLine();
				checker.certificateChecker(certificate);
				break;
			case 5:
				System.out.println("원하는 연봉을 입력하세요.");
				int salary = sc.nextInt();
				sc.nextLine(); // 버퍼 비우기
				checker.salaryChecker(salary);
				break;
			}
			break;
			
		case 2: // 예비 합격자 정보 출력
			checker.CandidateChecker();
			break;
		}
	}
}
