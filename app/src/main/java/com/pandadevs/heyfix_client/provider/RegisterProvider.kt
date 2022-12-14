package com.pandadevs.heyfix_client.provider

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.pandadevs.heyfix_client.data.model.UserPost
import kotlinx.coroutines.CompletableDeferred


class RegisterProvider {

    companion object{
        suspend fun registerDataUser(user:UserPost, password:String):String?{
            val def = CompletableDeferred<String?>()
            FirebaseFirestore
                .getInstance()
                .collection("users")
                .document()
                .set(user)
                .addOnSuccessListener {
                    FirebaseAuth
                        .getInstance()
                        .createUserWithEmailAndPassword(user.email,password)
                        .addOnCompleteListener{
                            def.complete(if (it.isSuccessful) "success" else "error")
                        }
                }
                .addOnFailureListener {
                    def.complete("error")
                }
            return def.await()
        }
    }

}

