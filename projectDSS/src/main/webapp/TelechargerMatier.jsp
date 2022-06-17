<%@ page import="java.io.*"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<html>

<table>
<tr><th>Nom du document </th><th>Télécharger</th>
<%
File f = new File("C:/UploadedFiles");
        File[] files = f.listFiles();
        for(int i=0;i<files.length;i++){
            String name=files[i].getName();
            String path=files[i].getPath();
%>
<tr><td><%=name%></td><td><a href="download.jsp?f=<%=path%>">Download File</a></td></tr>
     <%
        }
%>
</table>
</html>
