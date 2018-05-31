package com.studentinvaders.tpi;

/**
 * Created by Senistan.JEGARAJASIN on 25.05.2018.
 */

public class TeacherWords extends Words {

    boolean known;

    public TeacherWords(int vocID, int idWord, String word,wordType type){
        super(vocID,idWord,word,type);
        this.known = false;
    }
}
