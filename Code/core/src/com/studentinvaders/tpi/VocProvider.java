package com.studentinvaders.tpi;

import java.util.ArrayList;

/**
 * Created by Senistan.JEGARAJASIN on 17.05.2018.
 */

public class VocProvider {
    private static ArrayList<String> languages;
    private static ArrayList<Vocabulary> vocs;
    private static ArrayList<Words> words;

    static public void load(){
        languages = new ArrayList<String>();
        languages.add("Français");
        languages.add("Anglais");
        languages.add("Allemand");
        languages.add("Espagnol");

        vocs = new ArrayList<Vocabulary>();
        Vocabulary voc1 = new Vocabulary(1,"Les Couleurs",1,2);
        Vocabulary voc2 = new Vocabulary(2,"Le Restaurant",1,2);
        Vocabulary voc3 = new Vocabulary(3,"Les affaires",1,2);
        Vocabulary voc4 = new Vocabulary(4,"L'art",1,2);
        Vocabulary voc5 = new Vocabulary(5,"Les couleurs",1,3);
        Vocabulary voc6 = new Vocabulary(6,"Le Restaurant",1,3);
        Vocabulary voc7 = new Vocabulary(7,"Les Affaires",2,3);
        Vocabulary voc8 = new Vocabulary(8,"Le Restaurant",2,4);
        vocs.add(voc1);
        vocs.add(voc2);
        vocs.add(voc3);
        vocs.add(voc4);
        vocs.add(voc5);
        vocs.add(voc6);
        vocs.add(voc7);
        vocs.add(voc8);

        words = new ArrayList<Words>();
        Words words1 = new Words(1,1264,"blanc","white");
        Words words2 = new Words(1,1265,"bleu","blue");
        Words words3 = new Words(1,1266,"bleu clair","light blue");
        words.add(words1);
        words.add(words2);
        words.add(words3);



    }
    static public ArrayList<String> getLanguages(){
        return languages;
    }

    static public ArrayList<Vocabulary> getVocs(){
        return vocs;
    }

    static public ArrayList<Words> getWords(){return words;}
}
