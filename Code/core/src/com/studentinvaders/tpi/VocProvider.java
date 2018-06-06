package com.studentinvaders.tpi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;

import jdk.nashorn.internal.parser.JSONParser;

/**
 * Created by Senistan.JEGARAJASIN on 17.05.2018.
 * Réception des données du webservice pour ainsi les mettre dans un tableau respectif.
 * @author Seni-J
 * @version 1.0
 */

public class VocProvider {
    private static ArrayList<Languages> languages;
    private static ArrayList<Vocabulary> vocs;
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

                    // Ajout des langages avec le webservice
                    for (JsonValue langages : baselangue.iterator()) {
                        Integer id = langages.getInt("lId");
                        String lang = langages.getString("lName");
                        languages.add(new Languages(id, lang));
                    }
                }

                @Override
                public void failed(Throwable t) {
                    Gdx.app.error("Requête HTTP", "Pas de connexion", t);
                }

                @Override
                public void cancelled() {
                    Gdx.app.log("Requête HTTP", "cancelled");
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

                    //Ajout des vocs
                    for (JsonValue voc : base.iterator()) {
                        Integer idVoc = voc.getInt("mId");
                        String titleVoc = voc.getString("mTitle");
                        Integer idLangTeacher = voc.getInt("mLang1");
                        Integer idLangStudent = voc.getInt("mLang2");

                        Vocabulary newvoc = new Vocabulary(idVoc,titleVoc,idLangTeacher,idLangStudent);

                        JsonValue words = voc.get("Words");

                        // Ajout des mots suivant le vocabulaire
                        for(JsonValue word : words.iterator()){
                            Integer idWord = word.getInt("mId");
                            String wordTeacher = word.getString("mValue1");
                            String wordStudent = word.getString("mValue2");

                            newvoc.addWords(new TeacherWords(idVoc, idWord, wordTeacher, Words.wordType.Teacher), new StudentWords(idVoc, idWord, wordStudent, Words.wordType.Student));
                        }
                        vocs.add(newvoc);
                    }
                }

                @Override
                public void failed(Throwable t) {
                    Gdx.app.error("Requête HTTP", "Pas de connexion", t);
                }

                @Override
                public void cancelled() {
                    Gdx.app.log("Requête HTTP", "cancelled");
                }
            });
        }

    }
    static public ArrayList<Languages> getLanguages(){
        return languages;
    }

    static public ArrayList<Vocabulary> getVocs(){
        return vocs;
    }

    static public Vocabulary getVoc(int vocid) {
        return vocs.get(vocid);
    }
}
