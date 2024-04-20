package com.feedback.feedback.Controller;

import com.feedback.feedback.Model.Feedback;
import com.feedback.feedback.Repository.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
@CrossOrigin(origins="*")
public class FeedBackController{

    @Autowired
    private FeedBackRepository repo;

    @GetMapping("/health")
    public String checkHealth() {
        return "Succesully working...!!!";
    }

    @GetMapping("/get_all_feedbacks")
    public ResponseEntity<List<Feedback>> getFeedbacks() {
        List<Feedback> feedbacks = repo.findAll();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/get_feedback/{id}")
    public ResponseEntity<Optional<Feedback>> getFeedback(@PathVariable String id) {
        if (repo.existsById(id)) {
            return ResponseEntity.ok(repo.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create_feedback")
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        Feedback f = repo.save(feedback);
        return ResponseEntity.ok(f);
    }

    @PutMapping("/update_feedback/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable String id, @RequestBody Feedback feedback) {
        if (repo.existsById(id)) {
            feedback.setId(Integer.parseInt(id));
            Feedback f = repo.save(feedback);
            return ResponseEntity.ok(f);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete_feedback/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
