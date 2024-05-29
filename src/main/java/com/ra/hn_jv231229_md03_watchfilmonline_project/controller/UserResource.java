package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

<<<<<<< HEAD
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.UserDTO;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
=======
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.UserDTO;
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserFilterRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.response.BaseResponse;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.implementation.UserService;
import com.ra.hn_jv231229_md03_watchfilmonline_project.util.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userList")
<<<<<<< HEAD
public class UserResource {

    private final UserService service;
    public UserResource(UserService service) {
        this.service = service;
    }
    @PostMapping("")
    public ResponseEntity<BaseResponse<Page<UserDTO>>> getAll(@RequestBody UserFilterRequest filterRequest,
                                                              @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                              @RequestParam(name = "size", required = false, defaultValue = "3") int size) {
=======
public class UserResource
{

    private final UserService service;

    public UserResource(UserService service)
    {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<BaseResponse<Page<UserDTO>>> getAll(@RequestBody UserFilterRequest filterRequest,
                                                              @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                              @RequestParam(name = "size", required = false, defaultValue = "3") int size)
    {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
        System.out.println(filterRequest);
        System.out.println(page);
        System.out.println(size);

<<<<<<< HEAD
        return ResponseEntity.ok(service.getAllByFilter(filterRequest,page,size));
=======
        return ResponseEntity.ok(service.getAllByFilter(filterRequest, page, size));
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
    }
}
