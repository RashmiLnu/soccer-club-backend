package com.tazmaniandevils.soccer_club_backend.service;

import com.tazmaniandevils.soccer_club_backend.model.Service;
import com.tazmaniandevils.soccer_club_backend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {
    
    private final ServiceRepository serviceRepository;
    
    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }
    
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }
    
    public Optional<Service> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }
    
    public Service createService(Service service) {
        return serviceRepository.save(service);
    }
    
    public Optional<Service> updateService(Long id, Service serviceDetails) {
        return serviceRepository.findById(id)
                .map(existingService -> {
                    existingService.setTitle(serviceDetails.getTitle());
                    existingService.setDescription(serviceDetails.getDescription());
                    existingService.setIconName(serviceDetails.getIconName());
                    return serviceRepository.save(existingService);
                });
    }
    
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}