package com.example.testtask.game

import android.graphics.Canvas

interface GameObject {
    fun draw(canvas: Canvas)
    fun update()
}