package com.bokor.bt_mathoperation.Item;

/**
 * Created by Arvin on 2/21/2018.
 */

public class Question {

    public String questions[] = {
            "ស៊ីណាមានប្រាក់38ដុល្លា។ នាងទិញស្បែកជើងអស់ប្រាក់15ដុល្លា។ តើស៊ីណានៅសល់ប្រាក់ប៉ុន្មាន?",
            "ស្រីណុច និងស្រីនាងមានគោ10ក្បាល ហើយគេទាំងពីរ បានហូបអស់8ក្បាល។ តើគេទាំងពីរនាក់ នៅសល់គោប៉ុន្មានក្បាល?",
            "កសិដ្ឋានមួយកន្លែង ចិញ្ចឹម ជ្រូក 10ក្បាល មាន់20ក្បាល និងទា15ក្បាល។ ហើយម្ចាស់កសិដ្ឋានបានលក់មាន់អស់ចំនួន9ក្បាល។ តើម្ចាស់កសិដ្ឋាននោះនៅសល់មាន់ចំនួនប៉ុន្មាន?"
    };

    public String choices[][] = {
            {"21", "22", "23", "24"},
            {"1", "2", "3", "4"},
            {"8", "9", "10", "11"}
    };

    public String correctAnswer[] = {
        "23",
        "2",
        "11"
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
