package com.crud.library.mapper;

import com.crud.library.domain.Volume;
import com.crud.library.domain.dto.VolumeDto;
import org.springframework.stereotype.Component;

@Component
public class VolumeMapper {
    public Volume mapToVolume(VolumeDto volumeDto) {
        return new Volume(
                volumeDto.getId(),
                volumeDto.getBook(),
                volumeDto.isRented()
        );
    }

    public VolumeDto mapToVolumeDto(Volume volume) {
        return new VolumeDto(
                volume.getId(),
                volume.getBook(),
                volume.isRented()
        );
    }
}
