package pao.fisiere;

import pao.fisiere.exceptions.FileReadingException;
import pao.fisiere.exceptions.FileWritingException;


import pao.fisiere.exceptions.FileReadingException;
import pao.fisiere.exceptions.FileWritingException;


    public class Main {

        public static void main(String[] args) throws FileWritingException, FileReadingException {
            WriteToFileService.writeUsingFileOutputStream("hello again");
            ReadFromFileService.readUsingFileInputStream();

            WriteToFileService.writeUsingFileWriter("hello again");
            ReadFromFileService.readUsingFileReader();

            WriteToFileService.writeUsingDataOutputStream("hello again");
            ReadFromFileService.readUsingDataInputStream();

            WriteToFileService.writeUsingBufferedOutputStream("hello again");
            ReadFromFileService.readUsingBufferedInputStream();

            WriteToFileService.writeUsingBufferedWriter("hello again");
            ReadFromFileService.readUsingBufferedReader();
        }
    }
