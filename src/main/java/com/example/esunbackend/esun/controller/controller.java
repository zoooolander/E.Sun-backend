package com.example.esunbackend.esun.controller;

import com.example.esunbackend.esun.domain.pollitem.aggregate.PollItem;
import com.example.esunbackend.esun.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/polls")
public class controller {

    @Autowired
    private PollService pollService;

    @GetMapping
    public List<PollItem> getAllPolls() {
        return pollService.getAllPolls();
    }

    @PostMapping
    public PollItem createPoll(@RequestBody PollItem pollItem) {
        return pollService.createPoll(pollItem);
    }

    @PostMapping("/{id}")
    public PollItem updatePoll(@PathVariable Long id, @RequestBody PollItem pollItem) {
        return pollService.updatePoll(id, pollItem);
    }

    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable Long id) {
        pollService.deletePoll(id);
    }

    @PostMapping("/{id}/vote")
    public void vote(@PathVariable Long id, @RequestParam Long userId) {
        pollService.vote(id, userId);
    }
}
