package com.crud.library.mapper;

import com.crud.library.domain.Volume;
import com.crud.library.domain.dto.VolumeDto;
import com.crud.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VolumeMapper {

    private final BookRepository bookRepository;

    @Autowired
    public VolumeMapper(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Volume mapToVolume(VolumeDto volumeDto) {
        return new Volume(
                volumeDto.getId(),
                bookRepository.findById(volumeDto.getBookId()).get(),
                volumeDto.isRented()
        );
    }

    public VolumeDto mapToVolumeDto(Volume volume) {
        return new VolumeDto(
                volume.getId(),
                volume.getBook().getId(),
                volume.isRented()
        );
    }
}
