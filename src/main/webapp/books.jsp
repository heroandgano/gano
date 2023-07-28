<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="metro4:locale" content="ko-KR" />
<meta name="metro4:init" content="false" />

<title>Madang Metro</title>

<link rel="stylesheet"
	href="https://cdn.korzh.com/metroui/v4.5.1/css/metro-all.min.css" />
<style>
a.customer_id, a.customer_id:visited {
	cursor: pointer;
	text-decoration: underline;
	color: blue;
}
</style>
</head>

<body>

	<div data-role="appbar" data-expand="true">
		<ul class="app-bar-menu">
			<li><a href="<c:url value="madang?action=orderings"/>">주문</a></li>
			<li><a href="<c:url value="madang?action=customers"/>">고객</a></li>
			<li><a href="<c:url value="madang?action=books"/>">도서</a></li>
		</ul>
	</div>
	<br />
	<br />
	<br />

	<div class="container">
		<label>책정보</label>
		<br>
		<table class="table">

			<thead>
				<tr>
					<th>책번호</th>
					<th>제목</th>
					<th>출판사</th>
					<th>금액</th>
				</tr>
			</thead>
			
			<tbody id="books">
				<c:forEach var="book" varStatus="i" items="${bookList}">
					<tr>
						<td><a class="book_id"
							href="<c:url value="madang?action=book&id=${book.id}"/>"
							data-id="${book.id}">${book.id}</a></td>
						<td>${book.title}</td>
						<td>${book.publisher}</td>
						<td>${book.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="container">
		<form id="goto_form" action="<c:url value="madang"/>" method="get">
			<input type="hidden" name="action" value="book" />
			<input type="hidden" name="id" value="-1" />
			<input type="submit" value="추가" id="add_button" />
		</form>
	</div>

	<script>
		let hasOrdering = ${hasOrdering};
	</script>

	<script src="books.js"></script>
</body>
</html>