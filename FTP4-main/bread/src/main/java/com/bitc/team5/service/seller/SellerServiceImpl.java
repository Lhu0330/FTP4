package com.bitc.team5.service.seller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.team5.common.ProductFileUtils;
import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.BoardDto;
import com.bitc.team5.dto.MarketDto;
import com.bitc.team5.dto.SheduleDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.UsersDto;
import com.bitc.team5.dto.classDto;
import com.bitc.team5.mapper.seller.SellerMapper;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerMapper sellerMapper;
	
	@Autowired
	private ProductFileUtils fileUtils;
	
	@Override
	public List<UsersDto> getUsers() throws Exception {
		
		return sellerMapper.getUsers();
	}
	
	//일반상품리스트
		@Override
		public List<ShopDto> selectProductList() throws Exception {
			// TODO Auto-generated method stub
			return sellerMapper.selectProductList();
		}
		
		
		// 클래스리스트 
			@Override
			public List<classDto> selectclassList() throws Exception {
				
				return sellerMapper.selectclassList();
			}
		
				

			// 폼 리스트 가져오기 
		@Override
		public List<MarketDto> selectformList() throws Exception {
			
			return sellerMapper.selectformList();
		}
		

		// 상품등록 
		@Override
		public void insertBoard(ShopDto restBoard, MultipartHttpServletRequest multiFiles, String storeId) throws Exception {
			
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
			String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
			String subNum = "";
			 
			for(int i = 1; i <= 3; i ++) {
				subNum += (int)(Math.random() * 10);
			}
			
			String orderCodeS = ymd + subNum;
			
			long orderCode = Long.parseLong(orderCodeS);
			
			restBoard.setProductId(orderCode);
			restBoard.setStoreId(storeId);
			
			sellerMapper.insertBoard(restBoard);
			
		
			
			List<AdminProductFileDto> list = new ArrayList<AdminProductFileDto>();
			
			List<AdminProductFileDto> alist = fileUtils.parseFileInfo(restBoard.getIdx(), multiFiles);
//			List<AdminProductFileDto> list = fileUtils.parseFileInfo(0, multiFiles);
			
			
			
			for (AdminProductFileDto item : alist) {
					item.setProductId(orderCode);
					list.add(item);
			
			}
			
//			분석된 파일 리스트의 내용이 있는지 확인하고 Mapper를 통해서 DB에 저장
			if (CollectionUtils.isEmpty(list) == false) {
				
				
				sellerMapper.insertBoardFileList(list);
			
			}
			
		//	sellerMapper.insertshop(restBoard);
			
		}
		
		
		// 클래스 등록
			@Override
			public void insertClass(classDto restBoard, MultipartHttpServletRequest multiFiles, String storeId) throws Exception {
				// TODO Auto-generated method stub
				
				
				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
				String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
				String subNum = "";
				 
				for(int i = 1; i <= 4; i ++) {
					subNum += (int)(Math.random() * 10);
				}
				
				String orderCodeS = ymd + subNum;
				
				long orderCode = Long.parseLong(orderCodeS);
				
				restBoard.setClassId(orderCodeS);
				restBoard.setStoreId(storeId);
				
				sellerMapper.insertClass(restBoard);
				
			
				
				List<AdminProductFileDto> list = new ArrayList<AdminProductFileDto>();
				
				List<AdminProductFileDto> alist = fileUtils.parseFileInfo(restBoard.getIdx(), multiFiles);
//				List<AdminProductFileDto> list = fileUtils.parseFileInfo(0, multiFiles);
				
				
				
				for (AdminProductFileDto item : alist) {
						item.setClassId(orderCode);
						item.setStoreId(storeId);
						list.add(item);
				
				}
				
//				분석된 파일 리스트의 내용이 있는지 확인하고 Mapper를 통해서 DB에 저장
				if (CollectionUtils.isEmpty(list) == false) {
					
					
					sellerMapper.insertBoardFileList2(list);
				
				}
					
				
			}
		
			//// 상품디테일
		@Override
		public ShopDto selectAdminProductDetail(int idx) throws Exception {
		
			ShopDto board = sellerMapper.selectBoardDetail(idx);
			
			
//			첨부파일
			List<AdminProductFileDto> fileList = sellerMapper.selectBoardFileList(idx);
			
			board.setFileList(fileList);
			
			return board;
			
		}
		
		 //클래스 상세보기
			@Override
			public classDto selectclassDetail(int idx) throws Exception {
				
				
				classDto board = sellerMapper.selectclassDetail(idx);
				
				
//				첨부파일
				List<AdminProductFileDto> fileList = sellerMapper.selectBoardFileList2(idx);
				
			
				board.setFileList(fileList);
				
				return board;
				
				
			}

			
			// 마켓 폼 상세보기 
			
			@Override
			public MarketDto selectformDetail(long formId) throws Exception {
				
				MarketDto board = sellerMapper.selectformDetail(formId);
								
								
					//			첨부파일
				List<AdminProductFileDto> fileList = sellerMapper.selectBoardFileList3(formId);
								
							
				board.setFileList(fileList);
								
				return board;
			}


			 // 폼 상세화면 
			@Override
			public List<ShopDto> selectformDetail2(long formId) throws Exception {
				
				
				return (List<ShopDto>) sellerMapper.selectformDetail2( formId);
				

			}
			

			
		
		
		@Override
		public AdminProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception {
			return sellerMapper.selectBoardFileInfo(fileIdx, boardIdx);
		}

		 // 마켓 관련 
		
			//마켓정보 등록 
		@Override
		public void insertForm(MarketDto market, MultipartHttpServletRequest multiFiles, String storeId, long formId) throws Exception {
			
			market.setStoreId(storeId);
			

//			Calendar cal = Calendar.getInstance();
//			int year = cal.get(Calendar.YEAR);
//			String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
//			String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
//			String subNum = "";
//			 
//			for(int i = 1; i <= 5; i ++) {
//				subNum += (int)(Math.random() * 10);
//			}
//			
//			String orderCodeS = ymd + subNum;
//			
//			long orderCode = Long.parseLong(orderCodeS);
//			
			market.setFormId(formId);
			market.setStoreId(storeId);
			
			sellerMapper.insertForm(market);
			
		
			
			List<AdminProductFileDto> list = new ArrayList<AdminProductFileDto>();
			
			List<AdminProductFileDto> alist = fileUtils.parseFileInfo(market.getIdx(), multiFiles);
//			List<AdminProductFileDto> list = fileUtils.parseFileInfo(0, multiFiles);
			
			
			
			for (AdminProductFileDto item : alist) {
					item.setFormId(formId);
					item.setStoreId(storeId);					
					list.add(item);
			
			}
			
//			분석된 파일 리스트의 내용이 있는지 확인하고 Mapper를 통해서 DB에 저장
			if (CollectionUtils.isEmpty(list) == false) {
				
				
				sellerMapper.insertBoardFileList3(list);
			
			}
				
			
			
		}
		

		// 폼 동적 INPUT 상품  등록  
		@Override
		public void insertForm2(List<ShopDto> formProduct, String storeId,  long formId) {
			
			/*
			 * List<ShopDto> formProduct2 = new ArrayList<ShopDto>();
			 * 
			 * for (ShopDto item : alist) { item.setFormId(orderCode);
			 * item.setStoreId(storeId); item .add(item);
			 * 
			 * }
			 */
			
		
			sellerMapper.insertForm2(formProduct);
			
		}

		@Override
		public void addSchedule(SheduleDto dto) throws Exception{
			sellerMapper.addSchedule(dto);
			
		}

		
		
// 캘린더 
		@Override
		public List<MarketDto> formDateList() {
			// TODO Auto-generated method stub
			return sellerMapper.formDateList();
		}
		
		@Override
		public List<classDto> classDateList() {
			// TODO Auto-generated method stub
			return sellerMapper.classDateList();
		}
		
	//	
	//	
		
//		게시글, 리뷰
		@Override
		public void writeBoard(BoardDto board, MultipartHttpServletRequest multiFiles) throws Exception {
			sellerMapper.writeBoard(board);
		}
		@Override
		public List<BoardDto> selectBoardList() throws Exception {
			return sellerMapper.selectBoardList();
		}
		@Override
		public BoardDto selectDetailBoard(int idx) throws Exception {
			return sellerMapper.selectDetailBoard(idx);
		}
		
		@Override
		public void updateBoard(BoardDto board) throws Exception {
			sellerMapper.updateBoard(board);
		}
		@Override
		public void deleteBoard(int idx) throws Exception {
			sellerMapper.deleteBoard(idx);
		}
		
		@Override
		public List<BoardDto> selectMyBoard(String userId) throws Exception {
			return sellerMapper.selectMyBoard(userId);
		}
	
	
	
}
	

