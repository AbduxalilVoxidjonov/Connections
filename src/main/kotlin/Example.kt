package org.example

import Posts
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.InputStreamReader
import java.net.URL

fun main() {
    val gson = GsonBuilder().setPrettyPrinting().create()
    try {
        val url = URL("https://jsonplaceholder.typicode.com/posts?userId=1g")
        val urlConnection = url.openConnection()

        val reader = BufferedReader(InputStreamReader(urlConnection.getInputStream()))

//        val posts = File("src/main/resources/posts.txt")
//        val writer = FileWriter(posts)

        val posts = gson.fromJson(reader, Array<Posts>::class.java)
        posts.forEach { println(it) }

        val file = File("src/main/resources/posts.json")
        val fileOutputStream = FileOutputStream(file)
        fileOutputStream.write(gson.toJson(posts).toByteArray())
        fileOutputStream.close()

    } catch (e: Exception) {
        println("Error: ${e.message}")
    }

}