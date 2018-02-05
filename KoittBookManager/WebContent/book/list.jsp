<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>도서관리 목록</title></head>
<body>
	<table>
		<thead>
			<tr>
				<th>책 번호</th>
				<th>책 제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>책 설명</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${ requestScope.list }">
				<tr>
					<td>${ book.isbn }</td>
					<td>${ book.title }</td>
					<td>${ book.author }</td>
					<td>${ book.publisher }</td>
					<td>${ book.price }</td>
					<td>${ book.description }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>