package com.studentinvaders.tpi;

/**
 * Created by Senistan.JEGARAJASIN on 25.05.2018.
 * @author Seni-J
 * @version 1.0
 */

public class TeacherWords extends Words {

    boolean known;

    /**
     * Constructeur pour chaque mot du prof. La particularité est qu'on rajoute un booléen "known" pour savoir si le mot a été appris ou non.
     *
     * @param vocID = id du vocabulaire
     * @param idWord = id du mot
     * @param word = Mot de l'élève
     * @param type = Le type pour le mot (Prof ou élève). Un seul type possible dans ce cas, le prof.
     */
    public TeacherWords(int vocID, int idWord, String word,wordType type){
        super(vocID,idWord,word,type);
        this.known = false;
    }
}
