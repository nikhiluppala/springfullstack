package com.springfullstack.FirstJobApp.review.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springfullstack.FirstJobApp.company.Company;
import com.springfullstack.FirstJobApp.company.CompanyService;
import com.springfullstack.FirstJobApp.review.Review;
import com.springfullstack.FirstJobApp.review.ReviewRepo;
import com.springfullstack.FirstJobApp.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewRepo reviewRepo;

	@Autowired
	private CompanyService companySevice;

	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews = reviewRepo.findByCompanyId(companyId);
		if (reviews.size() != 0)
			return reviews;
		return null;
	}

	@Override
	public boolean addReview(Long companyId, Review review) {
		Company company = companySevice.getCompanyById(companyId);
		if (company != null) {
			review.setCompany(company);
			reviewRepo.save(review);
			return true;
		}
		return false;

	}

	@Override
	public Review getReviewById(Long companyId, Long reviewId) {
		
		List<Review> reviews = reviewRepo.findByCompanyId(companyId);
		return reviews.stream().
				filter(review -> review.getId().equals(reviewId))
				.findFirst()
				.orElse(null);
		
	}

	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review updateReview) {
		if(companySevice.getCompanyById(companyId) != null) {
			updateReview.setCompany(companySevice.getCompanyById(companyId));
			updateReview.setId(reviewId);
			reviewRepo.save(updateReview);
			return true;
		}
		return false;
	}

	
}
