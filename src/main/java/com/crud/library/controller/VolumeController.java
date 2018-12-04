package com.crud.library.controller;

import com.crud.library.domain.Volume;
import com.crud.library.domain.dto.VolumeDto;
import com.crud.library.mapper.VolumeMapper;
import com.crud.library.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/volumes")
public class VolumeController {
    private VolumeService volumeService;
    private VolumeMapper volumeMapper;

    @Autowired
    public VolumeController(VolumeService volumeService, VolumeMapper volumeMapper) {
        this.volumeService = volumeService;
        this.volumeMapper = volumeMapper;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Long createVolume(@RequestBody VolumeDto volumeDto) {
        return volumeService.saveVolume(volumeMapper.mapToVolume(volumeDto)).getId();
    }
}
