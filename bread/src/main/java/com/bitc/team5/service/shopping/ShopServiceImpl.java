package com.bitc.team5.service.shopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.AdminProductFileDto;
import com.bitc.team5.dto.MarketDto;
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.classDto;
import com.bitc.team5.mapper.shoppinig.ShopMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class ShopServiceImpl  implements ShopService {

	@Autowired
	private ShopMapper shopMapper;
	
	/*
	 * @Autowired private ProductFileUtils fileUtils;
	 */
	
////메인화면
//	@Override
//	public List<ProjectDto> selectJrList() throws Exception {
//		
//		return projectMapper.selectJrList();
//		
//	}

//	@Override
//	public List<ProjectDto> selectList() throws Exception {
//		return projectMapper.selectList();
//	}
	

//	@Override
//	public ProjectDto selectBoardDetail(int productIdx) throws Exception {
//		
//		ProjectDto board = projectMapper.selectBoardDetail(productIdx);
//		List<ProductFileDto> fileList = projectMapper.selectBoardFileList(productIdx);
//		board.setFileList(fileList);
//		return board;
//	}
//	
	
//		@Override
//		public ProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception {
//			return projectMapper.selectBoardFileInfo(fileIdx, boardIdx);
//		}

		// 카테고리별 상품화면 
		@Override
		public Page<ShopDto> selectProductList(int pageNum, int productCateId) throws Exception {
			
		//	PageInfo<ShopDto> ProductList2 = new PageInfo<> ();
			
//			List<AdminProductFileDto> fileList = shopMapper.selectMenuFileList(productCateId);

			
			PageHelper.startPage(pageNum, 12);
			

			
			return shopMapper.selectProductList(productCateId);
			
		}

		@Override
		public List<AdminProductFileDto> selectMenuFileList(int productCateId) {
		
			return shopMapper.selectMenuFileList(productCateId);
		}

		
		 // 상품상세화면
		@Override
		public ShopDto selectProductDetail(long productId) throws Exception {
			
			// ask
			shopMapper.updateHitCnt(productId);
			ShopDto board = shopMapper.selectProductDetail(productId);
			
		
			
//			첨부파일 (썸네일 )
			List<AdminProductFileDto> fileList = shopMapper.selectBoardFileList(productId);
			List<AdminProductFileDto> fileList2 = shopMapper.selectBoardFileList2(productId);
			board.setFileList(fileList);
			board.setFileList2(fileList2);
			
			
			return board;
			
		}

		// 클래스 list
		@Override
		public Page<classDto> selectClass(int pageNum) throws Exception {
//			startPage(pageNum, 10) : 첫번 매개변수는 현재 페이지 번호, 두번째 매개변수는 한 페이지에 출력되는 데이터 수
			PageHelper.startPage(pageNum, 10);
			return shopMapper.selectClass();
			
		}
			//클래스 상세보기
		
		@Override
		public classDto selectClassDetail(long classId) throws Exception {
			
			
			classDto board = shopMapper.selectClassDetail(classId);
			
//			첨부파일 (썸네일 )
			List<AdminProductFileDto> fileList = shopMapper.selectclassFileList(classId);
			List<AdminProductFileDto> fileList2 = shopMapper.selectclassFileList2(classId);
			board.setFileList(fileList);
			board.setFileList2(fileList2);
			
			return board;

			
		}
		
			// 마켓

		@Override
		public Page<MarketDto> selectdformList(int pageNum) {
			PageHelper.startPage(pageNum, 8); 
			return shopMapper.selectdformList();
		}

		@Override
		public MarketDto selectclassDetail(long formId) {
			
			MarketDto board = shopMapper.selectformDetail(formId);
			
			// 첨부파일 (썸네일 )
			List<AdminProductFileDto> fileList = shopMapper.selectformFileList(formId);
			List<AdminProductFileDto> fileList2 = shopMapper.selectformFileList2(formId);
			board.setFileList(fileList);
			board.setFileList2(fileList2);
			
			
			return board;
		}
			/// 마켓  input 상품들 가져오기
		@Override
		public List<ShopDto> selectformDetail2(long formId) {
			
			return shopMapper.selectformDetail2(formId);
		}


		
		
		// 클래스 리스트 화면 
	
		
		/*
		 * @Override public ProjectDto selectBoardDetail(int productIdx) throws
		 * Exception {
		 * 
		 * ProjectDto board = projectMapper.selectBoardDetail(productIdx);
		 * List<ProjectDto> fileList = projectMapper.selectBoardFileList(productIdx);
		 * board.setFileList(fileList); return board; }
		 */



}
