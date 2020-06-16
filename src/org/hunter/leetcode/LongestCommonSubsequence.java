package org.hunter.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LongestCommonSubsequence {

	public static void main(String [] args) {
//		String text1 = "xabcde";
//		String text2 = "ydacex";
		//3

//		String text1 = "pmjghexybyrgzczy";
//		String text2 = "hafcdqbgncrcbihkd";
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

		String text1 = "fcvafurqjylclorwfoladwfqzkbebslwnmpmlkbezkxoncvwhstwzwpqxqtyxozkpgtgtsjobujezgrkvevklmludgtyrmjaxyputqbyxqvupojutsjwlwluzsbmvyxifqtglwvcnkfsfglwjwrmtyxmdgjifyjwrsnenuvsdedsbqdovwzsdghclcdexmtsbexwrszihcpibwpidixmpmxshwzmjgtadmtkxqfkrsdqjcrmxkbkfoncrcvoxuvcdytajgfwrcxivixanuzerebuzklyhezevonqdsrkzetsrgfgxibqpmfuxcrinetyzkvudghgrytsvwzkjulmhanankxqfihenuhmfsfkfepibkjmzybmlkzozmluvybyzsleludsxkpinizoraxonmhwtkfkhudizepyzijafqlepcbihofepmjqtgrsxorunshgpazovuhktatmlcfklafivivefyfubunszyvarcrkpsnglkduzaxqrerkvcnmrurkhkpargvcxefovwtapedaluhclmzynebczodwropwdenqxmrutuhehadyfspcpuxyzodifqdqzgbwhodcjonypyjwbwxepcpujerkrelunstebopkncdazexsbezmhynizsvarafwfmnclerafejgnizcbsrcvcnwrolofyzulcxaxqjqzunedidulspslebifinqrchyvapkzmzwbwjgbyrqhqpolwjijmzyduzerqnadapudmrazmzadstozytonuzarizszubkzkhenaxivytmjqjgvgzwpgxefatetoncjgjsdilmvgtgpgbibexwnexstipkjylalqnupexytkradwxmlmhsnmzuxcdkfkxyfgrmfqtajatgjctenqhkvyrgvapctqtyrufcdobibizihuhsrsterozotytubefutaxcjarknynetipehoduxyjstufwvkvwvwnuletybmrczgtmxctuny";
		String text2 = "nohgdazargvalupetizezqpklktojqtqdivcpsfgjopaxwbkvujilqbclehulatshehmjqhyfkpcfwxovajkvankjkvevgdovazmbgtqfwvejczsnmbchkdibstklkxarwjqbqxwvixavkhylqvghqpifijohudenozotejoxavkfkzcdqnoxydynavwdylwhatslyrwlejwdwrmpevmtwpahatwlaxmjmdgrebmfyngdcbmbgjcvqpcbadujkxaxujudmbejcrevuvcdobolcbstifedcvmngnqhudixgzktcdqngxmruhcxqxypwhahobudelivgvynefkjqdyvalmvudcdivmhghqrelurodwdsvuzmjixgdexonwjczghalsjopixsrwjixuzmjgxydqnipelgrivkzkxgjchibgnqbknstspujwdydszohqjsfuzstyjgnwhsrebmlwzkzijgnmnczmrehspihspyfedabotwvwxwpspypctizyhcxypqzctwlspszonsrmnyvmhsvqtkbyhmhwjmvazaviruzqxmbczaxmtqjexmdudypovkjklynktahupanujylylgrajozobsbwpwtohkfsxeverqxylwdwtojoxydepybavwhgdehafurqtcxqhuhkdwxkdojipolctcvcrsvczcxedglgrejerqdgrsvsxgjodajatsnixutihwpivihadqdotsvyrkxehodybapwlsjexixgponcxifijchejoxgxebmbclczqvkfuzgxsbshqvgfcraxytaxeviryhexmvqjybizivyjanwxmpojgxgbyhcruvqpafwjslkbohqlknkdqjixsfsdurgbsvclmrcrcnulinqvcdqhcvwdaxgvafwravunurqvizqtozuxinytafopmhchmxsxgfanetmdcjalmrolejidylkjktunqhkxchyjmpkvsfgnybsjedmzkrkhwryzan";
		//323

//		String text1 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
//		String text2 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";

		LongestCommonSubsequence l = new LongestCommonSubsequence();
		System.out.println(l.longestCommonSubsequence(text1, text2));
	}

	public int longestCommonSubsequence(String text1, String text2) {
		Map<String, Integer> mem = new LinkedHashMap<>();
		Map<Integer, Integer> mem2 = new LinkedHashMap<>();
		return longestCommonSubsequenceMem(text1, text2);
	}

	public int longestCommonSubsequenceMem(String text1, String text2) {
		int [][] mem = new int[text1.length()][text2.length()];
		Map<String, Integer> map = new HashMap<String, Integer>();
		int pos1 = 0, maxSize = 0;
		for (char char1 : text1.toCharArray()) {
			String string = String.valueOf(char1);
			int pos2 = 0;
			for (char char2 : text2.toCharArray()) {
				String string2 = String.valueOf(char2);
				if (string.equals(string2)) {
					if (pos1 == 0 || pos2 == 0) {
						mem[pos1][pos2] = 1;
						map.put(String.valueOf(pos1) + "-" + String.valueOf(pos2), 1);
					}
					else {
						int last = map.get(String.valueOf(pos1 - 1) + "-" + String.valueOf(pos2 - 1));
						mem[pos1][pos2] = 1 + last;
						map.put(String.valueOf(pos1) + "-" + String.valueOf(pos2), mem[pos1][pos2]);
					}
					maxSize = Math.max(maxSize, mem[pos1][pos2]);
				}
				else {
					Integer last1 = map.get(String.valueOf(pos1 - 1) + "-" + String.valueOf(pos2 - 1));
					Integer last2 = map.get(String.valueOf(pos1 - 1) + "-" + String.valueOf(pos2));
					Integer last3 = map.get(String.valueOf(pos1) + "-" + String.valueOf(pos2 - 1));
					if (last1 == null) {
						last1 = 0;
					}
					if (last2 == null) {
						last2 = 0;
					}
					if (last3 == null) {
						last3 = 0;
					}
					int max = Math.max(Math.max(last1, last2), last3);
					map.put(String.valueOf(pos1) + "-" + String.valueOf(pos2), max);
				}
				++pos2;
			}
			++pos1;
		}
		return maxSize;
	}
}
