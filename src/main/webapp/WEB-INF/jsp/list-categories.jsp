<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <div>
        <a type="button" class="btn btn-primary btn-md" href="/add-category">Add Category</a>
    </div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>List of Categories</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="40%">Name</th>
                    <th width="40%">Description</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categories}" var="category">
                    <tr>
                        <td>${category.name}</td>
                        <td>${category.description}</td>
                        <td><a type="button" class="btn btn-success"
                               href="/update-category?id=${category.id}">Update</a>
                            <a type="button" class="btn btn-warning"
                               onclick="deleteProfile(${category.id});">Delete</a></td>
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
		location.href = '/delete-category?id=' + id;
	});
	document.querySelector('#modal-cancel').addEventListener('click', ()=> {
		document.querySelector('#modal').classList.remove('show');
	});
}</script>