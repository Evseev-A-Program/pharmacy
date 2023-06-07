<%@ page import="com.google.gson.Gson" %>
<%@ page import="org.evseev.model.Sales" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список чеков</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<%
    Gson gson = new Gson();
    Sales[] sales = gson.fromJson((String) request.getAttribute("sales"), Sales[].class);
%>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Аптека. Филиал.</th>
        <th>Документ</th>
        <th>Позиций в чеке</th>
        <th>Дата создания чека</th>
        <th>Количество проданных товаров</th>
        <th>Общая сумма</th>
    </tr>
    </thead>
    <tbody>
    <% for (Sales sale : sales) { %>
    <tr>
        <td><%= sale.getId() %></td>
        <td><%= sale.getBranch() %></td>
        <td><%= sale.getDocType() %></td>
        <td><%= sale.getPosCount() %></td>
        <td><%= sale.getCreateDate() %></td>
        <td><%= sale.getSumQuantity() %></td>
        <td><%= sale.getSumRoznWNDS() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

</body>
</html>
