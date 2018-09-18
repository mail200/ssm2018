<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String appPath = request.getContextPath(); %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
</head>
<script type="text/javascript">  
function getUserInfo(){
	var form = document.getElementById('myform');
	form.submit();
}


function ajaxTest1(){ 
	alert("aaaa");
    $.ajax({ 

    data:"name=小红&age=12", 

    type:"POST", 

    dataType: 'json', 

    url:"<%=appPath%>/user/testAjax", 

    success:function(data){ 

       alert("success");
       alert(data.name);
       alert(data.age);
     },

    error:function(data){ 

        alert("fail"); 

    }

}); 

} 


</script>
<body>
    <h1>用户登录</h1>
 	<hr>
        	欢迎${user.username}您进入!
    <hr>
    <form action="<%=appPath%>/user/getUserInfoPc" method="get" id="myform">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" id="username" name="username"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="button" value="获取用户信息" id="login" onclick="ajaxTest1()"/></td>
            </tr>
            <tr>
                <td>用户信息</td>
            </tr>            
        </table>
        
        
		<table  id="myTable">
		    <c:forEach var="user" items="${userList}">
		     <tr>
		      <td>
		       SID=${user.id}
		      </td>
		      <td>
		       SName=${user.username}
		      </td>
		      <td>
		       Score=${user.password}
		      </td>
		     </tr>
		    </c:forEach>
		</table>        
    </form>
</body>
</html>



