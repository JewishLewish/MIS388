/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jewishlewish.mis388;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;

import java.awt.image.BufferedImage;

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
        

        
        File imageFile;

        //Use TIFF NOT PNG! PNG BREAKS EVERYTHING EVEN THE SCOPE OF THE UNNIVERSE!
        
        try {
            if (!isTiffFormat("Resume-1.png")) {
                convertToTiff("Resume-1.png", "Output.tiff");
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageFile = new File("Resume-1.tiff");
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

    public static boolean isTiffFormat(String filePath) {
        String fileExtension = FilenameUtils.getExtension(filePath).toLowerCase();
        return fileExtension.equals("tiff") || fileExtension.equals("tif");
    }

    public static void convertToTiff(String inputFile, String outputFile) throws IOException {
        BufferedImage image = ImageIO.read(new File(inputFile));

        if (image != null) {
            // Write the BufferedImage to the output TIFF file
            ImageIO.write(image, "TIFF", new File(outputFile));
        } else {
            System.err.println("Failed to read input image: " + inputFile);
        }
    }
}
