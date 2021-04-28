package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DaVinciCode {
    /*
    Hozdd létre a DaVinciCode osztályt, és abban a decode metódust,
    ami paraméternek várja egy file elérési útját és a keresett karaktert, ami lehet '0', '1' vagy 'x'.

Ha paraméterként nem ezen karakterek egyikét kapja, akkor dobjon egy kivételt!

A fájl 0, 1 és x karaktereket tartalmaz.
A metódus térjen vissza azzal, hogy a második paraméterben kapott karakter hányszor szerepel a fájlban.

22p
     */
    public int encode(String path, char findChar){
        int count= 0;

        if(findChar!='0' &&findChar!='1' && findChar!='x'){
            throw new IllegalArgumentException("Character must be 0 1 or x");
        }

        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {
            String line;
            while ((line = br.readLine())  != null) {

                count = countCharFromLine(findChar, count, line);
            }
            return count;

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }

    private int countCharFromLine(char findChar, int count, String line) {
        for(char ch: line.toCharArray()){
            if(ch== findChar){
                count++;
            }
        }
        return count;
    }
}
