package com.example.carparkingmanagementbe.news;

import com.example.carparkingmanagementbe.controller.NewsController;
import com.example.carparkingmanagementbe.dto.NewsDto;
import com.example.carparkingmanagementbe.model.NewsType;
import com.example.carparkingmanagementbe.service.Impl.NewsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NewsController_createNews_tiennnl {
    @Autowired
    private NewsController controller;

    @Autowired
    private NewsService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void createNews_code_13() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode(null);
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle("Con gà ăn cơm tấm");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("Tádknsadbsahdbasgdaygsdhjabsdhjbashdjavjhgdsad");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createNews_author_13() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor(null);
        newsDto.setTitle("Con gà ăn cơm tấm");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("Tádknsadbsahdbasgdaygsdhjabsdhjbashdjavjhgdsad");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createNews_title_13() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle(null);
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("Tádknsadbsahdbasgdaygsdhjabsdhjbashdjavjhgdsad");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_date_13() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle("Con gà ăn cơm tấm");
        newsDto.setDate(null);
        newsDto.setDescription("Tádknsadbsahdbasgdaygsdhjabsdhjbashdjavjhgdsad");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_description_13() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle("Con gà ăn cơm tấm");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription(null);
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_img_13() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle("Con gà ăn cơm tấm");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("jshdahjsdajhsjhdashdjagshjdgahjsgdhjsagdshjagsdywgjhagbsdhajds");
        newsDto.setImg(null);
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_idNewsType_13() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle("Con gà ăn cơm tấm");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("jshdahjsdajhsjhdashdjagshjdgahjsgdhjsagdshjagsdywgjhagbsdhajds");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(null);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_author_14() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("");
        newsDto.setTitle("Con gà ăn cơm tấm");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("jshdahjsdajhsjhdashdjagshjdgahjsgdhjsagdshjagsdywgjhagbsdhajds");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1l);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_title_14() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle("    ");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("jshdahjsdajhsjhdashdjagshjdgahjsgdhjsagdshjagsdywgjhagbsdhajds");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1l);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_description_14() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle("Hồ Nhật Hiếu bất ngờ khi dành được trái tim người đẹp Đà Nẵng");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("                                          ");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1l);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_author_15() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nugyeenx 1");
        newsDto.setTitle("Hồ Nhật Hiếu bất ngờ khi dành được trái tim người đẹp Đà Nẵng");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("con heo ăn cám heoo và con chim ăn con hổ, Sau đó con hổ ăn lại con chimm");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1l);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_author_16() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("n");
        newsDto.setTitle("Hồ Nhật Hiếu bất ngờ khi dành được trái tim người đẹp Đà Nẵng");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("con heo ăn cám heoo và con chim ăn con hổ, Sau đó con hổ ăn lại con chimm");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1l);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_title_16() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle("Hq");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("con heo ăn cám heoo và con chim ăn con hổ, Sau đó con hổ ăn lại con chimm");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1l);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_description_16() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle("CON CÁ ĂN CƠM");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("Con cá aloalo");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1l);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_author_17() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên ádhasdhagsduagwhgashdygahsdwaiuyhdiasduhsaduihsadiuahdiuhadawd");
        newsDto.setTitle("CON CÁ ĂN CƠM");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("Con cá aloalojdhwihaiudyhwiuahsidhxawiuhaiudshaiwu");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1l);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNews_allValid_18() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setCode("NE-001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle("CON CÁ ĂN CƠM");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("Con cá đá con trâu con trâu đá con bò con cò ăn con lợn con lợn chơi con heo");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
        newsDto.setIdNewsType(1l);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
