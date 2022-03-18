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

import lombok.extern.log4j.Log4j2;
import net.webjjang.util.PageObject;

//RestController�� ������ �����͸� �����ҋ� ����Ѵ� 
//
@RestController
@Log4j2
public class ReplyController {
	
	@Autowired
	@Qualifier("replyServiceImpl")
	private ReplyService service;
	//��۾���
	// �����͸�  �޾Ƽ� DB�� ���� -> CONTENT , WRITER(user_id)
	// ȭ���ʿ��� CONTENT , WRITER(user_id)�� �����͸� �޾Ƽ� java��(spring)�� �ѱ�
	// java���� �޾ƿ°� db������ ���� 
	// so �ڹ������� �Ѿ�� �����͸� �����ϱ����� ��ü so dto(vo)  
	@PostMapping(value= "/ajax/replyWrite.do",
			 // contentType:"application/json; charset=utf-8",
			consumes = "application/json", 
			// �������ִ� �������� Ÿ�� 
			produces = MediaType.TEXT_PLAIN_VALUE )
	// �����͸� �״�� �޾Ƽ� ó���ϱ� ���� ( @RequestBody ReplyDto vo)�� ���� 
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
	
	 // ResponseEntity: �����Ϳ� ������ ó������(���¹�ȣ ex) 200-����ó�� ��� )�� ���� �ѿ���
	
	 // ���������� �̿��� ��� ����
	
	
	
	//��۸����� �ޱ�
			@GetMapping(
				value= "/ajax/replyList.do",
				 // contentType:"application/json; charset=utf-8",
		 //		consumes = "application/json",
				// �������ִ� �������� Ÿ�� 
				// 2������ ���� ����Ʈ�� pageObject
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
			
			
			
		// ��� ���� 
			@PatchMapping(
					value= "/ajax/replyUpdate.do",
					 // contentType:"application/json; charset=utf-8",
				//	consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
					// �������ִ� �������� Ÿ�� 
					produces = MediaType.TEXT_PLAIN_VALUE )
			public ResponseEntity<String> update(@RequestBody ReplyDto vo){
			    
				log.info(vo);
				
				int updateCount = service.update(vo);
				//String msg = "�Խ��� �ۼ����� ���������� �Ǿ����ϴ� ";
				//HttpStatus status = HttpStatus.OK;
				
			//	if (result == 0 ) {
			//		msg = "�Խ��� ���� ���� - ������ Ȯ���� �ּ���.";
			//		status = HttpStatus.NOT_MODIFIED; 
				
			//	
					log.info(updateCount) ;
			
				return	new ResponseEntity<String>("success" , HttpStatus.OK );
					
			}
			
			
////			// ��� ���� 
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

