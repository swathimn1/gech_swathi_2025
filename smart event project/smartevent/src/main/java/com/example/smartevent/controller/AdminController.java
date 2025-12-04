package com.example.smartevent.controller;

import com.example.smartevent.dto.AdminQueryResponse;
import com.example.smartevent.dto.AnalyticsDTO;
import com.example.smartevent.dto.EventVisitorsDTO;
import com.example.smartevent.dto.StallRatingDTO;
import com.example.smartevent.dto.StallScanDTO;
import com.example.smartevent.dto.UserDTO;
import com.example.smartevent.models.Role;
import com.example.smartevent.models.User;
import com.example.smartevent.service.AnalyticsService;
import com.example.smartevent.service.QueryService;
import com.example.smartevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')") // ✅ Applies to all endpoints in this controller
@CrossOrigin(origins = "http://localhost:5173") // allow your frontend
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AnalyticsService analyticsService;
    @Autowired
    private QueryService queryService;
    

    // ✅ CREATE: Add a new user
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // ✅ READ: Get all users
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // ✅ READ: Get user by ID
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // ✅ UPDATE: Update user details
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    // ✅ UPDATE: Update user role
    @PutMapping("/users/{id}/role")
    public ResponseEntity<User> updateUserRole(@PathVariable Long id, @RequestParam Role role) {
        User updatedUser = userService.updateUserRole(id, role);
        return ResponseEntity.ok(updatedUser);
    }

    // ✅ DELETE: Delete user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    // ✅ ANALYTICS: Dashboard summary
 // ✅ ANALYTICS: Dashboard summary
    @GetMapping("/analytics")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AnalyticsDTO> getAnalytics() {
        AnalyticsDTO dto = analyticsService.getAnalytics();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/analytics/event-visitors")
    public List<EventVisitorsDTO> eventVisitors() {
        return analyticsService.getVisitorsPerEvent();
    }

    @GetMapping("/analytics/stall-scans")
    public List<StallScanDTO> stallScans() {
        return analyticsService.getScanCountsPerStall();
    }

    @GetMapping("/analytics/stall-ratings")
    public List<StallRatingDTO> stallRatings() {
        return analyticsService.getAvgRatingsPerStall();
    }
    
    

    @GetMapping("/queries")
    public List<AdminQueryResponse> getAllQueries() {
        return queryService.getAllAdminQueries();
    }

    @PostMapping("/queries/{id}/reply")
    public ResponseEntity<?> replyQuery(@PathVariable Long id, @RequestBody Map<String,String> body) throws Exception {
        String reply = body.get("reply");
        queryService.answerQuery(id, reply);
        return ResponseEntity.ok("Reply sent");
    }

}
