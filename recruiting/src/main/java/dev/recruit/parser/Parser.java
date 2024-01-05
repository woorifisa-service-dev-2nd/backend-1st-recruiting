package dev.recruit.parser;

import java.util.ArrayList;
import java.util.List;

import dev.recruit.model.ApplicantInfo;

public class Parser {
	
	// 1. 데이터에서 한 줄만 파싱하는 기능
	private ApplicantInfo parseFrom(final String line) {
		String[] columns = line.split(",(?![^\\[\\]]*\\])"); // 쉼표로 구분, 배열 안의 쉼표는 무시
		for (int i = 0; i < columns.length; i++) {
			columns[i] = columns[i].replace(" ", "");
		}
		ApplicantInfo applicantInfo = new ApplicantInfo(columns[0], columns[1], Integer.parseInt(columns[2]),
				columns[3], columns[4], columns[5], Integer.parseInt(columns[6]));
		return applicantInfo;
	}
	
	// 2. 한 줄 씩 파싱된 데이터를 리스트에 추가하는 기능
	public ArrayList<ApplicantInfo> parseLinesFrom(List<String> lines) {
		ArrayList<ApplicantInfo> applicantInfos = new ArrayList<>();
		for(String line : lines) {
			ApplicantInfo applicantInfo = parseFrom(line);
			applicantInfos.add(applicantInfo);
		}
		return applicantInfos;
	}
	
	

}
