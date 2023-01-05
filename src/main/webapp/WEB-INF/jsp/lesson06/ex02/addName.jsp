<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 중복 확인</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script> 
	
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		<div class="form-group">
			<label for="name">이름</label>
			<div class="d-flex">
				<input type="text" id="name" class="form-control col-3">
				<button type="button" class="btn btn-info" id="nameCheckBtn">중복확인</button>
			</div>
			
			<small id="nameStatusArea"></small>
		</div>
		
		<button type="button" class="btn btn-success" id="joinBtn">가입하기</button>
	</div>
	
	<script>
		$(document).ready(function() { 
			//중복하기 버튼 클릭
			$('#nameCheckBtn').on('click', function(){
				// 처음에 들어오자마자 nameStatusArea 하위 태그들을 초기화 시키고 시작! => 안그러면 이름이 비어있다고 여러개 뜸.
				$('#nameStatusArea').empty(); // empty(): 안쪽 자식, 자손들 모든 것들을 다 사라지게하는 함수
				//validation체크
				let name = $('#name').val().trim();
				
				//이름이 입력 됐는지 체크
				if (name == '') {
					$('#nameStatusArea').append('<span class="text-danger">이름이 비어있습니다.</span>'); // 스몰태그 안 쪽에다가 태그 넣음
					return;
				}
				
				// 이름 중복 확인 -> DB에서 조회 => API를 통해서 AJAX 통신
				$.ajax({
					//request
					type:"get" //타입 명시 안 하면 기본값은 get
					, url:"/lesson06/ex02/is_duplication" //api
					, data:{"name":name}
				
					//response로 콜백 받기
					, success:function(data) {
						//alert(data.is_duplication);
						if(data.is_duplication == true) { // is_duplicationd 자체가 true기 때문에 true 안 적어도 됌.
							$('#nameStatusArea').append('<span class="text-danger">중복된 이름입니다.</span>');
						}
					}
					, error:function(e) { // 여기에 오면 서버에 가지도 못한 것. => 요청에 문제가 있는 것.
						alert("실패" + e);
					}
				});
				
				
			});
		});
	</script>
	
</body>
</html>