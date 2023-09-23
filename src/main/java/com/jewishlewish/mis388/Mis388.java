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
        instance.setTessVariable("user_defined_dpi", "1800");
        instance.setTessVariable("tessedit_write_images", "true");
        //instance.setTessVariable("load_system_dawg", "0");
        

        //Use TIFF NOT PNG! PNG BREAKS EVERYTHING EVEN THE SCOPE OF THE UNNIVERSE!
        File imageFile = new File("Resume-1.tiff");

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
