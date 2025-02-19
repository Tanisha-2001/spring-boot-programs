<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h2>Product List</h2>
    <table border="1">
        <tr>
            <th>Product Name</th>
            <th>Product Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>
                    <a href="update.html?id=${product.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="add.html">Add New Product</a>
</body>
</html>
