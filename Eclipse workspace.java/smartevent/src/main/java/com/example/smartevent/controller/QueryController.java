package com.example.smartevent.controller;

import com.example.smartevent.dto.QueryRequest;
import com.example.smartevent.dto.QueryResponse;
import com.example.smartevent.models.Query;
import com.example.smartevent.service.QueryService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/visitor")
@CrossOrigin("*")
public class QueryController {

    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping("/queries")
    public QueryResponse create(@RequestBody QueryRequest request) {
        return queryService.createQuery(request);
    }

    @PutMapping("/queries/{id}")
    public QueryResponse update(@PathVariable Long id,
                                @RequestBody QueryRequest request) {
        return queryService.updateQuery(id, request);
    }

    @GetMapping("/queries/user/{userId}")
    public List<QueryResponse> getByUser(@PathVariable Long userId) {
        return queryService.getQueriesByUser(userId);
    }

    @GetMapping("/queries/{id}")
    public QueryResponse getOne(@PathVariable Long id) {
        return queryService.getQuery(id);
    }

    @DeleteMapping("/queries/{id}")
    public String delete(@PathVariable Long id) {
        queryService.deleteQuery(id);
        return "Query deleted successfully";
    }
    @PostMapping("/create")
    public ResponseEntity<Query> createQuery(@RequestBody Map<String, Object> body) throws Exception {

        Long stallId = Long.parseLong(body.get("stallId").toString());
        Long visitorId = Long.parseLong(body.get("visitorId").toString());
        String question = body.get("question").toString();

        Query saved = queryService.submitQuery(stallId, visitorId, question);
        return ResponseEntity.ok(saved);
    }


    @PostMapping("/{id}/answer")
    public ResponseEntity<Query> answerQuery(@PathVariable Long id, @RequestBody Map<String, String> body) throws Exception {
        String answer = body.get("answer");
        Query updated = queryService.answerQuery(id, answer);
        return ResponseEntity.ok(updated);
    }
//    @GetMapping("/queries/stall/{stallId}")
//    public ResponseEntity<List<QueryRequest>> getQueriesByStall(
//            @PathVariable Long stallId,
//            Authentication authentication) {
//        String username = authentication.getName();
//        List<QueryRequest> queries = queryService.getQueriesByStallAndOwner(stallId, username);
//        return ResponseEntity.ok(queries);
//    }
}