<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page session="true" %>
    <div class="header-2">
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <i class="fa fa-bars" aria-hidden="true"></i>
                    </button>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <div class="navbar-right">
                        <ul class="nav navbar-nav flexbox">
                            <li class="username">
                                <a href="#">
									<span class="text-overflow">
										<i class="fa fa-user" aria-hidden="true"></i> ${fullname}
									</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/auth/C108">
                                    <i class="fa fa-sign-out" aria-hidden="true"></i> ログアウト
                                </a>
                            </li>
                        </ul>
                    </div>

                    <ul class="nav navbar-nav navbar-main">
                        <li class="active first-child">
                            <a>利用履歴</a>
                            <div class="sub-menu">
                                <ul class="flexbox">
                                    <li class="sub-active">
                                        <a href="#"><span>利用履歴</span></a>
                                    </li>
                                    <li><a href="#"><span>配達内容訂正申請</span></a></li>
                                    <li><a href="#"><span>配達内容訂正承認</span></a></li>
                                </ul>
                            </div>
                        </li>

                        <li class="normal">
                            <a>請求支払</a>
                            <div class="sub-menu">
                                <ul class="flexbox">
                                    <li><a href="#"><span>請求</span></a></li>
                                    <li><a href="#"><span>事業所別月別利用明細</span></a></li>
                                    <li><a href="#"><span>従業員別月別利用明細</span></a></li>
                                    <li><a href="#"><span>支払</span></a></li>
                                    <li><a href="#"><span>店舗別月別売上</span></a></li>
                                </ul>
                            </div>
                        </li>

                        <li class="normal">
                            <a>メニュー管理</a>
                            <div class="sub-menu">
                                <ul class="flexbox">
                                    <li><a href="#"><span>メニュー</span></a></li>
                                    <li><a href="#"><span>メニュー詳細</span></a></li>
                                    <li><a href="#"><span>メニューカテゴリー</span></a></li>
                                    <li><a href="#"><span>配達メニュー</span></a></li>
                                    <li><a href="#"><span>配達メニュー詳細</span></a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="normal">
                            <a>弁当予約管理</a>
                            <div class="sub-menu">
                                <ul class="flexbox">
                                    <li><a href="#"><span>従業員別予約一覧</span></a></li>
                                    <li><a href="#"><span>事業所別予約一覧</span></a></li>
                                    <li><a href="#"><span>配達先別一覧</span></a></li>
                                    <li><a href="#"><span>メニュー別一覧</span></a></li>
                                    <li><a href="#"><span>予約履歴</span></a></li>
                                </ul>
                            </div>
                        </li>

                        <li>
                            <a><spring:message code="MENU.AM" /></a>
                            <div class="sub-menu">
                                <ul class="flexbox">
                                    <li><a href="${pageContext.request.contextPath}/company/AM19"><span><spring:message code="MENU.AM.AM19" /></span></a></li>
                                    <li><a href="${pageContext.request.contextPath}/company/AM20"><span><spring:message code="MENU.AM.AM20" /></span></a></li>
                                    <li><a href="${pageContext.request.contextPath}/company/AM21"><span><spring:message code="MENU.AM.AM21" /></span></a></li>
                                    <li><a href="#"><span>事業所情報</span></a></li>
                                    <li><a href="#"><span>事業所月額オプション設定</span></a></li>
                                    <li><a href="#"><span>従業員情報</span></a></li>
                                    <li><a href="#"><span>NFC情報</span></a></li>
                                </ul>
                            </div>
                        </li>

                        <li class="normal">
                            <a>基本情報(店舗)</a>
                            <div class="sub-menu">
                                <ul class="flexbox">
                                    <li><a href="#"><span>店舗運営企業情報</span></a></li>
                                    <li><a href="#"><span>店舗企業契約情報</span></a></li>
                                    <li><a href="#"><span>店舗情報</span></a></li>
                                    <li><a href="#"><span>店舗月額オプション設定</span></a></li>
                                    <li><a href="#"><span>配達条件</span></a></li>
                                    <li><a href="#"><span>配達先情報</span></a></li>
                                    <li><a href="#"><span>休業日情報</span></a></li>
                                    <li><a href="#"><span>店舗スタッフ情報</span></a></li>
                                </ul>
                            </div>
                        </li>

                        <li class="normal last-child">
                            <a>システム管理</a>
                            <div class="sub-menu">
                                <ul class="flexbox">
                                    <li><a href="#"><span>月額オプションマスタ</span></a></li>
                                    <li><a href="#"><span>都道府県</span></a></li>
                                    <li><a href="#"><span>消費税</span></a></li>
                                    <li><a href="#"><span>配達メニュージャンル</span></a></li>
                                    <li><a href="#"><span>端末</span></a></li>
                                    <li><a href="#"><span>カード種別</span></a></li>
                                    <li><a href="#"><span>健康MSG</span></a></li>
                                    <li><a href="#"><span>タブレットアプリVER</span></a></li>
                                    <li><a href="#"><span>利用規約</span></a></li>
                                    <li><a href="#"><span>システムパラメータ</span></a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
