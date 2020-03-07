package com.metao.persoinfo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.metao.persoinfo.dto.TagDTO;
import com.metao.persoinfo.dto.ResponseMap;
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
public class TagTest extends BaseTest {

  private static TagDTO tagDTO;

  @Test
  public void getAllTags() throws Exception {
    this.mvc.perform(get(BASE_URL)
      .header("Authorization", "Bearer " + JWT)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().is2xxSuccessful())
      .andDo(print())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("tags"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(result -> {
        ResponseMap<List<TagDTO>> json = objectFactory.fromJson(new TypeReference<ResponseMap<List<TagDTO>>>() {
        }, result.getResponse().getContentAsString());
        assertThat(json).isNotNull();
        assertThat(json.getResponse().size()).isGreaterThanOrEqualTo(0);
      });
  }

  protected void goSetup() throws Exception {
    BASE_URL += "tag/";
    if (tagDTO == null) {
      this.mvc.perform(get(BASE_URL)
        .header("Authorization", "Bearer " + JWT)
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().is2xxSuccessful())
        .andDo(print())
        .andExpect(jsonPath("$.message").exists())
        .andExpect(jsonPath("$.message").isString())
        .andExpect(jsonPath("$.message").value("tags"))
        .andExpect(jsonPath("$.response").exists())
        .andDo(result -> {
          ResponseMap<List<TagDTO>> json = objectFactory
            .fromJson(new TypeReference<ResponseMap<List<TagDTO>>>() {
            }, result.getResponse().getContentAsString());
          assertThat(json).isNotNull();
          assertThat(json.getResponse().size()).isGreaterThanOrEqualTo(0);
          List<TagDTO> response = json.getResponse();
          tagDTO = response.get(0);
        });
    }
  }

  @Test
  public void getOneTag() throws Exception {
    this.mvc.perform(get(BASE_URL + tagDTO.getId())
      .header("Authorization", "Bearer " + JWT)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().isOk())
      .andDo(print())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("tag"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(tag -> {
        ResponseMap<TagDTO> dtoResponseMap = objectFactory.fromJson(new TypeReference<>() {
        }, tag.getResponse().getContentAsString());
        assertThat(dtoResponseMap.getResponse()).isEqualTo(tagDTO);
      });
  }
}
