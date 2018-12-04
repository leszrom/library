package com.crud.library.service;

import com.crud.library.domain.Volume;
import com.crud.library.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Volume> getVolumesByBookId(final Long id) {
        return volumeRepository.findAllByBookId(id);
    }

    public List<Volume> getAvailableVolumesByBookId(final Long id) {
        return volumeRepository.findAllByBookIdAndRentedIsFalse(id);
    }
}
