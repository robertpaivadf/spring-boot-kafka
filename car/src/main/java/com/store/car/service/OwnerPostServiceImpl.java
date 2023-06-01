package com.store.car.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.store.car.dto.OwnerPostDTO;
import com.store.car.entity.OwnerPostEntity;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {

        OwnerPostEntity ownerPost = new OwnerPostEntity();
        BeanUtils.copyProperties(ownerPostDTO, ownerPost);
        ownerPostRepository.save(ownerPost);

    }
}
