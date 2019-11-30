package com.tutorials.tut7;

public class Subject
{
    private String subjectCode;
    private String title;
    private String coordinator;

    public Subject(String subjectCode, String title, String coordinator) {
        this.subjectCode = subjectCode;
        this.title = title;
        this.coordinator = coordinator;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public String printAllStudents(Student[] students)
    {
        String allStudents = "";
        for(int i = 0; i < students.length; i++)
        {
            for(int j = 0; j < students[i].getSubjects().length; j++)
            {
                if(students[i].getSubjects()[j].getSubjectCode() == subjectCode)
                {
                    allStudents += students[i].toString() + "\n";
                }
            }
        }
        return allStudents;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectCode='" + subjectCode + '\'' +
                ", title='" + title + '\'' +
                ", coordinator='" + coordinator + '\'' +
                '}';
    }
}
