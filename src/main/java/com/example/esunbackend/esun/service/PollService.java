package com.example.esunbackend.esun.service;

import com.example.esunbackend.esun.domain.ResourceNotFoundException;
import com.example.esunbackend.esun.domain.pollitem.aggregate.PollItem;
import com.example.esunbackend.esun.domain.voteitem.aggregate.Vote;
import com.example.esunbackend.esun.infra.PollRepository;
import com.example.esunbackend.esun.infra.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    // 自動注入 PollRepository,用於操作 PollItem 實體
    @Autowired
    private PollRepository pollRepository;

    // 自動注入 VoteRepository,用於操作 Vote 實體
    @Autowired
    private VoteRepository voteRepository;

    // 獲取所有投票項目
    public List<PollItem> getAllPolls() {
        // 調用 repository 的 findAll 方法來獲取所有 PollItem
        return pollRepository.findAll();
    }

    // 創建新的投票項目
    public PollItem createPoll(PollItem pollItem) {
        // 調用 repository 的 save 方法來保存新的 PollItem
        return pollRepository.save(pollItem);
    }

    // 更新現有的投票項目
    public PollItem updatePoll(Long id, PollItem pollItem) {
        // 通過 ID 查找現有的 PollItem,如果不存在則拋出異常
        PollItem existingPoll = pollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Poll not found"));
        // 更新標題和描述
        existingPoll.setTitle(pollItem.getTitle());
        existingPoll.setDescription(pollItem.getDescription());
        // 保存更新後的 PollItem
        return pollRepository.save(existingPoll);
    }

    // 刪除投票項目
    public void deletePoll(Long id) {
        // 通過 ID 刪除 PollItem
        pollRepository.deleteById(id);
    }

    // 進行投票
    // @Transactional 註解確保這個方法在一個事務中執行
    @Transactional
    public void vote(Long pollId, Long userId) {
        // 通過 ID 查找 PollItem,如果不存在則拋出異常
        PollItem poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new ResourceNotFoundException("Poll not found"));
        // 創建新的 Vote 對象
        Vote vote = new Vote();
        // 設置 Vote 對象的 PollItem
        vote.setPollItem(poll);
        // 設置 Vote 對象的 userId
        vote.setUserId(userId);
        // 保存 Vote 對象
        voteRepository.save(vote);
    }

}
