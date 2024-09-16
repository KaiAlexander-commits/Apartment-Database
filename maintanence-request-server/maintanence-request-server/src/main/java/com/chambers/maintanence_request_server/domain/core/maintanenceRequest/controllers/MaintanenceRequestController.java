package com.chambers.maintanence_request_server.domain.core.maintanenceRequest.controllers;

import com.chambers.maintanence_request_server.domain.core.maintanenceRequest.models.MaintanenceRequest;
import com.chambers.maintanence_request_server.domain.core.maintanenceRequest.services.MaintanenceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/maintanence-requests")
public class MaintanenceRequestController {

    private final MaintanenceRequestService maintanenceRequestService;

    @Autowired
    public MaintanenceRequestController(MaintanenceRequestService maintanenceRequestService) {
        this.maintanenceRequestService = maintanenceRequestService;
    }

    @GetMapping
    public ResponseEntity<List<MaintanenceRequest>> getAll() {
        List<MaintanenceRequest> requests = maintanenceRequestService.getAll();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaintanenceRequest> create(@RequestBody MaintanenceRequest request) {
        request = maintanenceRequestService.create(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MaintanenceRequest> getById(@PathVariable("id") Long id) {
        MaintanenceRequest request = maintanenceRequestService.getById(id);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<MaintanenceRequest> update(@PathVariable("id") Long id, @RequestBody MaintanenceRequest requestDetail) {
        requestDetail = maintanenceRequestService.update(id, requestDetail);
        return new ResponseEntity<>(requestDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        maintanenceRequestService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
