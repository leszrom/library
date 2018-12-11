package com.crud.library.service;

import com.crud.library.domain.Volume;
import com.crud.library.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VolumeService {
    private final VolumeRepository volumeRepository;

    @Autowired
    public VolumeService(VolumeRepository volumeRepository) {
        this.volumeRepository = volumeRepository;
    }

    public Volume saveVolume(final Volume volume) {
        return volumeRepository.save(volume);
    }

    public Optional<Volume> getVolumeById(final Long id) {
        return volumeRepository.findById(id);
    }
}
