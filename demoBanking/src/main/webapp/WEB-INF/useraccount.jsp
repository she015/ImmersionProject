<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<style>
h2 {
  margin-bottom: 50px;
}

.container {
  text-align: center;
  overflow: hidden;
  width: 800px;
  margin: 0 auto;
}

.container table {
  width: 100%;
}

.container td, .container th {
  padding: 10px;
}

.container td:first-child, .container th:first-child {
  padding-left: 20px;
}

.container td:last-child, .container th:last-child {
  padding-right: 20px;
}

.container th {
  border-bottom: 1px solid #ddd;
  position: relative;
}

</style>
	<head>
<title>User's Details</title>
<link href="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap.no-icons.min.css" rel="stylesheet">
	</head>
	<body>
<section class="container">

	<h2>${user.userName}'s Details</h2>

	<input type="search" class="light-table-filter" data-table="order-table" placeholder="Filter" />

	<table class="order-table">
		<thead>
			<tr>
				<th>ID</th>
				<th>UserName</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Contact No</th>
				<th>Total Bal</th>
				<th>Transfer</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${listUserAccount}" var="useraccount">
		 <tr>		
			<td>${useraccount.id}</td>
			<td>${useraccount.userName}</td>
			<td>${useraccount.firstName}</td>
            <td>${useraccount.lastName}</td>
            <td>${useraccount.contactNo}</td>
            <td>${useraccount.totalBal}</td>
            <td>
            <h5><a href="/newtransaction/${useraccount.id}">Transfer Money</a></h5>
             <h5><a href="/newdeposit/${useraccount.id}">Deposit Money</a></h5>
            <h5><a href="/transactionhistory/${useraccount.id}">Transaction History</a></h5>
            </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

<h5><a href="/new">New User</a></h5>
<h5><a href="/logout">Logout</a></h5>
</section>
<script>
(function(document) {
	'use strict';

	var LightTableFilter = (function(Arr) {

		var _input;

		function _onInputEvent(e) {
			_input = e.target;
			var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
			Arr.forEach.call(tables, function(table) {
				Arr.forEach.call(table.tBodies, function(tbody) {
					Arr.forEach.call(tbody.rows, _filter);
				});
			});
		}

		function _filter(row) {
			var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
			row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
		}

		return {
			init: function() {
				var inputs = document.getElementsByClassName('light-table-filter');
				Arr.forEach.call(inputs, function(input) {
					input.oninput = _onInputEvent;
				});
			}
		};
	})(Array.prototype);

	document.addEventListener('readystatechange', function() {
		if (document.readyState === 'complete') {
			LightTableFilter.init();
		}
	});

})(document);
</script>
	</body>
</html>