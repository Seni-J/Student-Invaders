package com.studentinvaders.tpi;

import java.util.ArrayList;

/**
 * Created by Senistan.JEGARAJASIN on 17.05.2018.
 */

public class VocProvider {
    private static ArrayList<String> languages;
    private static ArrayList<Vocabulary> vocs;

    static public void load(){
        languages = new ArrayList<String>();
        languages.add("Français");
        languages.add("Anglais");
        languages.add("Allemand");
        languages.add("Espagnol");

        Vocabulary voc1 = new Vocabulary(1,"Les Couleurs",1,2);
        Vocabulary voc2 = new Vocabulary(2,"Le Restaurant",1,2);
        Vocabulary voc3 = new Vocabulary(3,"Les affaires",1,2);
        Vocabulary voc4 = new Vocabulary(4,"L'art",1,2);
        Vocabulary voc5 = new Vocabulary(5,"Les couleurs",1,3);
        Vocabulary voc6 = new Vocabulary(6,"Le Restaurant",1,3);
        Vocabulary voc7 = new Vocabulary(7,"Les Affaires",2,3);
        Vocabulary voc8 = new Vocabulary(8,"Le Restaurant",2,4);

        vocs = new ArrayList<Vocabulary>();
        vocs.add(voc1);
        vocs.add(voc2);
        vocs.add(voc3);
        vocs.add(voc4);
        vocs.add(voc5);
        vocs.add(voc6);
        vocs.add(voc7);
        vocs.add(voc8);

    }
    static public ArrayList<String> getLanguages(){
        return languages;
    }

    static public ArrayList<Vocabulary> getVocs(){
        return vocs;
    }
}
