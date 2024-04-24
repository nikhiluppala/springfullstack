package com.springfullstack.FirstJobApp.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
	
	@Autowired
	public ReviewService reviewService;
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
		List<Review> reviews = reviewService.getAllReviews(companyId);
		if(reviews != null) return new ResponseEntity<>(reviews ,HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/reviews")
	public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
		boolean reviewAdded = reviewService.addReview(companyId, review);
		if(reviewAdded) return new ResponseEntity<>("Review Added Successfully",HttpStatus.OK);
		
		return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
		return new ResponseEntity<>(reviewService.getReviewById(companyId, reviewId), HttpStatus.OK);
	}
	
	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReviewById(@PathVariable Long companyId, 
												   @PathVariable Long reviewId,
												   @RequestBody Review review){
		boolean isUpdated = reviewService.updateReview(companyId, reviewId, review);
		if(isUpdated) return new ResponseEntity<>("Review updated Successfully", HttpStatus.OK);
		
		return new ResponseEntity<>("Company Not found",HttpStatus.NOT_FOUND);
	} 

}
