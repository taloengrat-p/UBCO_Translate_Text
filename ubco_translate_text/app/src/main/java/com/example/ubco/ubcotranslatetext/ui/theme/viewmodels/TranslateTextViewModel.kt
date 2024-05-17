package com.example.ubco.ubcotranslatetext.ui.theme.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TranslateTextViewModel : ViewModel() {
    /**
     * You can edit, run, and share this code.
     * play.kotlinlang.org
     */
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
        var result = ""
        result = doTranslateCondDoubleVowel(value, originalValue = originalWord)

        result = doTranslateCondShiftCharExcludeVowel(result, 1)

        result = doTranslateCondPrefixWithUBCO(result)

        result =
            doTranslateCondEndWithCountOfWords(result, originalValue = originalWord)


        _translateResult.value = result
    }

    private fun doTranslateCondPrefixWithUBCO(value: String): String {
        return "UBCO $value"
    }

    private fun doTranslateCondDoubleVowel(value: String, originalValue: String): String {
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
        val result = (char.code + shiftAmount).toChar()
        return if (isVowel(result)) shiftCharacter(result, shiftAmount) else result;
    }

    private fun isVowel(charactor: Char): Boolean {
        return when (charactor.lowercaseChar()) {
            'a', 'e', 'i', 'o', 'u' -> true
            else -> false
        }
    }

    private fun doTranslateCondEndWithCountOfWords(value: String, originalValue: String): String {
        val resultCountOfWordSplit = originalValue.split(" ").filter { item ->
            !item.equals(originalValue)
        }.count()

        val resultCountOfWord =
            if (resultCountOfWordSplit == 0 && originalWord.isNotEmpty()) 1 else resultCountOfWordSplit;
        return "${value}${resultCountOfWord}"
    }
}