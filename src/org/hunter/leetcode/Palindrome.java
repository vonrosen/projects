package org.hunter.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Palindrome {

    public static void main(String [] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.longestPalindrome("ac"));
        System.out.println(p.longestPalindrome("babad"));
        System.out.println(p.longestPalindrome("cbbd"));
        System.out.println(p.longestPalindrome("abb"));
        System.out.println(p.longestPalindrome("whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone"));
        System.out.println(p.longestPalindrome("ujtofmboiyyrjzbonysurqfxylvhuzzrzqwcjxibhawifptuammlxstcjmcmfvjuphyyfflkcbwimmpehqrqcdqxglqciduhhuhbjnwaaywofljhwzuqsnhyhahtkilwggineoosnqhdluahhkkbcwbupjcuvzlbzocgmkkyhhglqsvrxsgcglfisbzbawitbjwycareuhyxnbvounqdqdaixgqtljpxpyrccagrkdxsdtvgdjlifknczaacdwxropuxelvmcffiollbuekcfkxzdzuobkrgjedueyospuiuwyppgiwhemyhdjhadcabhgtkotqyneioqzbxviebbvqavtvwgyyrjhnlceyedhfechrbhugotqxkndwxukwtnfiqmstaadlsebfopixrkbvetaoycicsdndmztyqnaehnozchrakt"));
        System.out.println(p.longestPalindrome("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        Map<String, String> palins = new HashMap<String, String>();
        for (int i = 0; i < s.length(); ++i) {
            List<Integer> positions = findPositions(i, s, String.valueOf(s.charAt(i)));

            if (positions.size() == s.length() - 1) {
                return s;
            }

            for (int pos : positions) {
                String sub = s.substring(i, pos + 1);

                if (isP(sub)) {
                    palins.put(sub, sub);
                }
            }
        }

        if (palins.size() == 0) {
            return s.substring(0, 1);
        }

        String sub = palins.values().stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {
                    return 1;
                }
                else if (s1.length() < s2.length()) {
                    return -1;
                }
                return 0;
            }
        }).collect(Collectors.toList()).get(palins.size() - 1);

        return sub;
    }

    public List<Integer> findPositions(int pos, String s, String sub) {
        List<Integer> positions = new ArrayList<Integer>();
        int indexOf = 0;

        while (indexOf != -1) {
            indexOf = s.indexOf(sub, pos + 1);

            if (indexOf != -1) {
                positions.add(indexOf);
            }
            pos = indexOf;
        }

        return positions;
    }

    public boolean isP(String s) {
       if (s.length() == 1) {
           return true;
       }

       if (s.length() % 2 == 0) {
           String first = s.substring(0, s.length() / 2);
           StringBuffer second = new StringBuffer(s.substring(s.length() / 2, s.length()));

           return first.equals(second.reverse().toString());
       }
       else {
           String first = s.substring(0, s.length() / 2);
           StringBuffer second = new StringBuffer(s.substring((s.length() / 2) + 1, s.length()));

           return first.equals(second.reverse().toString());
       }
    }

}
