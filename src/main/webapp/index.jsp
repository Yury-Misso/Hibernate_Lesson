<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Урок JDBC</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            background-color: #f9f9f9;
        }

        .center-container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100%;
            text-align: center;
        }

        h1, h2 {
            color: #333;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        .button {
            font-size: 16px;
            width: 200px;
            padding: 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 12px;
            border: 2px solid #007aff;
            background-color: #007aff;
            color: white;
            transition: background-color 0.3s, box-shadow 0.3s;
        }

        .button:hover {
            background-color: #005bb5;
            box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>

<div class="center-container">
    <h1>Урок JDBC</h1>

    <h2>Задания:</h2>
    <ul>
        <li>
            <!-- Кнопка перехода на страницу со списком самолетов -->
            <a href="${pageContext.request.contextPath}/airplanelist" class="button">Выдать список самолетов</a>
        </li>
        <li>
            <!-- Кнопка перехода на страницу со списком аэропортов -->
            <a href="${pageContext.request.contextPath}/airportslist" class="button">Выдать список аэропортов</a>
        </li>
        <li>
            <!-- Кнопка перехода на страницу со списком полетов -->
            <a href="${pageContext.request.contextPath}/flightslist" class="button">Выдать список полетов</a>
        </li>
    </ul>
</div>

</body>
</html>
