package integration;

import com.novi.easyboat.EasyboatApplication;
import com.novi.easyboat.controllers.dto.CustomerDto;
import com.novi.easyboat.controllers.dto.CustomerInputDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EasyboatApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class CustomerControllerITest {
    private static final String BASE_URL = "http://localhost:8082";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSaveCustomer() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var input = new CustomerInputDto();
        input.firstname = "Henk";

        var request = new HttpEntity<>(input, headers);

        var response = this.restTemplate.postForEntity(BASE_URL + "/customers", request, CustomerDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.hasBody()).isTrue();
        assertThat(response.getBody().firstname).isEqualTo("Henk");
    }

    @Test
    public void testGetCustomers() {
        var input1 = new CustomerInputDto();
        input1.firstname = "Henk";

        var input2 = new CustomerInputDto();
        input2.firstname = "Henk";

        this.restTemplate.postForEntity(BASE_URL + "/customers", input1, CustomerDto.class);
        this.restTemplate.postForEntity(BASE_URL + "/customers", input2, CustomerDto.class);

        var response = this.restTemplate.getForEntity(BASE_URL + "/customers", CustomerDto[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.hasBody()).isTrue();
        assertThat(response.getBody().length).isEqualTo(2);
    }

}
