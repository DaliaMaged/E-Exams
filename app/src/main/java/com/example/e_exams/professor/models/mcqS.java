package com.example.e_exams.professor.models;

public class mcqS {
    private String msqQuestion;
    private boolean firstBtn,secondBtn,thirdBtn ,forthBtn;
    private String firstAns,secondAns,thirdANs,forthAns;

    public mcqS(String msqQuestion, String firstAns, String secondAns, String thirdANs, String forthAns) {
        this.msqQuestion = msqQuestion;
//        this.firstBtn = firstBtn;
//        this.secondBtn = secondBtn;
//        this.thirdBtn = thirdBtn;
//        this.forthBtn = forthBtn;
        this.firstAns = firstAns;
        this.secondAns = secondAns;
        this.thirdANs = thirdANs;
        this.forthAns = forthAns;
    }

    public void setMsqQuestion(String msqQuestion) {
        this.msqQuestion = msqQuestion;
    }

    public String getMsqQuestion() {
        return msqQuestion;
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
//
//    public boolean isThirdBtn() {
//        return thirdBtn;
//    }
//
//    public void setThirdBtn(boolean thirdBtn) {
//        this.thirdBtn = thirdBtn;
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

    public String getThirdANs() {
        return thirdANs;
    }

    public void setThirdANs(String thirdANs) {
        this.thirdANs = thirdANs;
    }



//    public boolean isForthBtn() {
//        return forthBtn;
//    }
//
//    public void setForthBtn(boolean forthBtn) {
//        this.forthBtn = forthBtn;
//    }

    public String getForthAns() {
        return forthAns;
    }

    public void setForthAns(String forthAns) {
        this.forthAns = forthAns;
    }
}
