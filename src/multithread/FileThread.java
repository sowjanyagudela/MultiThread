package multithread;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ramakrishna
 */
public class FileThread implements Runnable {

    private String filePath;
    private byte[] data;

    private int offSet;
    //private int length;
    
    public FileThread(String filePath, byte[] data,int offSet) {
        this.filePath = filePath;
        this.data = data;
        this.offSet = offSet;
        //this.length = legth;
    }

    @Override
    public void run() {
        try {
            RandomAccessFileEx.writeToFile(filePath, data, offSet);
        } catch (IOException ex) {
            Logger.getLogger(FileThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
