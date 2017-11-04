package com.ben.quiz.domain.common.util;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PropertiesGenerator {
    public static void main(String args[]){
        List<String> oldLines = new ArrayList<>();
        String jpValue = getFile("quizMessage_en.properties");
        String[] lines = jpValue.split("\\r?\\n");
        System.out.println("{");
        for(String line : lines){
            line = line.trim();
            if(!line.startsWith("#") && line !=null && !line.isEmpty()) {
                String[] proLine = line.split("=");
                proLine[1] = StringEscapeUtils.unescapeJava(proLine[1]);
                proLine[1] = deneme(proLine[1]);
                if(!oldLines.contains(proLine[0])) {
                    oldLines.add(proLine[0]);
                    System.out.println("\t\"" + proLine[0] + "\"" + ": \"" + proLine[1] + "\",");
                }
            }
        }
        System.out.println("}");
    }
    private static String deneme(String string){
        String string2 = null;

        try {
            byte[] utf8 = string.getBytes("UTF-8");
            string2 = new String(utf8, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        return string2;
    }

    private static String Unicode2UTF8(String strInput){
        String str = strInput.split(" ")[0];
        str = str.replace("\\","");
        String[] arr = str.split("u");
        String text = "";
        for(int i = 1; i < arr.length; i++){
            int hexVal = Integer.parseInt(arr[i], 16);
            text += (char)hexVal;
        }
        return text;
    }

    private static String getFile(String fileName) {
        StringBuilder result = new StringBuilder("");
        //Get file from resources folder
        ClassLoader classLoader = PropertiesGenerator.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
