package dev.recruit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import dev.recruit.checker.Checker;
import dev.recruit.logging.ResultLog;
import dev.recruit.model.ApplicantInfo;
import dev.recruit.parser.Parser;


public class Main {
	// 1. 파일 읽어오기. jar 용
	private static final String RESOURCES = "/resources/";
	
	// Logger 객체 생성
		public static final Logger logger = 
				Logger.getLogger(Checker.class.getName());
	// ResultLog 객체 생성. 생성자에서 myfile.log 생성
		public static ResultLog resultLog = new ResultLog(logger);
	
	public static void main(String[] args) throws IOException {

//		// 1. 파일 읽어오기. jar 용
//		ArrayList<String> list = new ArrayList<>();
//		
//		InputStream inputStream = Main.class.getResourceAsStream(RESOURCES + "applicant.txt");
//		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
//			String line;
//			while ((line = reader.readLine()) != null) {
//				list.add(line);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		// 1. 파일 읽어오기. 테스트 용
		ArrayList<String> list = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/applicant.txt"));

		String str;
		while ((str = reader.readLine()) != null) {
			list.add(str);
		}
		reader.close();
		

		// 2. 읽어들인 데이터 파싱 처리
		ArrayList<ApplicantInfo> applicantInfos = new Parser().parseLinesFrom(list);

		// 3. 카테고리 별로 조건에 맞는 지원자 출력하기
		
		PrintApplicants printApplicants = new PrintApplicants(applicantInfos);
		printApplicants.printByInputCondition();
		
	}
}
