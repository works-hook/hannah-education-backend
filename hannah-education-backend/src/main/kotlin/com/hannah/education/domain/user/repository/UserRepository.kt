package com.hannah.education.domain.user.repository

import com.hannah.education.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>, UserCustomRepository
