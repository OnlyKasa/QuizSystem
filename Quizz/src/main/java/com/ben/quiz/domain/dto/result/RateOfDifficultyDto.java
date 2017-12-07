package com.ben.quiz.domain.dto.result;

public class RateOfDifficultyDto {

    private int iRateOfDifficultyPk;
    private String strRateDifficultyName;
    private Integer iNumQuestionLevel1;
    private Integer iNumQuestionLevel2;
    private Integer iNumQuestionLevel3;
    private Integer iNumQuestionLevel4;
    private Integer iRateOfDifficultyPkEk;

    public int getiRateOfDifficultyPk() {
        return iRateOfDifficultyPk;
    }

    public void setiRateOfDifficultyPk(int iRateOfDifficultyPk) {
        this.iRateOfDifficultyPk = iRateOfDifficultyPk;
    }

    public String getStrRateDifficultyName() {
        return strRateDifficultyName;
    }

    public void setStrRateDifficultyName(String strRateDifficultyName) {
        this.strRateDifficultyName = strRateDifficultyName;
    }

    public Integer getiNumQuestionLevel1() {
        return iNumQuestionLevel1;
    }

    public void setiNumQuestionLevel1(Integer iNumQuestionLevel1) {
        this.iNumQuestionLevel1 = iNumQuestionLevel1;
    }

    public Integer getiNumQuestionLevel2() {
        return iNumQuestionLevel2;
    }

    public void setiNumQuestionLevel2(Integer iNumQuestionLevel2) {
        this.iNumQuestionLevel2 = iNumQuestionLevel2;
    }

    public Integer getiNumQuestionLevel3() {
        return iNumQuestionLevel3;
    }

    public void setiNumQuestionLevel3(Integer iNumQuestionLevel3) {
        this.iNumQuestionLevel3 = iNumQuestionLevel3;
    }

    public Integer getiNumQuestionLevel4() {
        return iNumQuestionLevel4;
    }

    public void setiNumQuestionLevel4(Integer iNumQuestionLevel4) {
        this.iNumQuestionLevel4 = iNumQuestionLevel4;
    }

    public Integer getiRateOfDifficultyPkEk() {
        return iRateOfDifficultyPkEk;
    }

    public void setiRateOfDifficultyPkEk(Integer iRateOfDifficultyPkEk) {
        this.iRateOfDifficultyPkEk = iRateOfDifficultyPkEk;
    }
}
