package dev.recruit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodingTest {

	public static void main(String[] args) {
		int n = 5; // 벽 길이
		int m = 4; // 롤러 길이
		int[] section = { 1, 3 }; // 덧칠할 벽 번호

		Integer[] wall = new Integer[n];
		for (int i = 0; i < n; i++) {
			wall[i] = 1;
		}
		for (int i = 0; i < section.length; i++) {
			wall[section[i] - 1] = 0;
		}
		System.out.println(Arrays.toString(wall));

		int cnt = 0;
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(wall));
		for (int i = 0; i < section.length; i++) {
			for (int j = 0; j < m; j++) {
				if (section[i] - 1 + j < n) {
					wall[section[i] - 1 + j] = 1;
				}
			}
			cnt++;

			if (set.contains(1) && set.size() == 1) {
				System.out.println(cnt);
				break;
			}
		}
		
		System.out.println(Arrays.toString(wall));
		System.out.println(cnt);

	}

}
