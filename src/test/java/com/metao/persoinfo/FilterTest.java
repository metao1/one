package com.metao.persoinfo;

import com.metao.persoinfo.dto.FilterDTO;
import com.metao.persoinfo.dto.ResponseMap;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringRunner.class)
@SpringBootTest
public class FilterTest extends BaseTest {

  private static FilterDTO filterDTO;

  @Test
  public void getAllFilters() throws Exception {
    this.mvc.perform(get(BASE_URL)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().is2xxSuccessful())
      .andDo(print())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("filters"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(result -> {
        ResponseMap<List<FilterDTO>> json = objectFactory.fromJson(new TypeReference<ResponseMap<List<FilterDTO>>>() {
        }, result.getResponse().getContentAsString());
        assertThat(json).isNotNull();
        assertThat(json.getResponse().size()).isGreaterThanOrEqualTo(0);
      });
  }

  protected void goSetup() throws Exception {
    BASE_URL += "filter/";
    if (filterDTO == null) {
      this.mvc.perform(get(BASE_URL)
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().is2xxSuccessful())
        .andDo(print())
        .andExpect(jsonPath("$.message").exists())
        .andExpect(jsonPath("$.message").isString())
        .andExpect(jsonPath("$.message").value("filters"))
        .andExpect(jsonPath("$.response").exists())
        .andDo(result -> {
          ResponseMap<List<FilterDTO>> json = objectFactory
            .fromJson(new TypeReference<ResponseMap<List<FilterDTO>>>() {
            }, result.getResponse().getContentAsString());
          assertThat(json).isNotNull();
          assertThat(json.getResponse().size()).isGreaterThanOrEqualTo(0);
          List<FilterDTO> response = json.getResponse();
          filterDTO = response.get(0);
        });
    }
  }

  @Test
  public void getOneFilter() throws Exception {
    this.mvc.perform(get(BASE_URL + filterDTO.getId())
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().isOk())
      .andDo(print())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("filter"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(filter -> {
        ResponseMap<FilterDTO> dtoResponseMap = objectFactory.fromJson(new TypeReference<ResponseMap<FilterDTO>>() {
        }, filter.getResponse().getContentAsString());
        assertThat(dtoResponseMap.getResponse()).isEqualTo(filterDTO);
      });
  }

  @Test
  public void deleteFilterTest() throws Exception {
    this.mvc.perform(delete(BASE_URL + filterDTO.getId())
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andDo(print())
      .andExpect(status().is2xxSuccessful());
  }

  @Test
  public void deleteFilterFailedTest() throws Exception {
    this.mvc.perform(delete(BASE_URL + filterDTO.getId())
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andDo(print())
      .andExpect(status().isNotFound());
  }
}
