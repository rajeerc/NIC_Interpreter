<%-- 
    Document   : results
    Created on : Sep 11, 2013, 11:37:29 AM
    Author     : Rajith
--%>

<%@page language="java" contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="sample.Interpreter"%>
<%@page import="sample.NICProp"%>
<%@page import="org.joda.time.DateTime"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>NIC_Interpreter</title>
    </head>
    <body>
        <h1>NIC_Interpreter</h1>
        
        <p>
            <%
                String idNo = request.getParameter("nic");
                Interpreter interpreter = new Interpreter();
                try{
                NICProp nicProp = interpreter.createNICProp(idNo);
                interpreter.interpret(nicProp);
                DateTime birthday = interpreter.getBirthday();
                String gender = interpreter.getGender();
                boolean voter = interpreter.isVoter();
                
                
                out.print("Nic [" + "birthday=[year=" + birthday.getYear() + ", month=" + birthday.getMonthOfYear() +
                ", date=" + birthday.getDayOfMonth() + "], gender=" + gender +
                ", isVoter=" + voter + ']');
                               }
                catch (Exception e){
                    out.print(e.getMessage());
                }
             %>

        </p>
    </body>
</html>


