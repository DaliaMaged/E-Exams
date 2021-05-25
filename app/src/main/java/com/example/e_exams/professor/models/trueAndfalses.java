package com.example.e_exams.professor.models;

public class trueAndfalses {
    public String gettNfQuestion() {
        return tNfQuestion;
    }

    public void settNfQuestion(String tNfQuestion) {
        this.tNfQuestion = tNfQuestion;
    }

//    public boolean isFirstBtn() {
//        return firstBtn;
//    }
//
//    public void setFirstBtn(boolean firstBtn) {
//        this.firstBtn = firstBtn;
//    }
//
//    public boolean isSecondBtn() {
//        return secondBtn;
//    }
//
//    public void setSecondBtn(boolean secondBtn) {
//        this.secondBtn = secondBtn;
//    }

    public String getFirstAns() {
        return firstAns;
    }

    public void setFirstAns(String firstAns) {
        this.firstAns = firstAns;
    }

    public String getSecondAns() {
        return secondAns;
    }

    public void setSecondAns(String secondAns) {
        this.secondAns = secondAns;
    }

    public trueAndfalses(String tNfQuestion, String firstAns, String secondAns) {
        this.tNfQuestion = tNfQuestion;
//        this.firstBtn = firstBtn;
//        this.secondBtn = secondBtn;
        this.firstAns = firstAns;
        this.secondAns = secondAns;
    }

    private String tNfQuestion;
//    private boolean firstBtn,secondBtn;
    private String firstAns,secondAns;
}
