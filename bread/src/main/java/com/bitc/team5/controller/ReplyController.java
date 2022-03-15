package com.bitc.team5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitc.team5.dto.ReplyDto;
import com.bitc.team5.service.ReplyService;

import lombok.extern.log4j.Log4j;
import net.webjjang.util.PageObject;

//RestController는 순수한 데이터를 전달할떄 사용한다 
//
@RestController
@Log4j
public class ReplyController {
	
	@Autowired
	@Qualifier("replyServiceImpl")
	private ReplyService service;
	//댓글쓰기
	// 데이터를  받아서 DB에 저장 -> CONTENT , WRITER(user_id)
	// 화면쪽에서 CONTENT , WRITER(user_id)의 데이터를 받아서 java쪽(spring)에 넘김
	// java에서 받아온것 db쪽으로 전달 
	// so 자바쪽으로 넘어온 데이터를 저장하기위한 객체 so dto(vo)  
	@PostMapping(value= "/ajax/replyWrite.do",
			 // contentType:"application/json; charset=utf-8",
			consumes = "application/json", 
			// 리턴해주는 데이터의 타입 
			produces = MediaType.TEXT_PLAIN_VALUE )
	// 데이터를 그대로 받아서 처리하기 위해 ( @RequestBody ReplyDto vo)로 선언 
	public ResponseEntity<String> write(@RequestBody ReplyDto vo){
	    
		log.info(vo);
		int insertCount = service.write(vo);
		log.info("Reply insert Count : " + insertCount);
	//	log.info(HttpStatus.OK);
		return( insertCount ==1 ) 
		?	new ResponseEntity<String>("success.write", HttpStatus.OK )
		: 	new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR )
		;	
	}
	
	 // ResponseEntity: 데이터와 서버의 처리상태(상태번호 ex) 200-정상처리 등등 )를 같이 넘여줌
	
	 // 제이쿼리를 이용해 댓글 받음
	
	
	
	//댓글리스드 받기
			@GetMapping(
				value= "/ajax/replyList.do",
				 // contentType:"application/json; charset=utf-8",
		 //		consumes = "application/json",
				// 리턴해주는 데이터의 타입 
				// 2가지를 리턴 리스트랑 pageObject
				produces = { MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE } )
		public ResponseEntity<List<ReplyDto>> list(PageObject pageObject, int no){
		    
			log.info(pageObject);
			log.info(no);
			List<ReplyDto> list = service.list(pageObject, no);
			log.info("list " + list);
		//	log.info(HttpStatus.OK);
			return( list != null && list.size() > 0  ) 
			?	new ResponseEntity<>(list, HttpStatus.OK )
			: 	new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR )
			;	
		}
			
			
			
		// 댓글 수정 
			@PatchMapping(
					value= "/ajax/replyUpdate.do",
					 // contentType:"application/json; charset=utf-8",
				//	consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
					// 리턴해주는 데이터의 타입 
					produces = MediaType.TEXT_PLAIN_VALUE )
			public ResponseEntity<String> update(@RequestBody ReplyDto vo){
			    
				log.info(vo);
				
				int updateCount = service.update(vo);
				//String msg = "게시판 글수정이 성공적으로 되었습니다 ";
				//HttpStatus status = HttpStatus.OK;
				
			//	if (result == 0 ) {
			//		msg = "게시판 수정 실패 - 정보를 확인해 주세요.";
			//		status = HttpStatus.NOT_MODIFIED; 
				
			//	
					log.info(updateCount) ;
			
				return	new ResponseEntity<String>("success" , HttpStatus.OK );
					
			}
			
			
////			// 댓글 삭제 
//				@DeleteMapping(
//						value= "/ajax/replyDelete.do",
//					 produces = MediaType.TEXT_PLAIN_VALUE )
//				public ResponseEntity<String> remove( int rno){
//		
//					
//				  return service.delete(rno) == 1
//          				  ? new ResponseEntity<>("success", HttpStatus.OK)
//                   				 : new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
//						
//				}
				
				 @DeleteMapping(value="/ajax/replyDelete.do", 
						 produces =  MediaType.TEXT_PLAIN_VALUE ) 
				    public ResponseEntity<String> delete( int rno){
					 
				        log.info("remove : " + rno);
				        int deleteCount = service.delete(rno);
				        
				        log.info(deleteCount);
				        
				        return new ResponseEntity<String>("success", HttpStatus.OK);
				                       
				    }

				
//			
			
			
		
}
