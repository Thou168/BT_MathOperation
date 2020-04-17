package com.bokor.bt_mathoperation.Item;

public class Item_list_lesson {
    private String num_lesson;
    private String des_lesson;


    public Item_list_lesson(String num_lesson, String des_lesson)
    {
        this.num_lesson = num_lesson;
        this.des_lesson = des_lesson;
    }

    public String getNum_lesson() {
        return num_lesson;
    }

    public void setNum_lesson(String num_lesson) {
        this.num_lesson = num_lesson;
    }

    public String getDes_lesson() {
        return des_lesson;
    }

    public void setDes_lesson(String des_lesson) {
        this.des_lesson = des_lesson;
    }
}
