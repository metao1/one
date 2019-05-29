package com.metao.persoinfo.service.impl;

import com.metao.persoinfo.dto.FilterDTO;
import com.metao.persoinfo.dto.ObjectFactory;
import com.metao.persoinfo.entity.Filter;
import com.metao.persoinfo.exception.NotFoundException;
import com.metao.persoinfo.repository.FilterRepository;
import com.metao.persoinfo.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FilterService implements GeneralService<FilterDTO> {


  @Autowired
  private FilterRepository filterRepository;

  @Autowired
  private ObjectFactory objectFactory;

  @Override
  public FilterDTO saveOrUpdateModel(FilterDTO object) {
    Filter filter = objectFactory.buildFilter(object);
    Filter savedFilter = filterRepository.save(filter);
    return objectFactory.buildFilter(savedFilter);
  }

  @Override
  public FilterDTO getModel(String id) {
    return filterRepository.findById(id)
      .map(filter -> objectFactory.buildFilter(filter))
      .orElseThrow(() -> new NotFoundException(
        String.format("the expected %s filter", id)));
  }

  @Override
  public void removeModel(String id) {
    filterRepository.deleteById(id);
  }

  @Override
  public List<FilterDTO> getModels(String username) {
    List<Filter> filterList = filterRepository.findAll();
    List<FilterDTO> filterDTOList = new ArrayList<>();
    filterList
      .stream()
      .filter(Objects::nonNull)
      .filter(s -> s.getId() != null)
      .forEach(filter -> {
        FilterDTO filterDTO = objectFactory.buildFilter(filter);
        filterDTOList.add(filterDTO);
      });
    return filterDTOList;
  }

  @Override
  public boolean isModelExist(FilterDTO object) {
    return filterRepository.findById(object.getId()).isPresent();
  }

}
