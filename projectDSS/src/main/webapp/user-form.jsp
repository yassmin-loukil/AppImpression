<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>User Management Application</title>
</head>
<body>
 <center>
  <h1>User Management</h1>
        <h2>
         <a href="new">Add New User</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Users</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${user != null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
   <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${user != null}">
               Edit User
              </c:if>
              <c:if test="${user == null}">
               Add New User
              </c:if>
             </h2>
            </caption>
          <c:if test="${user != null}">
           <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
          </c:if>            
            <tr>
                <th>first Name: </th>
                <td>
                 <input type="text" name="firstName" size="45"
                   value="<c:out value='${user.firstName}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>last Name: </th>
                <td>
                 <input type="text" name="lastName" size="45"
                   value="<c:out value='${user.lastName}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>User Name: </th>
                <td>
                 <input type="text" name="username" size="15"
                   value="<c:out value='${user.username}' />"
                 />
                </td>
            </tr>
              <tr>
                <th>password: </th>
                <td>
                 <input type="password" name="password" size="15"
                   value="<c:out value='${user.password}' />"
                 />
                </td>
            </tr>
              <tr>
                <th>role: </th>
                <td>
                 <input type="text" name="role" size="15"
                   value="<c:out value='${user.role}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>