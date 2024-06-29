package com.example.testing.downloading

interface Downloader {
    fun downloadFile(url: String): Long
}