package com.feedback.feedback.Repository;

import com.feedback.feedback.Model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepository extends JpaRepository<Feedback, String> {

}
