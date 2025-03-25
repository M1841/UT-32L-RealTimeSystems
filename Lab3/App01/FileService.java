package Lab3.App01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FileService {
  public FileService(String fileName) {
    this.fileName = fileName;

    try {
      writer = new PrintWriter(new FileWriter(fileName, true));
      reader = new BufferedReader(new FileReader(fileName));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void write(String message) {
    Date date = new Date(System.currentTimeMillis());
    writer.println("Date: " + date);

    writer.println("Message: " + message);
    writer.flush();
  }

  public String read() throws IOException {
    String iterator, last = "no message to read";

    while ((iterator = reader.readLine()) != null) {
      last = new Date(System.currentTimeMillis()) + " - "
          + iterator;
    }

    return last;
  }

  String fileName;
  BufferedReader reader;
  PrintWriter writer;
}
