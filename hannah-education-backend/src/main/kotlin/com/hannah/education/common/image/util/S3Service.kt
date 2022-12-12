package com.hannah.education.common.image.util

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.DeleteObjectRequest
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class S3Service(
    private val amazonS3Client: AmazonS3Client,
) {

    @Value("\${S3_GET_BUCKET}")
    private val bucket = "";

    fun uploadFile(inputStream: InputStream, objectMetadata: ObjectMetadata, fileName: String): String {
        amazonS3Client.putObject(
            PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                .withCannedAcl(CannedAccessControlList.PublicRead)
        )
        return amazonS3Client.getResourceUrl(bucket, fileName)
    }

    fun removeFile(fileUrl: String, uploadFolder: UploadFolder) {
        amazonS3Client.deleteObject(DeleteObjectRequest(bucket, getFileKey(fileUrl, uploadFolder)))
    }

    private fun getFileKey(fileUrl: String, uploadFolder: UploadFolder): String {
        val idx = fileUrl.indexOf("/$uploadFolder")
        return fileUrl.substring(idx + 1)
    }

}
