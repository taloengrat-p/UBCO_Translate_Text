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

when user interact by taping on textfield and keyboard showing up then typing and system will be translate together and show result transled in bottom output field and if you need to clear input translate immediately by action button close on top right in application

## Reasons for the technical decisions



## If i have more time, What other things i would implement

1. Structure the project to accommodate features that will be added in the future.

2. Apply concept dependency injection into my project.

3. Implement feature history translation.

4. Implement feature translate back from UBCO to English languge.

