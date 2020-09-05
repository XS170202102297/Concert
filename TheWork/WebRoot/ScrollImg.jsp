<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>轮播图</title>
    
    <link href="Css/css.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/js.js" charset="UTF-8"></script>
    

  </head>
  
  <body>
  	<div class="box" id="scrollImg"> <!-- 轮播图  -->	
    		<div class="content">
	       		 <ul>
	           		 <li><img src="Images/showImages/1.jpg" width="500" height="250"></li>
	           		 <li><img src="Images/showImages/2.jpg" width="500" height="250"></li>         
	      		  </ul>
	      		  <ol></ol>
	        		<div class="arrow">
	            		<span class="arr-left"></span>
	            		<span class="arr-right">></span>
	       			</div>
	    	</div>
	</div>

		<script>	
			var divEle = document.getElementById("scrollImg");
		    var ulEle = divEle.children[0].children[0];
		    var imgWidth = divEle.children[0].offsetWidth;
		    var olEle = divEle.children[0].children[1];
		    var arrEle = divEle.children[0].children[2];
		    //1、在第五张图片后放置第一张图片
		    var firstImg = ulEle.children[0].cloneNode(true);
		    ulEle.appendChild(firstImg);
			    //2、创建5个小图标
			    for (var i = 0; i < ulEle.children.length - 1; i++) {
			        var liEle = document.createElement("li");
			        liEle.innerHTML = i + 1;
			        olEle.appendChild(liEle);
			    }
			    //3、点亮第一个小图标
			    olEle.children[0].className = "current";
		    //4、鼠标放到小图标上轮播图片
		    var olLiArr = olEle.children;
			    for (var i = 0; i < olLiArr.length; i++) {
			        olLiArr[i].index = i;
			        olLiArr[i].onmouseover = function () {
			            for (var j = 0; j < olLiArr.length; j++) {
			                olLiArr[j].className = "";
			            }
			            this.className = "current";
			            animate(ulEle, -imgWidth * this.index);
			            key = square = this.index;
			        }
			    }
		    //5、添加定时器
		    var timer = setInterval(autoPaly, 3000);
		    var key = 0;
		    var square = 0;
		    //图片1秒钟滑动一次，并且对应的小图片也随机点亮
		    //当key=5时是第5张图片向第6张图片移动（第6张也就是第1张）
		    //当key=6时其实是第1张向第2张图片移动，此时我们立刻更改ul的left值，达到了偷梁换柱的效果
		    function autoPaly() {
		        key++;
		        if (key > olLiArr.length) {//key=2立刻将key=1
		            ulEle.style.left = 0;
		            key = 1;
		        }
		        animate(ulEle, -imgWidth * key);
		        square++;
		        if (key === olLiArr.length) {//当key=2时，此时已经滑动到了第一张图片，所以square=0
		            square = 0;
		        }
		        for (var i = 0; i < olLiArr.length; i++) {
		            olLiArr[i].className = "";
		        }
		
		        olLiArr[square].className = "current";
		    }
		
		    //6、鼠标放上去清除定时器，移开后在开启定时器
		    divEle.onmouseover = function () {
		        arrEle.style.display = "block";
		        clearInterval(timer);
		    }
		    //在清除定时器时，因为key与square都是全局变量
		    //所以当再次开启定时器时，函数依然按照原来计划执行
		    divEle.onmouseout = function () {
		        arrEle.style.display = "none";
		        timer = setInterval(autoPaly, 3000);
		    }
		    //7、左右箭头切换图片
		    arrEle.children[0].onclick = function () {
		        key--;
		        if (key < 0) {//key=-1时立刻换到最后一张图片，并将key值赋值成倒数第二张图片的数值
		            ulEle.style.left = -olLiArr.length * imgWidth + "px";
		            key = olLiArr.length - 1;
		        }
		        animate(ulEle, -imgWidth * key);
		        square--;
		        if (key < 0) {//当key=5时，此时已经滑动到了第一张图片，所以square=0
		            square = 4;
		        }
		        for (var i = 0; i < olLiArr.length; i++) {
		            olLiArr[i].className = "";
		        }
		
		        olLiArr[square].className = "current";
		    }
		    arrEle.children[1].onclick = function () {
		        autoPaly();
		    }
		
		    //图片移动
		    function animate(ele, target) {
		        clearInterval(ele.timer);
		        var speed = ele.offsetLeft < target ? 15 : -15;
		        ele.timer = setInterval(function () {
		            ele.style.left = ele.offsetLeft + speed + "px";
		            var value = ele.offsetLeft - target;
		            if (Math.abs(value) <= Math.abs(speed)) {
		                ele.style.left = target + "px";
		                clearInterval(ele.timer);
		            }
		        }, 10);
		    }
	
		</script>
  </body>
</html>
