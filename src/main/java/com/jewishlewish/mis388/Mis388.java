/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jewishlewish.mis388;

import java.io.File;
import java.io.IOException;

public class Mis388 {

    public static void main(String[] args) throws IOException {

        check_tesseract(); //first check if we have required folders

        //Variables
        String targetfile = "Resume.png";
        System.out.println(tess4j.tesseract_read(targetfile));
    }

    public static void check_tesseract() {
        String folderPath = "tesseract_system";

        File folder = new File(folderPath);
        if (!folder.exists()) {
            // If it doesn't exist, create it
            boolean folderCreated = folder.mkdirs();
            if (folderCreated) {
                System.out.println("Folder created successfully.");
            } else {
                System.err.println("Failed to create the folder.");
                return;
            }
        }
    }

}
