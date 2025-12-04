package com.example.smartevent.config;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartevent.dto.StallOwnerDashboardDTO;
import com.example.smartevent.service.StallService;
@RestController
public class stallownerController {
	private StallService stallService;
	
	
	public stallownerController(StallService stallService) {
		super();
		this.stallService = stallService;
	}


//	@GetMapping("/dashboard")
//    public ResponseEntity<StallOwnerDashboardDTO> getDashboard(Authentication authentication) {
//        String username = authentication.getName();
//        StallOwnerDashboardDTO dashboard = stallService.getOwnerDashboard(username);
//        return ResponseEntity.ok(dashboard);
//    }

}
