<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML><HEAD><HEAD><link rel="stylesheet" type="text/css" href="/MyEvents/style/login.css"><link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"><script src="https://code.jquery.com/jquery-1.12.4.js"></script><script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script><script>$( function() {

$( "#DateFrom" ).datepicker({ dateFormat: "dd.mm.yy" });

$( "#DateTo" ).datepicker({ dateFormat: "dd.mm.yy" });


} );</script></HEAD><BODY><form method="post"><input type="hidden" name="step" value="2" /><input type="hidden" name="report" value="reporting.VeranstaltungenStat" /><table>
<tr><td>DateFrom:</td><td><input id="DateFrom" name="DateFrom" type="text"/></td></tr>
<tr><td>DateTo:</td><td><input id="DateTo" name="DateTo" type="text"/></td></tr>
<tr><td>IsDiagramm:</td><td><select name="IsDiagramm"/><option value="1">True</option><option value="0">False</option></select></td></tr>
</table><input type="submit" value="Done"/></form></BODY></HTML>
