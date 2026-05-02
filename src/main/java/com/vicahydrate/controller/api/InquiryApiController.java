package com.vicahydrate.controller.api;

import com.vicahydrate.dto.InquiryRequest;
import com.vicahydrate.model.Inquiry;
import com.vicahydrate.service.InquiryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/inquiries")
public class InquiryApiController {

    private final InquiryService inquiryService;

    public InquiryApiController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> submitInquiry(
            @Valid @RequestBody InquiryRequest request,
            BindingResult bindingResult) {

        Map<String, Object> response = new HashMap<>();

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(err ->
                    errors.put(err.getField(), err.getDefaultMessage()));

            response.put("success", false);
            response.put("errors", errors);
            return ResponseEntity.badRequest().body(response);
        }

        Inquiry saved = inquiryService.submitInquiry(request);

        response.put("success", true);
        response.put("message", "Thank you for reaching out! We will get back to you within 24 hours.");
        response.put("id", saved.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}