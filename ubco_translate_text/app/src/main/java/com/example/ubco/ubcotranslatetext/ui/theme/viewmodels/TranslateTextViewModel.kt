package com.example.ubco.ubcotranslatetext.ui.theme.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TranslateTextViewModel : ViewModel() {
    /**
     * You can edit, run, and share this code.
     * play.kotlinlang.org
     */
    val VOWELS = listOf('a', 'e', 'i', 'o', 'u')
    val PREFIX_WORD = "UBCO"
    val MAX_CHAR_UPPER = 90
    val MAX_CHAR_LOWER = 122
    val MIN_CHAR_UPPER = 65
    val MIN_CHAR_LOWER = 97

    private val _originalWord = mutableStateOf("")
    private val _translateResult = mutableStateOf("")


    val translateResult: String
        get() = _translateResult.value

    val originalWord: String
        get() = _originalWord.value


    fun doClear() {
        _originalWord.value = ""
        _translateResult.value = ""
    }

    fun doTranslate(value: String) {
        println("doTranslate $value")
        _originalWord.value = value
        if (value.trim().isEmpty()) {
            _translateResult.value = ""
            return
        }
        var result = ""
        result = doTranslateCondDoubleVowel(value)

        result = doTranslateCondShiftCharExcludeVowel(result, 1)

        result =
            doTranslateCondEndWithCountOfWords(result)

        result = doTranslateCondPrefixWithUBCO(result)

        _translateResult.value = result
    }

    private fun doTranslateCondPrefixWithUBCO(value: String): String {
        return "$PREFIX_WORD $value"
    }

    private fun doTranslateCondDoubleVowel(value: String): String {
        val result = value.map { char ->
            if (isVowel(char)) char.toString() + char.toString()
            else char.toString()
        }.joinToString(separator = "")

        return result
    }

    private fun doTranslateCondShiftCharExcludeVowel(value: String, shiftAmount: Int): String {

        val result = value.map { char ->
            println(" char code $char ${char.code}")

            if (char.isWhitespace() || char.isDigit()) char.toString()
            else if (isVowel(char)) char.toString()
            else shiftCharacter(char, shiftAmount)
        }.joinToString(separator = "")

        return result
    }

    private fun shiftCharacter(char: Char, shiftAmount: Int): Char {

        val baseCharMax = if (char.isLowerCase()) MAX_CHAR_LOWER else MAX_CHAR_UPPER

        val shipedChar = char.code + shiftAmount

        var result = shipedChar.toChar()
        if (shipedChar > baseCharMax) {
            result = (if (char.isLowerCase()) MIN_CHAR_LOWER else MIN_CHAR_UPPER).toChar()
        }

        return if (isVowel(result)) shiftCharacter(result, shiftAmount) else result;
    }

    private fun isVowel(char: Char): Boolean {
        return char.lowercaseChar() in VOWELS
    }

    private fun doTranslateCondEndWithCountOfWords(value: String): String {
        val resultCountOfWordSplit = originalWord.split(" ").filter { item ->
            item.isNotEmpty() && !item.equals(" ")
        }.count()

//        val resultCountOfWord = resultCountOfWordSplit;
        return "${value}${resultCountOfWordSplit}"
    }
}