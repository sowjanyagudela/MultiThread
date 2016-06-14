/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread;

/**
 *
 * @author ramakrishna
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomAccessFileEx {

    static final String FILEPATH = "/www/shared/FTP/jacob/dynamic/2014-06-27/4084_AvailabilityAndPrices_20140626030225.txt";
    static final String FILE_OUT_PATH = "/home/ramakrishna/avail_w.txt";
    private static RandomAccessFile file = null;
    private static RandomAccessFile file1 = null;

    static {
        if (file == null) {
            try {
                file = new RandomAccessFile(FILEPATH, "r");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RandomAccessFileEx.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (file1 == null) {
            try {
                file1 = new RandomAccessFile(FILE_OUT_PATH, "rw");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RandomAccessFileEx.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static byte[] readFromFile(String filePath, int position, int size)
            throws IOException {
        byte[] bytes;

        System.out.println("Reading from " + position + " data size :" + size);
        file.seek(position);
        bytes = new byte[size];
        file.read(bytes);

        return bytes;

    }

    public static void writeToFile(String filePath, byte[] data, int position)
            throws IOException {
        file1 = new RandomAccessFile(filePath, "rw");
        file1.seek(position);
        file1.write(data);
        //file1.close();
    }
}