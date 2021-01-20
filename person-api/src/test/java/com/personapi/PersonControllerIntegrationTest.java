package com.personapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.apache.catalina.startup.HomesUserDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.WebApplicationContext;

import com.personapi.entity.Hobby;
import com.personapi.entity.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PersonApiApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
        return "http://localhost:" + port;
    }
	
	
    @Test
    public void contextLoads() {

    }
    
    @Autowired
    private WebApplicationContext wac;
 
    @Autowired
    private FilterChainProxy springSecurityFilterChain;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
          .addFilter(springSecurityFilterChain).build();
    }
    
    private String getAccessToken(String username, String password) throws  Exception{
    	
    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    	
    	
    	params.add("grant_type", "password");
       // params.add("client_id", "fooClientIdPassword");
        params.add("username", username);
        params.add("password", password);
        HttpHeaders headers= new HttpHeaders();
        headers.add("Authorization", "Basic bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0");
        ResultActions result 
          = mockMvc.perform(post("/oauth/token")
            .params(params).headers(headers)
            .accept("application/json"));            
        String resultString = result.andReturn().getResponse().getContentAsString();
        
        System.out.println("OAUTH TOKEN " +resultString);
     
        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }
    
    @Test
    public void testGetAllPersons() throws Exception {
    	
    	HttpHeaders headers= new HttpHeaders();
    	  HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    	  String val=getAccessToken("admin","admin");
          ResponseEntity<Map> response = restTemplate.exchange(getRootUrl() + "/api/person?access_token="+val,
          HttpMethod.GET, entity, Map.class); 
          System.out.println(" TEST - GET ALL PERSONS " +response.getBody());
          assertNotNull(response.getBody());
    }
    
    @Test
    public void testGetPersonById() throws Exception {
    	 String val=getAccessToken("admin","admin");
        Person person = restTemplate.getForObject(getRootUrl() + "/api/person/1?access_token="+val, Person.class);
        System.out.println(person.getFirstName());
        assertNotNull(person);
    }
    
    @Test
    public void testCreatePerson() throws Exception {
        Person person = new Person();
        person.setFirstName("Bharathidasan");
        person.setLastName("Manickam");
        person.setAge(33);
        person.setFavouriteColor("Red");
        Hobby hobby=new Hobby();
        hobby.setName("Cricket");
        person.addHobby(hobby);
        String val=getAccessToken("admin","admin");
        ResponseEntity<Person> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/person?access_token="+val, person, Person.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdatePerson() throws Exception {
        int id = 3;
        String val=getAccessToken("admin","admin");
        Person person = restTemplate.getForObject(getRootUrl() + "/api/person"+val+"?access_token="+val, Person.class);
        person.setId(id);
        person.setFirstName("Bharathi");
        person.setLastName("Manickam");
        Hobby hobby=new Hobby();
        hobby.setName("Cricket");
        person.addHobby(hobby);        
        restTemplate.put(getRootUrl() + "/api/person?access_token="+val, person);
        Person updatedPerson = restTemplate.getForObject(getRootUrl() + "/api/person?access_token="+val, Person.class);
        assertNotNull(updatedPerson);
    }

    @Test
    public void testDeletePerson() throws Exception {
         int id = 2;
         String val=getAccessToken("admin","admin");
         Person person = restTemplate.getForObject(getRootUrl() + "/api/person" + id+"?access_token="+val, Person.class);
         assertNotNull(person);    
         restTemplate.delete(getRootUrl() + "/api/person/" + id);
         try {
              person = restTemplate.getForObject(getRootUrl() + "/api/person/" + id+"?access_token="+val, Person.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }

}
