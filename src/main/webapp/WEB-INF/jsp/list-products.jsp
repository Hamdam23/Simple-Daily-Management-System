<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-product">Add Product</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of Products</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
				<tr>
					<th width="40%">Name</th>
					<th width="40%">Category</th>
					<th width="40%">Description</th>
					<th width="40%">Date</th>
					<th width="20%"></th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td>${product.name}</td>
						<td>${product.category}</td>
						<td>${product.description}</td>
						<td><fmt:formatDate value="${product.timestamp}"
											pattern="dd/MM/yyyy" /></td>
						<td><a type="button" class="btn btn-success"
							   href="/update-product?id=${product.id}">Update</a>
							<a type="button" class="btn btn-warning"
							   onclick="deleteProfile(${product.id});">Delete</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>
<%@ include file="common/modal.jsp"%>
<script>function deleteProfile(id) {
	document.querySelector('#modal').classList.add('show');
	document.querySelector('#modal-ok').addEventListener('click', ()=> {
		location.href = '/delete-product?id=' + id;
	});
	document.querySelector('#modal-cancel').addEventListener('click', ()=> {
		document.querySelector('#modal').classList.remove('show');
	});
}</script>