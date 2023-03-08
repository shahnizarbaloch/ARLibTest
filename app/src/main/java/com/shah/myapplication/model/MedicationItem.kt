package com.shah.myapplication.model

import java.io.Serializable

data class MedicationItem (
    val dose: String,
    val id: Int,
    val name: String,
    val strength: String
): Serializable