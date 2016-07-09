<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ page session="false" %>
<html>
    <head>
        <title>LostPassword</title>
    </head>
    <body>
        <h1>
            <form action="LoginServlet" method="post" >
                <table>
                    <th>
                        Reset Your Password
                    </th>
                    <tr>
                        <td>Please input your username </td>
                        <td><input type="text" name="username" id="username" required="required"></td>
                    </tr>
                    <tr>
                        <td>Please input your email</td>
                        <td><input type="text"  name="email" id="email" required="required"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input id="submit" type="submit" value="Submit" />
                        </td>
                    </tr>
                </table>
            </form>
        </h1>
    </body>
</html>