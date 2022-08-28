# Spring Security Demo

Demonstrates how to configure Spring Security using the `SecurityFilterChain` bean which is the preferred method to configure security after the deprecation of `WebSecurityConfigurerAdapter`.

The demo exposes 3 endpoints as follows:

- `/` - permits all requests
- `/user` - requires a role of `USER`
- `/admin` - requires a role of `ADMIN`

## Curl Requests

### Access the `/` endpoint:

```shell
curl -X GET --location "http://localhost:8080" \
    -H "Accept: application/json"
```

### Access the `/user` endpoint:

```shell
curl -X GET --location "http://localhost:8080/user" \
    -H "Accept: application/json" \
    -H "Authorization: Basic dXNlcjpwYXNzd29yZA"
```

### Access the `/admin` endpoint:

```shell
curl -X GET --location "http://localhost:8080/admin" \
    -H "Accept: application/json" \
    -H "Authorization: Basic YWRtaW46cGFzc3dvcmQ"
```
