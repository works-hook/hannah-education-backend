package com.hannah.education.common.image.service

import com.hannah.education.common.image.util.S3Service
import com.hannah.education.common.image.util.UploadFolder
import com.hannah.education.common.image.util.UploadUtils.createFileNameAndDirectory
import com.hannah.education.common.image.util.UploadUtils.getObjectData
import com.hannah.education.common.image.util.UploadUtils.validateFileType
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException


@Service
class UploadService(
    private val s3Service: S3Service,
) {

    fun imageUpload(file: MultipartFile, uploadFolder: UploadFolder): String {
        validateFileType(file.originalFilename)
        val fileName = createFileNameAndDirectory(file.originalFilename, uploadFolder)
        val objectMetadata = getObjectData(file)
        try {
            file.inputStream.use { inputStream ->
                return s3Service.uploadFile(
                    inputStream,
                    objectMetadata,
                    fileName
                )
            }
        } catch (e: IOException) { throw BusinessException(ErrorCode.IMAGE_UPLOAD_ERROR) }
    }

    fun imageRemove(fileUrl: String, uploadFolder: UploadFolder) {
        try {
            s3Service.removeFile(fileUrl, uploadFolder)
        } catch (e: Exception) {
            throw BusinessException(ErrorCode.IMAGE_REMOVE_ERROR)
        }
    }
}