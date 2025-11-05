package com.example.smartevent.service;

import com.example.smartevent.models.Query;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.QueryRepository;
import com.example.smartevent.repository.StallRepository;
import com.example.smartevent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryService {

	private final QueryRepository queryRepository;
	private final StallRepository stallRepository;
	private final UserRepository userRepository;

	public QueryService(QueryRepository queryRepository, StallRepository stallRepository,
			UserRepository userRepository) {
		super();
		this.queryRepository = queryRepository;
		this.stallRepository = stallRepository;
		this.userRepository = userRepository;
	}

	public Query saveQuery(Long stallId, Long visitorId, Query query) {
		Stall stall = stallRepository.findById(stallId).orElseThrow(() -> new RuntimeException("Stall not found"));
		User visitor = userRepository.findById(visitorId).orElseThrow(() -> new RuntimeException("Visitor not found"));

		query.setStall(stall);
		query.setVisitor(visitor);

		return queryRepository.save(query);
	}

	public List<Query> getQueriesByStall(Long stallId) {
		Stall stall = stallRepository.findById(stallId).orElseThrow(() -> new RuntimeException("Stall not found"));
		return queryRepository.findByStallId(stall);
	}

	public Query respondToQuery(Long queryId, boolean response) {
		Query query = queryRepository.findById(queryId).orElseThrow(() -> new RuntimeException("Query not found"));
		query.setResponse(response);
		return queryRepository.save(query);
	}
}
