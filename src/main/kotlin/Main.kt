package org.example

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.net.URL

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    try {
        val url = URL("https://www.w3schools.com/js/js_json_intro.asp")
//        println("Protocol: ${url.protocol}")
//        println("Host: ${url.host}")
//        println("Port: ${url.port}")
//        println("File: ${url.file}")
//        println("Path: ${url.path}")
//        println("Query: ${url.query}")
        try {
            val urlConnection = url.openConnection()
            println("Content-Type: ${urlConnection.contentType}")
            println("Content-length: ${urlConnection.contentLength}")
            val reader: BufferedReader = BufferedReader(InputStreamReader(urlConnection.getInputStream()))
//            var line: String? = null
//            while (reader.readLine().also({ line = it }) != null) {
//                println(line)
//            }

        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}