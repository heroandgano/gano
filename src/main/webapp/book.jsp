<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta name="metro4:locale" content="ko-KR" />
        <meta name="metro4:init" content="false" />

        <title>bookInfo</title>

        <link rel="stylesheet" href="https://cdn.korzh.com/metroui/v4.5.1/css/metro-all.min.css" />
    </head>
<body>
 	<div data-role="appbar">
            <ul class="app-bar-menu">
                <li><a href='<c:url value="madang?action=orderings"/>'>주문</a></li>
                <li><a href='<c:url value="madang?action=customers"/>'>고객</a></li>
                <li><a href='<c:url value="madang?action=books"/>'>도서</a></li>
            </ul>
        </div>

        <br />
        <br />
        <br />
        <div class="container">
            <label>책 추가/수정/삭제 하기</label>
            <br />
            <br />
			<form id="book_form" action="<c:url value="madang"/>" method="post">
                <input type="hidden" name="action" id="book_form_action"/>
                <div class="row">
                    <label class="cell-2">책번호</label>
                    <div class="cell-10"><input type="number" data-role="input" name="id" value="${book.id}" id="id" readonly /></div>
                </div>
                <div class="row">
                    <label class="cell-2">제목</label>
                    <div class="cell-10"><input type="text" data-role="input" name="title" value="${book.title}" id="title" /></div>
                </div>
                <div class="row">
                    <label class="cell-2">출판사</label>
                    <div class="cell-10"><input type="text" data-role="input" name="publisher" value="${book.publisher}" id="publisher" /></div>
                </div>
                <div class="row">
                    <label class="cell-2">금액</label>
                    <div class="cell-10"><input type="text" data-role="input" name="price" value="${book.price}" id="price" /></div>
                </div>
                <div class="row">
                    <div class="cell-3"></div>
                    <div class="cell-3">
                        <button class="button" id="update_button">저장</button>
                        <button class="button" id="delete_button">삭제</button>
                    </div>
                    <div class="cell-3"></div>
                    <div class="cell-3"></div>
                </div>
            </form>
        </div>
        <script src="https://cdn.korzh.com/metroui/v4.5.1/js/metro.min.js"></script>
        <script src="book.js"></script>
</body>
</html>