
function deleteTicket(userId){
	if(confirm("你确定删除该用户吗?")){ 
		location.href="deleteTicketAction?id2="+userId;
	}
}

function updateTicket(userId){
	location.href="queryTicketById?id2="+userId;
}

function first(){
	location.href="loginAction";
}
