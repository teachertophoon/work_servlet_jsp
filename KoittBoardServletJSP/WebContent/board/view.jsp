<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>글 상세보기</title></head>
<body>
	<table>
		<tbody>
			<tr>
				<th>번호</th>
				<td>${ requestScope.board.no }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${ requestScope.board.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${ requestScope.board.content }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${ requestScope.board.writer }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${ requestScope.board.regdate }</td>
			</tr>
		</tbody>
	</table>
</body>
</html>