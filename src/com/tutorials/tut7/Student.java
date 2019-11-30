package com.tutorials.tut7;

public class Student
{
    private String name;
    private String studentNumber;
    private String username;
    private Subject[] subjects;

    public Student(String name, String studentNumber, String username, int size) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.username = username;
        this.subjects = new Subject[size];
        for(int i = 0; i< subjects.length; i++)
        {
            subjects[i] = null;
        }
    }

    public Boolean enrolSubject(Subject newSubject)
    {
        Boolean success_enrol = false;
        for(int i = 0; i < subjects.length; i++)
        {
            if(subjects[i] == null)
            {
                subjects[i] = newSubject;
                success_enrol = true;
                break;
            }
        }
        return success_enrol;
    }

    public Boolean unenrolSubject(Subject delSubject)
    {
        Boolean success_unenrol = false;
        for(int i = 0; i < subjects.length; i++)
        {
            if(subjects[i] != null && subjects[i].toString().equals(delSubject.toString()))
            {
                subjects[i] = null;
                success_unenrol = true;
                break;
            }
        }
        return success_unenrol;
    }

    public String printAllSubjects()
    {
        String allSubjects = "";
        for(int i = 0; i < subjects.length; i++)
        {
            if(subjects[i] != null)
            {
                allSubjects += subjects[i].toString() + "\n";
            }
        }
        return allSubjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public Subject[] getSubjects() {
        return subjects;
    }
}
