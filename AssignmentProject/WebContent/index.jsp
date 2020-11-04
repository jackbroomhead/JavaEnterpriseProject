<html>
<head>
<meta http-equiv="Content-Type" content ="text/html; charset=UTF-8">
<title> AJAX JSON ARRAY EXAMPLE</title>
<style type ="text/css">
table, td, th
{
border:1px solid green;
font-family: 'Oxygen', sans-serif;
}
th
{
background-color:green;
color:white;
}
body
{
text-align: center;
}
.container
{
margin-left: auto;
margin-right: auto;
width: 40em;
}
</style>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#tablediv").hide();
	$("#showTable").click(function(event){
	$.get('PopulateTable', function(responseJson) {
		if(responseJson!=null){
			$("#filmtable").find("tr:gt(0)").remove();
			var table1 = $("#filmtable");
			$.each(responseJson, function(key,value) {
				var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
				rowNew.children().eq(0).text(value['id']);
				rowNew.children().eq(1).text(value['title']);
				rowNew.children().eq(2).text(value['year']);
				rowNew.children().eq(3).text(value['director']);
				rowNew.children().eq(4).text(value['stars']);
				rowNew.children().eq(5).text(value['review']);
				rowNew.appendTo(table1);
			});
			}
		});
		$("#tablediv").show();	
	});
});
</script>
</head>
<body class ="container">
<h1> AJAX Retrieve allFilms (20) from database in servlet and jsp using json array</h1>
<input type ="button" value ="Show JSON Table" id="showTable"/>
<div id="tablediv">
<table cellspacing="0" id="filmtable">
<tr>
<th scope="col">id</th>
<th scope="col">title</th>
<th scope="col">year</th>
<th scope="col">director</th>
<th scope="col">stars</th>
<th scope="col">review</th>
</tr>
</table>
</div>
</body>
</html>