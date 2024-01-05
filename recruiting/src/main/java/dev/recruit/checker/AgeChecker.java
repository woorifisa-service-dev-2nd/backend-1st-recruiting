package dev.recruit.checker;

import java.util.ArrayList;
import dev.recruit.model.ApplicantInfo;

public class AgeChecker {
	private ArrayList<ApplicantInfo> tens;
	private ArrayList<ApplicantInfo> twenties;
	private ArrayList<ApplicantInfo> thirties;
	private ArrayList<ApplicantInfo> forties;
	private ArrayList<ApplicantInfo> fifties;
	private ArrayList<ApplicantInfo> sixties;

	public AgeChecker(ArrayList<ApplicantInfo> applicantInfos) {
		tens = new ArrayList<>();
		twenties = new ArrayList<>();
		thirties = new ArrayList<>();
		forties = new ArrayList<>();
		fifties = new ArrayList<>();
		sixties = new ArrayList<>();

		for (int i = 0; i < applicantInfos.size(); i++) {
			int age = applicantInfos.get(i).getAge();
			if (age == 10) {
				tens.add(applicantInfos.get(i));
			} else if (age == 20) {
				twenties.add(applicantInfos.get(i));
			} else if (age == 30) {
				thirties.add(applicantInfos.get(i));
			} else if (age == 40) {
				forties.add(applicantInfos.get(i));
			} else if (age == 50) {
				fifties.add(applicantInfos.get(i));
			} else if (age >= 60) {
				sixties.add(applicantInfos.get(i));
			}

		}

	}

	public void AgeInput(int number) {
		switch(number) {
		case 1 :
			System.out.println(tens);
			break;
		case 2 :
			System.out.println(twenties);
			break;
		case 3 :
			System.out.println(thirties);
			break;
		case 4 :
			System.out.println(forties);
			break;
		case 5 :
			System.out.println(fifties);
			break;
		case 6 :
			System.out.println(sixties);
			break;
		}
	}

}