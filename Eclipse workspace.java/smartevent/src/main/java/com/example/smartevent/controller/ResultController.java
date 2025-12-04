package com.example.smartevent.controller;


import com.example.smartevent.models.Result;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.ResultRepository;
import com.example.smartevent.repository.StallRepository;
import com.example.smartevent.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/stall-owner/results")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ResultController {
    
    private final ResultRepository resultRepository;
    private final StallRepository stallRepository;
    private final UserRepository userRepository;
    
    public ResultController(ResultRepository resultRepository, StallRepository stallRepository,
			UserRepository userRepository) {
		super();
		this.resultRepository = resultRepository;
		this.stallRepository = stallRepository;
		this.userRepository = userRepository;
	}

	@GetMapping
    public ResponseEntity<List<Result>> getAllResults(Authentication authentication) {
        User user = getUserFromAuth(authentication);
        List<Result> results = resultRepository.findByUploadedBy(user);
        return ResponseEntity.ok(results);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Long id, Authentication authentication) {
        User user = getUserFromAuth(authentication);
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));
        
        if (!result.getUploadedBy().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }
        
        return ResponseEntity.ok(result);
    }
    
    @PostMapping
    public ResponseEntity<Result> createResult(@Valid @RequestBody ResultRequest request, 
                                               Authentication authentication) {
        User user = getUserFromAuth(authentication);
        
        Result result = new Result();
        result.setTitle(request.getTitle());
        result.setDate(LocalDate.parse(request.getDate()));
        result.setDescription(request.getDescription());
        result.setPerformance(request.getPerformance());
        result.setRevenue(new BigDecimal(request.getRevenue()));
        result.setUploadedBy(user);
        
        if (request.getStallId() != null) {
            Stall stall = stallRepository.findById(request.getStallId())
                    .orElseThrow(() -> new RuntimeException("Stall not found"));
            result.setStall(stall);
        }
        
        Result savedResult = resultRepository.save(result);
        return ResponseEntity.ok(savedResult);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResult(@PathVariable Long id, Authentication authentication) {
        User user = getUserFromAuth(authentication);
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));
        
        if (!result.getUploadedBy().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }
        
        resultRepository.delete(result);
        return ResponseEntity.ok().body("Result deleted successfully");
    }
    
    private User getUserFromAuth(Authentication authentication) {
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

@Data
class ResultRequest {
    private String title;
    private String date;
    private String description;
    private Integer performance;
    private String revenue;
    private Long stallId;
	
	public String getTitle() {
		return title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPerformance() {
		return performance;
	}
	public void setPerformance(Integer performance) {
		this.performance = performance;
	}
	public String getRevenue() {
		return revenue;
	}
	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}
	public Long getStallId() {
		return stallId;
	}
	public void setStallId(Long stallId) {
		this.stallId = stallId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
