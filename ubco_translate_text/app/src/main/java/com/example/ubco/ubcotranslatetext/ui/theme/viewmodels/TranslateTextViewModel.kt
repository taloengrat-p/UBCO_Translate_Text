package com.example.ubco.ubcotranslatetext.ui.theme.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TranslateTextViewModel : ViewModel() {
    /**
     * You can edit, run, and share this code.
     * play.kotlinlang.org
     */
    val MAX_CHAR_UPPER = 122
    val MAX_CHAR_LOWER = 91

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
        if (value.isEmpty()) {
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
        return "UBCO $value"
    }

    private fun doTranslateCondDoubleVowel(value: String): String {
        val result = value.map { char ->
            if (char.isWhitespace()) char.toString() else if (isVowel(char)) char.toString() + char.toString() else char.toString()
        }.joinToString(separator = "")

        return result
    }

    private fun doTranslateCondShiftCharExcludeVowel(value: String, shiftAmount: Int): String {

        val result = value.map { char ->
            if (char.isWhitespace() || !char.isLetterOrDigit()) char.toString() else if (isVowel(
                    char
                )
            ) char.toString() else shiftCharacter(char, shiftAmount)
        }.joinToString(separator = "")

        return result
    }

    private fun shiftCharacter(char: Char, shiftAmount: Int): Char {


        val baseCharMax = if (char.isLowerCase()) MAX_CHAR_UPPER else MAX_CHAR_LOWER

        val shipedChar = char.code + shiftAmount

        var result = shipedChar.toChar()
        if (shipedChar > baseCharMax) {
            result = (if (char.isLowerCase()) MIN_CHAR_LOWER else MIN_CHAR_UPPER).toChar()
        }

        return if (isVowel(result)) shiftCharacter(result, shiftAmount) else result;
    }

    private fun isVowel(charactor: Char): Boolean {
        return when (charactor.lowercaseChar()) {
            'a', 'e', 'i', 'o', 'u' -> true
            else -> false
        }
    }

    private fun doTranslateCondEndWithCountOfWords(value: String): String {
        val resultCountOfWordSplit = originalWord.split(" ").filter { item ->
            !item.equals(originalWord) && item.isNotEmpty()
        }.count()

        val resultCountOfWord =
            if (resultCountOfWordSplit == 0 && originalWord.isNotEmpty()) 1 else resultCountOfWordSplit;
        return "${value}${resultCountOfWord}"
    }
}