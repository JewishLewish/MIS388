/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jewishlewish.mis388;

import java.io.File;
import java.io.IOException;

public class Mis388 {

    public static void main(String[] args) throws IOException {

        setup.check_tesseract(); //first check if we have required folders

        //Variables
        String targetfile = "example_images\\image_1.png";

        //Read Tesseract
        String data = tess4j.tesseract_read(targetfile);

        String temp = parseString.convert(data);
    }

}
