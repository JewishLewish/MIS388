package com.jewishlewish.mis388;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import net.lingala.zip4j.ZipFile;

public class setup {
    /*
     * setup.java
     * 
     * This part of the code checks if the user / code has the appropriate files to execute the code
     */
    public static void check_tesseract() {
        String folderPath = "tesseract_system";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Folder created successfully.");
                try {
                    install_tess();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                System.err.println("Failed to create the folder.");
                return;
            }
        }
    }

    //Install the Tesseract OCR and Unzip

    //bad messy code. it is what it is
    private static void install_tess() throws IOException{
        String tesseract_Github = "https://github.com/JewishLewish/MIS388/raw/main/system_requirements/Tesseract-OCR.zip";
        URL url = new URL(tesseract_Github);
        download(url);

        new ZipFile("tesseract_system\\Tesseract-OCR.zip").extractAll("tesseract_system");
    }

    //Download system, use byte buffer to read the .zip file and download the .zip here
    //By doing this we can get the file. File is .zip so this won't take too long (phew)
    public static void download(URL url) {
        File file = new File("tesseract_system\\Tesseract-OCR.zip");
		try {
			InputStream input = url.openStream();
			FileOutputStream output = new FileOutputStream(file);

			byte[] buffer = new byte[4096];
			int n = 0;
			while (-1 != (n = input.read(buffer))) {
				output.write(buffer, 0, n);
			}

			input.close(); output.close(); //close.
			
			System.out.println("Tesseract-OCR.zip has downloaded successfully!");
		}
		catch(IOException ioEx) {
			ioEx.printStackTrace();
		}
	}
}