
package hu.nive.ujratervezes.io.phonebook;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) throw new IllegalArgumentException("Üres vagy nem található fájl.");
        File file = new File(output);
        BufferedWriter bf;

        try {
            file.delete();
            file.createNewFile();
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry :
                    contacts.entrySet()) {
                bf.write(entry.getKey() + ": "
                        + entry.getValue());
                bf.newLine();
            }
            bf.flush();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}