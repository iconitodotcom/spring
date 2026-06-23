package io.iconito.backendmaven.controller;

import io.iconito.backendmaven.dto.UserDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dummy/users")
public class UserController {

    // Test URL : http://127.0.0.1:8080/api/dummy/users/123
    // Test URL : http://127.0.0.1:8080/api/dummy/users/123/posts/456
    @GetMapping({"/{userId}/posts/{postId}","/{userId}"})
    public ResponseEntity<String> searchUserPostWithMultiPathVariables(@PathVariable Long userId, @PathVariable(required = false) Long postId)
    {
        String response;
        if (postId == null) response = "Fetched user with id: " + userId;
        else response = "Fetchec user with id: " + userId + " and post id: " + postId;

        return ResponseEntity.ok().body(response);
    }
    // Test URL : http://127.0.0.1:8080/api/dummy/users/123/orders/456
    @GetMapping({"/{userId}/orders/{orderId}"})
    public String searchUserOrderWithMultiPathVariables(@PathVariable(name = "userId") Long customerId, @PathVariable Long orderId)
    {
        return "Fetched user with id: " + customerId + " and order id : " + orderId;
    }
    @GetMapping({"/{userId}/address/{addressId}"})
    public String searchUserAddressWithMultiPathVariables(@PathVariable Map<String, String> pathVariablesMap)
    {
        return "Fetched user with id: " + pathVariablesMap.get("userId") + " and address id: " + pathVariablesMap.get("addressId");
    }
    @GetMapping("/search")
    public String searchUserWithQueryParams(@RequestParam(required = false, defaultValue = "Guess") String name,@RequestParam(name = "gender") String sex)
    {
        return "Fetched user with query params : " + name + " and gender: " + sex;
    }
    @GetMapping("/search/map")
    public String searchUserWithMapQueryParams(@RequestParam Map<String, String> requestParams)
    {
        return "Fetched user with query params : " + requestParams.get("name") + " and gender: " + requestParams.get("gender");
    }
    @GetMapping("/headers")
    public String readRequestHeaders(@RequestHeader("User-Agent") String userAgent, @RequestHeader(name="User-Location", required = false, defaultValue = "Hyderabad") String userLocation)
    {
        return "Receeived : " + userAgent + " " + userLocation;
    }
    @GetMapping("/headers/map")
    public String readRequestHeadersWithMap(@RequestHeader Map<String, String> requestHeaders)
    {
        return "Receive: " + requestHeaders.get("User-Agent") + " " + requestHeaders.get("User-Location");
    }
    @GetMapping("/headers/http-headers")
    public String readRequestHeadersWithHttpHeaders(@RequestHeader HttpHeaders requestHeaders)
    {
        return "Received: " + requestHeaders.get("User-Agent") + " " + requestHeaders.get("User-Location");
    }
    @PostMapping
    public String createUser(@RequestBody UserDto userDto)
    {
        return "Created User with the data: " + userDto.toString();
    }
    @PostMapping("request-entry")
    public ResponseEntity<String> createUserWithRequestEntity(RequestEntity<UserDto> requestEntity)
    {
        HttpHeaders httpHeaders = requestEntity.getHeaders();
        UserDto userDto = requestEntity.getBody();
        String queryParam = requestEntity.getUrl().getQuery();
        String pathVariables = requestEntity.getUrl().getPath();
        // return "Created User with the data: " + userDto.toString();
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Custom-Header", "ExampleValue")
                .body("Created User with the data: " + userDto.toString());
    }
}
