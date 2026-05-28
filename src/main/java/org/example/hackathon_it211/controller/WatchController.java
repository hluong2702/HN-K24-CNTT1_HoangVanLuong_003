package org.example.hackathon_it211.controller;

import jakarta.validation.Valid;
import org.example.hackathon_it211.dto.request.WatchPatchRequestDTO;
import org.example.hackathon_it211.dto.request.WatchRequestDTO;
import org.example.hackathon_it211.dto.response.WatchResponseDTO;
import org.example.hackathon_it211.service.IWatchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/watches")
public class WatchController {
    private final IWatchService watchService;

    public WatchController(IWatchService watchService) {
        this.watchService = watchService;
    }

    @GetMapping
    public Page<WatchResponseDTO> getWatches(Pageable pageable) {
        return watchService.getWatches(pageable);
    }

    @GetMapping("/{id}")
    public WatchResponseDTO getWatchById(@PathVariable Long id) {
        return watchService.getWatchById(id);
    }

    @PostMapping
    public ResponseEntity<WatchResponseDTO> createWatch(@RequestBody @Valid WatchRequestDTO watchRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(watchService.createWatch(watchRequestDTO));
    }

    @PutMapping("/{id}")
    public WatchResponseDTO updateWatch(@PathVariable Long id, @RequestBody @Valid WatchRequestDTO watchRequestDTO) {
        return watchService.updateWatch(id, watchRequestDTO);
    }

    @PatchMapping("/{id}")
    public WatchResponseDTO partialUpdateWatch(@PathVariable Long id,
                                               @RequestBody @Valid WatchPatchRequestDTO watchPatchRequestDTO) {
        return watchService.partialUpdateWatch(id, watchPatchRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWatch(@PathVariable Long id) {
        watchService.deleteWatch(id);
    }

}
