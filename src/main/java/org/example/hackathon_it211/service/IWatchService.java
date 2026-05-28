package org.example.hackathon_it211.service;

import org.example.hackathon_it211.dto.request.WatchRequestDTO;
import org.example.hackathon_it211.dto.request.WatchPatchRequestDTO;
import org.example.hackathon_it211.dto.response.WatchResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IWatchService {
    Page<WatchResponseDTO> getWatches(Pageable pageable);

    WatchResponseDTO createWatch(WatchRequestDTO watchRequestDTO);

    WatchResponseDTO updateWatch(Long id, WatchRequestDTO watchRequestDTO);

    WatchResponseDTO partialUpdateWatch(Long id, WatchPatchRequestDTO watchPatchRequestDTO);

    void deleteWatch(Long id);

    WatchResponseDTO getWatchById(Long id);


}
