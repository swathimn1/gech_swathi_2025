package com.example.smartevent.repository;

import com.example.smartevent.dto.AdminQueryResponse;
import com.example.smartevent.models.Query;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {

    List<Query> findByUserId(Long userId);

    List<Query> findByStall_Id(Long stallId);

    Long countByStall_IdAndStatus(Long id, String status);

    Long countByStall_IdInAndStatus(List<Long> stallIds, String status);

    // ✅ Use ONLY THIS for admin
    @org.springframework.data.jpa.repository.Query(
    	      value = """
    	        SELECT 
    	            q.id,
    	            u.full_name,
    	            s.name,
    	            q.description,
    	            CASE 
    	                WHEN q.description LIKE '%ANSWER:%' 
    	                THEN SUBSTRING(q.description, LOCATE('ANSWER:', q.description) + 7)
    	                ELSE NULL 
    	            END AS answer
    	        FROM query_table q
    	        JOIN users u ON u.id = q.user_id
    	        JOIN stall s ON s.id = q.stall_id
    	        ORDER BY q.created_at DESC
    	      """,
    	      nativeQuery = true
    	    )
    	    List<Object[]> findAllAdminQueries();

//	List<AdminQueryResponse> findAllForAdmin();
}
