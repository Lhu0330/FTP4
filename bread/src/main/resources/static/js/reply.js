/**
 *  게시판 댓글 처리를 위한 객체선언 
 */
 
 // 댓글 js 모듈이 시작되고 있다.는 것을 알려줌 
 //console.log("Reply Module");
 //alert("댓글 모듈 진행... 시작 ");
 
 var replyService = (
 		function(){
 
 		 //댓글리스트함수
   		  		function list(pageInfo, callback){
  				// alert("댓글 리스트 처리 진행.." + JSON.stringify(pageInfo));
  				// server에 데이터를 넘겨서 처리 - 브라우저의 url을 바꾸지 않는다 - ajax 처리
  				$.ajax({ // https://api.jquery.com/jquery.ajax/#using-converters 참고
  				   url:'/ajax/replyList.do',
  				   type:'get',
  				   // 서버로 보내지는 데이터 
  				   data:pageInfo,
  				   // 보내지는 데이터의 형식 <> 서버에서부터 데이터받을때의 타입의 dataType
  				   // 헤더셋팅
  				   contentType:"application/json; charset=utf-8",
  				   // 받는데이터 형식 - json
  				   dataType:"json",
  				   // 처리가 성공했을때 실행되는 함수 
  				   success: function(result, status, xhr){
  				
  				   // for each문으로 뽑으면 쉽게 뽑을수있다 
  				   // 성공하면 callback 함수가 있는 경우 실행 한다 
  				   // 요 밑에 해당하는 거는 다 javascript, jquery
	  				   if(callback){  				     
	  				   		callback(result);
	  				   }
	  					//alert(result);
	  				 	//alert(status);
	  				   
	  				 },
  				   // 처리가 실패했을때 실행되는 함수 

  				 error : function(xhr, status, er){
  				 	alert(status);
  				  	alert(er);
  				 }  
  				 
  				 
  				});
  			
  		} 
  		
  		 //댓글쓰기
  		 // reply는 json객체를 문자열로 만들어서 넘겨야한다 
   		  		function add(reply, callback){
  				// alert("댓글쓰기처리 진행.." + reply);
  				// server에 데이터를 넘겨서 처리 - 브라우저의 url을 바꾸지 않는다 - ajax 처리
  				$.ajax({ // https://api.jquery.com/jquery.ajax/#using-converters 참고
  				   url:'/ajax/replyWrite.do',
  				   type:'post',
  				   // 서버로 보내지는 데이터 
  				   data:reply,
  				   // 보내지는 데이터의 형식 <> 서버에서부터 데이터받을때의 타입의 dataType
  				   // 헤더셋팅
  				   contentType:"application/json; charset=utf-8",
  				   // 처리가 성공했을때 실행되는 함수 
  				   success: function(result, status, xhr){
  				   // 성공하면 callback 함수가 있는 경우 실행 한다 
  				   // 요 밑에 해당하는 거는 다 javascript, jquerys
	  				   if(callback){  				     
	  				   		callback();
	  				   }
	  				 //  	alert(result);
	  				 //  	alert(status);
	  				   
	  				 },
  				   // 처리가 실패했을때 실행되는 함수 

  				 error : function(xhr, status, er){
  				 	alert(status);
  				  	alert(er);
  				 }  
  				 
  				 
  				});
  			
  		} 
  		
  				 //댓글 수정 함수 
  				 // reply는 json객체를 문자열로 만들어서 넘겨야한다 
  				 // reply에는 댓글의 페이지가 포함되어 있어야 한다 .
   		  		function update(reply, callback, error){
  				//	alert("댓글쓰기처리 진행.." + JSON.stringify(reply));
  				// server에 데이터를 넘겨서 처리 - 브라우저의 url을 바꾸지 않는다 - ajax 처리
  				$.ajax({ 
  				   url:'/ajax/replyUpdate.do',
  				   type:'patch',
  				   data: JSON.stringify(reply) ,  				  
  				   contentType:"application/json; charset=utf-8",
  				   // 처리가 성공했을때 실행되는 함수 
  				   success: function(result, status, xhr){
  				   
	  				   if(callback){
	  				   	 		callback(result);		     
	  				   	
	  				   }else alert("댓글 수정 완료");
	  				 
	  				 },
  				 error : function(xhr, status, er){
  				  	if(error)error(er);	
  				  	else alert("댓글 수정 실패");
  				 }  
  				 
  				 
  				});
  			
  		} 
  		
  			 //댓글 삭제 함수 - delete()는 사용하고 있기 떄문에 재사용시 오류남 함수이름은 remove로 
   		  		function remove(rno, callback, error){
  				alert("댓글쓰기처리 진행.." + rno);
  				$.ajax({ 
  				   url:'/ajax/replyDelete.do?rno=' + rno,
  				   type:'delete',
  				   success: function(result, status, xhr){
  				   
	  				   if(callback){
	  				   	 		callback(result);		     
	  				   	
	  				   }else alert("댓글 삭제 완료");
	  				 
	  				 },
  				 error : function(xhr, status, er){
  				  	if(error) error(er);	
  				  	else alert("댓글 삭제 실패");
  				 }  
  				 				 
  					});  			
  				} 
  		  		
  		// replyService.add(reply,callback) 함수 호출  		
  		return {
  			list:list,
  			add:add,
  			update:update,
  			delete:remove
  			
  			// 키:값 여기서는 변수
  				
  				}
  		}
          
 )();