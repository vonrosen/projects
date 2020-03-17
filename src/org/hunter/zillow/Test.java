package org.hunter.zillow;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

	public static List<String> processLogs(List<String> logs, int threshold) {
		// Write your code here
		Comparator comp = new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (Integer.parseInt(s1.split(" ")[0]) < Integer.parseInt(s2.split(" ")[0])) {
					return -1;
				} else if (Integer.parseInt(s1.split(" ")[0]) > Integer.parseInt(s2.split(" ")[0])) {
					return 1;
				}

				return 0;
			}
		};

		logs.sort(comp);
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String log: logs) {
            String uid = log.split(" ")[0];
            String uid2 = log.split(" ")[1];            

            if (map.get(uid) != null) {
                map.put(uid, map.get(uid) + 1);
            }

            if (map.get(uid2) != null) {
                map.put(uid2, map.get(uid2) + 1);
            }         
            
            map.putIfAbsent(uid, 1);
            map.putIfAbsent(uid2, 1);
            	
        }		

		List<String> finalList = new ArrayList<String>();
		for (String m : map.keySet()) {
			if (map.get(m) >= threshold) {
				finalList.add(m);
			}
		}

		finalList.sort(comp);
		return finalList;
	}
	
	public static String getInAm(String t, String f) {
		BigDecimal ta = new BigDecimal(t);
		BigDecimal fee = new BigDecimal(f);
		
		return ta.subtract(fee).setScale(2).toString();
	}

	public static void main(String[] args) {
		List<String> logs = new ArrayList<String>();
		logs.add("88 99 200");
		logs.add("88 99 300");
		logs.add("99 32 100");
		logs.add("12 12 15");

		//System.out.println(processLogs(logs, 2));
		System.out.println(getInAm("23434322423", "2"));
	}

}
