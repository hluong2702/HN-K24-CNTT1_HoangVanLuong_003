package org.example.hackathon_it211.service;

import org.example.hackathon_it211.dto.request.WatchPatchRequestDTO;
import org.example.hackathon_it211.dto.request.WatchRequestDTO;
import org.example.hackathon_it211.dto.response.WatchResponseDTO;
import org.example.hackathon_it211.entity.Watch;
import org.example.hackathon_it211.exception.ResourceNotFoundException;
import org.example.hackathon_it211.repository.WatchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class WatchServiceImpl implements IWatchService {

    private final WatchRepository watchRepository;

    public WatchServiceImpl(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    @Override
    public Page<WatchResponseDTO> getWatches(Pageable pageable) {
        return watchRepository.findAllByDeletedFalse(pageable).map(this::toResponse);
    }

    @Override
    public WatchResponseDTO createWatch(WatchRequestDTO watchRequestDTO) {
        Watch watch = Watch.builder()
                .modelName(watchRequestDTO.getModelName())
                .brand(watchRequestDTO.getBrand())
                .price(watchRequestDTO.getPrice())
                .movementType(watchRequestDTO.getMovementType())
                .status(watchRequestDTO.getStatus())
                .deleted(false)
                .build();
        return toResponse(watchRepository.save(watch));
    }

    @Override
    public WatchResponseDTO updateWatch(Long id, WatchRequestDTO watchRequestDTO) {
        Watch watch = watchRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Watch not found with id: " + id));
        watch.setModelName(watchRequestDTO.getModelName());
        watch.setBrand(watchRequestDTO.getBrand());
        watch.setPrice(watchRequestDTO.getPrice());
        watch.setMovementType(watchRequestDTO.getMovementType());
        watch.setStatus(watchRequestDTO.getStatus());
        return toResponse(watchRepository.save(watch));
    }

    @Override
    public WatchResponseDTO partialUpdateWatch(Long id, WatchPatchRequestDTO watchPatchRequestDTO) {
        Watch watch = watchRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Watch not found with id: " + id));
        if (watchPatchRequestDTO.getModelName() != null) {
            watch.setModelName(watchPatchRequestDTO.getModelName());
        }
        if (watchPatchRequestDTO.getBrand() != null) {
            watch.setBrand(watchPatchRequestDTO.getBrand());
        }
        if (watchPatchRequestDTO.getPrice() != null) {
            watch.setPrice(watchPatchRequestDTO.getPrice());
        }
        if (watchPatchRequestDTO.getMovementType() != null) {
            watch.setMovementType(watchPatchRequestDTO.getMovementType());
        }
        if (watchPatchRequestDTO.getStatus() != null) {
            watch.setStatus(watchPatchRequestDTO.getStatus());
        }
        return toResponse(watchRepository.save(watch));
    }

    @Override
    public void deleteWatch(Long id) {
        Watch watch = watchRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Watch not found with id: " + id));
        watch.setDeleted(true);
        watchRepository.save(watch);
    }

    @Override
    public WatchResponseDTO getWatchById(Long id) {
        Watch watch = watchRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Watch not found with id: " + id));
        return toResponse(watch);

    }

    private WatchResponseDTO toResponse(Watch watch) {
        return WatchResponseDTO.builder()
                .id(watch.getId())
                .modelName(watch.getModelName())
                .brand(watch.getBrand())
                .price(watch.getPrice())
                .movementType(watch.getMovementType())
                .status(watch.getStatus())
                .build();
    }
}


