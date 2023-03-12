package org.example;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipTest {

    public static void main(String[] args) throws Exception {
        String txt = readZip("F:\\zip5.zip");
        System.out.println(txt);
    }

    public static String readZip(String file) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
        ZipEntry zipEntry = null;
        StringBuffer sb = new StringBuffer();
        while ((zipEntry = zis.getNextEntry()) != null) {
            BufferedInputStream bis = new BufferedInputStream(zis);
            String encoding = CodeDetector.getEncode(bis, false);
            if (zipEntry.getName().equals("zip3.txt")) {
                encoding = "UTF-16LE";
            }
            bis.reset();

            System.out.println("\n");
            System.out.println("文件名：" + zipEntry.getName() + " 文件大小：" + zipEntry.getSize() + " bytes" + " 编码：" + encoding);

            byte[] buffer = new byte[1024];
            int pos = 0;
            while ((pos = bis.read(buffer)) != -1) {
                String chunk = new String(buffer, 0, pos, Charset.forName(encoding));
                System.out.println(chunk);
            }
        }

        zis.closeEntry();
        return sb.toString();
    }

    public static String readTxt(String file) throws Exception {
        String encoding = CodeDetector.getEncode(file, true);
        return encoding;
    }
}
