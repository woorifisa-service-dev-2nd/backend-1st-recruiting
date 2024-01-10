package dev.recruit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

import dev.recruit.model.ApplicantInfo;
import dev.recruit.parser.Parser;


public class Main {
	// 1. 파일 읽어오기. jar 용
	private static final String RESOURCES = "/resources/";
	 
	 
	public static void main(String[] args) throws IOException, InterruptedException {
		Logging.log(Level.INFO, "사용자가 프로그램을 시작함");

		// 1. 파일 읽어오기. jar 용
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
		
		
//		// 1. 파일 읽어오기. 테스트 용
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
