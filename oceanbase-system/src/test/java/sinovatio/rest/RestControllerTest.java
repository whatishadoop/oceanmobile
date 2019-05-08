package sinovatio.rest;

import com.sinovatio.AppRun;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName: RestControllerTest
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/7 17:04
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppRun.class)
@WithMockUser(username="admin",roles={"USER","ADMIN"})
public class RestControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    /**
     * 在所有方法启动前启动
     */
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).apply(SecurityMockMvcConfigurers.springSecurity()).build();
    }

    @Test
    public void whenQuerySuccess() throws Exception {
        String result = mockMvc.perform(get("/api/application")
                .param("busiName", "业务1222")
                .param("size","10")
                .param("page","0")
                //.param("sort","sort,desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


    @Test
    public void whenGenInfoSuccess() throws Exception {
        String result = mockMvc.perform(get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("tom"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    /**
     * 创建应用
     *
     * @throws Exception
     */
    @Test
    public void WhenCreateSuccess() throws Exception {
        Date date = new Date();
        System.out.println(date.getTime());
        String content = "{\"name\":\"tom\",\"code\":\"123\",\"description\":\"描述信息\",\"busiName\":\"业务1\",\"creator\":\"张三\",\"sort\":11}";
        String reuslt = mockMvc.perform(post("/api/application").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("6"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(reuslt);
    }

    /**
     * 修改应用
     *
     * @throws Exception
     */
    @Test
    public void whenUpdateSuccess() throws Exception {
        Date date = new Date();
        System.out.println(date.getTime());
        String content = "{\"id\":\"1\",\"name\":\"tom222\",\"code\":\"123\",\"description\":\"描述信息\",\"busiName\":\"业务1222\",\"creator\":\"张三111\",\"sort\":11}";
        String reuslt = mockMvc.perform(put("/api/application").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(reuslt);
    }

    /**
     * 删除应用
     *
     * @throws Exception
     */
    @Test
    @WithMockUser(username="admin",roles={"ADMIN"},password = "123456")
    public void whenDeleteSuccess() throws Exception {
        mockMvc.perform(delete("/api/application/8")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    /**
     * 文件上传测试
     *
     * @throws Exception
     */
    @Test
    public void whenUploadSuccess() throws Exception {
        String result = mockMvc.perform(fileUpload("/file")
                .file(new MockMultipartFile("file", "test.txt", "multipart/form-data", "hello upload".getBytes("UTF-8"))))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }
}
