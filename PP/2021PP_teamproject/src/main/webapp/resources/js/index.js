$("#menu-toggle").click(function(e) {
	e.preventDefault();
	$("#wrapper").toggleClass("active");
});

function addRow(me) {
	var htmlText =
		"<tr><td><input type='text' class='form-control' placeholder='과목' id='title'/></td>";
	htmlText +=
		"<td><input type='number' class='form-control' placeholder='학점' id='study-score'/></td>";
	htmlText +=
		"<td><button type='button' class='btn btn-primary' onclick='save(this);'>저장</button></td>";
	htmlText +=
		"<td><button type='button' class='btn btn-danger' onclick='deleteRow(this)'>삭제</button></td></tr>";
	$("#mytable > tbody:last").append(htmlText);
}
function deleteRow(me) {
	console.log(me);
	console.log($(me).parent().parent());
	$(me).parent().parent().remove();
}

function save(me) {
	var title = $(me).parent().parent().find("td").find("#title").val();
	var sscore = $(me).parent().parent().find("td").find("#study-score").val();
	if (title == "" || sscore == "") {
		alert("값을 입력하세요.");
	} else {
		var total = $("#total").val() * 1;
		console.log(total);

		var changeText =
			"<td>" +
			title +
			"</td><td>" +
			sscore +
			"</td><td><button type='button' class='btn btn-primary' disabled>저장</button></td><td><button type='button' class='btn btn-danger' onclick='deleteRow(this)'>삭제</button></td></tr>";
		$(me).parent().parent().html(changeText);

		total = total * 1 + sscore * 1;

		$("#total").val(total);
	}
}

function saveFile(me) {
	var total = $("#total").val();
	alert(total);
	saveAsFile(total, "output.txt");
}

function reset(me) {
	var changeText =
		"<input type='number' class='form-control' placeholder='학점' id='study-score' value='0' readonly/>";
	console.log($(me).parent().parent().find("#study-score"));
	var score = $(me).parent().parent().find("#study-score").val();
	$(me).parent().parent().find("#study-score").parent().html(changeText);

	var total = $("#total").val() * 1 - score * 1;
	$("#total").val(total);
}
