package com.example.esunbackend.esun.domain.voteitem.aggregate;

import com.example.esunbackend.esun.BaseAggregate;
import com.example.esunbackend.esun.domain.pollitem.aggregate.PollItem;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "vote")
public class Vote extends BaseAggregate<Vote>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poll_item_id", nullable = false)
    private PollItem pollItem;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Vote(PollItem pollItem, Long userId) {
        this.pollItem = pollItem;
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PollItem getPollItem() {
        return pollItem;
    }

    public void setPollItem(PollItem pollItem) {
        this.pollItem = pollItem;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
