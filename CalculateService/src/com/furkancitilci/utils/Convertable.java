package com.furkancitilci.utils;


import java.util.HashMap;
import java.util.Map;

public class Convertable {
	//statically kept the word equivalents of the numbers as an array of their own type in a clustered manner.
	private static final String[] KATLAR = { "", "bin", "milyon", "milyar", "trilyon"};
    private static final String[] ONLAR = { "", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan" };
    private static final String[] BIRLER = { "", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz" };
    
	//kept the number equivalents of the words to be converted with static map as value
	private static final Map<String, Integer> NUMBER_LIST = new HashMap<String, Integer>() {{
        put("sıfır", 0);
        put("bir", 1);
        put("iki", 2);
        put("üç", 3);
        put("dört", 4);
        put("beş", 5);
        put("altı", 6);
        put("yedi", 7);
        put("sekiz", 8);
        put("dokuz", 9);
        put("on", 10);
        put("yirmi", 20);
        put("otuz", 30);
        put("kırk", 40);
        put("elli", 50);
        put("altmış", 60);
        put("yetmiş", 70);
        put("seksen", 80);
        put("doksan", 90);
        put("yüz", 100);
        put("bin", 1000);
        put("milyon", 1000000);
        put("milyar", 1000000000);
    }};

    //get the result as the instant value by finding the corresponding number value in the map, which comes as text
    public static int wordToNumber(String text) {
        int result = 0;
        int currentNumber = 0;
        for (String word : text.split(" ")) {
            Integer value = NUMBER_LIST.get(word);
            if (value != null) {
                if (value < 100) {
                    currentNumber += value;
                } else {
                    currentNumber *= value;
                    result += currentNumber;
                    currentNumber = 0;
                }
            }
        }
        result += currentNumber;
        return result;
    }


    //get our result as text, we return the long type value obtained as a result of the operation to text
	public static String numberToWord(long number) {
		 if (number == 0) {
	            return "sıfır";
	        }

	        String text = "";
	        int unitIndex = 0;

	        while (number > 0) {
	            int numberGroup = (int) (number % 1000);
	            number /= 1000;

	            int tens = numberGroup % 100;
	            int hundreds = numberGroup / 100;

	            String groupText = "";

	            if (hundreds > 0) {
	                groupText += BIRLER[hundreds] + " yüz ";
	            }

	            if (tens > 0) {
	                if (tens < 10) {
	                    groupText += BIRLER[tens];
	                } else {
	                    groupText += ONLAR[tens / 10] + " " + BIRLER[tens % 10];
	                }
	            }

	            if (groupText.length() > 0) {
	                text = groupText + KATLAR[unitIndex] + " " + text;
	            }

	            unitIndex++;
	        }

	        return text.trim();
	}

}
