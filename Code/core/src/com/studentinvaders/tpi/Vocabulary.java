package com.studentinvaders.tpi;

import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

/**
 * Created by Senistan.JEGARAJASIN on 17.05.2018.
 */

public class Vocabulary {
    int id;
    String vocName;
    int langprof;
    int langeleve;

    ArrayList<TeacherWords> teacherWords;
    ArrayList<StudentWords> studentWords;

    Vocabulary(int id, String vocName, int langprof, int langeleve){
        this.id = id;
        this.vocName = vocName;
        this.langprof = langprof;
        this.langeleve = langeleve;

        /*teacherWords = new ArrayList<TeacherWords>();
        studentWords = new ArrayList<StudentWords>();*/
    }

    public void addWord(){

    }
}
