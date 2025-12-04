//package com.example.smartevent.controller.visitor;
//
//import com.example.smartevent.dto.VisitorScanDTO;
//import com.example.smartevent.service.VisitorScanService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.security.Principal;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/visitor/scan")
//@CrossOrigin(origins = "*")
//public class VisitorScanController {
//
//    @Autowired
//    private VisitorScanService scanService;
//
//    // POST /api/visitor/scan
//    @PostMapping
//    public ResponseEntity<VisitorScanDTO> addScan(@RequestBody Map<String, String> request, Principal principal) {
//        String content = request.get("content");
//        VisitorScanDTO savedScan = scanService.addScan(principal.getName(), content);
//        return ResponseEntity.ok(savedScan);
//    }
//
//    // GET /api/visitor/scan
//    @GetMapping
//    public ResponseEntity<List<VisitorScanDTO>> getScans(Principal principal) {
//        return ResponseEntity.ok(scanService.getScans(principal.getName()));
//    }
//
//    // GET /api/visitor/points
//    @GetMapping("/points")
//    public ResponseEntity<Map<String, Integer>> getPoints(Principal principal) {
//        int total = scanService.getTotalPoints(principal.getName());
//        return ResponseEntity.ok(Map.of("totalPoints", total));
//    }
//
//    // DELETE /api/visitor/scan/{id}
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteScan(@PathVariable Long id) {
//        scanService.deleteScan(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // DELETE /api/visitor/scan/all
//    @DeleteMapping("/all")
//    public ResponseEntity<Void> deleteAll(Principal principal) {
//        scanService.deleteAllScans(principal.getName());
//        return ResponseEntity.noContent().build();
//    }
//}
