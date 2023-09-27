package com.jewishlewish.mis388;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;

public class tess4j {

    /*
     *  tess4j.java
     * 
     *  The Code here uses tesseract OCR which helps read the contents of a person's resume and converts it to text 
     *  Originally was going to use the tess4j package but the accuracy of tess4j was so poor compared to use tesseract.exe itself
     *  
     *  This code is bulky but geniunely screw it
     */

     
    public static String tesseract_read(String targetfile) throws IOException {

        String tesseractPath = "C:\\Program Files\\Tesseract-OCR\\tesseract.exe";

        String[] command = {
            tesseractPath,
            targetfile,
            "output",
            "-l", "eng",                  // ENGLISH
            "--oem", "1",                 // yes
            "--psm", "1",                 // yes
            "-c", "tessedit_char_whitelist=0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-@*. '", // Specify the whitelist of characters
        };

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.start();
        //String output = IOUtils.toString(processBuilder.start().getInputStream(), StandardCharsets.UTF_8);
        return readFileToString("output.txt");

    }

    //Very Bad. Temporarily Solution.
    private static String readFileToString(String filePath) throws IOException {return new String(Files.readAllBytes(Paths.get(filePath)));}
}
