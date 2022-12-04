package com.hannah.education.domain.banner.repository

import com.hannah.education.domain.banner.Banner
import org.springframework.data.jpa.repository.JpaRepository

interface BannerRepository: JpaRepository<Banner, Long>