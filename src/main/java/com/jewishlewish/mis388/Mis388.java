/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jewishlewish.mis388;

import java.io.IOException;

public class Mis388 {

    public static void main(String[] args) throws IOException {

        setup.check_tesseract(); //first check if we have required folders

        //Variables
        String targetfile = "Resume.png";

        //Read Tesseract
        String content = tess4j.tesseract_read(targetfile);

        //parseString converts String to appropriate variables
        parseString.convert(content);
    }

}
