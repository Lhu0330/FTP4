package com.bitc.team5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.mapper.ShopMapper;
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
			
			PageHelper.startPage(pageNum, 12);
			
			return shopMapper.selectProductList(productCateId);
		}

		 // 상품상세화면
		@Override
		public ShopDto selectProductDetail(int productId) throws Exception {
			
			ShopDto board = shopMapper.selectProductDetail(productId);
			
			return board;
			
		}

		
		/*
		 * @Override public ProjectDto selectBoardDetail(int productIdx) throws
		 * Exception {
		 * 
		 * ProjectDto board = projectMapper.selectBoardDetail(productIdx);
		 * List<ProjectDto> fileList = projectMapper.selectBoardFileList(productIdx);
		 * board.setFileList(fileList); return board; }
		 */


}
