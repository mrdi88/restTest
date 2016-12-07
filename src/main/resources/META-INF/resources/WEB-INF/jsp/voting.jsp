<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VoitingList</title>
        <link href="${pageContext.request.contextPath}/resources/css/voting.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.js"></script>
        <script src="${pageContext.request.contextPath}/resources/javascript/dentist.js"></script>
        <script src="${pageContext.request.contextPath}/resources/javascript/voting.js"></script>
    </head>
    <body>
        <form id="voting">
            <h1>Voting</h1>
            <input class="topic" type="text" value="" readonly><br>
            <select class="options" name="option">
            </select>
            <input type="submit" value="vote">
        </form>
        <form id="results">
            <p> Voting has finished </p>
            <input class="topic" type="text" value="" readonly><br>
        </form>
</html>



