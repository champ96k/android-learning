package com.champ96k.newsstory.model
import kotlinx.serialization.Serializable


@Serializable
data class Source(
    val id: String,
    val name: String
)