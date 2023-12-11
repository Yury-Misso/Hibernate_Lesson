<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Урок JDBC Список самолетов</title>
    <style>
        .my-style-input {
            font-family: 'San Francisco', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
            font-size: 16px;
            padding: 8px 12px;
            border-radius: 8px;
            border: 1px solid #c7c7cc;
            outline: none;
            transition: border-color 0.3s ease;
            width: 100%;
            box-sizing: border-box;
            -webkit-appearance: none;
        }

        .my-style-input:focus {
            border-color: #007aff;
            box-shadow: 0 0 5px rgba(0, 122, 255, 0.2);
        }

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

        .pagination {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px;
            font-family: 'San Francisco', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
        }

        .pagination a {
            color: #007aff;
            font-size: 16px;
            text-decoration: none;
            margin: 0 5px;
            padding: 5px 10px;
            border-radius: 8px;
            transition: background-color 0.3s ease;
        }

        .pagination a:hover {
            background-color: rgba(0, 122, 255, 0.1);
        }

        .pagination .active {
            color: #fff;
            background-color: #007aff;
        }

        .pagination .previous, .pagination .next {
            font-weight: bold;
            padding: 5px 15px;
        }

        .page-size-selector {
            display: flex;
            align-items: center;
            padding: 5px 10px;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .page-size-selector:hover {
            background-color: rgba(0, 122, 255, 0.1);
        }

        .page-size-selector label {
            color: #007aff;
            font-size: 16px;
            margin-right: 10px;
        }

        .page-size-selector select {
            color: #007aff;
            font-size: 16px;
            padding: 5px 10px;
            border-radius: 8px;
            border: 1px solid #007aff;
            background-color: #fff;
        }

    </style>

    <script>

        function myFunction() {
            let params = getAllParam();

            let baseUrl = window.location.origin;
            let endpoint = "/jdbclesson/flightslist";
            let fullUrl = baseUrl + endpoint;

            let formData = objectToFormData(params);

            fetch(fullUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: formData
            }).then(response => response.text())
                .then(html => {
                    document.documentElement.innerHTML = html;
                });
        }

        function objectToFormData(obj) {
            let formData = '';
            for (let key in obj) {
                if (formData) formData += '&';
                formData += key + '=' + encodeURIComponent(obj[key]);
            }
            return formData;
        }

        function getAllParam() {
            return {
                pageSize: document.getElementById('pageSize').value,
                pageNo: 1,
                flightId: document.getElementById('flightId').value,
                flightNo: document.getElementById('flightNo').value,
                scheduledDeparture: document.getElementById('scheduledDeparture').value,
                scheduledArrival: document.getElementById('scheduledArrival').value,
                departureAirport: document.getElementById('departureAirport').value,
                arrivalAirport: document.getElementById('arrivalAirport').value,
                status: document.getElementById('status').value,
                aircraftCode: document.getElementById('aircraftCode').value,
                actualDeparture: document.getElementById('actualDeparture').value,
                actualArrival: document.getElementById('actualArrival').value
            };
        }

        function getPage(obj) {
            let params = getAllParam();
            params.pageNo = obj;


            let baseUrl = window.location.origin;
            let endpoint = "/jdbclesson/flightslist";
            let fullUrl = baseUrl + endpoint;

            let formData = objectToFormData(params);

            fetch(fullUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: formData
            }).then(response => response.text())
                .then(html => {
                    document.documentElement.innerHTML = html;
                });
        }

    </script>


</head>


<body>

<button class="home-button" onclick="location.href='${pageContext.request.contextPath}/';">На главную</button>

