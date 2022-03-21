package com.bitc.team5.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitc.team5.dto.MarketDto;
import com.bitc.team5.dto.classDto;
import com.bitc.team5.service.seller.SellerService;

@Controller
public class UsersControllerSchedule {
	
	@Autowired
	private SellerService productService;
	
	
//	// sotck 등록 화면
//		@RequestMapping(value="/saveSchedata.do", method=RequestMethod.POST)
//		public ResponseEntity<List<ReplyDto>>(List<SheduleDto> sd) throws Exception {
//			 System.out.println(sd);
//			ModelAndView mv = new ModelAndView("/main");
//			//List<SheduleDto> sdList = productService.insertSche(sd);
//			return mv;
//		}
//	 sotck 등록 화면
//		@PostMapping(value= "/saveSchedata.do",
//				consumes = "application/json"
//				)
//		public String viewProduct(@RequestBody ResponseEntity<List<SheduleDto>> sd, Model model) {
//		
//			 System.out.println(sd);
//			//List<SheduleDto> sdList = productService.insertSche(sd);
//			model.addAttribute("template", "admin/insertProduct");
//			return "admin/index";
//		}
////		
//		
//		@PostMapping(value= "/saveSchedata.do",
//				consumes = "application/json"
//				)
//		public ResponseEntity list(@RequestBody Map <String ,Object> map , Model model) {
//		
//			 System.out.println(" map");
//			//List<SheduleDto> sdList = productService.insertSche(sd);
//			model.addAttribute("template", "admin/insertProduct");
//			
//			return new ResponseEntity<>(map, HttpStatus.OK );
//		}
		

	
	//String color = "#" + String.valueOf(Math.round(Math.random() * 0xffffff));
			
	
//	   JSONObject obj = new JSONObject();
//	   try {
//	   JSONArray jArray = new JSONArray();//배열이 필요할때
//	   for (int i = 0; i < databoard.size(); i++)//배열
//	   {
//	   JSONObject sObject = new JSONObject();//배열 내에 들어갈 json
//	   sObject.put("id", databoard.get(i).getIdx());
//	   sObject.put("title", databoard.get(i).getStoreId());
//	   sObject.put("start", databoard.get(i).getStartDate());
//	   sObject.put("end", databoard.get(i).getEndDate());
//	   sObject.put("allDay", databoard.get(i).getAllday());
//	   sObject.put("color", color );
//	   jArray.put(sObject);
//	   
//	   }
//	   
//	   JSONArray jsonArray = JSONArray.toJSONObject(jArray);
//
//	   System.out.println(obj.toString());
//
//	   } catch (JSONException e) {
//	   e.printStackTrace();
//	   }
//	   
	/*
	 * // ""textColor":"yellow", "backgroundColor":"navy", "borderColor":"navy"
	 */
	 
	//String color = "#" + String.valueOf(Math.round(Math.random() * 3 ));

		@ResponseBody
		@RequestMapping(value="/getevent.do", method=RequestMethod.POST)
		public String getformdate( ) throws Exception {
			
			
			List<MarketDto> databoard = productService.formDateList();
	
			
			JSONArray jArray = new JSONArray();
			   
			   try {
				   
				    for (int i = 0; i < databoard.size(); i++) {
				        JSONObject sObject = new JSONObject();//배열 내에 들어갈 json
				       
				        	sObject.put("id", String.valueOf(databoard.get(i).getIdx()));
				        	
						   sObject.put("title", databoard.get(i).getStoreId()  + ":" + databoard.get(i).getMarketName() );
						   sObject.put("start", databoard.get(i).getStartDate() +"T" + databoard.get(i).getTime() + ":00");
						//   sObject.put("time", databoard.get(i).getTime());
						    sObject.put("end", databoard.get(i).getEndDate() + "T24:00:00" );
						//   sObject.put("end", databoard.get(i).getTime());
						   //sObject.put("write", "dd");
						 //  sObject.put("allDay", "false");
						   sObject.put("color", "#" + String.valueOf(Math.round(Math.random() * 999 )) );
						   
				        jArray.put(sObject);
				    }

				
				
			   } catch (JSONException e) {
				    e.printStackTrace();
				}
			   
			   
			   var result =   jArray.toString();
			   
			   System.out.println(result);
			   
			return result;

		}
		
//		/getevent.do
		
		@ResponseBody
		@RequestMapping(value="/getclassevent.do", method=RequestMethod.POST)
		public String getclassdate( ) throws Exception {
			
			
			List<classDto> databoard = productService.classDateList();
	
			
			JSONArray jArray = new JSONArray();
			   
			   try {
				   
				    for (int i = 0; i < databoard.size(); i++) {
				        JSONObject sObject = new JSONObject();//배열 내에 들어갈 json
				       
				        	sObject.put("id", String.valueOf(databoard.get(i).getIdx()));
				        	
						   sObject.put("title", databoard.get(i).getStoreId() + ":" + databoard.get(i).getClassName() );
						   sObject.put("start", databoard.get(i).getStartDate() +"T" + databoard.get(i).getTime() + ":00");
						//   sObject.put("time", databoard.get(i).getTime());
						  sObject.put("end", databoard.get(i).getEndDate() + "T24:00:00");
						//   sObject.put("end", databoard.get(i).getTime());
						   //sObject.put("write", "dd");
						 // sObject.put("allDay", "true");
						   sObject.put("color", "#" + String.valueOf(Math.round(Math.random() * 999 )) );
						   
				        jArray.put(sObject);
				    }

				
				
			   } catch (JSONException e) {
				    e.printStackTrace();
				}
			   
			   
			   var result =   jArray.toString();
			   
			   System.out.println(result);
			   
			return result;

		}
		
		
		
//		
//	@ResponseBody
//	@RequestMapping(value = "/saveSchedata.do", method = RequestMethod.POST)
//	public Map<Object,Object> addSchedule(@RequestBody SheduleDto dto) throws Exception{
//		Map<Object,Object>map = new HashMap<Object,Object>();
//
//	//	productService.addSchedule(dto);
//
//		return map;
//	}
//
//	@RequestMapping(value = "/schedule")
//	public String schedule(Model model)throws Exception {
//
//	//	model.addAttribute("showSchedule" , productService.showSchedule());
//	    
//		return "/schedule";
//	}
	
	
		/*
		 * @GetMapping("/productStockList") public String viewStock(Model model) throws
		 * Exception {
		 * 
		 * List<ShopDto> stockList = sellerService.selectProductList();
		 * model.addAttribute(stockList);
		 * 
		 * model.addAttribute("template", "admin/productStockList"); return
		 * "admin/index"; }
		 * 
		 */
		
		
		
		
	
	
}
