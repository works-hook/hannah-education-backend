package com.hannah.education.common.image.util

import com.amazonaws.services.s3.model.ObjectMetadata
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import org.apache.commons.io.FilenameUtils
import org.springframework.web.multipart.MultipartFile
import java.text.SimpleDateFormat
import java.util.*

object UploadUtils {

    private val createFolder = { uploadFolder: UploadFolder -> "$uploadFolder/" }

    fun validateFileType(originalFilename: String?) {
        val typeList: List<String> = listOf("jpg", "jpg", "jpeg", "png")
        val type: String = FilenameUtils.getExtension(originalFilename)
        if (!typeList.contains(type)) throw BusinessException(ErrorCode.NOT_IMAGE_FORMAT)
    }

    fun createFileNameAndDirectory(originalFilename: String?, uploadFolder: UploadFolder): String {
        val now = SimpleDateFormat("yyyyMMddHmsS").format(Date())
        val folder = createFolder(uploadFolder)
        return folder + now + originalFilename
    }

    fun getObjectData(file: MultipartFile): ObjectMetadata {
        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = file.size
        objectMetadata.contentType = file.contentType
        return objectMetadata
    }

}