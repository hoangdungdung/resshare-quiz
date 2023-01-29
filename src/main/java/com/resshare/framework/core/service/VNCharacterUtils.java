package com.resshare.framework.core.service;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;



public class VNCharacterUtils {

	private static final char[] SOURCE_CHARACTERS0 = { 'À', 'Á', 'Â', 'Ã', 'È', 'É', 'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ',
			'Ù', 'Ú', 'Ý', 'à', 'á', 'â', 'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý', 'Ă', 'ă',
			'Đ', 'đ', 'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ', 'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ',
			'ẫ', 'Ậ', 'ậ', 'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ', 'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế',
			'Ề', 'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ', 'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ',
			'ổ', 'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ', 'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ', 'ứ',
			'Ừ', 'ừ', 'Ử', 'ử', 'Ữ', 'ữ', 'Ự', 'ự', };
	private static final char[] SOURCE_CHARACTERS = { 'á', 'à', 'ả', 'ạ', 'ã', 'Á', 'À', 'Ả', 'Ạ', 'Ã', 'â', 'ấ', 'ầ',
			'ẩ', 'ậ', 'ẫ', 'Â', 'Ấ', 'Ầ', 'Ẩ', 'Ậ', 'Ẫ', 'ă', 'ắ', 'ằ', 'ẳ', 'ặ', 'ẵ', 'Ă', 'Ắ', 'Ằ', 'Ẳ', 'Ặ', 'Ẵ',
			'é', 'è', 'ẻ', 'ẹ', 'ẽ', 'É', 'È', 'Ẻ', 'Ẹ', 'Ẽ', 'ê', 'ế', 'ề', 'ể', 'ệ', 'ễ', 'Ê', 'Ế', 'Ề', 'Ể', 'Ệ',
			'Ễ', 'ó', 'ò', 'ỏ', 'ọ', 'õ', 'Ó', 'Ò', 'Ỏ', 'Ọ', 'Õ', 'ô', 'ố', 'ồ', 'ổ', 'ộ', 'ỗ', 'Ô', 'Ố', 'Ồ', 'Ổ',
			'Ộ', 'Ỗ', 'ơ', 'ớ', 'ờ', 'ở', 'ợ', 'ỡ', 'Ơ', 'Ớ', 'Ờ', 'Ở', 'Ợ', 'Ỡ', 'ú', 'ù', 'ủ', 'ụ', 'ũ', 'Ú', 'Ù',
			'Ủ', 'Ụ', 'Ũ', 'ư', 'ứ', 'ừ', 'ử', 'ự', 'ữ', 'Ư', 'Ứ', 'Ừ', 'Ử', 'Ự', 'Ữ', 'í', 'ì', 'ỉ', 'ị', 'ĩ', 'Í',
			'Ì', 'Ỉ', 'Ị', 'Ĩ', 'ý', 'ỳ', 'ỷ', 'ỵ', 'ỹ', 'Ý', 'Ỳ', 'Ỷ', 'Ỵ', 'Ỹ', 'đ', 'Đ', };

	private static final char[] DESTINATION_CHARACTERS = { 'a', 'a', 'a', 'a', 'a', 'A', 'A', 'A', 'A', 'A', 'a', 'a',
			'a', 'a', 'a', 'a', 'A', 'A', 'A', 'A', 'A', 'A', 'a', 'a', 'a', 'a', 'a', 'a', 'A', 'A', 'A', 'A', 'A',
			'A', 'e', 'e', 'e', 'e', 'e', 'E', 'E', 'E', 'E', 'E', 'e', 'e', 'e', 'e', 'e', 'e', 'E', 'E', 'E', 'E',
			'E', 'E', 'o', 'o', 'o', 'o', 'o', 'O', 'O', 'O', 'O', 'O', 'o', 'o', 'o', 'o', 'o', 'o', 'O', 'O', 'O',
			'O', 'O', 'O', 'o', 'o', 'o', 'o', 'o', 'o', 'O', 'O', 'O', 'O', 'O', 'O', 'u', 'u', 'u', 'u', 'u', 'U',
			'U', 'U', 'U', 'U', 'u', 'u', 'u', 'u', 'u', 'u', 'U', 'U', 'U', 'U', 'U', 'U', 'i', 'i', 'i', 'i', 'i',
			'I', 'I', 'I', 'I', 'I', 'y', 'y', 'y', 'y', 'y', 'Y', 'Y', 'Y', 'Y', 'Y', 'd', 'D', };

	private static final char[] DESTINATION_CHARACTERS0 = { 'A', 'A', 'A', 'A', 'E', 'E', 'E', 'I', 'I', 'O', 'O', 'O',
			'O', 'U', 'U', 'Y', 'a', 'a', 'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u', 'y', 'A',
			'a', 'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a',
			'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e', 'E', 'e', 'E', 'e', 'E',
			'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
			'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'U', 'u', 'U', 'u', 'U',
			'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', };

	static HashMap hmChar;

	public static char removeAccent(char ch) {
		if (hmChar == null) {
			init();
		}
		// int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
		// if (index >= 0) {
		// ch = DESTINATION_CHARACTERS[index];
		// }
		if (hmChar.containsKey(ch))
			return (char) hmChar.get(ch);
		return ch;
	}

	private static void init() {
		hmChar = new HashMap<>();
		for (int i = 0; i < SOURCE_CHARACTERS.length; i++) {
			hmChar.put(SOURCE_CHARACTERS[i], DESTINATION_CHARACTERS[i]);

		}

	}

	public static void main(String[] args) {
	String d = removeAccent("việt Mỹ đếc");
	System.out.print(d);
	}
	public static String removeAccent(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			sb.setCharAt(i, removeAccent(sb.charAt(i)));
		}
		return sb.toString();
	}
}