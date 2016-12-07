<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VoitingList</title>
        <link href="${pageContext.request.contextPath}/resources/css/votingList.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.js"></script>
        <script src="${pageContext.request.contextPath}/resources/javascript/votingList.js"></script>
    </head>
    <body>
        <h1>Votings :</h1>
        <table id="votings" width="80%" cellpadding="2" >
            <th class="topic">Тема</th>
            <th class="state">Состояние</th>
        </table>
    </body>
</html>



