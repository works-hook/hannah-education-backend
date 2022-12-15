package com.hannah.education.common.user.controller

import com.hannah.education.common.user.service.UserService
import com.hannah.education.common.user.dto.request.UserCreateRequest
import com.hannah.education.common.user.dto.request.UserDuplicateRequest
import com.hannah.education.common.user.dto.request.UserLoginRequest
import com.hannah.education.common.user.dto.request.UserUpdatePasswordRequest
import com.hannah.education.common.user.dto.response.UserCreateResponse
import com.hannah.education.common.user.dto.response.UserLoginSuccessResponse
import com.hannah.education.config.interceptor.NoToken
import com.hannah.education.config.resolver.UserId
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @NoToken
    @PostMapping("")
    fun createUser(@RequestBody request: UserCreateRequest): Success<UserCreateResponse> {
        val result = userService.createUser(request)
        return Success(result, SuccessCode.USER_REGISTER)
    }

    @NoToken
    @PostMapping("/account")
    fun accountDuplicateCheck(@RequestBody request: UserDuplicateRequest): Success<String> {
        userService.accountDuplicateCheck(request)
        return Success(SuccessCode.NOT_DUPLICATE_ACCOUNT)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): Success<String> {
        userService.deleteUser(id)
        return Success(SuccessCode.SECESSION)
    }

    @NoToken
    @PostMapping("/login")
    fun loginUser(@RequestBody request: UserLoginRequest): Success<UserLoginSuccessResponse> {
        val result = userService.loginUser(request)
        return Success(result, SuccessCode.LOGIN)
    }

    @PostMapping("/password")
    fun updatePassword(@UserId id: Long, @RequestBody request: UserUpdatePasswordRequest): Success<String> {
        userService.updatePassword(id, request)
        return Success(SuccessCode.UPDATE_PASSWORD)
    }

}