package org.hlworks.mp3down.main;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String args[]) {
        String urlstr;
        String pathstr;
        String filestr;
        int byteread;
        System.out.print("Input MP3 URL: ");
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        try {
            urlstr = br.readLine();
        } catch (IOException e) {
            System.out.println("Error inputing URL");
            return;
        }
        System.out.print("Input save path (without file name): ");
        try {
            pathstr = br.readLine();
        } catch (IOException e) {
            System.out.println("Error inputing path");
            return;
        }
        System.out.print("Input save file name (without .mp3): ");
        try {
            filestr = br.readLine();
        } catch (IOException e) {
            System.out.println("Error inputing file name");
            return;
        }
        try {
            URL url = new URL(urlstr);
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            File dir = new File(pathstr);
            File file = new File(dir, filestr + ".mp3");
            FileOutputStream out = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            while ((byteread = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteread);
            }
        } catch (MalformedURLException e) {
            System.out.println("Error in URL");
            return;
        } catch (IOException e) {
            System.out.println("Error when download");
            return;
        }
        System.out.println("Download finished");
    }
}
