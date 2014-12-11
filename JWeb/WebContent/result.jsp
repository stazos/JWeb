<%@ page import="java.util.*" %>

<html>
<body>
<h1 align="center">Coffee Recommandation JSP View</h1>
<p>

<%
  List<String> styles = (List<String>) request.getAttribute("styles");
  Iterator it = styles.iterator();
  while(it.hasNext()) {
    out.print("<br>try: " + it.next());
  }
%>
</p>
</body>
</html>