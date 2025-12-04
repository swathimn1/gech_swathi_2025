package com.example.smartevent.repository;

import com.example.smartevent.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    
//    List<Notification> findByUserIdOrderByTimestampDesc(Long userId);
    
    List<Notification> findByUserIdAndReadFalse(Long userId);
    
    Long countByUserIdAndReadFalse(Long userId);

	long countByUserIdAndRead(Long id, boolean b);

    List<Notification> findByUserIdOrderByTimestampDesc(Long userId);

	List<Notification> findByUserIdAndRead(Long id, boolean b);

//	long countByUserIdAndRead(Long id, boolean b);
}
