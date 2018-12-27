package com.crud.library.mapper;

import com.crud.library.domain.Volume;
import com.crud.library.domain.dto.VolumeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VolumeMapper {

    public VolumeDto mapToVolumeDto(Volume volume) {
        return new VolumeDto(
                volume.getId(),
                volume.getBook().getId(),
                volume.isRented()
        );
    }

    public List<VolumeDto> mapToVolumeDtoList(List<Volume> volumeList) {
        return volumeList.stream()
                .map(this::mapToVolumeDto)
                .collect(Collectors.toList());
    }
}
