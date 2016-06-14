/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramakrishna
 */
public class MultiThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            RandomAccessFile raf = new RandomAccessFile(RandomAccessFileEx.FILEPATH, "r");

            Long fileSize = null;
            fileSize = raf.length();
            System.out.println("FileSize :::: " + fileSize);


            RandomAccessFile raf1 = new RandomAccessFile("/home/ramakrishna/hdcn_w.XML", "rw");

            int position = 0;
            int size = fileSize.intValue() / 8;
            for (int i = 0; i < 8; i++) {
                position = i * size;
                byte[] data_t1 = RandomAccessFileEx.readFromFile(RandomAccessFileEx.FILEPATH, position, size);
                System.out.println("d "+i + data_t1.length);
                new Thread(new FileThread(RandomAccessFileEx.FILE_OUT_PATH, data_t1, position)).start();

            }



            byte[] data_t1 = RandomAccessFileEx.readFromFile(RandomAccessFileEx.FILEPATH, 0, (int) (fileSize / 3));
//            System.out.println("d1 " + data_t1.length);
//            new Thread(new FileThread(RandomAccessFileEx.FILE_OUT_PATH, data_t1, 0)).start();
//            //raf.seek(fileSize / 2);
//            //System.out.println(""+raf.length());
//            byte[] data_t2 = RandomAccessFileEx.readFromFile(RandomAccessFileEx.FILEPATH, (int) (fileSize / 3), (int) (fileSize / 3));
//            //raf.read(data_t2, (int) (fileSize / 2), fileSize.intValue() - 1);
//            //raf1.seek(fileSize / 2);
//            System.out.println("d2 " + data_t2.length);
//            new Thread(new FileThread(RandomAccessFileEx.FILE_OUT_PATH, data_t2, ((int) (fileSize / 3)))).start();
//
//            byte[] data_t3 = RandomAccessFileEx.readFromFile(RandomAccessFileEx.FILEPATH, 2 * ((int) (fileSize / 3)), (int) (fileSize / 3));
//            System.out.println("d3 " + data_t3.length);
//            new Thread(new FileThread(RandomAccessFileEx.FILE_OUT_PATH, data_t3, 2 * ((int) (fileSize / 3)))).start();

            //RandomAccessFileEx.FILEPATH.close;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            RandomAccessFile raf = new RandomAccessFile("/www/shared/FTP/jacob/dynamic/2014-06-27/4084_AvailabilityAndPrices_20140626030225.txt", "r");
//            RandomAccessFile raf1 = new RandomAccessFile("/home/ramakrishna/avail_w.txt", "rw");
//            byte[] data = new byte[(int) raf.length()];
//            raf.read(data);
//            raf1.write(data);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
//        }


    }
}
