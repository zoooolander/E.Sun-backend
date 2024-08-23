package com.example.esunbackend.esun.infra;

import com.example.esunbackend.esun.domain.pollitem.aggregate.PollItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<PollItem, Long> {
}