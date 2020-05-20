import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//Sprawdzam, czy nie mając założonego konta użytkownik może zalogować się do aplikacji
WebUI.openBrowser('')

WebUI.navigateToUrl('http://kmg.hcm.pl/testowanie/')

WebUI.maximizeWindow()

//Tworzę dwie zmienne do logowania i loginu. Hasło jest błędne
WebUI.sendKeys(findTestObject('Nazwa użytkownika'), varLogin)

WebUI.sendKeys(findTestObject('Hasło'), varPassword)

WebUI.click(findTestObject('Button Login'))

//Weryfikuję czy wyswietla się spodziewany widok pop-up alertu oraz widok formularza logowania
WebUI.verifyAlertPresent(0)

WebUI.acceptAlert()

WebUI.verifyNotEqual(findTestObject('Historia rozmów'), findTestObject('Text Link Zajestruj konto'))

WebUI.verifyElementVisible(findTestObject('Text Link Zajestruj konto'))

WebUI.closeBrowser()

