package com.ben.quiz.domain.dto.request;

public class SubjectInformationSearchReq {

    private String strSubjectInformationName;

    private String strFacultyInformationShortName;
    private String strFacultyInformationFullName;

    public String getStrSubjectInformationName() {
        return strSubjectInformationName;
    }

    public void setStrSubjectInformationName(String strSubjectInformationName) {
        this.strSubjectInformationName = strSubjectInformationName;
    }

    public String getStrFacultyInformationShortName() {
        return strFacultyInformationShortName;
    }

    public void setStrFacultyInformationShortName(String strFacultyInformationShortName) {
        this.strFacultyInformationShortName = strFacultyInformationShortName;
    }

    public String getStrFacultyInformationFullName() {
        return strFacultyInformationFullName;
    }

    public void setStrFacultyInformationFullName(String strFacultyInformationFullName) {
        this.strFacultyInformationFullName = strFacultyInformationFullName;
    }
}
