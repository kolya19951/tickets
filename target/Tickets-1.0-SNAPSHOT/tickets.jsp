<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Auto-Completion using AJAX</title>
    <script type="text/javascript" src="javascript.js"></script>
</head>
<body onload="init()">
<h1>Auto-Completion using AJAX</h1>
<form name="autofillform" action="autocomplete">
    <table border="0" cellpadding="5">
        <thead>
        <tr>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><strong>Composer Name:</strong></td>
            <td><%--@declare id="datalist"--%><input type="text"
                       size="40"
                       id="complete-field"
                       onchange="doCompletion();"
                        list="datalist"></td>

        </tr>
        <tr>
            <td id="auto-row" colspan="2">
                <table id="complete-table" />
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>