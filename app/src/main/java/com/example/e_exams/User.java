package com.example.e_exams;
import android.widget.EditText;

import java.util.ArrayList;

public class User {
    private String name,email,password,type,uid,age,subject1,subject2,subject3,subject4,
            subject5,subject6,subject7,subject8, subject9,subject10,subject11,subject12,
            subject13,subject14,subject15,subject16, subject17, year1, year2, year3, year4,subjectList;

    private ArrayList<String> Subjects;
    public User(String name,String email,String password,String type, String subject1, String subject2,
                String subject3, String subject4, String year1, String year2, String year3, String year4,String subjectList,ArrayList<String> Subjects) {

    this.type=type;
    this.email = email;
    this.name=name;
    this.password = password;
    this.subject1=subject1;
    this.subject1=subject1;
    this.subject2=subject2;
    this.subject3=subject3;
    this.subject4=subject4;
    this.year1=year1;
    this.year2=year2;this.year3=year3;this.year4=year4;
    this.subjectList=subjectList;

}
    public User(String name, String email, String password, String type,String uid,String age,String subject1,String subject2,String subject3,String subject4,
                String subject5,String subject6,String subject7,String subject8,String subject9,String subject10,String subject11,String subject12,
                String subject13,String subject14,String subject15,String subject16,String subject17
            ,String year1,String year2,String year3,String year4,String subjectList) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type=type;
        this.uid=uid;
        this.age=age;
        this.subject1=subject1;  this.subject2=subject2;this.subject3=subject3;
        this.subject4=subject4;this.subject5=subject5;this.subject6=subject6;
        this.subject7=subject7;this.subject8=subject8;this.subject9=subject9;
        this.subject10=subject10;this.subject11=subject11;this.subject12=subject12;
        this.subject13=subject13;this.subject14=subject14;this.subject15=subject15;this.subject16=subject16;
        this.subject17=subject17;this.year1=year1;this.year2=year2;this.year3=year3;this.year4=year4;
        this.subjectList=subjectList;
    }

    public String getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(String subjectList) {
        this.subjectList = subjectList;
    }

    public String getSubject15() {
        return subject15;
    }

    public void setSubject15(String subject15) {
        this.subject15 = subject15;
    }

    public String getSubject16() {
        return subject16;
    }

    public void setSubject16(String subject16) {
        this.subject16 = subject16;
    }

    public String getSubject17() {
        return subject17;
    }

    public void setSubject17(String subject17) {
        this.subject17 = subject17;
    }

    public String getSubject5() {
        return subject5;
    }

    public void setSubject5(String subject5) {
        this.subject5 = subject5;
    }

    public String getSubject6() {
        return subject6;
    }

    public void setSubject6(String subject6) {
        this.subject6 = subject6;
    }

    public String getSubject7() {
        return subject7;
    }

    public void setSubject7(String subject7) {
        this.subject7 = subject7;
    }

    public String getSubject8() {
        return subject8;
    }

    public void setSubject8(String subject8) {
        this.subject8 = subject8;
    }

    public String getSubject9() {
        return subject9;
    }

    public void setSubject9(String subject9) {
        this.subject9 = subject9;
    }

    public String getSubject10() {
        return subject10;
    }

    public void setSubject10(String subject10) {
        this.subject10 = subject10;
    }

    public String getSubject11() {
        return subject11;
    }

    public void setSubject11(String subject11) {
        this.subject11 = subject11;
    }

    public String getSubject12() {
        return subject12;
    }

    public void setSubject12(String subject12) {
        this.subject12 = subject12;
    }

    public String getSubject13() {
        return subject13;
    }

    public void setSubject13(String subject13) {
        this.subject13 = subject13;
    }

    public String getSubject14() {
        return subject14;
    }

    public void setSubject14(String subject14) {
        this.subject14 = subject14;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public String getSubject3() {
        return subject3;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    public String getSubject4() {
        return subject4;
    }

    public void setSubject4(String subject4) {
        this.subject4 = subject4;
    }

    public String getYear1() {
        return year1;
    }

    public void setYear1(String year1) {
        this.year1 = year1;
    }

    public String getYear2() {
        return year2;
    }

    public void setYear2(String year2) {
        this.year2 = year2;
    }

    public String getYear3() {
        return year3;
    }

    public void setYear3(String year3) {
        this.year3 = year3;
    }

    public String getYear4() {
        return year4;
    }

    public void setYear4(String year4) {
        this.year4 = year4;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String check1) {
        this.subject1 = check1;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String check1) {
        this.type = type;
    }



    public ArrayList<String> getSubjects() {
        return Subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        Subjects = subjects;
    }

}

