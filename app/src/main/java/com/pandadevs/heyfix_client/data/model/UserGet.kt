package com.pandadevs.heyfix_client.data.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.GeoPoint
import java.io.Serializable

data class UserGet(
    var id: String,
    var name: String,
    var first_surname: String,
    var second_surname: String,
    var active: Boolean,
    var client: Boolean,
    var email: String,
    var phone_number: String,
    var picture: String,
    var ranked_avg: Double,
    var transport: String,
    var category_id: String,
    var last_online: Timestamp?,
    var current_position: GeoPoint?,
    var tokenNotification: String
)