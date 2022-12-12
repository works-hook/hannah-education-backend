package com.hannah.education.common.image.controller

import com.hannah.education.common.image.dto.request.RemoveImgRequest
import com.hannah.education.common.image.service.UploadService
import com.hannah.education.common.image.util.UploadFolder
import com.hannah.education.util.ApiResponse
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/image-upload")
class UploadController(
    private val uploadService: UploadService,
) {

    @PostMapping("/{uploadFolder}")
    fun recordImageUpload(@RequestPart file: MultipartFile, @PathVariable uploadFolder: UploadFolder): ApiResponse<String> {
        val result = uploadService.imageUpload(file, uploadFolder)
        return Success(result, SuccessCode.SUCCESS_SAVE_IMAGE)
    }

    @DeleteMapping("/{uploadFolder}")
    fun imageRemove(@RequestBody request: RemoveImgRequest, @PathVariable uploadFolder: UploadFolder): ApiResponse<String> {
        uploadService.imageRemove(request.imageUrl, uploadFolder)
        return Success(SuccessCode.SUCCESS_DELETE_IMAGE)
    }
}