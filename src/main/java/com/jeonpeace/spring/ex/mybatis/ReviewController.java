package com.jeonpeace.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeonpeace.spring.ex.mybatis.domain.Review;
import com.jeonpeace.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	// parameter로 전달 받은 id와 일치하는 리뷰 정보를 json으로 Response 담는다.
	@RequestMapping("/")
	@ResponseBody
	public Review review(@RequestParam("id") int id) {
		// reqeust Parameter
		// request.getParameter("id"); (servlet)
		
		Review review = reviewService.getReview(id);
		
		return review;
		
	}
	
	// 리뷰 정보를 저장하는 페이지
	@RequestMapping("/create")
	@ResponseBody
	public String createReview(){
		
//		// 4, 치즈피자, 전진우, 4.5, 치즈피자 존맛!
//		int count = reviewService.addReview(4, "치즈피자", "전진우", 4.5, "치즈피자 존맛!");
		
		// 2, 뿌링클, 전진우, 4.0, 역시 뿌링클은 진리입니다.
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("전진우");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다.");
		
		int count = reviewService.addReviewByObject(review);
		
		// 입력 개수 : 1
		return "입력 개수 : " + count;
		
	}
	
}
