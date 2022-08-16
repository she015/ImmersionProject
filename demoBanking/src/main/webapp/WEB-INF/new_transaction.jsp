<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Transfer</title>
</head>
<style>
html,
body {
  background-color: #211F2B;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}

h1,
h2 {
  margin: 0;
}

h1 {
  color: white;
  font-size: 30px;
  font-weight: 500;
  margin-top: 10px;
}

h2 {
  color: rgba(255, 255, 255, 0.5);
  font-size: 14px;
  font-weight: 500;
  margin-bottom: 10px;
}

form {
  margin: 0;
  padding: 0;
  width: 100%;
}

.divider {
  width: 100px;
  height: 3px;
  margin: 20px auto;
  background-color: #617BFF;
}

input,
textarea {
  position: relative;
  text-align: center;
  display: block;
  margin: 0;
  border-radius: 7px;
  border: 2px white solid;
  background-color: white;
  padding: 10px 20px;
  width: 100%;
  color: #1E1C29;
  margin-bottom: 20px;
  box-sizing: border-box;
  transition: all 0.2s;
}

input:focus,
textarea:focus {
  outline: none;
  border: 2px #617BFF solid;
}

.container {
  background-color: rgba(255, 255, 255, 0.1);
  width: 300px;
  margin: 0 auto;
  border-radius: 14px;
  padding: 30px 30px 20px 30px;
  margin-top: 50px;
}

input[name="amount"] {
  font-size: 20px;
  font-weight: 600;
}

input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

#btn-send {
  display: block;
  text-decoration: none;
  border-radius: 7px;
  margin-bottom: 10px;
  cursor: pointer;
  font-size: 20px;
  font-weight: 600;
  border: 2px #617BFF solid;
  color: white;
  background-color: #617BFF;
  padding: 15px;
  transition: all 0.2s;
}

#btn-send:hover {
  border: 2px #8095FF solid;
  background-color: #8095FF;
}


</style>
<body>
	<form:form action="/transfer" method="post" modelAttribute="transaction">
    <div class="container">
      <h1>New Transfer</h1>
     <h2>From Account No</h2>
      <form:input id="input-username"  type="number" path="userAccountId" readonly="true"/>
     <h2>To Account No</h2>
      <form:input id="input-username"  type="text" path="toUserAccountId" />
     <h2>Amount</h2>
      <form:input id="input-contact" type="text" path="transferAmount" />
      <input id="btn-send" type="submit" value="Save" />
    </div>
     </form:form>
</body>
</html>