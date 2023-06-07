<%@ page import="com.google.gson.Gson" %>
<%@ page import="org.evseev.model.Sales" %>
<%@ page import="org.evseev.model.ChequeContent" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Чек</title>

    <style>
        body{
            background-color: #b3f8e4;
            font-size: 150%;
        }
        #context{
            text-align: center;
        }
        a {
            color: #BA7D67;
            border: 2px solid transparent;
        }
        a:hover {
            border: 2px solid #BA7D67;
        }

        body{
            background-color: antiquewhite;
        }
        .table_price {
            border-collapse: collapse;
            border-left: 3px solid #22aebb;
            border-right: 3px solid #22aebb;
            border-bottom: 3px solid #22aebb;
            font-family: "Lucida Grande", sans-serif;
            margin: 0 auto;
            text-align: center;
        }
        .table_price caption {
            background: #22aebb;
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
            background: #22aebb;
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
<%--<%--%>
<%--    Gson gson = new Gson();--%>
<%--    Sales[] sales = gson.fromJson((String) request.getAttribute("chequeContent"), Sales[].class);--%>
<%--%>--%>
    <div id="context">
        <a href="/pharmacy_war_exploded/sales">Показать список чеков</a>
        <h1></h1>
    </div>


<%
    Gson gson = new Gson();
    ChequeContent[] chequeContents = gson.fromJson((String) request.getAttribute("contents"), ChequeContent[].class);
%>
<table class="table_price">
    <caption>Чек <%= request.getAttribute("chequeId") %></caption>
    <thead>
    <tr>
        <th>Название товара</th>
        <th>Форма выпуска</th>
        <th>Производитель</th>
        <th>Количество проданного товара</th>
        <th>Сумма продажи</th>
        <th>Ставка НДС</th>
        <th>Срок годности</th>
    </tr>
    </thead>
    <tbody>
    <% for (ChequeContent chequeContent : chequeContents) { %>
    <tr>
        <td><%= chequeContent.getDrug() %></td>
        <td><%= chequeContent.getForm() %></td>
        <td><%= chequeContent.getFabr() %></td>
        <td><%= chequeContent.getQuantity() %></td>
        <td><%= chequeContent.getSumRoznWNDS() %></td>
        <td><%= chequeContent.getNds() %></td>
        <td><%= chequeContent.getSrokG() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
