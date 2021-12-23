package com.example.a201835025;

import java.util.ArrayList;
import java.util.List;

public class QuestionLibrary {

    private static List<QuestionsList> songQuestions() {

        List<QuestionsList> questionsLists1 = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("What musical instrument do you hear?","Piano", "Guitar", "Violin","Akordeon","Guitar","",0);
        final QuestionsList question2 = new QuestionsList("What musical instrument do you hear?","Akerdeon", "Bass Guitar", "Violin","Piano","Piano","",1);
        final QuestionsList question3 = new QuestionsList("What musical instrument do you hear?","Saxophone ", "Guitar", "Violin","Akordeon","Violin","",2);
        final QuestionsList question4 = new QuestionsList("What musical instrument do you hear?","Tuba ", "Viola", "Violin","Saxophone","Saxophone","",3);
        final QuestionsList question5 = new QuestionsList("What musical instrument do you hear?","Clarinet ", "Bass Guitar", "Bell","Akordeon","Clarinet ","",4);
        final QuestionsList question6 = new QuestionsList("What musical instrument do you hear?","Drum", "Bell", "Oud","Saxophone","Drum","",5);
        final QuestionsList question7 = new QuestionsList("What musical instrument do you hear?","Oud", "Guitar", "Violin","Akordeon","Oud","",6);
        final QuestionsList question8 = new QuestionsList("What musical instrument do you hear?","Piano", "Tambourine", "Tuba","Electro Guitar","ElectroGuitar","",7);
        final QuestionsList question9 = new QuestionsList("What musical instrument do you hear?","Piano", "Flute", "Violin","Tambourine","Flute","",8);
        final QuestionsList question10 = new QuestionsList("What musical instrument do you hear?","Tambourine", "Guitar", "Violin","Tuba","Tambourine","",9);


        questionsLists1.add(question1);
        questionsLists1.add(question2);
        questionsLists1.add(question3);
        questionsLists1.add(question4);
        questionsLists1.add(question5);
        questionsLists1.add(question6);
        questionsLists1.add(question7);
        questionsLists1.add(question8);
        questionsLists1.add(question9);
        questionsLists1.add(question10);

        return questionsLists1;

    }
    private static List<QuestionsList> instrQuestions() {

        List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("What musical instrument do you hear?","Harmonica", "Guitar", "Baggipe","Akordeon","Akordeon","",0);
        final QuestionsList question2 = new QuestionsList("What musical instrument do you hear?","Tambourine", "Drum", "Triangle","Cello","Cello","",1);
        final QuestionsList question3 = new QuestionsList("What musical instrument do you hear?","Pipe", "Guitar", "Keyboard","Hand drum","Hand drum","",2);
        final QuestionsList question4 = new QuestionsList("What musical instrument do you hear?","Gong", "Maracas", "Double bass","Violin","Violin","",3);
        final QuestionsList question5 = new QuestionsList("What musical instrument do you hear?","Balalayka", "Maracas", "Xylophone","Mızıka","Mızıka","",4);
        final QuestionsList question6 = new QuestionsList("What musical instrument do you hear?","Banjo", "Percussion", "Mandolin","Tef","Tef","",5);
        final QuestionsList question7 = new QuestionsList("What musical instrument do you hear?","Piano", "Shrill pipe", "Melodica","Clairnet","Clairnet","",6);
        final QuestionsList question8 = new QuestionsList("What musical instrument do you hear?","Recorder", "Viola", "Oboe","Melodica","Melodica","",7);
        final QuestionsList question9 = new QuestionsList("What musical instrument do you hear?","Bugle", "Trumpet", "Organ","Piyano","Piyano","",8);
        final QuestionsList question10 = new QuestionsList("What musical instrument do you hear?","Piano", "Harmonica", "Trombone","Guitar","Guitar","",9);


        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

        return questionsLists;
    }




    public static List<QuestionsList> getQuestions(String selectedTopicName) {
        switch (selectedTopicName){
        case "song":
            return songQuestions();
            case "instr":
            return instrQuestions();
            default:
                return songQuestions();
        }
    }

}
