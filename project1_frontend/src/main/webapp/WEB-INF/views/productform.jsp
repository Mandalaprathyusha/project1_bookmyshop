<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style=background-color:orange>
<c:url value="/admin/saveproduct" var="url"></c:url>
	<form:form action="${url }" method="post" modelAttribute="product" enctype="multipart/form-data">
		<div class="form-group">
			<form:hidden path="id" class="form-control" />
		</div>
		<div class="form-group">
			Enter Product Name
			<form:input path="productName" class="form-control"  />
			<form:errors path="productName" cssStyle="color:red"></form:errors>
		</div>
		<br>
		<div class="form-group">
			Enter Price
			<form:input path="price" class="form-control" />
			<form:errors path="price" cssStyle="color:red"></form:errors>
		</div>
		<br>
		<div class="form-group">
			Enter Quantity
			<form:input path="quantity" class="form-control" />
			<form:errors path="quantity" cssStyle="color:red"></form:errors>
		</div>
		<br>
		<div class="form-group">
			Enter Description
			<form:textarea path="description" class="form-control"  />
			<form:errors path="description" cssStyle="color:red"></form:errors>
		</div>
		<br>
		<div class="form-group">
			Select Category
			<form:select path="category.id">
			<c:forEach items="${categories }" var="c">
			<form:option value="${c.id }">${c.categoryName }</form:option>
			<!--  
				<form:radiobutton path="category.id" value="${c.id }" />${c.categoryName }
				-->
		    </c:forEach>
		    </form:select>
		 </div>
		 <div class="form-group">
		 Upload an image
		 <input type="file" name="image">
		 </div>
		
		<div class="form-group">
         <input type="submit" value="Add Product">
       </div>

	</form:form>

</body>
</html>
<%@ include file="footer.jsp"%>