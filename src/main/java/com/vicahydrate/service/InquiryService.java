package com.vicahydrate.service;

import com.vicahydrate.dto.InquiryRequest;
import com.vicahydrate.model.Inquiry;
import com.vicahydrate.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    public Inquiry submitInquiry(InquiryRequest request) {
        Inquiry inquiry = new Inquiry();
        inquiry.setName(request.getName());
        inquiry.setEmail(request.getEmail());
        inquiry.setPhone(request.getPhone());
        inquiry.setMessage(request.getMessage());
        inquiry.setStatus("new");
        return inquiryRepository.save(inquiry);
    }
}