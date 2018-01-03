var Tests = function () {
    let checkEnd = false ;
    var tests = {
      numberQuestion : 0,
        listQuestion :[],
        dateStart : new Date()
    };
    let hour = 0 ;
    let minute =0 ;
    let template7 = {
        compileTemplateCommon : Template7.compile($("#template-common-content").html()),
        compileTemplateQuestionContent : Template7.compile($("#template-question-content").html()),
        compileTemplateButtonQuestion : Template7.compile($("#template-button-question").html()),
        hour : Template7.compile($("#templatehour").html()),
        minute : Template7.compile($("#templateminute").html()),
    };

    let url ={
        urlCountTest : contextPath + "/tests/countByTestID",
        urlViewTest : contextPath + "/tests/findByTestID",
        urlSaveTest : contextPath +"/tests/updateByTestID"
    };

    function init() {
        tests.dateStart = new Date(dateStartTest);
        countQuestion();
    }
    function startTime(totalTimeTest) {
        let timeTest = (tests.dateStart - new Date())/1000/60 + totalTimeTest ;    // minute
        if(timeTest > 60){
            minute =  Math.floor(timeTest % 60) ;
            hour = Math.floor(timeTest/60);
        }else{
            hour =0 ;
            minute = timeTest ;
        }

        hour =checkTime(hour);
        minute =checkTime(minute);

        setTimeout(startTime, 500);
    }

    function checkTime(i) {
        if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
        return i;
    }
    function countQuestion() {
        let data = {
            iTestInformationPk:iTestInformationPk
        };
        executeGetNew(url.urlCountTest +"?"+ paramEncode(data),countSuccess,countError) ;
    }
    let position ={};
    function countSuccess(res) {
        if(res > 0){
            tests.numberQuestion = res ;
            listQuestion();
            for(let index = 1 ; index < res +1;index++ ) {
                let numberQuestion ={
                    index : index
                };
                $("#list-question-button").append(template7.compileTemplateButtonQuestion(numberQuestion));
            }
            $("#button-1").addClass("select");
        }else{
            redirectPage('student','s102');
            display("Load tests false !!");
        }

    }

    function goToPosition(index) {
        $("#button-" + index).addClass("select");
        for(let i = 1 ; i <tests.numberQuestion +1 ;i++ ) {
            if (i != index)
                $("#button-" + i).removeClass("select");

        }
        $("#table-content").animate({
            scrollTop: position['question' + index]
        }, 1000);
    }

    function listQuestion() {
        let data = {
            iTestInformationPk:iTestInformationPk,
            page : 0,
            rowPerPage : 0
        };
        executeGetNew(url.urlViewTest +"?"+ paramEncode(data),listSuccess,countError) ;
    }

    function listSuccess(res) {
        tests.listQuestion = $.map(res, function (value) {
            return [value];
        });
        showCommon(res[0]);

        for(let index = 0 ; index< res.length  ;index++){
            res[index]['index'] = index +1;
            $("#table-content").append(template7.compileTemplateQuestionContent(res[index]));
            position['question' + (index +1)] = $('#question-' + (index+1)).position().top;
        }

    }

    function showCommon(res) {
        res["dtExaminationDay"]= reFormatDateTime(res["dtExaminationDay"]);
        console.log(res["iTestInformationTime"]);

        $("#common-content").html(template7.compileTemplateCommon(res));
        setInterval(function () {
            startTime(res["iTestInformationTime"]);
            res["hour"] = hour ;
            res["minute"] =minute;
            $("#hour").empty();
            $("#minute").empty();
            $("#hour").html(template7.hour(res));
            $("#minute").html(template7.minute(res));
            if(hour ==0 && minute ==0){
                checkEnd = true;
                submitTest();
            }
        },1000);
        $("#common-content").append("<button class='btn btn-green' id='btnSubmitTest'>Nộp bài</button>");

        $("#btnSubmitTest").click(function () {
            checkEnd = true;
            submitTest();
        })
    }
    function countError(err) {
        redirectPage('student','s102');
        display(err.responseText);

    }

    function submitTest() {
        for(let index = 0 ;index < tests.listQuestion.length;index ++){
            let nameRadio = 'radio-'+(index + 1).toString();
            let numberAnswer = $("input[name="+nameRadio+"]:checked").val();
            if(index ==0 )
            tests.listQuestion[index].dtExaminationDay = new Date(tests.listQuestion[index].dtExaminationDay);

            if(numberAnswer !="undefined"){
                switch (numberAnswer){
                    case 1 :
                        tests.listQuestion[index]['strStudentAnswer'] = tests.listQuestion[index]['strAnswer1'];
                        break;
                    case 2 :
                        tests.listQuestion[index]['strStudentAnswer'] = tests.listQuestion[index]['strAnswer2'];
                        break;
                    case 3 :
                        tests.listQuestion[index]['strStudentAnswer'] = tests.listQuestion[index]['strAnswer3'];
                        break;
                    case 4 :
                        tests.listQuestion[index]['strStudentAnswer'] = tests.listQuestion[index]['strAnswer4'];
                        break;
                    case 5 :
                        tests.listQuestion[index]['strStudentAnswer'] = tests.listQuestion[index]['strAnswer5'];
                        break;
                }

            }

        }

        let data = JSON.stringify({testInformationDetailDtos : tests.listQuestion, iStudentInformationPk:123});
        console.log(data);
        executePostNew(url.urlSaveTest,data ,saveSuccess,display)
    }
    function saveSuccess() {
        if(checkEnd)
            displayUpdated('student','s102')
    }
    return{
        init:init,
        goToPosition : goToPosition
    }
}();



$(document).ready(function () {
   Tests.init();
});