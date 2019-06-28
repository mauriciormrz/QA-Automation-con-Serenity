#Sample Feature Definition Template

Feature: Google Translate
  As a web user
  I want to use Google Translate
  to translate words between different languages

  Scenario: Translate from source language to target language
    Given That Mauricio want to use Google Translate
    When he translate the word table from English to Spanish
    Then he should see the word mesa on the screen
