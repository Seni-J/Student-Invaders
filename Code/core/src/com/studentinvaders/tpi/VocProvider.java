package com.studentinvaders.tpi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;

/**
 * Created by Senistan.JEGARAJASIN on 17.05.2018.
 * Réception des données du webservice pour ainsi les mettre dans un tableau respectif.
 * @author Seni-J
 * @version 1.0
 */

public class VocProvider {
    private static ArrayList<Languages> languages;
    private static ArrayList<Vocabulary> vocs;
    private static ArrayList<TeacherWords> teacherWords;
    private static ArrayList<StudentWords> studentWords;

    static public void load(){
        languages = new ArrayList<Languages>();
        vocs = new ArrayList<Vocabulary>();


        if(languages.isEmpty()) {
            HttpRequestBuilder requestLangues = new HttpRequestBuilder();
            final Net.HttpRequest httpRequestLangues = requestLangues.newRequest().method(Net.HttpMethods.GET).url("http://voxerver.mycpnv.ch/api/v1/languages").build();
            Gdx.net.sendHttpRequest(httpRequestLangues, new Net.HttpResponseListener() {
                @Override
                public void handleHttpResponse(Net.HttpResponse httpResponse) {
                    JsonReader jsonlangue = new JsonReader();
                    JsonValue baselangue = jsonlangue.parse(httpResponse.getResultAsString());

                    for (JsonValue langages : baselangue.iterator()) {
                        Integer id = langages.getInt("lId");
                        String lang = langages.getString("lName");
                        languages.add(new Languages(id, lang));
                    }
                    Gdx.app.log("HttpRequestExample", "response: " + baselangue.toString());
                }

                @Override
                public void failed(Throwable t) {
                    Gdx.app.error("HttpRequestExample", "No connection", t);
                }

                @Override
                public void cancelled() {
                    Gdx.app.log("HttpRequestExample", "cancelled");
                }
            });
        }

        if(vocs.isEmpty()) {
            HttpRequestBuilder requestVocs = new HttpRequestBuilder();
            final Net.HttpRequest httpRequestVocs = requestVocs.newRequest().method(Net.HttpMethods.GET).url("http://voxerver.mycpnv.ch/api/v1/fullvocs").build();
            Gdx.net.sendHttpRequest(httpRequestVocs, new Net.HttpResponseListener() {
                @Override
                public void handleHttpResponse(Net.HttpResponse httpResponse) {
                    JsonReader json = new JsonReader();
                    JsonValue base = json.parse(httpResponse.getResultAsString());

                    for (JsonValue voc : base.iterator()) {
                        Integer idVoc = voc.getInt("mId");
                        String titleVoc = voc.getString("mTitle");
                        Integer idLangTeacher = voc.getInt("mLang1");
                        Integer idLangStudent = voc.getInt("mLang2");

                        vocs.add(new Vocabulary(idVoc,titleVoc,idLangTeacher,idLangStudent));

                        Gdx.app.log("Value",voc.getChild("Words").toString());
                    }
                }

                @Override
                public void failed(Throwable t) {
                    Gdx.app.error("HttpRequestExample", "No connection", t);
                }

                @Override
                public void cancelled() {
                    Gdx.app.log("HttpRequestExample", "cancelled");
                }
            });
        }


/*
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
        studentWords.add(wordsStud6);*/


    }
    static public ArrayList<Languages> getLanguages(){
        return languages;
    }

    static public ArrayList<Vocabulary> getVocs(){
        return vocs;
    }

    static public ArrayList<TeacherWords> getTeacherWords(){return teacherWords;}

    static public ArrayList<StudentWords> getStudentWords(){return studentWords;}
}
