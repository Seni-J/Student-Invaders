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

    public ArrayList<TeacherWords> teacherWords;
    public ArrayList<StudentWords> studentWords;

    Vocabulary(int id, String vocName, int langprof, int langeleve){
        this.id = id;
        this.vocName = vocName;
        this.langprof = langprof;
        this.langeleve = langeleve;

        teacherWords = new ArrayList<TeacherWords>();
        studentWords = new ArrayList<StudentWords>();
    }

    public void addWords(TeacherWords teacherWord, StudentWords studentword){
        teacherWords.add(teacherWord);
        studentWords.add(studentword);
    }

    public ArrayList<TeacherWords> getTeacherWords() {
        return teacherWords;
    }

    public ArrayList<StudentWords> getStudentWords() {
        return studentWords;
    }
}
