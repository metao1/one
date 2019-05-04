package com.metao.persoinfo.service.impl;

import com.metao.persoinfo.dto.TagDTO;
import com.metao.persoinfo.dto.ObjectFactory;
import com.metao.persoinfo.entity.Tag;
import com.metao.persoinfo.exception.NotFoundException;
import com.metao.persoinfo.repository.TagRepository;
import com.metao.persoinfo.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TagService implements GeneralService<TagDTO> {


  @Autowired
  private TagRepository tagRepository;

  @Autowired
  private ObjectFactory objectFactory;

  @Override
  public TagDTO saveOrUpdateModel(TagDTO object) {
    Tag tag = objectFactory.buildTag(object);
    Tag savedTag = tagRepository.save(tag);
    return objectFactory.buildTag(savedTag);
  }

  @Override
  public TagDTO getModel(String id) {
    return tagRepository.findById(id)
      .map(tag -> objectFactory.buildTag(tag))
      .orElseThrow(() -> new NotFoundException(
        String.format("the expected %s tag", id)));
  }

  @Override
  public void removeModel(String id) {
    tagRepository.deleteById(id);
  }

  @Override
  public List<TagDTO> getModels() {
    List<Tag> tagList = tagRepository.findAll();
    List<TagDTO> tagDTOList = new ArrayList<>();
    tagList
      .stream()
      .filter(Objects::nonNull)
      .filter(s -> s.getId() != null)
      .forEach(tag -> {
        TagDTO tagDTO = objectFactory.buildTag(tag);
        tagDTOList.add(tagDTO);
      });
    return tagDTOList;
  }

  @Override
  public boolean isModelExist(TagDTO object) {
    return tagRepository.findById(object.getId()).isPresent();
  }

}
