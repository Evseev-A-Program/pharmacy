<%@ page import="com.google.gson.Gson" %>
<%@ page import="org.evseev.model.Sales" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список чеков</title>
<%--    <link rel="stylesheet" type="text/css" href="/WEB-INF/css/sales.css">--%>

    <style>
        body{
            background-color: antiquewhite;
        }
        .table_price {
            border-collapse: collapse;
            border-left: 3px solid #F79361;
            border-right: 3px solid #F79361;
            border-bottom: 3px solid #F79361;
            font-family: "Lucida Grande", sans-serif;
            margin: 0 auto;
            text-align: center;
        }
        .table_price caption {
            background: #F79361;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            padding: 10px;
            box-shadow: 0 2px  4px 0 rgba(0,0,0,.3);
            color: white;
            font-family: "Roboto Slab",serif;
            font-style: normal;
            font-size: 26px;
            text-align: center;
            margin: 0;
        }
        .table_price td, .table_price th {
            padding: 10px;
        }
        .table_price th {
            text-align: left;
            font-size: 18px;
        }
        .table_price tr:nth-child(2n) {
            background: #E5E5E5;
        }
        .table_price td:last-of-type {
            text-align: center;
        }
        .table_price input[type="submit"] {
            display: inline-block;
            padding: 5px 10px;
            background: #F79361;
            box-shadow: 2px 2px 0 0 #a22800;
            position: relative;
            user-select: none;
        }
        .table_price input[type="submit"]:hover {
            box-shadow: none;
            top: 2px;
            left: 2px;
        }

    </style>
</head>
<body>
<%
    Gson gson = new Gson();
    Sales[] sales = gson.fromJson((String) request.getAttribute("sales"), Sales[].class);
%>
    <table class="table_price">
        <caption>Список чеков</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>Аптека. Филиал.</th>
            <th>Документ</th>
            <th>Позиций в чеке</th>
            <th>Дата создания чека</th>
            <th>Количество проданных товаров</th>
            <th>Общая сумма</th>
            <th></th>
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
            <form action="/pharmacy_war_exploded/chequeContent" method="get">
                <input type="hidden" name="NaklTitlerId" value=<%= sale.getId() %>>
                <td><input type="submit" value="Показать"></td>
            </form>

        </tr>
        <% } %>
        </tbody>
    </table>

</body>
</html>
