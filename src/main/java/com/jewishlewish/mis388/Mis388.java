/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jewishlewish.mis388;

import java.io.File;
import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.LoadLibs;

/**
 *
 * @author JewishLewish
 */
public class Mis388 {

    public static void main(String[] args) {

        //Setup Tesseract OCR
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Maven build bundles English data
        instance.setDatapath(tessDataFolder.getPath());
        
        File imageFile = new File("image_2.png");
        System.out.println(image_to_message(imageFile, instance));
    }

    public static String image_to_message(File imageFile, ITesseract instance) {
        try {
            String result = instance.doOCR(imageFile);
            return result;
        } catch (TesseractException e) {
            return e.getMessage();
        }
    }
}
