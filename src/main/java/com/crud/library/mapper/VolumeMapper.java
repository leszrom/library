package com.crud.library.mapper;

import com.crud.library.domain.Volume;
import com.crud.library.domain.dto.VolumeDto;
import com.crud.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VolumeMapper {

    private final BookService bookService;

    @Autowired
    public VolumeMapper(BookService bookService) {
        this.bookService = bookService;
    }

    public Volume mapToVolume(VolumeDto volumeDto) {
        return new Volume(
                volumeDto.getId(),
                bookService.getBookById(volumeDto.getBookId()).get(),
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
