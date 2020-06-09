package org.hunter.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LongestCommonSubsequence {

	public static void main(String [] args) {
//		String text1 = "xabcde";
//		String text2 = "ydacex";
		//3

		String text1 = "pmjghexybyrgzczy";
		String text2 = "hafcdqbgncrcbihkd";
		//4
		
//		String text1 = "mhunuzqrkzsnidwbun";
//		String text2 = "szulspmhwpazoxijwbq";
		//6

//		String text1 = "pmjghexybyrgzczy";
//		String text2 = "hafcdqbgncrcbihkd";
		//4

//		String text1 = "eeeee";
//		String text2 = "eeeee";

//		String text1 = "dknkdizqxkdczafixidorgfcnkrirmhmzqbcfuvojsxwraxe";
//		String text2 = "dulixqfgvipenkfubgtyxujixspoxmhgvahqdmzmlyhajerqz";
		//14

//		String text1 = "fcvafurqjylclorwfoladwfqzkbebslwnmpmlkbezkxoncvwhstwzwpqxqtyxozkpgtgtsjobujezgrkvevklmludgtyrmjaxyputqbyxqvupojutsjwlwluzsbmvyxifqtglwvcnkfsfglwjwrmtyxmdgjifyjwrsnenuvsdedsbqdovwzsdghclcdexmtsbexwrszihcpibwpidixmpmxshwzmjgtadmtkxqfkrsdqjcrmxkbkfoncrcvoxuvcdytajgfwrcxivixanuzerebuzklyhezevonqdsrkzetsrgfgxibqpmfuxcrinetyzkvudghgrytsvwzkjulmhanankxqfihenuhmfsfkfepibkjmzybmlkzozmluvybyzsleludsxkpinizoraxonmhwtkfkhudizepyzijafqlepcbihofepmjqtgrsxorunshgpazovuhktatmlcfklafivivefyfubunszyvarcrkpsnglkduzaxqrerkvcnmrurkhkpargvcxefovwtapedaluhclmzynebczodwropwdenqxmrutuhehadyfspcpuxyzodifqdqzgbwhodcjonypyjwbwxepcpujerkrelunstebopkncdazexsbezmhynizsvarafwfmnclerafejgnizcbsrcvcnwrolofyzulcxaxqjqzunedidulspslebifinqrchyvapkzmzwbwjgbyrqhqpolwjijmzyduzerqnadapudmrazmzadstozytonuzarizszubkzkhenaxivytmjqjgvgzwpgxefatetoncjgjsdilmvgtgpgbibexwnexstipkjylalqnupexytkradwxmlmhsnmzuxcdkfkxyfgrmfqtajatgjctenqhkvyrgvapctqtyrufcdobibizihuhsrsterozotytubefutaxcjarknynetipehoduxyjstufwvkvwvwnuletybmrczgtmxctuny";
//		String text2 = "nohgdazargvalupetizezqpklktojqtqdivcpsfgjopaxwbkvujilqbclehulatshehmjqhyfkpcfwxovajkvankjkvevgdovazmbgtqfwvejczsnmbchkdibstklkxarwjqbqxwvixavkhylqvghqpifijohudenozotejoxavkfkzcdqnoxydynavwdylwhatslyrwlejwdwrmpevmtwpahatwlaxmjmdgrebmfyngdcbmbgjcvqpcbadujkxaxujudmbejcrevuvcdobolcbstifedcvmngnqhudixgzktcdqngxmruhcxqxypwhahobudelivgvynefkjqdyvalmvudcdivmhghqrelurodwdsvuzmjixgdexonwjczghalsjopixsrwjixuzmjgxydqnipelgrivkzkxgjchibgnqbknstspujwdydszohqjsfuzstyjgnwhsrebmlwzkzijgnmnczmrehspihspyfedabotwvwxwpspypctizyhcxypqzctwlspszonsrmnyvmhsvqtkbyhmhwjmvazaviruzqxmbczaxmtqjexmdudypovkjklynktahupanujylylgrajozobsbwpwtohkfsxeverqxylwdwtojoxydepybavwhgdehafurqtcxqhuhkdwxkdojipolctcvcrsvczcxedglgrejerqdgrsvsxgjodajatsnixutihwpivihadqdotsvyrkxehodybapwlsjexixgponcxifijchejoxgxebmbclczqvkfuzgxsbshqvgfcraxytaxeviryhexmvqjybizivyjanwxmpojgxgbyhcruvqpafwjslkbohqlknkdqjixsfsdurgbsvclmrcrcnulinqvcdqhcvwdaxgvafwravunurqvizqtozuxinytafopmhchmxsxgfanetmdcjalmrolejidylkjktunqhkxchyjmpkvsfgnybsjedmzkrkhwryzan";
		//323

//		String text1 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
//		String text2 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";

		LongestCommonSubsequence l = new LongestCommonSubsequence();
		System.out.println(l.longestCommonSubsequence(text1, text2));
	}

	int calls = 0;
	//18609502

	public int longestCommonSubsequence(String text1, String text2) {
		Map<String, Integer> mem = new LinkedHashMap<>();
		Map<Integer, Integer> mem2 = new LinkedHashMap<>();
		return longestCommonSubsequenceMem(text1, text2,0, 0, mem, mem2);
	}

	public int longestCommonSubsequenceMem(String text1, String text2, int start, int start2, Map<String, Integer> mem, Map<Integer, Integer> mem2) {
		if (start >= text1.length() || start2 >= text2.length()) {
			mem.put(start + "-" + start2, 0);
			mem2.put(start, start2);
			return 0;
		}
		int maxSize = 0;
		int pos1 = start;
		for (char char1 : text1.substring(start).toCharArray()) {
			String string = String.valueOf(char1);

			int pos2 = start2;
			for (char char2 : text2.substring(start2).toCharArray()) {
				String string2 = String.valueOf(char2);

				if (string.equals(string2)) {
					String key = pos1 + "-" + pos2;
					if (mem2.get(pos1) != null) {
						//Integer p2 = mem2.get(pos1);
						if (mem.get(key) != null) {
							maxSize = Math.max(maxSize, mem.get(key));
							break;
						}
						int sum = 0;
						for (int p11 : mem2.keySet()) {
							if (p11 > pos1) {
								sum += mem.get(p11 + "-" + mem2.get(p11));
							}
						}
						mem.put(pos1 + "-" + pos2, 1 + sum);
						mem2.put(pos1, pos2);
						maxSize = Math.max(maxSize, mem.get(key));
						break;
					}

					int size;
					if (mem.get(key) == null) {
						size = 1 + longestCommonSubsequenceMem(text1, text2, pos1 + 1, pos2 + 1, mem, mem2);
						mem.put(key, size);
						mem2.put(pos1, pos2);
						maxSize = Math.max(maxSize, size);
					}
					else {
						maxSize = Math.max(maxSize, mem.get(key));
					}
					break;
				}
				++pos2;
			}
			++pos1;
		}

		return maxSize;
	}

//	public int longestCommonSubsequenceMem(String text1, String text2, int start, int start2, Map<String, Integer> mem, Map<Integer, Integer> mem2) {
//		if (start >= text1.length() || start2 >= text2.length()) {
//			mem.put(start + "-" + start2, 0);
//			mem2.put(start, 0);
//			return 0;
//		}
//		int maxSize = 0;
//		int pos1 = start;
//		for (char char1 : text1.substring(start).toCharArray()) {
//			String string = String.valueOf(char1);
//
//			int pos2 = start2;
//			for (char char2 : text2.substring(start2).toCharArray()) {
//				String string2 = String.valueOf(char2);
//
//				if (string.equals(string2)) {
//					if (mem.get((pos1 + 1) + "-" + (pos2 + 1)) == null) {
//						int lastSize = longestCommonSubsequenceMem(text1, text2, pos1 + 1, pos2 + 1, mem, mem2);
//						int size = 1 + lastSize;
//						mem.put((pos1 + 1) + "-" + (pos2 + 1), size);
//						maxSize = Math.max(maxSize, size);
//					}
//					else {
//						int size = 1 + mem.get((pos1 + 1) + "-" + (pos2 + 1));
//						maxSize = Math.max(maxSize, size);
//					}
//
////					if (mem2.get(pos1) == null) {
////					}
////					else {
////						int size = mem2.get(pos1);
////						maxSize = Math.max(maxSize, size);
////					}
//				}
//				++pos2;
//			}
//			++pos1;
//		}
//
//		return maxSize;
//	}
}
