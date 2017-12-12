<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="true"%>
<%@ page isELIgnored="false"%>

<section class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-4 col-md-4 box-left">
            <div class="box-infor mb20">
                <h5 class="title-box">Thông tin cơ bản</h5>
                <div class="box-infor-common">
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
                                    <span class="num-hour">02</span>
                                    <span>:</span>
                                    <span class="num-min">00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="box-infor box-infor-question">
                <h5 class="title-box">Danh sách câu hỏi</h5>
                <ul class="list-question list-inline">
                    <li>
                        <button class="btn btn-number" type="">1</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">2</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">3</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">4</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">5</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">6</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">7</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">8</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">9</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">10</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">100</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">499</button>
                    </li>
                    <li>
                        <button class="btn btn-number" type="">499</button>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-xs-12 col-sm-8 col-md-8 box-right">
            <div class="category-question">
                <div class="box-item-question">
                    <div class="head-box">
                        <span class="txt-bold">Câu 1: </span>
                        <span class="content-question">
									Quy phạm pháp luật là gì? Phân tích cấu trúc của quy phạm pháp luật? (Hãy lấy ví dụ minh họa).
								</span>
                    </div>
                    <div class="body-box">
                        <div class="answer">
                            <div class="radio">
                                <input id="radio-1" name="radio" type="radio">
                                <label for="radio-1" class="radio-label">Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                            </div>
                        </div>
                        <div class="answer">
                            <div class="radio">
                                <input id="radio-2" name="radio" type="radio">
                                <label for="radio-2" class="radio-label">Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
                            </div>
                        </div>
                        <div class="answer">
                            <div class="radio">
                                <input id="radio-3" name="radio" type="radio">
                                <label for="radio-3" class="radio-label">Là những quy tắc, chuẩn mực chung mang tính bắt buộc phải thi hành đối với tất cả tổ chức, cá nhân có liên quan, và được ban hành bởi các cơ quan Nhà nước có thẩm quyền.</label>
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

</section><!-- /.container -->