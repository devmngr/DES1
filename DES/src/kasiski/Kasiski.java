package kasiski;
import java.util.ArrayList;
import java.util.Scanner;

public class Kasiski {
	private static ArrayList<Character> getAllChars(String str) {

		ArrayList<Character> chars = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++)
			if (!chars.contains(str.charAt(i))) {
				chars.add(str.charAt(i));
			}

		return chars;
	}

	private static int nrOfOccurences(String str, char ch) {

		int count = 0;
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == ch)
				count++;

		}
		return count;

	}

	public static double indexOfCoincidence(String str) {
		double result = 0;
		int temp;
		ArrayList<Character> chars = getAllChars(str);

		for (int i = 0; i < chars.size(); i++) {
			temp = nrOfOccurences(str, chars.get(i));
			result += temp * (temp - 1);
		}
		int size = str.length();
		result = result / (size * (size - 1));
		return result;
	}

	public static ArrayList<Double> indexOfCoincidenceWithOffset(String str,
			int jump) {
		double result = 0;
		int temp;
		ArrayList<Character> chars = getAllChars(str);
		ArrayList<Double> offset = new ArrayList<Double>();
		int size = str.length();

		for (int j = 0; j < jump; j++) {

			for (int i = j; i < chars.size(); i += jump) {
				temp = nrOfOccurences(str, chars.get(i));
				result += temp * (temp - 1);
			}

			result = result / (size * (size - 1));
			offset.add(result);
		}
		return offset;
	}

	public static double estimatedKeyLength(String str) {

		double first = 0.0265 * str.length();
		double second = 0.0650 - indexOfCoincidence(str) + str.length()
				* (indexOfCoincidence(str) - 0.0385);
		double result = first / second;

		return result;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Write text; ");
		String text = scan.nextLine();
		System.out.println();

		System.out.println("AA:  \n" + indexOfCoincidenceWithOffset(text, 5));
		System.out.println("Index Of Coincidence: " + indexOfCoincidence(text));
		System.out.println("Estimated Key: " + estimatedKeyLength(text));

		/*
		 * Index Of Coincidence
		 * XMNUXIFJCQVWMXRCSIFACACHNSQMXHHQMMCHNXRXNPQVRXSWICIFMLUFHYCSIQVCACHNSQMXHCFRCILSQZZXMJFMLCACHNSQMXHVSFWLNUCSCXIXMLCCLMQNXECFNTUXHUICHWSXNPLQCIMQNEFNNCSNTQNSCMLIUFRCHQECNQJCNUCSNQEFYCNUCNQZXHQVNUXIGQQYQVRXNFAXMNCSCIN
		 * System.out.println("Index Of Coincidence: " +
		 * indexOfCoincidence(text));
		 */

		/*
		 * Estimated Key Length
		 * XVGRXANQTWSECQIOGANVTTRMIZBXXKPYCVRMIQISIGBPKQEEHMFKCLUKRSRBHWSOAMPDGWASRMNFTAQBDXCSCONXSMYORBEYCQPPGIHNIPRBTQFSCLROSVBDXURKIEUSRPFORCESIGQYTAAYIUNDIMEDLWGBTVQCWIIORWZOIWTOIPRBIWZKZMGRTBBZXKBPIPVCQWBUDNISIIYSCBRBTAG
		 * System.out.println("Estimated Key: " + estimatedKeyLength(text));
		 */

	}
}
