# My Translation App

My Translation App is an Android application developed in Android Studio on Android jetpack compose tools that allows users to translate text from one english to UBCO language. This README.md file provides an overview of the app's features, setup instructions, and usage guidelines.

## Features

Translation Rules:
1. Text always begins with the word ‘UBCO’.
2. All vowels in the original text (a, e, i, o, u) are doubled.
3. All other letters (the consonants) in the original text are shifted by one place to
the next consonant in the alphabet. For example:
o ‘b' goes to 'c’
o ‘d' goes to 'f’
o ‘z' goes to 'b’
4. Text ends with a number indicating the number of words in the original text.
5. Case is preserved.
6. All other characters (punctuation, whitespace, etc) are unchanged.

## Screenshots

<img width="376" alt="image" src="https://github.com/taloengrat-p/UBCO_Translate_text/assets/116055866/f9c0af69-6fc4-4799-9208-8de228986226">
<img width="375" alt="image" src="https://github.com/taloengrat-p/UBCO_Translate_text/assets/116055866/9d1d73a0-e126-47c1-9dca-40e47ddf08ba">


## Setup Instructions run locally

To set up the My Translation App project locally, follow these steps:

1. Clone this repository to your local machine using Git:

git clone https://github.com/taloengrat-p/UBCO_Translate_text.git

2. Open the project in Android Studio.

3. Build and run the app on an Android emulator or physical device.

## Usage

1. Launch the App on your Android device.

2. Enter the text you want to translate in the top input field.

3. View the translated text in the bottom output field.

7. Optionally, clear all text by click close button icon in action bar, application will be clear text.
   

## How solution works

Translation have 4 function as following
1. doTranslateCondDoubleVowel(value: String) : String, The function doTranslateCondDoubleVowel takes a String as an input and returns a String. The function processes each character in the input string         and constructs a new string based on the following rules:
   1. Vowel Doubling: If the character is a vowel, it is doubled.
   2. Other Characters: Any other character remains unchanged.

2. doTranslateCondShiftCharExcludeVowel(value: String, shiftAmount: Int) : String, The function doTranslateCondShiftCharExcludeVowel takes a String and an Int as inputs and returns a String. The function processes each character in the input string and constructs a new string based on the following rules:
   1. Whitespace, Digits and Non-Alphanumeric Characters: If the character is a whitespace or a non-alphanumeric character, it remains unchanged.
   2. Vowels: If the character is a vowel, it should repeat recursive function again for expect result is not vowel.
   3. Other Characters: Any other character (i.e., consonants) is shifted by a specified amount.

3. doTranslateCondEndWithCountOfWords(value: String) : String, The function doTranslateCondEndWithCountOfWords takes a String as an input and returns a String. The function appends the count of words in the input string to the end of the original string. by spliting original text for counting word with separate whitespace

4. doTranslateCondPrefixWithUBCO(value: String) : String, The function doTranslateCondPrefixWithUBCO takes a String as an input and returns a String. The function prefixes the input string with "UBCO ".

   
## Reasons for the technical decisions
   
   We use the shift character method by increasing ASCII instead of keeping all characters in the entire array and then shifting. This approach results in cleaner code and is easier for management.

Moreover, we employ Android Compose and MVVM architecture because this solution can scale effectively in the future and android compose integrates tools capable of creating comprehensive application solutions.  


## If i have more time, What other things i would implement

1. Structure the project to accommodate features that will be added in the future.

2. Apply concept dependency injection into my project.

3. Implement feature history translation.

4. Implement feature translate back from UBCO to English languge.

