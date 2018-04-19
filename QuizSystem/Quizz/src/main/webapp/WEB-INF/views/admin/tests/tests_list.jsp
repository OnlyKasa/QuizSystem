<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<div class="row">
    <div class="col-xs-12 col-sm-4 col-md-4 box-left">
        <div class="box-infor mb20">
            <h5 class="title-box">Thông tin cơ bản</h5>
            <div class="box-infor-common" id="common-content">

            </div>
        </div>

        <div class="box-infor box-infor-question">
            <h5 class="title-box">Danh sách câu hỏi</h5>
            <ul class="list-question list-inline" id="list-question-button">


            </ul>
        </div>
    </div>

    <div class="col-xs-12 col-sm-8 col-md-8 box-right">
        <div class="category-question" id="table-content">

            <div class="box-item-question">
                <div class="head-box">
                    <span class="txt-bold">Câu 2: </span>
                    <span class="content-question">
									 Phân tích cấu trúc của quy phạm pháp luật?.
								</span>
                </div>
                <div class="body-box">
                    <div class="answer">
                        <div class="radio">
                            <input id="radio-1" name="radio" type="radio">
                            <label for="radio-1" class="radio-label">Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức</label>
                        </div>
                    </div>
                    <div class="answer">
                        <div class="radio">
                            <input id="radio-2" name="radio" type="radio">
                            <label for="radio-2" class="radio-label">Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                        </div>
                    </div>
                    <div class="answer">
                        <div class="radio">
                            <input id="radio-3" name="radio" type="radio">
                            <label for="radio-3" class="radio-label">Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan</label>
                        </div>
                    </div>
                    <div class="answer">
                        <div class="radio">
                            <input id="radio-4" name="radio" type="radio">
                            <label for="radio-4" class="radio-label">Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="box-item-question">
                <div class="head-box">
                    <span class="txt-bold">Câu 2: </span>
                    <span class="content-question">
									Quy phạm pháp luật là gì? Phân tích cấu trúc của quy phạm pháp luật? (Hãy lấy ví dụ minh họa).
								</span>
                </div>
                <div class="body-box">
                    <div class="answer">
                        <div class="checkbox">
                            <input id="checkbox-1" name="radio" type="checkbox">
                            <label for="checkbox-1" class="checkbox-label"><div><i class="fa fa-check"></i></div>Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                        </div>
                    </div>
                    <div class="answer">
                        <div class="checkbox">
                            <input id="checkbox-2" name="radio" type="checkbox">
                            <label for="checkbox-2" class="checkbox-label"><div><i class="fa fa-check"></i></div>Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                        </div>
                    </div>
                    <div class="answer">
                        <div class="checkbox">
                            <input id="checkbox-3" name="radio" type="checkbox">
                            <label for="checkbox-3" class="checkbox-label"><div><i class="fa fa-check"></i></div>Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                        </div>
                    </div>
                    <div class="answer">
                        <div class="checkbox">
                            <input id="checkbox-4" name="radio" type="checkbox">
                            <label for="checkbox-4" class="checkbox-label"><div><i class="fa fa-check"></i></div>Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                        </div>
                    </div>
                </div>
            </div>

            <div class="box-item-question">
                <div class="head-box">
                    <span class="txt-bold">Câu 3: </span>
                    <span class="content-question">
									Quy phạm pháp luật là gì? Phân tích cấu trúc của quy phạm pháp luật? (Hãy lấy ví dụ minh họa).
								</span>
                </div>
                <div class="body-box">
                    <div class="answer">
                        <textarea class="form-control"></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script id="template-table-content" type="text/template7">
    <div class="box-item-question">
        <div class="head-box">
            <span class="txt-bold">Câu {{index}}: </span>
            <span class="content-question">
									Quy phạm pháp luật là gì?.
								</span>
        </div>
        <div class="body-box">
            <div class="answer">
                <div class="radio">
                    <input id="radio-strAnswer1-{{index}}" name="radio" type="radio">
                    <label for="radio-strAnswer1-{{index}}" class="radio-label" id="strAnswer1">Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                </div>
            </div>
            <div class="answer">
                <div class="radio">
                    <input id="radio-strAnswer2-{{index}}" name="radio" type="radio">
                    <label for="radio-strAnswer2-{{index}}" class="radio-label" id="strAnswer2">Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                </div>
            </div>
            <div class="answer">
                <div class="radio">
                    <input id="radio-strAnswer3-{{index}}" name="radio" type="radio">
                    <label for="radio-strAnswer3-{{index}}" class="radio-label" id="strAnswer3">Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                </div>
            </div>
            <div class="answer">
                <div class="radio">
                    <input id="radio-strAnswer4-{{index}}" name="radio" type="radio">
                    <label for="radio-strAnswer4-{{index}}" class="radio-label" id="strAnswer4">Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                </div>
            </div>
        </div>
    </div>
</script>
<script id="template-botton-question" type="text/template7">
    <li>
        <button class="btn btn-number" id="button-{{index}}" >index</button>
    </li>
</script>

<script id="template-common-content" type="text/template7">
    <div class="item-info">
        <div class="row">
            <div class="col-xs-5 clear-pr">
                <label>Tên môn thi:</label>
            </div>
            <div class="col-xs-7 clear-pl5">
                <span>Pháp luật đại cương</span>
            </div>
        </div>
    </div>

    <div class="item-info">
        <div class="row">
        <div class="col-xs-5 clear-pr">
        <label>Ngày thi:</label>
    </div>
    <div class="col-xs-7 clear-pl5">
        <span>20/12/2017</span>
    </div>
    </div>
    </div>

    <div class="item-info">
        <div class="row">
            <div class="col-xs-5 clear-pr">
                <label>Thời gian làm bài:</label>
            </div>
            <div class="col-xs-7 clear-pl5">
                <span>120 phút</span>
            </div>
        </div>
    </div>

    <div class="item-info">
        <div class="row">
            <div class="col-xs-5 clear-pr">
                <label>Thời gian còn lại:</label>
            </div>
            <div class="col-xs-7 clear-pl5">
                <div class="range-time">
                    <span class="num-hour">01</span>
                    <span>:</span>
                    <span class="num-min">45</span>
                </div>
             </div>
        </div>
    </div>
</script>



