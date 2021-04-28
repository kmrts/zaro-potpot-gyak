package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {
    /*
    előkész edd. 13p

    Hozd létre a UniqueFinder osztályt, és abban a uniqueChars metódust, ami paraméternek kap egy String-et,
    és térjen vissza az abban levő karakterek listájával.
    Minden karakter csak egyszer szerepeljen a listában, az inputban nézett első előfordulásának megfelelő helyen.

Ha a metódus null-t kap paraméterben, akkor dobj IllegalArgumentException-t!

8p

     */
    public List<Character> uniqueChars(String param){
        if(param== null){
            throw new IllegalArgumentException("Parameter is null");
        }
        List<Character> charList= new ArrayList<>();

        for(Character ch: param.toCharArray()){
            if(!charList.contains(ch)){
                charList.add(ch);
            }
        }
        return charList;
    }
}
