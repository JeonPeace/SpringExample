package com.jeonpeace.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeonpeace.spring.ex.database.domain.UsedGoods;
import com.jeonpeace.spring.ex.database.service.UsedGoodsService;

// request와 response 처리 담당
@Controller
public class UsedGoodsController {

	@Autowired
	private UsedGoodsService usedGoodsService;
	
	@RequestMapping("/db/usedgoods/list")
	@ResponseBody
	public List<UsedGoods> usedGodosList() {
		
		// 중고 물품 게시글 리스트 얻어오기 => service 역할
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		return usedGoodsList;
		
	}
	
}
