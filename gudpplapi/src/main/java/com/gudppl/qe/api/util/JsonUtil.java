package com.gudppl.qe.api.util;

import java.io.File;
import java.io.FileReader;


public class JsonUtil {

    public static String getTestDataAsString(String filePath) {
        String content = null;
        File file = new File(filePath); //for ex foo.txt
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }

}
