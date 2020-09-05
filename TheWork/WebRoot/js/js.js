//根据id删除用户
function deleteCon(ticketId){
	if(confirm("你确定删除该演唱会吗?")){ //弹出确认对话框
		location.href="deleteConAction?id="+ticketId;
	}
}

//修改用户数据，首先根据用户的id查询该用户详细信息，显示到界面上，以供修改
function queryTicketDetails(ticketid){
	//调用queryActionById的Action，？?id=  是传递查询的id参数
	location.href="queryActionById?id="+ticketid;
	
}
function queryOrderDetial(id){
	//调用queryActionById的Action，？?id=  是传递查询的id参数
	location.href="queryOrder?id="+id;
	
}
function queryTicket(ticketid){
	//调用queryActionById的Action，？?id=  是传递查询的id参数
	location.href="queryActionByCon?id="+ticketid;
	
}

function buy(ticketid){
	location.href="queryConcertById?ticketid="+ticketid;
}
function deleteod(sid){
	if(confirm("你确定删除该订单吗?")){
	location.href="deleteOrderAction?sid="+sid;
	}
}


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