package pao.biblioteca;

import pao.biblioteca.exceptions.FileWritingException;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileService {
    /**
     * Serviciu pentru citirea din fisier.
     * Am folosit mai multe metode.
     * Sunt aruncate exceptii acolo unde este nevoie.
     */

    public static void writeUsingFileOutputStream(String text, String path) throws FileWritingException {
        try (FileOutputStream out = new FileOutputStream(path)) {
            out.write(text.getBytes());
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingFileOutputStream method", e);
        }
    }

    public static void writeUsingFileWriter(String text, String path) throws FileWritingException {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.append(text);
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingFileWriter method", e);
        }
    }


    public static void writeUsingBufferedOutputStream(String text, String path) throws FileWritingException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream(path))) {
            bufferedOutputStream.write(text.getBytes());
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingBufferedOutputStream method", e);
        }
    }



}