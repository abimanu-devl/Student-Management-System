package util;

import java.util.ArrayList;

public class CommonUtils {
	public static String generateStudentIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.STUDENT_ID_PREFIX+ next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.STUDENT_ID_PREFIX + next;
		}
		return id;
	}
	
	public static String generateEmoyeeIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.Employee_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.Employee_ID_PREFIX + next;
		}
		return id;
	}
}