<div class="center-container">
    <h1>Список полетов:</h1>


    <div class="pagination">

        <a class="previous" onclick="getPage('prev#'+${pageParam.pageNo})">←</a>

        <c:forEach var="i" begin="1" end="10" step="1">
            <c:set var="temp" value="${i+pageParam.pageNo-6}"/>
            <c:if test="${(temp>0) && (temp<=pageParam.maxPage)}">

                <c:choose>
                    <c:when test="${(pageParam.pageNo==temp)}">
                        <a id="active" onclick="getPage(${temp})" class="active">${temp}</a>
                    </c:when>
                    <c:otherwise>
                        <a onclick="getPage(${temp})">${temp}</a>
                    </c:otherwise>
                </c:choose>

            </c:if>
        </c:forEach>

        <a onclick="getPage('next#'+${pageParam.pageNo})">→</a>

    </div>

    <div class="page-size-selector">
        <label for="pageSize">Записей на странице:</label>
        <select id="pageSize" name="pageSize" onchange="myFunction()">
            <option value="15" <c:if test="${pageParam.sizePage == '15'}">selected</c:if>>15</option>
            <option value="30" <c:if test="${pageParam.sizePage == '30'}">selected</c:if>>30</option>
            <option value="50" <c:if test="${pageParam.sizePage == '50'}">selected</c:if>>50</option>
            <option value="100" <c:if test="${pageParam.sizePage == '100'}">selected</c:if>>100</option>
            <option value="200" <c:if test="${pageParam.sizePage == '200'}">selected</c:if>>200</option>
        </select>
    </div>


    <table>
        <tr>
            <th>Id полета</th>
            <th>Номер полета</th>
            <th>Запланированный вылет</th>
            <th>Запланированный прилет</th>
            <th>Аэропорт отправления</th>
            <th>Аэропорт прибытия</th>
            <th>Статус</th>
            <th>Код самолета</th>
            <th>Актуальный вылет</th>
            <th>Актуальный прилет</th>
        </tr>
        <tr>
            <th><input class="my-style-input" type="text" id="flightId"
                       value="${flightFilters !=null ? flightFilters.flightId : ''}"
                       placeholder="Фильтр..."
                       onchange="myFunction()">
            </th>
            <th><input class="my-style-input" type="text" id="flightNo"
                       value="${flightFilters !=null ? flightFilters.flightNo : ''}"
                       placeholder="Фильтр..."
                       onchange="myFunction()">
            </th>
            <th><input class="my-style-input" type="date" id="scheduledDeparture"
                       value="${flightFilters !=null ? flightFilters.scheduledDeparture : ''}"
                       placeholder="Фильтр..."
                       onchange="myFunction()">
            </th>
            <th><input class="my-style-input" type="date" id="scheduledArrival"
                       value="${flightFilters !=null ? flightFilters.scheduledArrival : ''}"
                       placeholder="Фильтр..."
                       onchange="myFunction()">
            </th>
            <th><input class="my-style-input" type="text" id="departureAirport"
                       value="${flightFilters !=null ? flightFilters.departureAirport : ''}"
                       placeholder="Фильтр..."
                       onchange="myFunction()">
            </th>
            <th><input class="my-style-input" type="text" id="arrivalAirport"
                       value="${flightFilters !=null ? flightFilters.arrivalAirport : ''}"
                       placeholder="Фильтр..."
                       onchange="myFunction()">
            </th>
            <th><input class="my-style-input" type="text" id="status"
                       value="${flightFilters !=null ? flightFilters.status : ''}"
                       placeholder="Фильтр..."
                       onchange="myFunction()">
            </th>
            <th><input class="my-style-input" type="text" id="aircraftCode"
                       value="${flightFilters !=null ? flightFilters.aircraftCode : ''}"
                       placeholder="Фильтр..."
                       onchange="myFunction()">
            </th>
            <th><input class="my-style-input" type="date" id="actualDeparture"
                       value="${flightFilters !=null ? flightFilters.actualDeparture : ''}"
                       placeholder="Фильтр..."
                       onchange="myFunction()">
            </th>
            <th><input class="my-style-input" type="date" id="actualArrival"
                       value="${flightFilters !=null ? flightFilters.actualArrival : ''}"
                       placeholder="Фильтр..."
                       onchange="myFunction()">
            </th>
        </tr>
        <tbody>
        <c:forEach var="flight" items="${flights}">
            <tr>
                <td>${flight.flightId}</td>
                <td>${flight.flightNo}</td>
                <td>${flight.scheduledDeparture}</td>
                <td>${flight.scheduledArrival}</td>
                <td>${flight.departureAirport}</td>
                <td>${flight.arrivalAirport}</td>
                <td>${flight.status}</td>
                <td>${flight.aircraftCode}</td>
                <td>${flight.actualDeparture}</td>
                <td>${flight.actualArrival}</td>
            </tr>
        </c:forEach>
        </tbody>
        <tr>
            <th>Id полета</th>
            <th>Номер полета</th>
            <th>Запланированный вылет</th>
            <th>Запланированный прилет</th>
            <th>Аэропорт отправления</th>
            <th>Аэропорт прибытия</th>
            <th>Статус</th>
            <th>Код самолета</th>
            <th>Актуальный вылет</th>
            <th>Актуальный прилет</th>
        </tr>
    </table>


</div>

</body>
</html>
