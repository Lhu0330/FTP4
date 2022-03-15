package com.bitc.team5.service;

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
import com.bitc.team5.dto.ShopDto;
import com.bitc.team5.dto.UsersDto;
import com.bitc.team5.mapper.SellerMapper;

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

	@Override
	public List<ShopDto> selectProductList() throws Exception {
		// TODO Auto-generated method stub
		return sellerMapper.selectProductList();
	}

	// ��ǰ��� 
	@Override
	public void insertBoard(ShopDto restBoard, MultipartHttpServletRequest multiFiles) throws Exception {
		
		
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
		
		
		sellerMapper.insertBoard(restBoard);
		
	
		
		List<AdminProductFileDto> list = new ArrayList<AdminProductFileDto>();
		
		List<AdminProductFileDto> alist = fileUtils.parseFileInfo(restBoard.getIdx(), multiFiles);
//		List<AdminProductFileDto> list = fileUtils.parseFileInfo(0, multiFiles);
		
		
		
		for (AdminProductFileDto item : alist) {
				item.setProductId(orderCode);
				list.add(item);
		
		}
		
//		�м��� ���� ����Ʈ�� ������ �ִ��� Ȯ���ϰ� Mapper�� ���ؼ� DB�� ����
		if (CollectionUtils.isEmpty(list) == false) {
			sellerMapper.insertBoardFileList(list);
		
		}
		
	}
		// ��ǰ������
	@Override
	public ShopDto selectAdminProductDetail(int idx) throws Exception {
	
		ShopDto board = sellerMapper.selectBoardDetail(idx);
		
		
//		÷������
		List<AdminProductFileDto> fileList = sellerMapper.selectBoardFileList(idx);
		
		board.setFileList(fileList);
		
		return board;
		
	}
	
	@Override
	public AdminProductFileDto selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception {
		return sellerMapper.selectBoardFileInfo(fileIdx, boardIdx);
	}
	
//	
//	
//	@Override
//	public void deleteAdminProduct(int ProductIdx) throws Exception {
//		adminProductMapper.deleteAdminProduct(ProductIdx);
//	}
//
//	@Override
//	public AdminProductDto selectAdminProductDetail(int noticeIdx) throws Exception {
//		AdminProductDto adnot = adminProductMapper.selectAdminProductDetail(noticeIdx);
//		
//		List<AdminProductFileDto> adnotFi = adminProductMapper.selectAdminProductFileList(noticeIdx);
//		adnot.setFileList(adnotFi);
//		return adnot;
//	}
//	
//	@Override
//	public void updateAdminProduct(AdminProductDto adnot) throws Exception {
//		adminProductMapper.updateAdminProduct(adnot);
//	}
//	
//	@Override
//	public AdminProductFileDto selectAdminProductFileInfo(int fileIdx, int boardIdx) throws Exception {
//		return adminProductMapper.selectAdminProductFileInfo(fileIdx, boardIdx);
//	}
//
//	@Override
//	public List<CategoryProductDto> selectCategoryList() {
//		return adminProductMapper.selectCategoryList();
//	}
//	
	
	
}
	

