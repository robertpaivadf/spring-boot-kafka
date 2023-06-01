package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class CarPostServiceImpl implements CarPostService{

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = mapCarDTOToEntity(carPostDTO);
        carPostRepository.save(carPostEntity);
    }



    @Override
    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item-> listCarsSales.add(mapCarEntityToDTO(item)));
        return listCarsSales;
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, long postId) {
        carPostRepository.findById(postId).ifPresentOrElse(item->{
            item.setDescription(carPostDTO.getDescription());
            item.setContact(carPostDTO.getContact());
            item.setPrice(carPostDTO.getPrice());
            item.setBrand(carPostDTO.getBrand());
            item.setEngineVersion(carPostDTO.getEngineVersion());
            item.setModel(carPostDTO.getModel());
            carPostRepository.save(item);
        }, ()-> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }

    private CarPostDTO mapCarEntityToDTO(CarPostEntity item) {
        CarPostDTO carPostDTO = new CarPostDTO();
        BeanUtils.copyProperties(item, carPostDTO);
        return carPostDTO;
    }
    private CarPostEntity mapCarDTOToEntity(CarPostDTO item) {
        CarPostEntity carPostEntity = new CarPostEntity();
        BeanUtils.copyProperties(item, carPostEntity);
        return carPostEntity;
    }
}
