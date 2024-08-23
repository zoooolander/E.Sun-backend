package com.example.esunbackend.esun.infra;


import com.example.esunbackend.esun.domain.voteitem.aggregate.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
