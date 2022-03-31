package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class Mapper {
  public <T> T map(Object source, Class<T> targetType) {
    ModelMapper mapper = createModelMapper();
    mapper.getConfiguration().setAmbiguityIgnored(true);
    return mapper.map(source, targetType);
  }

  public <T, S> List<T> map(List<S> sourceList, Class<T> targetType) {
    ModelMapper mapper = createModelMapper();
    mapper.getConfiguration().setAmbiguityIgnored(true);
    List<T> result = new ArrayList<T>();

    if (!CollectionUtils.isEmpty(sourceList)) {
      for (S item : sourceList) {
        result.add(mapper.map(item, targetType));
      }
    }
    return result;
  }

  public void map(Object source, Object target) {
    ModelMapper mapper = createModelMapper();
    mapper.getConfiguration().setAmbiguityIgnored(true);
    mapper.map(source, target);
  }

  private ModelMapper createModelMapper() {
    ModelMapper mapper = new ModelMapper();

    return mapper;
  }
}
