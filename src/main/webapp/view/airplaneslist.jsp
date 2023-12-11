<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Урок JDBC Список самолетов</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            background-color: #f9f9f9;
        }

        .home-button {
            position: absolute;
            top: 20px;
            right: 20px;
            padding: 10px 20px;
            border: none;
            border-radius: 12px;
            background-color: #007aff;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .home-button:hover {
            background-color: #005bb5;
        }

        .center-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100%;
        }

        table {
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #007aff;
            color: white;
        }
    </style>
</head>
<body>

<button class="home-button" onclick="location.href='${pageContext.request.contextPath}/';">На главную</button>

<div class="center-container">
    <h1>Список самолетов:</h1>
    <table>
        <tr>
            <th>id</th>
            <th>Название самолета</th>
            <th>Дальность полета</th>
        </tr>
        <tbody>
        <c:forEach var="airCraft" items="${airCrafts}">
            <tr>
                <td>${airCraft.airCraftCode}</td>
                <td>${airCraft.model}</td>
                <td>${airCraft.range}</td>
            </tr>
        </c:forEach>
        </tbody>
        <tr>
            <th>id</th>
            <th>Название самолета</th>
            <th>Дальность полета</th>
        </tr>
    </table>
</div>

</body>
</html>
