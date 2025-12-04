package com.example.smartevent.service;

import com.example.smartevent.dto.AdminQueryResponse;
import com.example.smartevent.dto.QueryRequest;
import com.example.smartevent.dto.QueryResponse;
import com.example.smartevent.models.Event;
import com.example.smartevent.models.Query;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.EventRepository;
import com.example.smartevent.repository.QueryRepository;
import com.example.smartevent.repository.StallRepository;
import com.example.smartevent.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryService {

    private final QueryRepository queryRepository;
    private final StallRepository stallRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final EventRepository eventRepository;

   

    // -------------------------
    // BASIC CRUD
    // -------------------------

    public QueryService(QueryRepository queryRepository, StallRepository stallRepository, UserRepository userRepository,
			EmailService emailService, EventRepository eventRepository) {
		super();
		this.queryRepository = queryRepository;
		this.stallRepository = stallRepository;
		this.userRepository = userRepository;
		this.emailService = emailService;
		this.eventRepository = eventRepository;
	}


	public QueryResponse createQuery(QueryRequest req) {
        if (req.getUserId() == null) throw new IllegalArgumentException("User ID is required");
        if (req.getEventId() == null) throw new IllegalArgumentException("Event ID is required");

        // 1. Find the event
        Event event = eventRepository.findById(req.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found for ID: " + req.getEventId()));

        // Pick first stall
        Stall stall = event.getStalls().isEmpty() ? null : event.getStalls().get(0);
        if (stall == null) throw new RuntimeException("Event has no associated stalls");

        Query q = new Query();
        q.setTitle(event.getTitle());
        q.setCategory(req.getCategory());
        q.setPriority(req.getPriority());
        q.setStatus(req.getStatus());
        q.setDescription(req.getDescription());
        q.setUserId(req.getUserId());
        q.setStall(stall);

        return mapToResponse(queryRepository.save(q));
    }


    public QueryResponse updateQuery(Long id, QueryRequest req) {
        if (id == null) throw new IllegalArgumentException("Query ID must not be null");
        if (req == null) throw new IllegalArgumentException("QueryRequest must not be null");
        if (req.getUserId() == null) throw new IllegalArgumentException("User ID is required");

        Query q = queryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Query not found for ID: " + id));

//        q.setTitle(req.getTitle());
        q.setCategory(req.getCategory());
        q.setPriority(req.getPriority());
        q.setStatus(req.getStatus());
        q.setDescription(req.getDescription());
        q.setUserId(req.getUserId());

        return mapToResponse(queryRepository.save(q));
    }

    public List<QueryResponse> getQueriesByUser(Long userId) {
        if (userId == null) return List.of(); // return empty list instead of throwing exception

        return queryRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public QueryResponse getQuery(Long id) {
        if (id == null) throw new IllegalArgumentException("Query ID must not be null");

        return queryRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Query not found for ID: " + id));
    }

    public void deleteQuery(Long id) {
        if (id == null) throw new IllegalArgumentException("Query ID must not be null");

        if (!queryRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Query not found for ID: " + id);
        }
        queryRepository.deleteById(id);
    }

    // -------------------------
    // SUBMIT QUERY + EMAIL
    // -------------------------

    public Query submitQuery(Long stallId, Long visitorId, String description) throws Exception {
        if (stallId == null) throw new IllegalArgumentException("Stall ID must not be null");
        if (visitorId == null) throw new IllegalArgumentException("Visitor ID must not be null");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("Description is required");

        Stall stall = stallRepository.findById(stallId)
                .orElseThrow(() -> new RuntimeException("Stall not found for ID: " + stallId));

        User visitor = userRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found for ID: " + visitorId));

        Query q = new Query();
        q.setTitle("New Query");
        q.setCategory("General");
        q.setPriority("Normal");
        q.setStatus("Pending");
        q.setDescription(description);
        q.setUserId(visitorId);
        q.setStall(stall);

        Query saved = queryRepository.save(q);

        // Email stall owner
        emailService.sendEmail(
                stall.getOwner().getEmail(),
                "New Query from Visitor",
                "new-query.html",
                new String[][]{
                        {"{{visitorName}}", visitor.getFullName()},
                        {"{{stallName}}", stall.getName()},
                        {"{{queryText}}", description}
                }
        );

        return saved;
    }

    // -------------------------
    // ANSWER QUERY + EMAIL
    // -------------------------

    public Query answerQuery(Long queryId, String answer) throws Exception {
        if (queryId == null) throw new IllegalArgumentException("Query ID must not be null");
        if (answer == null || answer.isBlank()) throw new IllegalArgumentException("Answer is required");

        Query q = queryRepository.findById(queryId)
                .orElseThrow(() -> new RuntimeException("Query not found for ID: " + queryId));

        q.setStatus("Answered");
        q.setDescription(q.getDescription() + "\n\nANSWER: " + answer);

        Query saved = queryRepository.save(q);

        User visitor = userRepository.findById(q.getUserId())
                .orElseThrow(() -> new RuntimeException("Visitor not found for ID: " + q.getUserId()));

        // Send email to visitor
        emailService.sendEmail(
                visitor.getEmail(),
                "Your Query Has Been Answered",
                "query-response.html",
                new String[][]{
                        {"{{stallName}}", q.getStall().getName()},
                        {"{{queryText}}", q.getDescription()},
                        {"{{answer}}", answer}
                }
        );

        return saved;
    }

    // -------------------------
    // HELPER
    // -------------------------

    private QueryResponse mapToResponse(Query q) {
        QueryResponse r = new QueryResponse();
        r.setId(q.getId());
        r.setTitle(q.getTitle());
        r.setCategory(q.getCategory());
        r.setPriority(q.getPriority());
        r.setStatus(q.getStatus());
        r.setDescription(q.getDescription());
        r.setUserId(q.getUserId());
        r.setStallId(q.getStall() != null ? q.getStall().getId() : null);
        return r;
    }

    // -------------------------
    // ADMIN QUERIES
    // -------------------------

    public List<AdminQueryResponse> getAllAdminQueries() {
        List<Object[]> rows = queryRepository.findAllAdminQueries();

        return rows.stream().map(r ->
                new AdminQueryResponse(
                        ((Number) r[0]).longValue(),  // id
                        (String) r[1],                // fullName
                        (String) r[2],                // stallName
                        (String) r[3],                // description
                        (String) r[4]                 // answer
                )
        ).toList();
    }
}
