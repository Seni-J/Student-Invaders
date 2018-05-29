package com.studentinvaders.tpi;

import java.util.ArrayList;

/**
 * Created by Senistan.JEGARAJASIN on 17.05.2018.
 */

public class VocProvider {
    private static ArrayList<String> languages;
    private static ArrayList<Vocabulary> vocs;
    private static ArrayList<TeacherWords> teacherWords;
    private static ArrayList<StudentWords> studentWords;

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

        teacherWords = new ArrayList<TeacherWords>();
        studentWords = new ArrayList<StudentWords>();
        TeacherWords wordsTeach1 = new TeacherWords(1,1264,"blanc", Words.wordType.Teacher);
        StudentWords wordsStud1 = new StudentWords(1,1264,"white", Words.wordType.Student);
        TeacherWords wordsTeach2 = new TeacherWords(1,1265,"bleu", Words.wordType.Teacher);
        StudentWords wordsStud2 = new StudentWords(1,1265,"blue", Words.wordType.Student);
        TeacherWords wordsTeach3 = new TeacherWords(1,1266,"bleu clair", Words.wordType.Teacher);
        StudentWords wordsStud3 = new StudentWords(1,1266,"light blue", Words.wordType.Student);
        TeacherWords wordsTeach4 = new TeacherWords(1,1267,"rouge", Words.wordType.Teacher);
        StudentWords wordsStud4 = new StudentWords(1,1267,"red", Words.wordType.Student);
        TeacherWords wordsTeach5 = new TeacherWords(1,1271,"bleu foncé",Words.wordType.Teacher);
        StudentWords wordsStud5 = new StudentWords(1,1271,"dark blue", Words.wordType.Student);
        TeacherWords wordsTeach6 = new TeacherWords(1,1268,"multicolore",Words.wordType.Teacher);
        StudentWords wordsStud6 = new StudentWords(1,1268,"multi-colored", Words.wordType.Student);
        teacherWords.add(wordsTeach1);
        teacherWords.add(wordsTeach2);
        teacherWords.add(wordsTeach3);
        teacherWords.add(wordsTeach4);
        teacherWords.add(wordsTeach5);
        teacherWords.add(wordsTeach6);
        studentWords.add(wordsStud1);
        studentWords.add(wordsStud2);
        studentWords.add(wordsStud3);
        studentWords.add(wordsStud4);
        studentWords.add(wordsStud5);
        studentWords.add(wordsStud6);


    }
    static public ArrayList<String> getLanguages(){
        return languages;
    }

    static public ArrayList<Vocabulary> getVocs(){
        return vocs;
    }

    static public ArrayList<TeacherWords> getTeacherWords(){return teacherWords;}

    static public ArrayList<StudentWords> getStudentWords(){return studentWords;}
}
