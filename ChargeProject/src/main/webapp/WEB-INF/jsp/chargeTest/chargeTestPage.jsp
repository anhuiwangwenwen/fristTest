<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>

<script src="../dwr/engine.js"></script>  
<script src="../dwr/util.js"></script>  
<script src="../dwr/interface/TestService.js"></script>  
          
<script>
function abc(){
	TestService.sayHello("w122312o",callback);
}
	
    function callback(data){
    	alert(data);
    }
</script> 

<title>测试程序</title>
</head>
<body>
	<!-- 导航 -->
	<a href="#" onclick="abc();">test</a>
</body>
</html>