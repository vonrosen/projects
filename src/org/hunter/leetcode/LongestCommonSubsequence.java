package org.hunter.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LongestCommonSubsequence {

	public static void main(String [] args) {
//		String text1 = "abcde";
//		String text2 = "ace";
		//3

//		String text1 = "pmjghexybyrgzczy";
//		String text2 = "hafcdqbgncrcbihkd";
		//4
		
//		String text1 = "bsbininm";
//		String text2 = "jmjkbkjkv";
		
//		String text1 = "yzebsbuxmtcfmtodclszgh";
//		String text2 = "ejevmhcvshclydqrulwbyha";
		
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
		LongestCommonSubsequence l = new LongestCommonSubsequence();
		System.out.println(l.longestCommonSubsequence(text1, text2));
	}

	class CacheKey {
		Integer pos;
		Integer pos2;
		CacheKey(Integer pos, Integer pos2) {
			this.pos = pos;
			this.pos2 = pos2;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			CacheKey cacheKey = (CacheKey) o;
			return Objects.equals(pos, cacheKey.pos) &&
					Objects.equals(pos2, cacheKey.pos2);
		}

		@Override
		public int hashCode() {
			return Objects.hash(pos, pos2);
		}
	}

	int calls = 0;
	//18609502

	public int longestCommonSubsequence(String text1, String text2) {
		Map<String, Integer> mem = new HashMap<String, Integer>();

		StringBuffer t1 = new StringBuffer();
		StringBuffer t2 = new StringBuffer();
		for (char ch : text1.toCharArray()) {
			if (text2.charAt(ch) != -1) {
				t1.append(ch);
			}
		}
		for (char ch : text2.toCharArray()) {
			if (text1.charAt(ch) != -1) {
				t2.append(ch);
			}
		}
		return longestCommonSubsequenceMem(t1.toString(), t2.toString(),0, 0, mem);
	}

	public int longestCommonSubsequenceMem(String text1, String text2, int start, int start2, Map<String, Integer> mem) {
		if (start >= text1.length() || start2 >= text2.length()) {
			mem.put(start + "-" + start2, 0);
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
					longestCommonSubsequenceMem(text1, text2, pos1 + 1, pos2 + 1, mem);
					


					String key = (pos1 + 1) + "-" + (pos2 + 1);
					int lastSize = mem.get(key) == null ? longestCommonSubsequenceMem(text1, text2, pos1 + 1, pos2 + 1, mem) : mem.get(key);
					int size = 1 + lastSize;
					mem.put(pos1 + "-" + pos2, size);
					maxSize = Math.max(maxSize, size);
				}
				++pos2;
			}
			++pos1;
		}

		return maxSize;
	}
}
