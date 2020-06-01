package com.bokor.bt_mathoperation.Item;

/**
 * Created by Arvin on 2/21/2018.
 */

public class Question {

    public String questions[] = {
            "នារីមានសៀវភៅ120ក្បាល។ នាងបានចែកសៀវភៅទាំងនេះឱ្យទៅប្អូនៗនាងទាំង4នាក់ ដោយក្នុងម្នាក់ៗទទួលបានចំណែកស្មើៗគ្នា។ តើប្អូនៗរបស់នាងបានសៀវភៅម្នាក់ប៉ុន្មានក្បាល។",
            "លោកគ្រូសំមានក្រូច250ផ្លែ គាត់ចែកឱ្យសិស្សចំនួន5នាក់។ តើសិស្សម្នាក់ៗទទួលបានក្រូចប៉ុន្មានផ្លែ?",
            "កសិដ្ឋានមួយកន្លែង ចិញ្ចឹម មាន់20ក្បាល ដោយម្ចាស់កសិដ្ឋានបានលក់មាន់អស់ចំនួន5ក្បាល។ តើម្ចាស់កសិដ្ឋាននោះនៅសល់មាន់ចំនួនប៉ុន្មាន?"
    };

    public String choices[][] = {
            {"30", "35", "40", "45"},
            {"40", "50", "60", "70"},
            {"14", "5", "10", "15"}
    };

    public String correctAnswer[] = {
        "30",
        "50",
        "15"
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
